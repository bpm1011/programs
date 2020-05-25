package PongV2;

import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements Paddle {
	double y, yVel;
	boolean upAccel, downAccel;
	final double GRAVITY = 0.94;
	int player, x;
//declares variables used in HumanPaddle class that implements Paddle interface
	
	public HumanPaddle(int player) {
		upAccel = false; downAccel = false;
		y = 210; yVel = 0;
		if(player == 1)
			x = 20;
		else
			x = 660;
	}
//location of paddle on left screen for player 1 in if statement
	
	public void draw(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(x, (int)y, 20, 80);
		
	}
//color and size of paddle 
	
	public void move() {
		if(upAccel){
			yVel -= 2;
		}
		else if(downAccel) {
			yVel += 2;

		}
		else if(!upAccel && !downAccel) {
			yVel *= GRAVITY;
		}
// if else if statement that determines paddle y velocity up/down with GRAVITY variable
		
		if(yVel >= 5)
			yVel = 5;
		else if(yVel <= -5)
			yVel = -5;
		
		y += yVel;
		
		if(y < 0)
			y = 0;
		if(y > 420)
			y = 420;
	}
//if else if statement to determine max y velocity and sets boundaries so that paddle can't move off the screen up/down
	
	public void setUpAccel(boolean input){
		upAccel = input;
	}
	
	public void setDownAccel(boolean input){
		downAccel = input;
	}
	
	public int getY() {
		return (int)y;
	}
//input by user to determine up/down acceleration
	
}
