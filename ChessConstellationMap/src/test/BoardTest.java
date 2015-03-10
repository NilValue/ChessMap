package test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import pieces.Bishop;
import pieces.ChessPiece;
import util.Color;
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
    
    public void testCopyConstructor() {
	Board board = new Board();
	Board board2 = new Board();
	
	for (int i = 0; i < board.getBoard().length; i++) {
	    for (int j = 0; j < board.getBoard()[i].length; j++) {
		board2.getBoard()[i][j] = new Bishop(Color.BLACK);
		
	    }
	}
	System.out.println("PAUSE");
	
	// try {
	// board.getBoard()[i][j] = board2.getBoard()[i][j].getClass()
	// .getConstructor(Color.class)
	// .newInstance(Color.WHITE);
	// } catch (InstantiationException
	// | IllegalAccessException
	// | IllegalArgumentException
	// | InvocationTargetException
	// | NoSuchMethodException
	// | SecurityException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	
	board = board2;
	
	for (int i = 0; i < board.getBoard().length; i++) {
	    for (int j = 0; j < board.getBoard()[i].length; j++) {
		board2.getBoard()[i][j] = null;
		System.out.println("PAUSE");
	    }
	}
	System.out.println("PAUSE");
    }
    
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
    
    @Test
    public void myTest() {
	Bishop myBishop = new Bishop(Color.WHITE);
	myBishop.testMethod();
    }
}
