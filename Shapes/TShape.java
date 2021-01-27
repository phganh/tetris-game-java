package Shapes;

import java.awt.Color;

import Game.AbstractPiece;
import Game.Grid;
import Game.Square;

public class TShape extends AbstractPiece {
	
	public TShape(int r, int c, Grid g){
		
		/*
		 *  Color:	Yellow
		 *  
		 * t:		0 1 2
		 * 			  3
		 */
		
		super(g);
		square[0] = new Square(g, r - 1, c - 1, Color.YELLOW, true);
		square[1] = new Square(g, r - 1, c, Color.YELLOW, true);
		square[2] = new Square(g, r - 1, c + 1, Color.YELLOW, true);
		square[3] = new Square(g, r, c, Color.YELLOW, true);
		
	}
}
