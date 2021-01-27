package Shapes;

import java.awt.Color;

import Game.AbstractPiece;
import Game.Grid;
import Game.Square;

public class ZShape extends AbstractPiece {
	
	public ZShape (int r, int c, Grid g){
		/* 
		 * Color:	Red
		 * z:		0 1
		 * 			  2 3
		 * 
		 */
		
		super(g);
		square[0] = new Square(g, r - 1, c, Color.RED, true);
		square[1] = new Square(g, r - 1, c + 1, Color.RED, true);
		square[2] = new Square(g, r, c + 1, Color.RED, true);
		square[3] = new Square(g, r, c + 2, Color.RED, true);
		
	}
}
