package pieces;

import java.util.ArrayList;

/**
 * Class for handling all the possible moves for a chess piece in a specific
 * tile {@link #fromPos}.<br/>
 * Will not verify the validity of the moves, only save and manage distinct
 * values of possible moves.<br/>
 * Also will not calculate any possible moves. This is done in the specific
 * ChessPiece object.<br/>
 * 
 * @author Andy
 *
 */
public class Move {
    public Move(int fromPos[], int[] toPos) throws IllegalArgumentException {
	if (fromPos.length != 2) {
	    throw new IllegalArgumentException("ERROR: fromPos must be an array with the length of 2!");
	}
	this.fromPos = fromPos;
	this.destinations = new ArrayList<int[]>();
	this.destinations.add(toPos);
    }
    
    /**
     * The position of the tile which contains the ChessPiece that shall be
     * moved.
     */
    private int[] fromPos;
    
    /**
     * A list of destinations the ChessPiece that lies in {@link fromPos} can be
     * moved to.
     */
    private ArrayList<int[]> destinations;
    
    public void addDestination(int line, int row) {
	int[] destination = { line, row };
	this.addDestination(destination);
    }
    
    /**
     * Adds a destination to {@link destinations}.<br/>
     * Shall assert that all destinations are distinct values<br/>
     * 
     * 
     * @param destination
     *        : Array with size of 2
     */
    public void addDestination(int[] destination) {
	if (destination.length != 2) {
	    throw new IllegalArgumentException("ERROR: fromPos must be an array with the length of 2!");
	}
	
	if (!this.destinations.contains(destination)) {
	    this.destinations.add(destination);
	}
    }
    
    /**
     * Will remove the returned element.
     * 
     * @return: The first Element in the {@link destinations} list
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
