package util;

import java.util.ArrayList;
import java.util.Hashtable;

import core.Constellation;
import pieces.*;

public class IdManager {
    
    private final Hashtable<String, Constellation> constellationsTable = new Hashtable<String, Constellation>();;
    private final Hashtable<String, ArrayList<String>> followingConstellationsTable = new Hashtable<String, ArrayList<String>>();
    private final Hashtable<String, ArrayList<String>> formerConstellationsTable = new Hashtable<String, ArrayList<String>>();
    
    // Variables that code pieces on board.
    private final String PWN = "P";
    private final String ROK = "R";
    private final String KNT = "H";
    private final String BSH = "B";
    private final String QUN = "Q";
    private final String KNG = "K";
    
    /**
     * Adds a constellation only if it is not already contained.
     * 
     * @param id
     * @param constellation
     */
    public void addConstellation(String id, Constellation constellation) {
	this.constellationsTable.putIfAbsent(id, constellation);
	this.followingConstellationsTable.putIfAbsent(id, constellation.getFollowingConstellations());
	this.formerConstellationsTable.putIfAbsent(id, constellation.getFormerConstellations());
    }
    
    /**
     * @param id
     *        - The id of the constellation which is searched.
     * @return - the constellation object which is associated with the id.<br/>
     *         - null if there is no such object.
     */
    public Constellation getConstellation(String id) {
	return this.constellationsTable.get(id);
    }
    
    /**
     * @param boardArray
     *        - the current chess board in form of an array
     * @param movingPlayer
     *        - the color of currently moving player
     * @exception IllegalArgumentException
     *            thrown if assigned parameter isn't instance of a valid type
     * @return <b>String</b> - the ID uses the following pattern for the
     *         information of a chess piece:<br/>
     *         It starts with a character to indicate which player's turn it is
     *         (Black | White), value-range: "B", "W"<br/>
     *         <i>XYCP</i><br/>
     *         <ul>
     *         <li><b>X</b>: value of the row-position (1-8), value-range: 0-7</li>
     *         <li><b>Y</b>: value of the column-position (A-H), value-range:
     *         0-7</li>
     *         <li><b>C</b>: value of the piece's color (Black | White),
     *         value-range: "B", "W"</li>
     *         <li><b>P</b>: value of the piece's type = {<br/>
     *         Pawn = 'P',<br/>
     *         Rook = 'R',<br/>
     *         Knight(Horse) = 'H',<br/>
     *         Bishop = 'B',<br/>
     *         Queen = 'Q',<br/>
     *         King = 'K'}</li>
     *         </ul>
     *         The pattern repeats for all available pieces on the board.<br/>
     */
    public String generateId(ChessPiece[][] boardArray, Color movingPlayer) throws IllegalArgumentException {
	// 1. determine which player has to move, add to ID
	String id = this.convertColorToChar(movingPlayer);
	
	// 2. search through all tiles if there is a piece placed
	for (int row = 0; row < 8; row++) {
	    for (int col = 0; col < 8; col++) {
		if (boardArray[row][col] != null) {
		    String type = checkPieceType(boardArray[row][col]);
		    String color = convertColorToChar(boardArray[row][col].getColor());
		    
		    // 3. if you find a piece, add it's code to your ID.
		    id += Integer.toString(row) + Integer.toString(col) + color + type;
		}
	    }
	}
	
	// System.out.println("IdManager::generateIdForMapGeneration > return id: "
	// + id);
	
	return id;
    }
    
    /**
     * Adds a relationship between two constellations.<br/>
     * This means that the ID of the former constellation is added to the list
     * of IDs of the following constellation and vice versa.<br/>
     * These list have to be known to the constellation but should be attributes
     * of the IdManager class and manager by the IdManager class<br/>
     * 
     * @param idFormerConstellation
     *        - the ID of the former constellation
     * @param idFollowingConstellation
     *        - the ID of the following constellation
     */
    public void addRelationship(String idFormerConstellation, String idFollowingConstellation) {
	// TODO method implementation
	// TODO attributes to store the relationships within IdManager
    }
    
    /**
     * This method converts the assigned {@link Color} into a String:
     * Color.WHITE -> "W" | Color.BLACK -> "B"
     * 
     * @param c
     *        - assigned color
     * @return <b>String</b> - Color.WHITE -> "W" || Color.BLACK -> "B"
     * @throws IllegalArgumentException
     *         thrown if assigned parameter is no valid color (either WHITE or
     *         BLACK)
     */
    private String convertColorToChar(Color c) throws IllegalArgumentException {
	if (c == Color.WHITE) {
	    return "W";
	} else if (c == Color.BLACK) {
	    return "B";
	} else {
	    throw new IllegalArgumentException("Invalid color assigned.");
	}
    }
    
    /**
     * @param chessPiece
     *        - chessPiece that has to be examined according to it's type
     * @exception IllegalArgumentException
     *            thrown if assigned parameter isn't instance of type
     *            <ul>
     *            <li>{@link Bishop}</li>
     *            <li>{@link King}</li>
     *            <li>{@link Horse}</li>
     *            <li>{@link Pawn}</li>
     *            <li>{@link Queen}</li>
     *            <li>{@link Rook}</li>
     *            </ul>
     * @return <b>char</b> - character-value according to the kind of
     *         chessPiece, see current mapping in field-section.
     */
    private String checkPieceType(ChessPiece chessPiece) throws IllegalArgumentException {
	if (chessPiece instanceof Pawn) {
	    return PWN;
	} else if (chessPiece instanceof Rook) {
	    return ROK;
	} else if (chessPiece instanceof Horse) {
	    return KNT;
	} else if (chessPiece instanceof Bishop) {
	    return BSH;
	} else if (chessPiece instanceof Queen) {
	    return QUN;
	} else if (chessPiece instanceof King) {
	    return KNG;
	} else {
	    throw new IllegalArgumentException("Assigned chess piece is no instance of an available piece-class.");
	}
    }
}
