package test;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Moon {
	/*public int x = 0;
	public int y = 0;
	public Rectangle hitBox = new Rectangle(x,y,64,64);

	public void update() {
		hitBox = new Rectangle(this.x, this.y, 64, 64);
	}*/
	
	public void drawSelf(Graphics g) throws SlickException {
		Image img = new Image ("moon2.png");
		img.setFilter(Image.FILTER_NEAREST);
		img.draw(325, 90);

	}

}
