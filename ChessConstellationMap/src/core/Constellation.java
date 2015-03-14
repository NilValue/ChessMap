package core;

import java.util.ArrayList;

import pieces.ChessPiece;
import util.Color;
import util.IdManager;
import util.Move;

/**
 * "Core"-Element of ChessMap. <br/>
 * Contains a pointer to a chess board ({@link #board} which contains pointers
 * to all pieces in play and their positions.<br/>
 * Is able to create and instantiate all new constellations out of itself and
 * add the to its containing map. <br/>
 * Knows which constellations can be created out of it (
 * {@link #followingConstellations}).<br/>
 * <br/>
 * Two different constellations shall point to the same board if they share it.<br/>
 * Two constellations with the same board differ in:<br/>
 * - the color of the moving player ({@link #movingPlayer})<br/>
 * - the color of the player which is checkmate (@link {@link #checkmatePlayer})<br/>
 * - the list of the {@link #followingConstellations}
 * 
 * @author Andy
 */
public class Constellation {
    
    /**
     * This constructor will only be invoked when adding a new constellation to
     * an empty map.<br/>
     * It represents the constellation at the start of a game of chess.<br/>
     * Therefore it does the following:<br/>
     * - {@link #complete} is set to {@code false} .<br/>
     * - {link #movingPLayer} is set to {@code Color.WHITE}.<br/>
     * - {link #board} will receive a new instance of the class {@code Board}
     * using the default constructor.<br/>
     * <br/>
     * <b>Important note</b>: After the constructor has finished the new
     * constellation must be added to the idManager<br/>
     */
    public Constellation(IdManager idManager) {
	
	// In chess the first moving player is the white one
	this.movingPlayer = Color.WHITE;
	
	// Every constellation has its own board and its own list of moves
	this.board = new Board();
	
	// All constellations share the same idManager
	this.idManager = idManager;
	
	// Generate Id and set it within this constellation.
	this.id = this.idManager.generateId(this.board, this.movingPlayer);
	
	this.calculateAllPossibleMoves();
    }
    
    /**
     * This constructor creates a new constellation based on an existing
     * constellation<br/>
     * <br/>
     * <b>Important note</b>: After the constructor has finished two things have
     * to be done:<br/>
     * 1.) The new constellation must be added to the idManager<br/>
     * 2.) The new constellation must be added to the list of following
     * constellations of the former constellation.<br/>
     * 
     * @param formerConstellation
     *        : The constellation from which the new constellation is created
     * @throws Exception
     */
    public Constellation(Constellation formerConstellation) throws Exception {
	
	// Defining the color of the moving player in the new constellation
	switch (formerConstellation.movingPlayer) {
	
	    case BLACK:
		this.movingPlayer = Color.WHITE;
		break;
	    
	    case WHITE:
		this.movingPlayer = Color.BLACK;
		break;
	    
	    default:
		throw new Exception("No color assigned to movingPlayer at initialization of a new Constellation!");
	}
	
	if (this.movingPlayer == formerConstellation.movingPlayer || this.movingPlayer == null) {
	    throw new Exception("movingPlayer not assigned correctly while creating a new constellation with the copy constructor");
	}
	
	// Generate a mirrored copy of the old board
	this.board = new Board(formerConstellation);
	
	// TODO Handle errors that could occur while executing the moving!
	// Execute next logical single move
	this.executeNextMove(formerConstellation);
	
	// Retrieve a pointer to the overall idManager
	this.idManager = formerConstellation.idManager;
	
	// Generate Id and set it within this constellation
	this.id = this.idManager.generateId(this.board, this.movingPlayer);
	
	this.calculateAllPossibleMoves();
    }
    
    /**
     * Player that would have to do the next move in this constellation,<br/>
     * e.g. in WHITE in the very first constellation
     */
    private final Color movingPlayer;
    
    /**
     * The idManager is initialized at the call of the standard constructor
     * which is only to be called once per ChessMap.<br/>
     * All idManager identifiers of all constellations of one ChessMap point to
     * the same IdManager object.<br/>
     */
    private final IdManager idManager;
    
    // TODO calculate checkmatePlayer and stalemate
    private Color checkmatePlayer;
    private boolean stalemate;
    
    private final Board board;
    
    /**
     * A constellation is considered complete once all possible moves have been
     * executed.
     */
    private boolean complete = false;
    
    /**
     * all IDs shall be saved within their constellations. An IdManager object
     * with pointers to the constellations with their respective IDs will be
     * implemented in ChessMap
     */
    private final String id;
    
