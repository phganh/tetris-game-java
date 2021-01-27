package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import Shapes.BarShape;
import Shapes.JShape;
import Shapes.LShape;
import Shapes.SShape;
import Shapes.SquareShape;
import Shapes.TShape;
import Shapes.ZShape;

/*
 * Manages the game Tetris. Keeps track of the current piece and the grid.
 * 
 * Updates the display whenever the state of the game has changed
 */

public class Game {
	
	private Grid grid;					// the grid that make up the Tetris board
	private Tetris display;				// visual for the game
	private Piece piece;
	private static String name; // piece visual
	private boolean isOver;				// prompt to continue/quit
	private Random rand = new Random();

	// Running
	public Game(Tetris display){
		grid = new Grid();
		this.display = display;
		updatePiece();
		isOver = false;
	}
	
	/**
	 * Draws the current state of the game
	 */
	
	public void draw(Graphics g){
		grid.draw(g);
		if (piece != null){
			piece.draw(g);
		}
	}
	
	/**
	 * Moves the piece in the given direction
	 */
	
	public void movePiece(Direction direction){
		if (piece != null){
			if(direction == Direction.DROP){
				while(piece.canMove(Direction.DOWN)){
					piece.move(Direction.DOWN);
				}
			}else{
				piece.move(direction);
				
			}
		}
		updatePiece();
		display.update();
		grid.checkRows();
	}
	
	
	/**
	 * Rotates the piece clockwise
	 */
	//edit in HW2
	public void rotatePiece(){
		if( piece != null){
			if (piece.canRotate()){
				piece.rotate();
			}
		}
		updatePiece();
		display.update();
		grid.checkRows();
	}
	
	/**
	 * Return true of the game is over
	 */
	
	public boolean isGameOver(){
		// Game is over: piece occupies the same space as some non-empty
		// part of the grid
		if (piece == null){
			return false;
		}
		
		// check if game is already over
		if (isOver){
			return true;
		}
		
		// check every part of the piece
		Point[] p = piece.getLocations();
		for (int i = 0; i < p.length; i++){
			if(grid.isSet((int) p[i].getX(), (int) p[i].getY())){
				isOver = true;
				return true;
			}
		}
		return false;
	}
	
	// Updates the piece
	//edit in HW2
	private void updatePiece(){
		if(piece == null){
			
			// Get random number
			int n = rand.nextInt(7);
			
			//	Assign random number to shape
			switch(n) {
			case 0:	
				piece = new BarShape(1, Grid.WIDTH / 2 - 1, grid);
				name = "Bar";
				break;
					
			case 1:
				piece = new JShape(1, Grid.WIDTH / 2 - 1, grid);
				name = "J";
				break;
			
			case 2:
				piece = new LShape(1, Grid.WIDTH / 2 - 1, grid);
				name = "L";
				break;
				
			case 3:
				piece = new SShape(1, Grid.WIDTH / 2 - 1, grid);
				name = "S";
				break;
				
			case 4:
				piece = new TShape(1, Grid.WIDTH / 2 - 1, grid);
				name = "T";
				break;
				
			case 5:
				piece = new ZShape(1, Grid.WIDTH / 2 - 1, grid);
				name = "Z";
				break;
			
			case 6:
				piece = new SquareShape(1, Grid.WIDTH / 2 - 1, grid);
				name = "Square";
				break;
					
			}			
		}
		
		// set Grid positions correspondng to frozen piece & release the piece
		else if (!piece.canMove(Direction.DOWN)){
			Point[] p = piece.getLocations();
			Color c = piece.getColor();
			for (int i = 0; i < p.length;i++){
				grid.set((int) p[i].getX(), (int) p[i].getY(), c);
			}
			piece = null;
		}
		
	
	}
	//edit in HW2
	public static String getName() {
		return name;
	}
}
