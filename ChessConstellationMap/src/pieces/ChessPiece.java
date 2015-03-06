package pieces;

import core.Board;
import core.Constellation;
import main.Color;

public abstract class ChessPiece {

    protected ChessPiece(Constellation callingConstellation,
			 Color color,
			 String position) {
	this.color = color;

    }

    // ATTRIBUTES
    protected Color color;

    // PROTECTED ABSTRACT METHODS
    /**
     * @param board
     *        : the board constellation in which the piece shall be moved
     * @return an array which is true for every position the chess piece can
     *         move to in the board
     */
    protected abstract boolean[][] getPossibleMoves(Board board);

}
