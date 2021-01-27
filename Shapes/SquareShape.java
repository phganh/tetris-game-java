package Shapes;

import java.awt.Color;

import Game.AbstractPiece;
import Game.Grid;
import Game.Square;

public class SquareShape extends AbstractPiece {

	public SquareShape(int r, int c, Grid g){
		/*
		 * Color:	Gray
		 * 
		 * sqrt: 	0 1
		 * 			2 3
		 */
		
		super(g);
		square[0] = new Square(g, r - 1, c, Color.GRAY, true);
		square[1] = new Square(g, r - 1, c + 1, Color.GRAY, true);
		square[2] = new Square(g, r, c, Color.GRAY, true);
		square[3] = new Square(g, r, c + 1, Color.GRAY, true);
		
	}	
}
