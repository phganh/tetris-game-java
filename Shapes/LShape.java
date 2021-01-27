package Shapes;

import java.awt.Color;

import Game.AbstractPiece;
import Game.Grid;
import Game.Square;

public class LShape extends AbstractPiece {

	public LShape(int r, int c, Grid g) {
		
		super(g);
		square[0] = new Square(g, r - 1, c, Color.magenta, true);
		square[1] = new Square(g, r, c, Color.magenta, true);
		square[2] = new Square(g, r + 1, c, Color.magenta, true);
		square[3] = new Square(g, r + 1, c + 1, Color.magenta, true);
	}
}