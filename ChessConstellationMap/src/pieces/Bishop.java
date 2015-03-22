package pieces;

import core.Constellation;
import util.Color;
import util.Move;

public class Bishop extends ChessPiece {
    
    public Bishop(Color color) {
	super(color);
	// TODO Auto-generated constructor stub
    }
    
    /* (non-Javadoc)
     * @see pieces.ChessPiece#getPossibleMoves(core.Constellation, int, int)
     * Method finds all possible moves for current bishop:<br/>
	 * 1. checking if assigned fromPos is correct
	 * 2. instantiating new Move-Object, called bishopMoves
	 * 3. check for available moves to the north-east with while-loop
	 * 		a. if the next tile is empty, add this move to bishopMoves
	 * 		b. if the next tile is not empty, check the piece's color
	 * 			- if the piece has not the same color as this bishop, add this move to bishopMoves and break the loop,
	 * 				because the bishop isn't allowed to move past an enemy-piece without capturing it
	 * 			-if the piece has the same color as this bishop, break the loop,
	 * 				because the bishop isn't allowed to move past an allied-piece
	 * 4. check for available moves to the north-west with while-loop (same pattern as 3.)
	 * 5. check for available moves to the south-west with while-loop (same pattern as 3.)
	 * 6. check for available moves to the south-east with while-loop (same pattern as 3.)
	 * 7. no SPECIAL MOVES available
	 * 8. return bishopMoves as complete Move-Object with all available moves from defined position
	 * 9. TODO add different algorithm when king is checked!
     */
    @Override
    public Move getPossibleMoves(Constellation constellation, int fromPosRow,
			int fromPosCol) {
    	ChessPiece[][] b = constellation.getBoard().getBoardArray();
    	
    	//check if fromPos does actually describe rook's correct position
    	//also throws exception, if tile is NULL!!
    	if(b[fromPosRow][fromPosCol] != this){throw new IllegalArgumentException("ERROR: assigned chess piece doesn't stand on fromPos={"+fromPosRow+fromPosCol+"}!");}
    	
    	//instantiating new Move-Object, that will be returned at the end of the process
    	Move bishopMoves = new Move(fromPosRow, fromPosCol);
    	
    	//check for moves to the NORTH-EAST, within board-range
    	int row=fromPosRow+1, col=fromPosCol+1;
    	while(row<8 && col<8){
    		if(b[row][col] == null){
    			
    			//if tile is empty, add available move
				bishopMoves.addDestination(row, col);
    		}else{
				if(b[row][col].getColor() != this.getColor()){
					
					//if tile contains enemy-piece, add as available move
					//and stop loop, because rook can't move beyond that tile
					//possible TODO: add information that enemy-piece is captured!
					bishopMoves.addDestination(row, col); break;
				}else{
					
					//if tile contains allied piece, stop loop
					break;
				}
			}
    		row++; col++;
    	}
    	
    	//check for moves to the NORTH-WEST, within board-range
    	row=fromPosRow+1; col=fromPosCol-1;
    	while(row<8 && col>-1){
    		if(b[row][col] == null){
    			
    			//if tile is empty, add available move
				bishopMoves.addDestination(row, col);
    		}else{
				if(b[row][col].getColor() != this.getColor()){
					
					//if tile contains enemy-piece, add as available move
					//and stop loop, because rook can't move beyond that tile
					//possible TODO: add information that enemy-piece is captured!
					bishopMoves.addDestination(row, col); break;
				}else{
					
					//if tile contains allied piece, stop loop
					break;
				}
			}
    		row++; col--;
    	}
    	
    	//check for moves to the SOUTH-WEST, within board-range
    	row=fromPosRow-1; col=fromPosCol-1;
    	while(row>-1 && col>-1){
    		if(b[row][col] == null){
    			
    			//if tile is empty, add available move
				bishopMoves.addDestination(row, col);
    		}else{
				if(b[row][col].getColor() != this.getColor()){
					
					//if tile contains enemy-piece, add as available move
					//and stop loop, because rook can't move beyond that tile
					//possible TODO: add information that enemy-piece is captured!
					bishopMoves.addDestination(row, col); break;
				}else{
					
					//if tile contains allied piece, stop loop
					break;
				}
			}
    		row--; col--;
    	}
    	
    	//check for moves to the SOUTH-EAST, within board-range
    	row=fromPosRow-1; col=fromPosCol+1;
    	while(row>-1 && col<8){
    		if(b[row][col] == null){
    			
    			//if tile is empty, add available move
				bishopMoves.addDestination(row, col);
    		}else{
				if(b[row][col].getColor() != this.getColor()){
					
					//if tile contains enemy-piece, add as available move
					//and stop loop, because rook can't move beyond that tile
					//possible TODO: add information that enemy-piece is captured!
					bishopMoves.addDestination(row, col); break;
				}else{
					
					//if tile contains allied piece, stop loop
					break;
				}
			}
    		row--; col++;
    	}
    	
	return bishopMoves;
    }
    
}
