package Main;

import java.util.HashMap;
import Pieces.*;

public class Constellation {

    // CONSTRUCTOR
    public Constellation() {
	this.mapBoardArray();
    }

    // ATTRIBUTES
    private long id;
    private ChessPiece[][] boardArray = new ChessPiece[8][8];
    private HashMap<String, ChessPiece> board = new HashMap<String, ChessPiece>();

    // PRIVATE METHODS
    private void mapBoardArray() {
	for (int j = 0; j < 8; j++) {
	    for (int i = 0; i < 8; i++) {
		board.put(
			String.valueOf((char) ('A' + i))
				+ Integer.toString(j + 1), boardArray[i][j]);
	    }
	}
    }

    // PUBLIC METHODS

    public ChessPiece getChessPiece(String position) {
	return board.get(position);
    }

    // GETTERS AND SETTERS
    public long getId() {
	return id;
    }

}
