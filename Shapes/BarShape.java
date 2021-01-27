package Shapes;

import java.awt.Color;

import Game.AbstractPiece;
import Game.Grid;
import Game.Square;

public class BarShape extends AbstractPiece {
	
	public BarShape(int r, int c, Grid g){
		/*
		 *  Color:	Light Blue
		 *  b:		0 1 2 3
		 *  
		 */
		
		super(g);
		square[0] = new Square(g, r - 1, c, Color.CYAN, true);
		square[1] = new Square(g, r - 1, c + 1, Color.CYAN, true);
		square[2] = new Square(g, r - 1, c + 2, Color.CYAN, true);
		square[3] = new Square(g, r - 1, c + 3, Color.CYAN, true);
		
	}
}
