package pieces;

import core.Constellation;
import util.Color;
import util.Move;

public class Rook extends ChessPiece {

	public Rook(Color color) {
		super(color);
		// TODO Auto-generated constructor stub
	}


	/* (non-Javadoc)
	 * @see pieces.ChessPiece#getPossibleMoves(core.Constellation, int, int)
	 * Method finds all possible moves for current rook:<br/>
	 * 1. checking if assigned fromPos is correct
	 * 2. instantiating new Move-Object, called rookMoves
	 * 3. check for available moves to the north with for-loop
	 * 		a. if the next tile is empty, add this move to rookMoves
	 * 		b. if the next tile is not empty, check the piece's color
	 * 			- if the piece has not the same color as this rook, add this move to rookMoves and break the loop,
	 * 				because the rook isn't allowed to move past an enemy-piece without capturing it
	 * 			-if the piece has the same color as this rook, break the loop,
	 * 				because the rook isn't allowed to move past an allied-piece
	 * 4. check for available moves to the south with for-loop (same pattern as 3.)
	 * 5. check for available moves to the east with for-loop (same pattern as 3.)
	 * 6. check for available moves to the west with for-loop (same pattern as 3.)
	 * 7. TODO add SPECIAL MOVES
	 * 8. return rookMoves as complete Move-Object with all available moves from defined position
	 * TODO add different algorithm when king is checked!
	 */
	@Override
	public Move getPossibleMoves(Constellation constellation, int fromPosRow,
			int fromPosCol){
		ChessPiece[][] boardArray = constellation.getBoard().getBoardArray();
		
		//check if fromPos does actually describe rook's correct position
		//also throws exception, if tile is NULL!!
		if(boardArray[fromPosRow][fromPosCol] != this){throw new IllegalArgumentException("ERROR: assigned chess piece doesn't stand on fromPos={"+fromPosRow+fromPosCol+"}!");}
		
		//instantiating new Move-Object, that will be returned at the end of the process
		Move rookMoves = new Move(fromPosRow, fromPosCol);
		
		
		//check for moves to the NORTH, within board-range
		for(int row=fromPosRow+1; row<8; row++){
			if(boardArray[row][fromPosCol] == null){
				
				//if tile is empty, add available move
				rookMoves.addDestination(row, fromPosCol);
			}else{
				if(boardArray[row][fromPosCol].getColor() != this.getColor()){
					
					//if tile contains enemy-piece, add as available move
					//and stop loop, because rook can't move beyond that tile
					//possible TODO: add information that enemy-piece is captured!
					rookMoves.addDestination(row, fromPosCol); break;
				}else{
					
					//if tile contains allied piece, stop loop
					break;
				}
			}
		}
		
		//check for moves to the SOUTH, within board-range
		for(int row=fromPosRow-1; row>-1; row--){
			if(boardArray[row][fromPosCol] == null){
				
				//if tile is empty, add available move
				rookMoves.addDestination(row, fromPosCol);
			}else{
				if(boardArray[row][fromPosCol].getColor() != this.getColor()){
					
					//if tile contains enemy-piece, add as available move
					//and stop loop, because rook can't move beyond that tile
					//possible TODO: add information that enemy-piece is captured!
					rookMoves.addDestination(row, fromPosCol); break;
				}else{
					
					//if tile contains allied piece, stop loop
					break;
				}
			}
		}

		//check for moves to the EAST, within board-range
		for(int col=fromPosCol+1; col<8; col++){
			if(boardArray[fromPosRow][col] == null){
				
				//if tile is empty, add available move
				rookMoves.addDestination(fromPosRow, col);
			}else{
				if(boardArray[fromPosRow][col].getColor() != this.getColor()){
					
					//if tile contains enemy-piece, add as available move
					//and stop loop, because rook can't move beyond that tile
					//possible TODO: add information that enemy-piece is captured!
					rookMoves.addDestination(fromPosRow, col); break;
				}else{
					
					//if tile contains allied piece, stop loop
					break;
				}
			}
		}
		
		//check for moves to the WEST, within board-range
		for(int col=fromPosCol-1; col>-1; col--){
			if(boardArray[fromPosRow][col] == null){
				
				//if tile is empty, add available move
				rookMoves.addDestination(fromPosRow, col);
			}else{
				if(boardArray[fromPosRow][col].getColor() != this.getColor()){
					
					//if tile contains enemy-piece, add as available move
					//and stop loop, because rook can't move beyond that tile
					//possible TODO: add information that enemy-piece is captured!
					rookMoves.addDestination(fromPosRow, col); break;
				}else{
					
					//if tile contains allied piece, stop loop
					break;
				}
			}
		}
		
		return rookMoves;
	}


}
