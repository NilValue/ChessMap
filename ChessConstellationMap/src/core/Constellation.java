package core;

import java.util.ArrayList;

import util.Color;
import util.IdManager;
import util.Move;

/**
 * "Core"-Element of ChessMap. <br/>
 * Has two constructors, one for the very first constellation (
 * {@link #Constellation(IdManager)}) and another for all following
 * constellations ({@link #Constellation(Constellation)}).<br/>
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
     * - {@link #movingPLayer} is set to {@code Color.WHITE}.<br/>
     * - {@link #board} will receive a new instance of the class {@link Board}
     * using the default constructor which will fill said board with the
     * starting positions.<br/>
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
	this.id = this.idManager.generateId(this.board.getBoardArray(), this.movingPlayer);
	
	this.calculateAllPossibleMoves();
    }
    
    /**
     * This constructor creates a new constellation based on an existing
     * constellation<br/>
     * <br/>
     * Note that the new constellation is a new object and that its
     * instantiation shall have no side effects.<br/>
     * Therefore, after the constructor has finished, the former constellation
     * won't be updated and the new constellation has not been added to the
     * idManager.<br/>
     * <br/>
     * <b>Important note</b>: After the constructor has finished three things
     * have to be done:<br/>
     * 1.) The new constellation must be added to the idManager<br/>
     * 2.) The new constellation must be added to the list of following
     * constellations of the former constellation (see
     * {@link IdManager#addRelationship(String, String)}).<br/>
     * 3.) The former constellation must be added to the list of former
     * constellations of the new constellation (see
     * {@link IdManager#addRelationship(String, String)}).<br/>
     * 4.) The performed move must be removed from the former constellation.
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
	this.board = new Board(formerConstellation.board);
	
	// Execute next logical move
	this.executeNextMove(formerConstellation);
	
	// Retrieve a pointer to the overall idManager
	this.idManager = formerConstellation.idManager;
	
	// Generate Id and set it within this constellation
	this.id = this.idManager.generateId(this.board.getBoardArray(), this.movingPlayer);
	
	this.calculateAllPossibleMoves();
    }
    
    /**
     * Player that would have to do the next move in this constellation,<br/>
     * e.g. in WHITE in the very first constellation
     */
    private final Color movingPlayer;
    
    /**
     * The idManager is initialized before calling the standard constructor
     * which is only to be called once per ChessMap.<br/>
     * All idManager identifiers of all constellations of one ChessMap point to
     * the same IdManager object.<br/>
     */
    private final IdManager idManager;
    
    // TODO Deal with checkmate situations, stalemate situations and special
    // moves (e.g. rochade)
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
    
    /**
     * Every finished constellation shall know which constellations can follow
     * out of it and out of which constellations itself can follow.<br/>
     * Furthermore it shall be able to retrieve those out of it IdManager<br/>
     */
    private final ArrayList<String> followingConstellations = new ArrayList<String>(),
	    formerConstellations = new ArrayList<String>();
    
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
    private final void executeNextMove(Constellation formerConstellation) throws Exception {
	if (formerConstellation.moves.isEmpty()) {
	    throw new Exception("Trying to execute a move that does not exist!");
	}
	
	int[] fromPos = formerConstellation.moves.get(0).getFromPos();
	int[] toPos = formerConstellation.moves.get(0).getNextDestination();
	
	// TODO Handle errors that could occur while executing the move
	// TODO method implementation
    }
    
    /**
     * Calculates all possible moves of this constellation and adds them to the
     * ArrayList moves.<br/>
     */
    private final void calculateAllPossibleMoves() {
	// TODO method implementation
    }
    
    // TODO element comment
    public final void removeMove(int fromPosRow, int fromPosCol, int destinationRow, int destinationCol) {
	int[] fromPos = { fromPosRow, fromPosCol };
	int[] destination = { destinationRow, destinationCol };
	
	this.removeMove(fromPos, destination);
    }
    
    /**
     * Removes the next logical move which should have been retrieved first<br/>
     */
    public final void removeMove(int[] fromPos, int[] destination) {
	if ((fromPos.length != 2) || (destination.length != 2)) {
	    throw new IllegalArgumentException("Wrong parameters on removal of a move");
	}
	
	// TODO method implementation
    }
    
    /**
     * @return {@link #id}
     */
    public String getId() {
	return this.id;
    }
    
    /**
     * @return {@link #movingPlayer}
     */
    public Color getMovingPlayer() {
	return this.movingPlayer;
    }
    
    public boolean isComplete() {
	return this.complete;
    }
    
    public void markAsComplete() {
	this.complete = true;
    }
    
    public ArrayList<String> getFollowingConstellations() {
	return this.followingConstellations;
    }
    
    public ArrayList<String> getFormerConstellations() {
	return this.formerConstellations;
    }
}
