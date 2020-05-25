//Program when executed allows user to play Pong and face an unbeatable AI
//Author Brandon M. 
//Reference: https://www.youtube.com/watch?v=xIqeK2hzx1I

package PongV2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//Applet is interface that game is played on; other libraries help with graphics, inputs, and movement

public class Tennis extends Applet implements Runnable, KeyListener {
	final int WIDTH = 700, HEIGHT = 500;
	Thread thread;
	HumanPaddle p1;
	AIPaddle p2;
	Ball b1;
	boolean gameStarted;
//call main classes that Tennis inherits
	
	public void init() {
		this.resize(WIDTH, HEIGHT);
		gameStarted = false;
		this.addKeyListener(this);
		p1 = new HumanPaddle(1);
		b1 = new Ball();
		p2 = new AIPaddle(2, b1);
		thread = new Thread(this);
		thread.start();
    }
// init class helps with creation of game
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		if(b1.getX() < -10 || b1.getX() > 710) {
			g.setColor(Color.red);
			g.drawString("Game Over", 350, 250);
		}
		else{
			p1.draw(g);
			b1.draw(g);
			p2.draw(g);
		}
		
		if(!gameStarted) {
			g.setColor(Color.white);
			g.drawString("Tennis", 340, 100);
			g.drawString("Press Enter to Begin..", 310, 130);
		}
	}
	// paint class uses graphics library to essential 'draw' all the graphics used in the game
	
	public void update(Graphics g) {
		paint(g);
	}
   // update class updates graphics as game is run
	
	public void run() {
		for(;;){
			if(gameStarted) {
			p1.move();
			p2.move();
			b1.move();
			b1.checkPaddleCollision(p1, p2);
			}
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}	
    }
//run class allows paddles and ball to move as well as ball to move when it collides with paddle.
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			p1.setUpAccel(true);
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
		} else if(e.getKeyCode() == KeyEvent.VK_ENTER){
			gameStarted = true;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			p1.setUpAccel(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);	
		}	
	}

// keyPressed and key Released classes are used for user input when controlling paddle
	
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
	
	
	
