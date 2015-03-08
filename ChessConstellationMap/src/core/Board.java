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
     * Copy constructor for Board.<br/>
     * 
     * @param board
     */
    public Board(Board board) {
	this.board = new ChessPiece[8][8];
	
	/*
	 * First copy the pointers to all elements from the old board. Since the
	 * chess pieces are each only instantiated twice (once for each color)
	 * the new board only needs to point to the pieces shared by all boards
	 * instead of instantiating each piece anew. This improves performance
	 * because of less memory usage.
	 */
	for (int i = 0; i < this.board.length; i++) {
	    for (int j = 0; j < this.board[i].length; j++) {
		this.board[i][j] = board.getBoard()[i][j];
	    }
	}
    }
    
    /**
     * Contains and represents the chess board and its pieces
     */
    private ChessPiece[][] board;
    
    /**
     * Generates the starting position of a match of chess on the {@link #board}
     * .<br/>
     */
    private void generateStartingPosition() {
	// TODO method implementation
    }
    
    public void movePiece(int[] fromPos, int[] toPos) {
	// TODO method implementation
    }
    
    public ChessPiece[][] getBoard() {
	return this.board;
    }
    
}
