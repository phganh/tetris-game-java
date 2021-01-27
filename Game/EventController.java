package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;
import javax.swing.JFrame;

/*
 * 
 *	Handles events for the Tetris game
 *	User events (key strokes) as well as periodic timer events
 * 	Tell the game what to do
 */

public class EventController extends KeyAdapter implements ActionListener{
	
	private Game game;	// Current game: Grid & Current piece
	private Timer timer;
	
	private static final double PIECE_MOVE_TIME = 0.8 ;	// Wait 0.8s every time
	
	private boolean gameOver;
	
	/*
	 * Creates an EventController to handle key & timer events
	 * 
	 * @param game
	 * 				the game: this is controlling
	 */
	
	public EventController(Game game){
		this.game = game;
		gameOver = false;
		double delay = 1000 * PIECE_MOVE_TIME;	// in milliseconds
		timer = new Timer((int) delay, this);
		timer.setCoalesce(true);	// if multiple events pending, bunch hem to 1 event
		timer.start();
		
	}
	
	/**
	 * Responds to special keys being pressed
	 */
	
	public void keyPressed(KeyEvent e){
		
		// Press 'Q' -> quit
		if (e.getKeyCode() == KeyEvent.VK_Q){
			timer.stop();
			((JFrame) e.getSource()).dispose();
		}
		
		// Drop faster, move <, move >, Drop Down
		if(!gameOver){
			switch (e.getKeyCode()){
			
			// Drop faster 
			case KeyEvent.VK_DOWN:
				handleMove(Direction.DOWN);
				break;
				
			// Move to left >
			case KeyEvent.VK_LEFT:
				handleMove(Direction.LEFT);
				break;
				
			// Move to right <
			case KeyEvent.VK_RIGHT:
				handleMove(Direction.RIGHT);
				break;
				
			// Drop Down (SPACEBAR)
			case KeyEvent.VK_SPACE:
				handleMove(Direction.DROP);
				break;
				
			// Rotate ^
			case KeyEvent.VK_UP:
				game.rotatePiece();
				break;
			}
		}	
	}
	
	/**
	 * Updates the game periodically based on a timer event
	 */
	public void actionPerformed(ActionEvent e){
		handleMove(Direction.DOWN);
	}
	
	/**
	 * Update the game by moving in the given direction
	 */
	
	private void handleMove(Direction direction){
		game.movePiece(direction);
		gameOver = game.isGameOver();
		if (gameOver)
			timer.stop();
	}
}
