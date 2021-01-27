package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public interface Piece {
	
	public static final int PIECE_COUNT = 4;
	
	public void draw(Graphics g);
	
	public void move(Direction direction);
	
	public Point[] getLocations();
	
	public Color getColor();
	
	public boolean canMove(Direction direction);

	public boolean canRotate();
	
	public void rotate();

}
