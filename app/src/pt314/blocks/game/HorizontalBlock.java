package pt314.blocks.game;

import java.awt.Color;

/**
 * This type of block can only move horizontally (left or right).
 */
public class HorizontalBlock extends Block {

	public HorizontalBlock() {}

	@Override
	public boolean isValidDirection(Direction dir) {
		return dir == Direction.LEFT || dir == Direction.RIGHT;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.GREEN;
	}
}
