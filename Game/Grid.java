package Game;

import java.awt.Color;
import java.awt.Graphics;

/*
 *	This is the Tetris board represented by a (HEIGHT - by WIDTH) matrix of Squares
 *
 * The upper left Square is at (0,0)
 * The lower Square is at (HEIGHT -1, WIDTH -1)
 * 
 * Given a Square at (x,y) the square to the left is at (x-1,y) 
 * 										 the square below is at (x, y+1)
 * 
 * Each Square has a color.
 * White Square : empty
 * Color Squares: occupied
 * 
 * A grid will also remove completely full rows
 * 
 */

public class Grid {

	private Square[][] board;

	// Width & Height of play screen in number of squares
	public static final int HEIGHT = 20;
	public static final int WIDTH = 10;

	// Where play screen locate
	public static final int LEFT = 100; // pixel left position of grid
	public static final int TOP = 50; // pixel top position of grid

	// Border of play screen
	private static final int BORDER = 5;

	public static final Color EMPTY = Color.WHITE;

	// Creating grid (play screen)

	public Grid() {

		board = new Square[HEIGHT][WIDTH];

		// squares in the board
		for (int row = 0; row < HEIGHT; row++) {
			for (int col = 0; col < WIDTH; col++) {
				board[row][col] = new Square(this, row, col, EMPTY, false);
			}
		}
	}

	/**
	 * Return true if the location (row, col) on the grid is occupied
	 * 
	 * @param row
	 *            the row in the grid
	 * @param col
	 *            the column in the grid
	 * 
	 */

	public boolean isSet(int row, int col) {
		return !board[row][col].getColor().equals(EMPTY);
	}

	/**
	 * Changes the color of the Square at the given location
	 * 
	 * @param row
	 *            the row of the Square in the Grid
	 * @param col
	 *            the column of the Square in the Grid
	 * @param c
	 *            the color to set the Square
	 * @throws IndexOutOfBoundsException
	 *             if row < 0 || row >= HEIGHT || col < 0 || col >= WIDTH
	 */

	public void set(int row, int col, Color c) {
		board[row][col].setColor(c);
	}

	/*
	 * Checks for & remove all solid rows of squares
	 * 
	 * If a solid row is found and removed, all rows above it are moved down and
	 * the top row set to empty
	 */

	public void checkRows() {

		for (int row = 0; row < HEIGHT ; row++) {
			boolean isFull = true;
			for (int col = 0; col < WIDTH ; col++) {
				if (board[row][col].getColor().equals(EMPTY)) {
					isFull = false;
					break;
				}
			}

			if (isFull) {
				// clear row since it is full
				// loop r = row to 1
				for (int r = row; r >= 1; r--) {
					for (int col = 0; col < WIDTH ; col++) {
						// given r, loop over all of the columns of r
						board[r][col].setColor((board[r - 1][col]).getColor());
					}
				}
				// clear row = 0
				for (int c = 0; c < WIDTH; c ++) {
					board[0][c].setColor(EMPTY);
				}
			}

		}
	}

	/*
	 * Draws the Grid on the given Graphics context
	 */

	public void draw(Graphics g) {

		// draw the edges as rectangles: left, right in blue then bottom in red

		g.setColor(Color.BLUE);
		g.fillRect(LEFT - BORDER, TOP, BORDER, HEIGHT * Square.HEIGHT);
		g.fillRect(LEFT + WIDTH * Square.WIDTH, TOP, BORDER, HEIGHT * Square.HEIGHT);

		g.setColor(Color.RED);
		g.fillRect(LEFT - BORDER, TOP + HEIGHT * Square.HEIGHT, WIDTH * Square.WIDTH + 2 * BORDER, BORDER);

		// draw all the squares in the grid
		// empty ones first ( to avoid masking the black lines of the pieces
		// have already fallen)

		for (int r = 0; r < HEIGHT; r++) {
			for (int c = 0; c < WIDTH; c++) {
				if (board[r][c].getColor().equals(EMPTY)) {
					board[r][c].draw(g);
				}
			}
		}
		for (int r = 0; r < HEIGHT; r++) {
			for (int c = 0; c < WIDTH; c++) {
				if (!board[r][c].getColor().equals(EMPTY)) {
					board[r][c].draw(g);
				}
			}
		}
	}
}
