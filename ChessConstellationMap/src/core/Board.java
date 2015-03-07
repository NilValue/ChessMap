package core;

import java.util.ArrayList;

import pieces.ChessPiece;
import pieces.Move;

/**
 * Representation of the chess board within a constellation.
 * 
 * @author Andy
 * 
 */
public class Board {
    
    /**
     * Default constructor for the first board in the first constellation of the
     * map.<br/>
     * Fills the board with the starting positions.<br/>
     */
    public Board() {
	this.board = new ChessPiece[8][8];
	this.moves = new ArrayList<Move>();
	this.generateStartingPosition();
    }
    
    /**
     * Copy constructor for Board.<br/>
     * 
     * @param board
     */
    public Board(Board board) {
	
    }
    
    /**
     * Contains and represents the chess board and its pieces
     */
    private ChessPiece[][] board;
    private ArrayList<Move> moves;
    
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
     * 
     * @param fromPos
     *        : f.e. an array [0,2]
     * @param toPos
     *        : like fromPos
     * @throws Exception
     *         : In case that two movesToAccess become available in
     *         Board.addMove(), this would mean that the there are two moves
     *         with the with the same int[] fromPos which woukd have to be fixed
     */
    public void addMove(int[] fromPos, int[] toPos) throws Exception {
	if (fromPos.length != 2 || toPos.length != 2) {
	    throw new IllegalArgumentException("ERROR: fromPos and toPos must be arrays with the length of 2!");
	}
	
	Move moveToAccess = null;
	
	for (Move moveToCheck : this.moves) {
	    if (moveToCheck.getFromPos() == fromPos) {
		if (moveToAccess == null) {
		    moveToAccess = moveToCheck;
		} else {
		    throw new Exception("Two movesToAccess available in Board.addMove()!");
		}
	    }
	}
	if (moveToAccess != null) {
	    moveToAccess.addDestination(toPos);
	} else {
	    moves.add(new Move(fromPos, toPos));
	}
    }
    
    private void generateStartingPosition() {
	
    }
    
    public ChessPiece[][] getBoard() {
	return this.board;
    }
    
    /**
     * Will commit the next move contained in {@link moves}.<br/>
     * This is the first destination coordinate in the first Move object of
     * {@link moves}.<br/>
     * 
     * @param fromLine
     * @param fromRow
     * @param toLine
     * @param toRow
     */
    public void moveChessPiece() {
	
    }
}
