package core;

import java.util.List;

import main.Color;
import pieces.*;

/**
 * @author Andy
 *
 *         Core of ChessConstellationMap <br/>
 *         Contains a chess board which contains all pieces in play<br/>
 *         Shall be able to create a new constellation with itself as a template<br/>
 *         Knows which constellations can be created out of it
 */
public class Constellation {

    // CONSTRUCTOR

    // ATTRIBUTES

    /**
     * Player that would have to move in this constellation,<br/>
     * e.g. in WHITE in the very first constellation
     */
    private Color movingPlayer;

    /**
     * Player which is set checkmate in the current constellation<br/>
     * Either null or same value as {@code movingPlayer}
     */
    private Color checkmatePlayer;

    private List<Constellation> nextPossibleMoves;
    private List<ChessPiece> pieces;

    private String id;

    // PRIVATE METHODS

    private void generateId() {

    }

    // PUBLIC METHODS

    // GETTERS AND SETTERS
    public String getId() {
	return this.id;
    }

}
