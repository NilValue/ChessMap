package core;

import java.util.HashMap;

import pieces.ChessPiece;

/**
 * @author Andy
 * 
 *         Representation of the chess board in a constellation
 */
public class Board {

    public Board() {
	this.mapBoardArray();
    }

    // ATTRIBUTES

    /**
     * Contains and represents the chess board and its pieces
     */
    private ChessPiece[][] boardArray = new ChessPiece[8][8];

    /**
     * HashMap mapping field names (e.g. "A1", "A2", ...) to {@link #boardArray}
     */
    private HashMap<String, ChessPiece> boardHashMap = new HashMap<String, ChessPiece>();

    /**
     * Fills {@link #boardHashMap}
     */
    private void mapBoardArray() {
	for (int j = 0; j < 8; j++) {
	    for (int i = 0; i < 8; i++) {
		boardHashMap.put(String.valueOf((char) ('A' + i)) + Integer.toString(j + 1),
			boardArray[i][j]);
	    }
	}
    }

    /**
     * @param position
     *        as String
     * @return ChessPiece element from {@link #boardArray}
     */
    public ChessPiece getChessPiece(String position) {
	return this.boardHashMap.get(position);
	// TODO what if returned tile is NULL?
    }

    /**
     * @param line
     *        of the chess board ({@link #boardArray}) as short
     * @param row
     *        of the chess board ({@link #boardArray}) as short
     * @return ChessPiece element of {@link #boardArray}
     */
    public ChessPiece getChessPiece(short line, short row) {
	return this.boardArray[line][row];
	// TODO what if returned tile is NULL?
    }

    public void addChessPiece(ChessPiece pieceToAdd, String position) {
	// TODO method logic and comments
    }

    public void addChessPiece(ChessPiece pieceToAdd, short line, short row) {
	// TODO method logic and comments
    }
}
