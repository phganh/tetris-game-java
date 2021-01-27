package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class AbstractPiece implements Piece{
	
	protected boolean ableToMove; 		
	protected String name;
	protected static Square[] square; 


	protected Grid grid; 
	
	public AbstractPiece(Grid g){
		grid = g;
		square = new Square[PIECE_COUNT];
		ableToMove = true;
	}
	
	/* ******************************************** */
	
	public void draw(Graphics g) {
		for (int i = 0; i < PIECE_COUNT; i++) {
			square[i].draw(g);
		}
	}
	
	/* ******************************************** */
	
	public Point[] getLocations() {
		Point[] points = new Point[PIECE_COUNT];
		for (int i = 0; i < PIECE_COUNT; i++) {			
			points[i] = new Point(square[i].getRow(), square[i].getCol());
		}
		return points;
	}
	
	/* ******************************************** */
	
	public void move(Direction direction) {
		
		if (canMove(direction)) {
			for (int i = 0; i < PIECE_COUNT; i++)
				square[i].move(direction);
		}
		else if (direction == Direction.DOWN) {
			ableToMove = false;
		}
	}

	/* ******************************************** */
	
	public boolean canMove(Direction direction) {
		if (!ableToMove)
			return false;

		// Each square must be able to move in that direction
		boolean answer = true;
		for (int i = 0; i < PIECE_COUNT; i++) {
			answer = answer && square[i].canMove(direction);
		}
		return answer;
	}
	
	/* ******************************************** */

	public boolean canRotate(){
		// loop over the squares in square
		// check if each square can rotate about square[1]
		// -> yes return true
		// -> no return false
		for(Square s: square) { 
			if (!s.canRotateAbout(square[1])){
				return false;
			}
		}
		return true;
	}
	
	/* ******************************************** */
	
	public void rotate() {
		for(Square s: square) { 
			s.rotateAbout(square[1]);
		}
	}
	
	/* ******************************************** */
	
	public Color getColor() {
		return square[0].getColor();
	}

}
