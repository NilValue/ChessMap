package test;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Board;

public class BoardTest {
    
    public BoardTest() {
	this.board = new Board();
	
    }
    
    private Board board;
    private int[] from = { 1, 2 };
    private int[] to = { 3, 7 };
    
    private int[] from2 = { 4, 5 };
    private int[] to2 = { 6, 8 };
    
    public void testBoard() {
	fail("Not yet implemented");
    }
    
    public void testBoardBoard() {
	fail("Not yet implemented");
    }
    
    @Test
    public void testAddMove() {
	try {
	    board.addMove(this.from, this.to);
	    System.out.println("Pause");
	    board.addMove(this.from, this.to2);
	    System.out.println("Pause");
	    board.addMove(this.from2, this.to);
	    System.out.println("Pause");
	    board.addMove(this.from2, this.to2);
	    System.out.println("Pause");
	    
	    board.addMove(this.from, this.to);
	    System.out.println("Pause");
	    board.addMove(this.from, this.to2);
	    System.out.println("Pause");
	    board.addMove(this.from2, this.to);
	    System.out.println("Pause");
	    board.addMove(this.from2, this.to2);
	    System.out.println("Pause");
	    
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	System.out.println("Pause");
	
    }
    
    public void testGetBoard() {
	fail("Not yet implemented");
    }
    
}
