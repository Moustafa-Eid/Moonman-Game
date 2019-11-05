package test;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

public class fireBall {
	
	public int x;
	public int y;
	public int size;
	public int hspeed;
	public int vspeed;
	public boolean dead = false;
	public Circle hitBox = new Circle(1,2,3);
	
	public fireBall(int x, int y, int size, int hspeed, int vspeed) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.hspeed = hspeed;
		this.vspeed = vspeed;
	}
	
	public void update() {
		this.x += hspeed;
		this.y += vspeed;
		if (this.y < 0 && vspeed < 0) {
			vspeed = (int) (Math.random() * 1) + 3;
		}
		if (this.y > 720 && vspeed > 0) {
			vspeed = ((int) (Math.random() * 1) + 3) * -1;
		}
		if (this.x < 0 && hspeed < 0) {
			hspeed = (int) (Math.random() * 1) + 3;
		}
		if (this.x > 1280 && hspeed > 0) {
			hspeed = ((int) (Math.random() * 1) + 3) * -1;
		}
		hitBox = new Circle(x,y,size);
	}
	
	public void drawSelf(Graphics g) {
		g.setColor(Color.red);
		g.fill(hitBox);
	}
}
