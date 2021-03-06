package pt314.blocks.game;

import java.awt.Color;

/**
 * Generic block.
 * 
 * Subclasses should specify the directions in which they can be moved.
 */
public abstract class Block {
	
	public Block() {}

	public abstract boolean isValidDirection(Direction dir);

	public abstract Color getColor();
}
