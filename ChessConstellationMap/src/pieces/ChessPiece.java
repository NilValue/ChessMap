package pieces;

import java.util.List;

import core.Board;
import main.Color;

public abstract class ChessPiece {
    
    protected ChessPiece(Color color) {
	this.color = color;
    }
    
    protected Color color;
    
    /**
     * @param board
     *        : the board constellation in which the piece shall be moved
     * @return an array which is true for every position the chess piece can
     *         move to in the board
     */
    public abstract List<Integer[]> getPossibleMoves(Board board);
    
    public Color getColor() {
	return this.color;
    }
}
