package test;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Player {

	public boolean hit;
	public int x = 0;
	public int y = 0;
	public int scale = 2;
	public int health = 1000000;
	public boolean gameOver = false;

	public Rectangle hitBox = new Rectangle(90+x,350+y,400,64);
	
	public Image right;
	public Image left;
	public Image rightHit;
	public Image leftHit;
	
	

	public Player(int x, int y) throws SlickException {
		this.x = x;
		this.y = y;
		right = new Image ("flyingManRight.png");
		left = new Image ("flyingManLeft.png");
		rightHit = new Image ("flyingManRightHit.png");
		leftHit = new Image ("flyingManLeftHit.png");
	}
	
	public void update() {
		hitBox = new Rectangle(90+x, 350+y, 128*scale-90, 32 *scale-30);
		if (health <= 0) {
			gameOver = true;
		}
	}
	
	public void drawSelf(Graphics g, boolean pos) throws SlickException {
		

		right.setFilter(Image.FILTER_NEAREST);
		left.setFilter(Image.FILTER_NEAREST);
		
		if (pos == true && hit == false) {
			right.draw(90+x, 350+y, scale);
		}
		if (pos == false && hit == false) {
			left.draw(90+x, 350+y, scale);
		}
		if (pos == true && hit == true) {
			rightHit.draw(90+x, 350+y, scale);
		}
		if (pos == false && hit == true) {
			leftHit.draw(90+x, 350+y, scale);
		}

		//g.draw(hitBox);

	}
	
}
