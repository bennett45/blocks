package pt314.blocks.game;

import static org.junit.Assert.*;

import org.junit.Test;


public class MoveBlockTest {

	//horizontal block tests
	@Test
	public void moveHorizontalBlockRight() 
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new HorizontalBlock(), 2, 1);
		
		assertTrue(gameboard.moveBlock(2, 1, Direction.RIGHT, 1));
		assertTrue(gameboard.getBlockAt(2, 2) instanceof HorizontalBlock);
	}
	
	@Test
	public void moveHorizontalBlockLeft() 
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new HorizontalBlock(), 2, 2);
		
		assertTrue(gameboard.moveBlock(2, 2, Direction.LEFT, 1));
		assertTrue(gameboard.getBlockAt(2, 1) instanceof HorizontalBlock);
	}
	
	@Test
	public void moveHorizontalBlockUp() 
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new HorizontalBlock(), 2, 1);
		
		assertFalse(gameboard.moveBlock(2, 1, Direction.UP, 1));
		assertNull(gameboard.getBlockAt(1, 1));
	}
	@Test
	public void moveHorizontalBlockDown() 
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new HorizontalBlock(), 2, 1);
		
		assertFalse(gameboard.moveBlock(2, 1, Direction.DOWN, 1));
		assertNull(gameboard.getBlockAt(3, 1));
	}
	
	//vertical block tests
	@Test
	public void moveVerticalBlockRight() 
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new VerticalBlock(), 2, 1);
		
		assertFalse(gameboard.moveBlock(2, 1, Direction.RIGHT, 1));
		assertNull(gameboard.getBlockAt(2, 2));
	}
	
	@Test
	public void moveVerticalBlockLeft() 
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new VerticalBlock(), 2, 2);
		
		assertFalse(gameboard.moveBlock(2, 2, Direction.LEFT, 1));
		assertNull(gameboard.getBlockAt(2, 1));
	}
	
	@Test
	public void moveVerticalBlockUp() 
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new VerticalBlock(), 2, 1);
		
		assertTrue(gameboard.moveBlock(2, 1, Direction.UP, 1));
		assertTrue(gameboard.getBlockAt(1, 1) instanceof VerticalBlock);
	}
	@Test
	public void moveVerticalBlockDown() 
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new VerticalBlock(), 2, 1);
		
		assertTrue(gameboard.moveBlock(2, 1, Direction.DOWN, 1));
		assertTrue(gameboard.getBlockAt(3, 1) instanceof VerticalBlock);
	}
	
	//target block tests
	@Test
	public void moveTargetBlockRight() 
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new TargetBlock(), 2, 1);
		
		assertTrue(gameboard.moveBlock(2, 1, Direction.RIGHT, 1));
		assertTrue(gameboard.getBlockAt(2, 2) instanceof TargetBlock);
	}
	
	@Test
	public void moveTargetBlockLeft() 
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new TargetBlock(), 2, 2);
		
		assertTrue(gameboard.moveBlock(2, 2, Direction.LEFT, 1));
		assertTrue(gameboard.getBlockAt(2, 1) instanceof TargetBlock);
	}
	
	@Test
	public void moveTargetBlockUp() 
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new TargetBlock(), 2, 1);
		
		assertFalse(gameboard.moveBlock(2, 1, Direction.UP, 1));
		assertNull(gameboard.getBlockAt(1, 1));
	}
	@Test
	public void moveTargetBlockDown() 
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new TargetBlock(), 2, 1);
		
		assertFalse(gameboard.moveBlock(2, 1, Direction.DOWN, 1));
		assertNull(gameboard.getBlockAt(3, 1));
	}
	
	@Test
	public void moveTargetBlockToWinningSpace() 
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new TargetBlock(), 2, 1);
		
		gameboard.moveBlock(2, 1, Direction.RIGHT, 3);
		assertTrue(gameboard.isGameOver());
	}
	
	
	//other tests
	@Test 
	public void moveOutsidePlayingArea()
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new HorizontalBlock(), 2, 1);
		gameboard.placeBlockAt(new VerticalBlock(), 3, 3);
		
		assertFalse(gameboard.moveBlock(2, 1, Direction.RIGHT, 10));
		assertFalse(gameboard.moveBlock(3, 3, Direction.UP, 10));
	}
	
	@Test 
	public void moveOutsidePlayingAreaNegative()
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new HorizontalBlock(), 2, 1);
		gameboard.placeBlockAt(new VerticalBlock(), 3, 3);
		

		assertFalse(gameboard.moveBlock(3, 3, Direction.DOWN, 10));
		assertFalse(gameboard.moveBlock(2, 1, Direction.LEFT, -10));
	}
	
	@Test 
	public void moveOppositeValues()
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new HorizontalBlock(), 2, 1);
		
		assertFalse(gameboard.moveBlock(2, 1, Direction.RIGHT, -10));
	}
	
	@Test 
	public void blockInTheWayTest()
	{
		GameBoard gameboard = new GameBoard(5,5);
		gameboard.placeBlockAt(new HorizontalBlock(), 2, 1);
		gameboard.placeBlockAt(new VerticalBlock(), 3, 3);
		gameboard.placeBlockAt(new HorizontalBlock(), 2, 3);
		gameboard.placeBlockAt(new VerticalBlock(), 2, 3);
		

		assertFalse(gameboard.moveBlock(2, 1, Direction.RIGHT, 3));
		assertFalse(gameboard.moveBlock(3, 3, Direction.UP, 2));
	}
	
	@Test
	public void moveNullBlock()
	{
		GameBoard gameboard = new GameBoard(5,5);
		assertFalse(gameboard.moveBlock(2, 1, Direction.RIGHT, 3));
	}
	

}
