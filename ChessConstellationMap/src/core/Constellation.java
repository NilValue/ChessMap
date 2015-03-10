package core;

import java.util.ArrayList;

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
 * {@link #nextPossibleConstellations}).<br/>
 * <br/>
 * Two different constellations shall point to the same board if they share it.<br/>
 * Two constellations with the same board differ in:<br/>
 * - the color of the moving player ({@link #movingPlayer})<br/>
 * - the color of the player which is checkmate (@link {@link #checkmatePlayer})<br/>
 * - the list of the {@link #nextPossibleConstellations}<br/>
 * 
 * @author Andy
 */
public class Constellation {
    
    /**
     * This constructor will only be invoked when adding a new constellation to
     * an empty map.<br/>
     * It represents the constellation at the start of a game of chess.<br/>
     * Therefore it does the following:<br/>
     * - {@link #allPossibleMovesGenerated} is set to {@code false}.<br/>
     * - {link #movingPLayer} is set to {@code Color.WHITE}.<br/>
     * - {link #board} will receive a new instance of the class {@code Board}
     * using the default constructor.
     */
    public Constellation(IdManager idManager) {
	/*
	 * Every constellation starts with no possible Moves generated
	 */
	this.allPossibleMovesGenerated = false;
	
	/*
	 * In chess the first moving player is the white one
	 */
	this.movingPlayer = Color.WHITE;
	
	/*
	 * Every constellation has its own board and its own list of moves
	 */
	this.board = new Board();
	this.moves = new ArrayList<Move>();
	
	/*
	 * The IdManager shall be initialized within the constructor of the
	 * ChessMap class
	 */
	this.idManager = idManager;
	
	/*
	 * The list of the next possible constellations for each constellation
	 * exists within the IdManager
	 */
	this.nextPossibleConstellations = new ArrayList<Constellation>();
	
	/*
	 * Generate Id and set within this constellation
	 */
	this.id = IdManager.generateId(this);
	
	/*
	 * Add this new constellation to the IdManager
	 */
	this.idManager.addConstellation(this);
	
    }
    
    /**
     * This constructor creates a new constellation based on an existing
     * constellation<br/>
     * 
     * @param constellation
     *        : The constellation from which the new constellation is created
     * @throws Exception
     */
    public Constellation(Constellation constellation) throws Exception {
	
	this.allPossibleMovesGenerated = false;
	
	/*
	 * Defining the color of the moving player in the new constellation
	 */
	switch (constellation.movingPlayer) {
	
	    case BLACK:
		this.movingPlayer = Color.WHITE;
		break;
	    
	    case WHITE:
		this.movingPlayer = Color.BLACK;
		break;
	    
	    default:
		throw new Exception("No color assigned to movingPlayer at initializaiton of a new Constellation!");
	}
	
	/*
	 * Generate a copy of the old constellation's board with the copy
	 * constructor of Board
	 */
	this.board = new Board(constellation.board);
	
	/*
	 * We do not know yet know which moves are available in this
	 * constellation. So moves is instantiated as a new ArrayList.
	 */
	this.moves = new ArrayList<Move>();
	
	// TODO execute move
	
	this.nextPossibleConstellations = new ArrayList<Constellation>();
	
	// TODO add this Constellation(ConstellationId) to the list of next
	// possible Constellation of the previous constellation
	
	this.idManager = constellation.idManager;
	
	/*
	 * Generate Id and set within this constellation
	 */
	this.id = IdManager.generateId(this);
	
	// TODO what if constellation is already existent shall be checked and
	// dealt with here
	this.idManager.addConstellation(this);
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
    
    /**
     * Player which is set checkmate in the current constellation<br/>
     * Either null or same value as {@code movingPlayer}<br/>
     * <br/>
     * Note: If checkmatePlayer != null then nextPossibleMoves == null
     */
    private Color checkmatePlayer;
    
    private final Board board;
    private boolean allPossibleMovesGenerated;
    
    /**
     * all IDs shall be saved within their constellations. An IdManager object
     * with pointers to the constellations with their respective Ids will be
     * implemented in ChessMap
     */
    private final String id;
    
    // TODO make a method for this one, it shall retrieve the constellation
    // out of the IdManager by the constellation's ID
    /**
     * Every finished constellation shall know which constellations can follow
     * out of it.<br/>
     * Furthermore it shall be able to retrieve those out of it IdManager<br/>
     */
    private final ArrayList<Constellation> nextPossibleConstellations;
    
    /**
     * The moves that still have to be executed in order to get all
     * {@link #nextPossibleConstellations}.<br/>
     * Will be set to null once all {@link #nextPossibleConstellations} are
     * generated.<br/>
     */
    private ArrayList<Move> moves;
    
    /**
     * Executes the next logical move.<br/>
     * The next logical move is defined as the first destination of the first
     * Move object in the List moves.<br/>
     * The result is a new constellation with the following properties:<br/>
     * TODO define properties
     * 
     * @return: A new Constellation with an empty List of moves on which the
     *          next logical has been executed.
     * @throws Exception
     */
    public Constellation moveNext() throws Exception {
	Constellation newConstellation;
	
	newConstellation = new Constellation(this);
	
	// Defining the move that shall be executed
	int[] fromPos = this.moves.get(0).getFromPos();
	int[] toPos = this.moves.get(0).getAndRemoveFirstDestination();
	
	// TODO method implementation
	return newConstellation;
    }
    
    /**
     * Adds a new instance of Move to the list {@link moves} if there is none
     * with the assigned of fromPos.<br/>
     * If there is already such an instance of Move in the list, then it will
     * access that instance and add the toPos (moves.addDestination).<br/>
     * However, if there is already an instance of Move with the same fromPos
     * and the same toPos the method will do nothing.<br/>
     * (The method Move.addDestination has to specify that all destinations have
     * to be distinct from each other) <br/>
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
     */
    public void addMove(int[] fromPos, int[] toPos) throws Exception {
	
	/*
	 * Asserts that the the assigned arguments are arrays with a length of
	 * two. Throws an IllegalArgumentException if not.
	 */
	if (fromPos.length != 2 || toPos.length != 2) {
	    throw new IllegalArgumentException("ERROR: fromPos and toPos must be arrays with the length of 2!");
	}
	
	/*
	 * New identifier to which will temporarily contain a pointer to the
	 * Move object which shall be accessed in order to add a move.
	 */
	Move moveToAccess = null;
	
	/*
	 * ForEach loop in order to check if any of the Move objects in
	 * this.moves already contains the fromPos of the destination that shall
	 * be added. If there is one then moveToAccess will point to this Move
	 * object. If not the moveToAccess will stay null in which case a new
	 * Move object will be instantiated and added to the ArrayList
	 * this.moves. Also: checks if there are two Move objects with the same
	 * fromPos in which case an Exception will be thrown.
	 */
	for (Move moveToCheck : this.moves) {
	    if (moveToCheck.getFromPos() == fromPos) {
		if (moveToAccess == null) {
		    moveToAccess = moveToCheck;
		} else {
		    throw new Exception("Two movesToAccess available in Constellation.addMove()!");
		}
	    }
	}
	
	/*
	 * If moveToAccess couldn't be assigned to any of the checked moves,
	 * this means that there is no Move object in the ArrayList which has
	 * the fromPos that is to be added as its fromPos. In that case a new
	 * Move object will be instantiated and added to the ArrayList
	 * this.moves.
	 */
	if (moveToAccess != null) {
	    moveToAccess.addDestination(toPos);
	} else {
	    moves.add(new Move(fromPos, toPos));
	}
    }
    
    public String getId() {
	return this.id;
    }
    
}
