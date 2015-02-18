package pt314.blocks.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameBoardTest {

	@Test
	public void testMoveBlock() {
		GameBoard gb = new GameBoard(3, 3);
		Block hBlock = new HorizontalBlock();
		Block vBlock = new VerticalBlock();
		
		
		gb.placeBlockAt(hBlock, 0, 0);
		gb.placeBlockAt(vBlock, 1, 1);
		
		
		assertFalse(gb.moveBlock(0, 0, Direction.LEFT, 2));//Out Of Bounds
		assertFalse(gb.moveBlock(0, 0, Direction.DOWN, 1));//Bad direction
		assertTrue(gb.moveBlock(0, 0, Direction.RIGHT, 1));//Good Move
		
		assertFalse(gb.moveBlock(1, 1, Direction.LEFT, 1));//Bad Direction
		assertFalse(gb.moveBlock(1, 1, Direction.DOWN, 2));//Out of Bounds
		assertFalse(gb.moveBlock(1, 1, Direction.UP, 1));//Another Block in the way
		assertTrue(gb.moveBlock(1, 1, Direction.DOWN, 1));//Good Move
		
		
	}

}