    // TODO make a method for this one, it shall retrieve a list of all next
    // possible constellations out of the IdManager by transferring the
    // constellation's ID
    /**
     * Every finished constellation shall know which constellations can follow
     * out of it.<br/>
     * Furthermore it shall be able to retrieve those out of it IdManager<br/>
     */
    private final ArrayList<Constellation> followingConstellations = new ArrayList<Constellation>();
    
    /**
     * The moves that still have to be executed in order to get all
     * {@link #followingConstellations}.<br/>
     * Will be set to null once all {@link #followingConstellations} are
     * generated.<br/>
     */
    private ArrayList<Move> moves = new ArrayList<Move>();
    
    /**
     * Executes the next logical move.<br/>
     * The next logical move is defined as the first destination of the first
     * Move object in the List moves.<br/>
     * The resulting constellation will be instantiated with the copy
     * constructor<br/>
     * It will then be added to the IdManager and to the calling constellation's
     * nextPossibleConstellations List.<br/>
     * 
     * @throws Exception
     */
    private final void executeNextMove(Constellation formerConstellation) {
	// TODO method implementation
    }
    
    /**
     * Calculates all possible moves on this constellation and adds them to the
     * ArrayList moves.<br/>
     */
    private final void calculateAllPossibleMoves() {
	for (ChessPiece[] line : board.getBoardArray()) {
	    for (ChessPiece chessPiece : line) {
		this.moves.add(chessPiece.getPossibleMoves(this));
	    }
	}
	// TODO unfinished: needs to check that no two moves with the same
	// fromPos are in the list!
    }
    
    /**
     * Adds a new instance of Move to the list {@link moves} if there is none
     * with the assigned fromPos.<br/>
     * If there is already such an instance of Move in the list, then it will
     * access that instance and add the toPos (moves.addDestination).<br/>
     * However, if there is already an instance of Move with the same fromPos
     * and the same toPos the method will do nothing.<br/>
     * (The method Move.addDestination has to specify that all destinations have
     * to be distinct from each other) <br/>
     * <br/>
     * <b>Workflow:</b><br/>
     * <br/>
     * <b>Step 1:</b><br/>
     * Asserts that the the assigned arguments are arrays with a length of two.
     * Throws an IllegalArgumentException if not.<br/>
     * <br/>
     * <b>Step 2:</b><br/>
     * New identifier to which will temporarily contain a pointer to the Move
     * object which shall be accessed in order to add a move.<br/>
     * <br/>
     * <b>Step 3:</b><br/>
     * ForEach loop in order to check if any of the Move objects in this.moves
     * already contains the fromPos of the destination that shall be added. If
     * there is one then moveToAccess will point to this Move object. If not the
     * moveToAccess will stay null in which case a new Move object will be
     * instantiated and added to the ArrayList this.moves. Also: checks if there
     * are two Move objects with the same fromPos in which case an Exception
     * will be thrown.<br/>
     * <br/>
     * <b> Step 4:</b><br/>
     * If moveToAccess couldn't be assigned to any of the checked moves, this
     * means that there is no Move object in the ArrayList which has the fromPos
     * that is to be added as its fromPos. In that case a new Move object will
     * be instantiated and added to the ArrayList this.moves.<br/>
     * 
     * @param fromPos
     *        : f.e. an array [0,2]
     * @param toPos
     *        : like fromPos
     * @throws Exception
     *         : In case that two movesToAccess become available in
     *         Constellation.addMove(), this would mean that the there are two
     *         moves with the with the same int[] fromPos which woukd have to be
     *         fixed
     * @deprecated Replaced by calculateAllMoves() and incomplete
     */
    private void addMove(int[] fromPos, int[] toPos) throws Exception {
	
	// Step 1
	if (fromPos.length != 2 || toPos.length != 2) {
	    throw new IllegalArgumentException("ERROR: fromPos and toPos must be arrays with the length of 2!");
	}
	
	// Step 2
	Move moveToAccess = null;
	
	// Step 3
	for (Move moveToCheck : this.moves) {
	    if (moveToCheck.getFromPos() == fromPos) {
		if (moveToAccess == null) {
		    moveToAccess = moveToCheck;
		} else {
		    throw new Exception("Two movesToAccess available in Constellation.addMove()!");
		}
	    }
	}
	
	// Step 4
	if (moveToAccess != null) {
	    moveToAccess.addDestination(toPos);
	} else {
	    moves.add(new Move(fromPos));
	    // TODO add the destination
	}
    }
    
    public String getId() {
	return this.id;
    }
    
    public Board getBoard() {
	return this.board;
    }
    
    public Color getMovingPlayer() {
	return this.movingPlayer;
    }
    
}
