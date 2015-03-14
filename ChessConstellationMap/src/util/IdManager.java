package util;

import java.util.Hashtable;

import core.Board;
import core.Constellation;
import pieces.*;

public class IdManager {
    public IdManager() {
	this.constellationsMap = new Hashtable<String, Constellation>();
    }
    
    private final Hashtable<String, Constellation> constellationsMap;
    //variables, that code pieces on board.
    /**ID-encoding for a {@link Pawn} */
    private final String PWN = "P";
    /**ID-encoding for a {@link Rook} */
	private final String ROK = "R";
    /**ID-encoding for a Knight ({@link Horse}) */
	private final String KNT = "H";
    /**ID-encoding for a {@link Bishop} */
	private final String BSH = "B";
    /**ID-encoding for a {@link Queen} */
	private final String QUN = "Q";
    /**ID-encoding for a {@link King} */
	private final String KNG = "K";
	
    public void addConstellation(Constellation constellation) {
	this.constellationsMap.putIfAbsent(constellation.getId(), constellation);
    }
    
    /**
     * @param id
     *        - The id of the constellation which is searched.
     * @return The constellation object which is associated with the id or null
     *         if there is no such object.
     */
    public Constellation getConstellation(String id) {
	return this.constellationsMap.get(id);
    }
    
    /**
     * @param constellation
     *        - The constellation for which an ID shall be generated.
     * @return An ID for the given constellation.<br/>
     *         Those IDs will become fairly long so String is the best type for
     *         them.<br/>
     *         Calls a private method because it might become handy to implement
     *         different types of IDs later on <br/>
     */
    public String generateId(Constellation constellation) {
    	return this.generateIdForMapGeneration(constellation.getBoard().getBoardArray(), constellation.getMovingPlayer());
    }
    
    // TODO unsure if needed
    public static Constellation generateConstellationFromId(String id) {
    }
    
    /**
     * 
     * @param board
     * - the current chess board in form of an array
     * @param c
     * - the color of currently moving player
     * @exception IllegalArgumentException
     * thrown if assigned parameter isn't instance of a valid type
     * @return <b>String</b>
     * - the ID uses the following pattern for the information of a chess piece:<br/>
     * It starts with a character to indicate which player's turn it is (Black | White), value-range: "B", "W"<br/>
     * <i>XYCP</i><br/>
     * <ul><li><b>X</b>: value of the row-position (1-8), value-range: 0-7</li>
     * <li><b>Y</b>: value of the column-position (A-H), value-range: 0-7</li>
     * <li><b>C</b>: value of the piece's color (Black | White), value-range: "B", "W"</li>
     * <li><b>P</b>: value of the piece's type = {<br/>
     * Pawn = 'P',<br/>
     * Rook = 'R',<br/>
     * Knight(Horse) = 'H',<br/>
     * Bishop = 'B',<br/>
     * Queen = 'Q',<br/>
     * King = 'K'}</li></ul>
     * The pattern repeats for all available pieces on the board.<br/>
     */
    private String generateIdForMapGeneration(ChessPiece[][] board, Color c) throws IllegalArgumentException {
    	//1. determine which player has to move, add to ID
    	String id = this.convertColorToChar(c);
    	
    	//2. search through all tiles if there is a piece placed
		for(int row=0; row<8; row++){
			for(int col=0; col<8; col++){
				if(board[row][col] != null){
					String type = checkPieceType(board[row][col]);
					String color = convertColorToChar(board[row][col].getColor());
					
					//3. if you find a piece, add it's code to your ID.
					id += Integer.toString(row) + Integer.toString(col) + color + type;
				}
			}
		}
		
		System.out.println("IdManager::generateIdForMapGeneration > return id: " +id);
		return id;
    }
    
    /**
     * This method converts the assigned {@link Color} into a String: Color.WHITE -> "W" | Color.BLACK -> "B"
     * @param c
     * - assigned color
     * @return <b>String</b>
     * - Color.WHITE -> "W" || Color.BLACK -> "B"
     * @throws IllegalArgumentException
     * thrown if assigned parameter is no valid color (either WHITE or BLACK)
     */
    private String convertColorToChar(Color c) throws IllegalArgumentException {
		if(c == Color.WHITE){return "W";}
		else if(c == Color.BLACK){return "B";}
		else{throw new IllegalArgumentException("Invalid color assigned.");}
	}

	/**
     * @param chessPiece
     * - chessPiece that has to be examined according to it's type
     * @exception IllegalArgumentException
     * thrown if assigned parameter isn't instance of type
     * <ul><li>{@link Bishop}</li><li>{@link King}</li><li>{@link Horse}</li><li>{@link Pawn}</li><li>{@link Queen}</li><li>{@link Rook}</li></ul>
     * @return <b>char</b>
     * - character-value according to the kind of chessPiece, see current mapping in field-section.
     */
    private String checkPieceType(ChessPiece chessPiece) throws IllegalArgumentException {
		if(chessPiece instanceof Pawn){return PWN;}
		else if(chessPiece instanceof Rook){return ROK;}
		else if(chessPiece instanceof Horse){return KNT;}
		else if(chessPiece instanceof Bishop){return BSH;}
		else if(chessPiece instanceof Queen){return QUN;}
		else if(chessPiece instanceof King){return KNG;}
		else{throw new IllegalArgumentException("Assigned chess piece is no instance of an available piece-class.");}
	}
}
