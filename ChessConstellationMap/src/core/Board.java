package core;

import pieces.ChessPiece;

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
	this.generateStartingPosition();
    }
    
    /**
     * Copy constructor for Board which mirrors the board simultaneously.<br/>
     * 
     * @param board
     *        : The board of the former constellation.
     */
    public Board(Board board) {
	// Initialize a new board
	this.board = new ChessPiece[8][8];
	
	/*
	 * First copy the pointers to all elements from the old board. Since the
	 * chess pieces are each only instantiated twice (once for each color)
	 * the new board only needs to point to the pieces shared by all boards
	 * instead of instantiating each piece anew. This improves performance
	 * because of less memory usage.
	 * 
	 * The board will be mirrored simultaneously so that the new board is
	 * "spectated" from the side of the player who's turn it is then.
	 */
	for (int i = 0; i < this.board.length; i++) {
	    for (int j = 0; j < this.board[i].length; j++) {
		this.board[i][j] = board.getBoard()[i][j];
	    }
	}
	// Mirror the board!
	this.mirror();
    }
    
    /**
     * Represents the chess board and contains pointers to its pieces
     */
    private final ChessPiece[][] board;
    
    /**
     * Generates the starting position of a match of chess on the {@link #board}
     * .<br/>
     * The point of view onto the board is the point of view of the white
     * player.<br/>
     */
    private void generateStartingPosition() {
	
	// TODO method implementation
    }
    
    /**
     * Mirrors the board so that the point of view from which the Constellation
     * looks at it is the point of view of the player who's turn it is.<br/>
     */
    private void mirror() {
	// TODO mirror the board
    }
    
    public void movePiece(int[] fromPos, int[] toPos) {
	// TODO method implementation
    }
    
    public ChessPiece[][] getBoard() {
	return this.board;
    }
    
}
