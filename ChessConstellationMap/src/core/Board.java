package core;

import pieces.ChessPiece;
import pieces.ChessPieceContainer;

/**
 * Representation of the chess board within a constellation.
 * 
 * @author Andy
 */
public class Board {
    
    /**
     * Default constructor for the first board in the first constellation of the
     * map. Fills the board with the starting positions of a match of chess.<br/>
     */
    public Board() {
	// First board contains the starting positions
	this.generateStartingPosition();
    }
    
    /**
     * Deep copy constructor for Board which mirrors the board simultaneously.<br/>
     * <br/>
     * <b>Enhanced description:</b><br/>
     * The new board is a deep copy of the old board, while the new boardArray
     * is basically a mirrored shallow copy of the old boardArray. <br/>
     * In other words: Since the chess pieces are each only instantiated twice
     * (once for each color) the new board only needs to point to the pieces
     * shared by all boards instead of instantiating each piece anew. The board
     * is simultaneously mirrored (therefore [7 - row] and [7 - col]), so that
     * the new board is "viewed" from the side of the player who's turn it is in
     * the new constellation.<br/>
     * 
     * @param constellation
     *        - The former constellation.
     */
    public Board(Board formerBoard) {
	// Copy the old board and mirror it
	for (int row = 0; row < this.boardArray.length; row++) {
	    for (int col = 0; col < this.boardArray[row].length; col++) {
		this.boardArray[row][col] = formerBoard.boardArray[7 - row][7 - col];
	    }
	}
    }
    
    /**
     * Represents the chess board and contains pointers to the pieces.
     */
    private final ChessPiece[][] boardArray = new ChessPiece[8][8];
    
    /**
     * Generates the starting position of a match of chess on the
     * {@link #boardArray} .<br/>
     * The point of view onto the board is the point of view of the white
     * player.<br/>
     */
    private final void generateStartingPosition() {
	
	int row;
	
	// Fill in all white pawns.
	row = 1;
	for (int col = 0; col < boardArray[row].length; col++) {
	    this.boardArray[row][col] = ChessPieceContainer.getWhitePawn();
	}
	
	// Fill in all other white pieces.
	row = 0;
	this.boardArray[row][0] = ChessPieceContainer.getWhiteRook();
	this.boardArray[row][1] = ChessPieceContainer.getWhiteHorse();
	this.boardArray[row][2] = ChessPieceContainer.getWhiteBishop();
	this.boardArray[row][3] = ChessPieceContainer.getWhiteQueen();
	this.boardArray[row][4] = ChessPieceContainer.getWhiteHorse();
	this.boardArray[row][5] = ChessPieceContainer.getWhiteBishop();
	this.boardArray[row][6] = ChessPieceContainer.getWhiteHorse();
	this.boardArray[row][7] = ChessPieceContainer.getWhiteRook();
	
	// Fill in all black pawns.
	row = 6;
	for (int col = 0; col < boardArray[row].length; col++) {
	    this.boardArray[row][col] = ChessPieceContainer.getBlackPawn();
	}
	
	// Fill in all other black pieces.
	row = 7;
	this.boardArray[row][0] = ChessPieceContainer.getBlackRook();
	this.boardArray[row][1] = ChessPieceContainer.getBlackHorse();
	this.boardArray[row][2] = ChessPieceContainer.getBlackBishop();
	this.boardArray[row][3] = ChessPieceContainer.getBlackQueen();
	this.boardArray[row][4] = ChessPieceContainer.getBlackHorse();
	this.boardArray[row][5] = ChessPieceContainer.getBlackBishop();
	this.boardArray[row][6] = ChessPieceContainer.getBlackHorse();
	this.boardArray[row][7] = ChessPieceContainer.getBlackRook();
    }
    
    /**
     * @return - the {@link #boardArray}
     */
    public ChessPiece[][] getBoardArray() {
	return this.boardArray;
    }
    
}
