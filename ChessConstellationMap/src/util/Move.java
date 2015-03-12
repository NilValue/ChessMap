package util;

import java.util.ArrayList;

/**
 * Class for handling all the possible moves of a chess piece in a specific tile
 * represented by {@link #fromPos}.<br/>
 * Will not verify the validity of the moves, only save and manage distinct
 * values of possible moves.<br/>
 * Also will not calculate any possible moves. This is done in the specific
 * ChessPiece object.<br/>
 * 
 * @author Andy
 */
public class Move {
    
    /**
     * A move can only exist with a specified tile to which the possible moves
     * are assigned ({@link #fromPos}). Therefore fromPos is declared as final
     * and the constructor only accepts one fromPos array.<br/>
     * There is also another constructor which accepts the array coordinates for
     * the fromPos array as int values.<br/>
     * 
     * @param fromPos
     *        - The position of the chess piece on the boardArray. Array with a
     *        length of 2. Created as a new object to prevent overwriting the
     *        transferred array and accidentally altering the fromPos of this
     *        Move object.
     * @throws IllegalArgumentException
     *         if the transferred {@link #fromPos} has a length other than 2.
     */
    public Move(int fromPos[]) throws IllegalArgumentException {
	if (fromPos.length != 2) {
	    throw new IllegalArgumentException("ERROR: fromPos must be an array with the length of 2!");
	}
	
	this.fromPos = new int[2];
	
	this.fromPos[0] = fromPos[0];
	this.fromPos[1] = fromPos[1];
	
	this.destinations = new ArrayList<int[]>();
    }
    
    /**
     * A move can only exist with a specified tile to which the possible moves
     * are assigned ({@link #fromPos}). Therefore fromPos is declared as final
     * and the constructor only accepts one fromPos array.<br/>
     * However it might be useful to transfer the coordinates of the fromPos
     * array as plain int values. Therefore this constructor exists.<br/>
     * 
     * @param fromPosLine
     *        - The first coordinate of the fromPos array hence the line number
     *        of the chess board which tile has to be specified as the one
     *        containing the chess piece that shall be moved.<br/>
     * @param fromPosRow
     *        - The second coordinate of the fromPos array equivalent to the
     *        parameter {@code fromPosLine}.
     */
    public Move(int fromPosLine, int fromPosRow) {
	
	this.fromPos = new int[2];
	
	this.fromPos[0] = fromPosLine;
	this.fromPos[1] = fromPosRow;
	
	this.destinations = new ArrayList<int[]>();
    }
    
    /**
     * The coordinates of the tile which contains the chess piece which possible
     * moves are saved within this Move object.
     */
    private final int[] fromPos;
    
    /**
     * A list of destinations the chess piece which is specified in
     * {@link #fromPos} can move to.
     */
    private final ArrayList<int[]> destinations;
    
    /**
     * Adds a destination to {@link #destinations}.<br/>
     * Shall assert that all destinations are distinct values.<br/>
     * Does nothing if the destination that shall be added is already contained.<br/>
     * 
     * @param line
     *        - The first coordinate of the destination that shall be added.
     * @param row
     *        - The second coordinate of the destination that shall be added.
     */
    public void addDestination(int line, int row) {
	int[] destination = { line, row };
	this.addDestination(destination);
    }
    
    /**
     * Adds a destination to {@link #destinations}.<br/>
     * Shall assert that all destinations are distinct values.<br/>
     * Does nothing if the destination that shall be added is already contained.<br/>
     * 
     * @param destination
     *        : Array with a size of 2.
     */
    public void addDestination(int[] destination) {
	if (destination.length != 2) {
	    throw new IllegalArgumentException("ERROR: fromPos must be an array with the length of 2!");
	}
	
	/*
	 * If-clause to make sure that no destination is inserted twice.
	 */
	if (!this.destinations.contains(destination)) {
	    this.destinations.add(destination);
	}
    }
    
    /**
     * Will remove the returned element.<br/>
     * 
     * @return: The first Element in the {@link #destinations} list. Will return
     *          null if there is no such element.
     */
    public int[] getAndRemoveFirstDestination() {
	if (!this.destinations.isEmpty()) {
	    int[] destination = this.destinations.get(0);
	    this.destinations.remove(0);
	    return destination;
	}
	return null;
    }
    
    public int[] getFromPos() {
	return this.fromPos;
    }
}
