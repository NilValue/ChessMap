package pieces;

import core.Constellation;
import main.Color;

public abstract class ChessPiece {

    protected ChessPiece(Constellation callingConstellation,
	    Color color,
	    String position) {
	this.color = color;
	this.position = position;
	this.containingConstellation = callingConstellation;
    }

    // ATTRIBUTES
    protected Constellation containingConstellation;
    protected ChessPiece[][] possibleMoves = new ChessPiece[8][8];
    protected boolean hasMoved;
    protected Color color;
    protected String position;

    // PROTECTED ABSTRACT METHODS
    protected abstract void calculatePossibleMoves();

}
