package pieces;

import util.Color;
import util.Move;
import core.Constellation;

public abstract class ChessPiece {
    
    protected ChessPiece(Color color) {
	this.color = color;
    }
    
    private final Color color;
    
    /**
     * @param constellation
     *        : the board constellation in which the piece shall be moved
     * @return an array which is true for every position the chess piece can
     *         move to in the board
     */
    public abstract Move getPossibleMoves(Constellation constellation);
    
    public Color getColor() {
	return this.color;
    }
}
