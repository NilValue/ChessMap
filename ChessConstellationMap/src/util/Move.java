package util;

import java.util.ArrayList;

/**
 * Class for handling all the possible moves of a chess piece in a specific tile
 * represented by {@link #fromPos}.<br/>
 * Does not verify the validity of the moves, only save and manage distinct
 * values of possible moves.<br/>
 * Also does not calculate any possible moves. This is done in the specific
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
	    throw new IllegalArgumentException("fromPos must be an array with the length of 2!");
	}
	
	this.fromPos[0] = fromPos[0];
	this.fromPos[1] = fromPos[1];
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
	this.fromPos[0] = fromPosLine;
	this.fromPos[1] = fromPosRow;
    }
    
    /**
     * The coordinates of the tile which contains the chess piece which possible
     * moves are saved within this Move object.
     */
    private final int[] fromPos = new int[2];
    /**
     * A list of destinations the chess piece which is specified in
     * {@link #fromPos} can move to.<br/>
     * A destination is an array with a length of 2.
     */
    private final ArrayList<int[]> destinations = new ArrayList<int[]>();
    
    /**
     * Calls {@link #addDestination(int[])} with line and row as values in the
     * array.
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
     *        : Array with a size of 2 containing the line and the row
     *        coordinate of a chess board array..
     */
    public void addDestination(int[] destination) {
	if (destination.length != 2) {
	    throw new IllegalArgumentException("ERROR: fromPos must be an array with the length of 2!");
	}
	
	// Throw exception if destination is already contained
	if (this.destinations.contains(destination)) {
	    throw new IllegalArgumentException("Destination already contained within this move!");
	}
	
	this.destinations.add(destination);
	
    }
    
    /**
     * @return: The first element in the {@link #destinations} list. Will return
     *          null if there is no such element.
     */
    public int[] getNextDestination() {
	if (!(this.destinations.isEmpty())) {
	    return this.destinations.get(0);
	}
	return null;
    }
    
    /**
     * Removes the first element in the {@link #destinations} list.<br/>
     * 
     * @param destinationToRemove
     *        - Asserts that the destination that will be removed has been
     *        retrieved first.
     */
    public void removeDestination(int[] destinationToRemove) throws IllegalArgumentException {
	if ((destinationToRemove.length != 2)) {
	    throw new IllegalArgumentException("Transferred array has wrong length!");
	}
	
	if (!(this.destinations.get(0)[0] == destinationToRemove[0] && this.destinations.get(0)[1] == destinationToRemove[1])) {
	    throw new IllegalArgumentException("Transferred array has different values than the first destination array");
	}
	
	if (!(this.destinations.isEmpty())) {
	    this.destinations.remove(0);
	}
    }
    
    public int[] getFromPos() {
	return this.fromPos;
    }
}
