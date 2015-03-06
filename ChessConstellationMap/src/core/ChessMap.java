package core;

import java.util.Hashtable;

public class ChessMap {

    // ATTRIBUTES
    private Hashtable<String, Constellation> constellations = new Hashtable<String, Constellation>();

    private Constellation getConstellationById(String id) {
	return constellations.get(id);
    }

    // PUBLIC METHODS
    public void startMapGeneration() {

    }

    public void pauseMapGeneration() {

    }

    public void continueMapGeneration() {

    }

    public void saveMap() {

    }

    public void loadMap() {

    }

    public void generateNextConstellation() {

    }

    public void move() {

	//@formatter:off
	/*
	 * 1.) new constellation
	 * 2.) make a move, depending which player's turn
	 * 3.) check if new constellation already exists
	 * 	=> add if not, dismiss if it does
	 * 4.) repeat with another move
	 */
	//@formatter:on
    }
    // GETTERS AND SETTERS
}
