package core;

import pieces.ChessPiece;

/**
 * @author Andy
 * 
 *         Representation of the chess board within a constellation
 */
public class Board {

    /**
     * Default constructor for the first board in the first constellation of the
     * map<br/>
     * Fills the board with the starting positions
     */
    public Board() {
	this.board = new ChessPiece[8][8];
    }

    /**
     * Generates a copy of an existing board
     * 
     * @param board
     *        : board from which the new board is cloned
     */
    public Board(Board board) {

    }

    /**
     * Contains and represents the chess board and its pieces
     */
    private ChessPiece[][] board;

    /**
     * ID of the board<br/>
     * Two different constellations may point to the same board
     */
    private String id;

    /**
     * @param line
     *        of the chess board ({@link #board}) as short
     * @param row
     *        of the chess board ({@link #board}) as short
     * @return ChessPiece element of {@link #board}<br/>
     *         Returns null if there is no chessPiece at that position
     */
    public ChessPiece getTile(short line, short row) {
	return this.board[line][row];
	// TODO what if returned tile is NULL?
    }

    private void moveChessPiece(short lineFrom,
				short rowFrom,
				short lineTO,
				short rowTo) {
	// TODO implement method
    }
}
