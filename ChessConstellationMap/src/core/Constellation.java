package core;

import main.Color;

/**
 * "Core"-Element of ChessMap. <br/>
 * Contains a pointer to a chess board ({@link #board} which contains pointers
 * to all pieces in play and their positions.<br/>
 * Is able to create and instantiate all new constellations out of itself and
 * add the to its containing map. <br/>
 * Knows which constellations can be created out of it (
 * {@link #nextPossibleMoves}).<br/>
 * <br/>
 * Two different constellations shall point to the same board if they share it.<br/>
 * Two constellations with the same board differ in:<br/>
 * - the color of the moving player ({@link #movingPlayer})<br/>
 * - the color of the player which is checkmate (@link {@link #checkmatePlayer})<br/>
 * - the list of the {@link #nextPossibleMoves}<br/>
 * 
 * @author Andy
 * 
 */
public class Constellation {
    
    /**
     * This constructor will only be invoked when adding a new constellation to
     * an empty map.<br/>
     * It represents the constellation at the start of a game of chess.<br/>
     * Therefore it does the following:<br/>
     * - {@link #allPossibleMovesGenerated} is set to {@code false}.<br/>
     * - {link #movingPLayer} is set to {@code Color.WHITE}.<br/>
     * - {link #board} will receive a new instance of the class {@code Board}
     * using the default constructor.
     * 
     */
    public Constellation() {
	this.allPossibleMovesGenerated = false;
	this.movingPlayer = Color.WHITE;
	this.board = new Board();
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
	
	this.allPossibleMovesGenerated = false;
	
	// Defining the color of the moving player in the new constellation
	switch (constellation.movingPlayer) {
	
	    case BLACK:
		this.movingPlayer = Color.WHITE;
		break;
	    
	    case WHITE:
		this.movingPlayer = Color.BLACK;
		break;
	}
	
	// Generate a copy of the old constellation's board with the copy
	// constructor of Board
	this.board = new Board(constellation.board);
    }
    
    /**
     * Player that would have to do the next move in this constellation,<br/>
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
    private boolean allPossibleMovesGenerated;
    private String Id;
    
    public void checkForCheckmate() {
	
    }
}
