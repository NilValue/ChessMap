package core;

import java.util.List;

import main.Color;
import pieces.*;

/**
 * @author Andy
 *
 *         Core of ChessConstellationMap <br/>
 *         Contains a chess board which contains all pieces in play<br/>
 *         Shall be able to create and instantiate all new constellations out of
 *         itself and add the to its containing map <br/>
 *         Knows which constellations can be created out of it
 */
public class Constellation {

    /**
     * This constructor will only be invoked when adding a new constellation to
     * an empty map
     */
    public Constellation() {
	this.movingPlayer = Color.WHITE;
    }

    /**
     * This constructor creates a new constellation based on an existing
     * constellation<br/>
     * It will:<br/>
     * 1.) execute the move on the board<br/>
     * 2.)<br/>
     * X.) Check if there can follow any constellation after it<br/>
     * 
     * @param constellation
     *        : The constellation from which the new constellation is created
     */
    public Constellation(Constellation constellation) {
	// Defining the color of the moving player in the new constellation
	switch (constellation.movingPlayer) {

	    case BLACK:
		this.movingPlayer = Color.WHITE;
		break;

	    case WHITE:
		this.movingPlayer = Color.BLACK;
		break;

	}
    }

    // CONSTRUCTOR

    // ATTRIBUTES

    /**
     * Player that would have to move in this constellation,<br/>
     * e.g. in WHITE in the very first constellation
     */
    private Color movingPlayer;

    /**
     * Player which is set checkmate in the current constellation<br/>
     * Either null or same value as {@code movingPlayer}<br/>
     * <br/>
     * If checkmate != null then nextPossibleMoves == null
     */
    private Color checkmatePlayer;

    private Board board;

    private List<Constellation> nextPossibleMoves;
    private List<ChessPiece> pieces;

    private String id;

    // PRIVATE METHODS

    private void generateId() {

    }

    // PUBLIC METHODS

    // GETTERS AND SETTERS

    public String getId() {
	if (id == null) {
	    this.generateId();
	}
	return this.id;
    }

}
