package pieces;

import util.Color;
import util.Move;

public abstract class ChessPiece {

	protected ChessPiece(Color color) {
		this.color = color;
	}

	private final Color color;

	/**
	 * @param boardArray
	 *            - the board's boardArray of the constellation in which the
	 *            piece shall be moved
	 * @param fromPos
	 *            - the coordinates of the moving chess piece in the boardArray
	 * @return A move object containing all possible for that chess piece
	 */
	public final Move getPossibleMoves(ChessPiece[][] boardArray, int[] fromPos) {

		return this.getPossibleMoves(boardArray, fromPos[0], fromPos[1]);
	}

	/**
	 * Calls {@link #getPossibleMoves(ChessPiece[][], int[])}.<br/>
	 * The array coordinates of int[] are specified by {@code fromPosRow} and
	 * {@code fromPosCol}.
	 * 
	 * @param boardArray
	 *            - the board's boardArray of the constellation in which the
	 *            piece shall be moved
	 * @param fromPosRow
	 *            - first coordinate for the fromPos array
	 * @param fromPosCol
	 *            - second coordinate for the fromPos array
	 * @return A move object containing all possible for that chess piece
	 */
	public abstract Move getPossibleMoves(ChessPiece[][] boardArray,
			int fromPosRow, int fromPosCol);

	public final Color getColor() {
		return this.color;
	}
}
