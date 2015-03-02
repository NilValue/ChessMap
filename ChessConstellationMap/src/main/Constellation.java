package main;

import java.util.HashMap;
import java.util.List;

import pieces.*;

public class Constellation {

    // CONSTRUCTOR
    public Constellation() {
	this.mapBoardArray();
    }

    // ATTRIBUTES
    private ChessPiece[][] boardArray = new ChessPiece[8][8];
    private HashMap<String, ChessPiece> boardHashMap = new HashMap<String, ChessPiece>();

    private Color movingPlayer;
    private Color checkmatePlayer;

    private List<Constellation> nextPossibleMoves;
    private List<ChessPiece> pieces;

    private long numberOfPossibleMoves;
    private long id;

    // PRIVATE METHODS
    private void mapBoardArray() {
	for (int j = 0; j < 8; j++) {
	    for (int i = 0; i < 8; i++) {
		boardHashMap.put(String.valueOf((char) ('A' + i)) + Integer.toString(j + 1),
			boardArray[i][j]);
	    }
	}
    }

    private void generateId() {

    }

    // PUBLIC METHODS

    public ChessPiece getChessPiece(String position) {
	return boardHashMap.get(position);
    }

    // GETTERS AND SETTERS
    public long getId() {
	return id;
    }

}
