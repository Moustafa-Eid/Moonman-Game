package test;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Instructions {
	
	public void drawSelf(Graphics g) throws SlickException {
		g.drawString("The objective is to avoid the objects", 0, 0);
		g.drawString("", 0, 5);
		g.drawString("Press W to move up ", 0, 10);
		g.drawString("Press A to move left ", 0, 10);
		g.drawString("Press S to move down ", 0, 15);
		g.drawString("Press D to move right ", 0, 20);
	}

}
