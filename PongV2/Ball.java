package PongV2;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	double xVel, yVel, x, y;
//declares variables for public class Ball
	
	public Ball(){
		x = 350;
		y = 250;
		xVel = getRandomSpeed() * getRandomDirection();
		yVel = getRandomSpeed() * getRandomDirection();
	}
//variables that define start location for ball and  random x & y speed and direction
	
	public double getRandomSpeed(){
		return (Math.random() *2 + 2);
	}
//determines a random speed based off math.random package
	
	public int getRandomDirection(){
		int rand = (int)(Math.random() * 2);
		if(rand == 1)
			return 1;
		else
			return -1;
	}
//determines a random direction based off math.random package
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int)x-10, (int)y-10, 20, 20);
	}
//graphics to create shape/color of ball
	
	public void checkPaddleCollision(Paddle p1, Paddle p2){
		if(x <= 50){
			if(y >= p1.getY() && y <= p1.getY() + 80)
				xVel = 1.02 * -xVel;
		}
		else if(x >= 650){
			if(y >= p2.getY() && y <= p2.getY() + 80)
				xVel = 1.02 * -xVel;
		}
	}
//class to determine how ball interacts with paddle during collision using if statements (ball speeds up as it is hit more)
	
	public void move() {
		x += xVel;
		y += yVel;
		
		if(y < 10)
			yVel = -yVel;
		if(y > 490)
			yVel = -yVel;
	}
//ball movement range
	
	public int getX() {
		return (int)x;
	}
	
	public int getY() {
		return (int)y;
	}	
}
