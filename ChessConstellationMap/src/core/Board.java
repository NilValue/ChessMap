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
     * is simultaneously mirrored (therefore [7 - i] and [7 - j]), so that the
     * new board is "viewed" from the side of the player who's turn it is in the
     * new constellation.<br/>
     * 
     * @param constellation
     *        - The former constellation.
     */
    public Board(Constellation constellation) {
	// Copy the old board and mirror it
	for (int i = 0; i < this.boardArray.length; i++) {
	    for (int j = 0; j < this.boardArray[i].length; j++) {
		this.boardArray[i][j] = constellation.getBoard().boardArray[7 - i][7 - j];
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
	
	int line;
	
	// Fill in all white pawns.
	line = 1;
	for (int j = 0; j < boardArray[line].length; j++) {
	    this.boardArray[line][j] = ChessPieceContainer.getWhitePawn();
	}
	
	// Fill in all other white pieces.
	line = 0;
	this.boardArray[line][0] = ChessPieceContainer.getWhiteRook();
	this.boardArray[line][1] = ChessPieceContainer.getWhiteHorse();
	this.boardArray[line][2] = ChessPieceContainer.getWhiteBishop();
	this.boardArray[line][3] = ChessPieceContainer.getWhiteQueen();
	this.boardArray[line][4] = ChessPieceContainer.getWhiteHorse();
	this.boardArray[line][5] = ChessPieceContainer.getWhiteBishop();
	this.boardArray[line][6] = ChessPieceContainer.getWhiteHorse();
	this.boardArray[line][7] = ChessPieceContainer.getWhiteRook();
	
	// Fill in all black pawns.
	line = 6;
	for (int j = 0; j < boardArray[line].length; j++) {
	    this.boardArray[line][j] = ChessPieceContainer.getBlackPawn();
	}
	
	// Fill in all other black pieces.
	line = 7;
	this.boardArray[line][0] = ChessPieceContainer.getBlackRook();
	this.boardArray[line][1] = ChessPieceContainer.getBlackHorse();
	this.boardArray[line][2] = ChessPieceContainer.getBlackBishop();
	this.boardArray[line][3] = ChessPieceContainer.getBlackQueen();
	this.boardArray[line][4] = ChessPieceContainer.getBlackHorse();
	this.boardArray[line][5] = ChessPieceContainer.getBlackBishop();
	this.boardArray[line][6] = ChessPieceContainer.getBlackHorse();
	this.boardArray[line][7] = ChessPieceContainer.getBlackRook();
    }
    
    /**
     * @return - the {@link #boardArray}
     */
    public ChessPiece[][] getBoardArray() {
	return this.boardArray;
    }
    
}
