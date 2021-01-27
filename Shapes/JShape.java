package Shapes;

import java.awt.Color;

import Game.AbstractPiece;
import Game.Grid;
import Game.Square;


public class JShape extends AbstractPiece {
	
	public JShape(int r, int c, Grid g){
		/*
		 *  Color:	Dark Light Blue
		 *   j:		0
		 * 			1
		 * 		  3 2
		 */
		
		super(g);
		square[0] = new Square(g, r - 1, c, Color.BLUE, true);
		square[1] = new Square(g, r, c, Color.BLUE, true);
		square[2] = new Square(g, r + 1, c, Color.BLUE, true);
		square[3] = new Square(g, r + 1, c - 1, Color.BLUE, true);
	}
}