package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.Move;

public class MoveTest {
    
    public MoveTest() {
	// TODO Auto-generated constructor stub
	myMove.addDestination(destination);
	myMove.addDestination(destination2);
	myMove.addDestination(destination);
	myMove.addDestination(destination2);
	myMove.addDestination(destination);
	myMove.addDestination(destination2);
	myMove.addDestination(destination);
	myMove.addDestination(destination2);
    }
    
    int[] anArray = new int[2];
    int[] destination = { 3, 5 };
    int[] destination2 = { 1, 2 };
    Move myMove = new Move(anArray);
    
    public void testMove() {
	fail("Not yet implemented");
    }
    
    public void testAddDestinationIntInt() {
	fail("Not yet implemented");
    }
    
    public void testAddDestinationIntArray() {
	this.myMove.addDestination(this.destination);
	System.out.println("Pause here");
    }
    
    @Test
    public void testRetrieveAndDeleteFirstDestination() {
	
	System.out.println("Pause here");
	
    }
}
