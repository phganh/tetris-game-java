package Shapes;

import java.awt.Color;

import Game.AbstractPiece;
import Game.Grid;
import Game.Square;

public class SShape extends AbstractPiece {
	
	public SShape(int r, int c, Grid g){
		/*
		 *  Color:	Green
		 *  
		 * s:		1 0
		 * 		  3 2
		 *
		 */	
		
		super(g);
		
		square[0] = new Square(g, r - 1, c + 1, Color.GREEN, true);
		square[1] = new Square(g, r - 1, c, Color.GREEN, true);
		square[2] = new Square(g, r, c, Color.GREEN, true);
		square[3] = new Square(g, r, c - 1, Color.GREEN, true);
		
	}
}
