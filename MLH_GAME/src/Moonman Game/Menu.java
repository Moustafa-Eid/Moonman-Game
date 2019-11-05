package test;

import java.util.logging.Level;

import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.UnicodeFont;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;
import java.util.*;

public class Menu extends BasicGame {
	UnicodeFont uFont;

	public static int x = 90;
	public Map Map = new Map();
	public Moon Moon = new Moon();
	
	public Rectangle menu = new Rectangle(0,0,1280,720);
	public Menu(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new TestGame("MLH"));
			appgc.setDisplayMode(1280, 720, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(TestGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void render(GameContainer gec, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		Input input = gec.getInput();
		Map.drawSelf(g);
		Moon.drawSelf(g);
/*		g.setColor(Color.white);	
		g.fill(new Rectangle(555,150,200,120));
		g.fill(new Rectangle(555,550,200,120));*/
		g.setColor(Color.black);
		if (input.getMouseX() >=630 && input.getMouseX() <= 680 && input.getMouseY() >= 200 && input.getMouseY() <= 220) {
			g.setColor(Color.yellow);
		}
		
		g.drawString("PLAY", 638, 200);
		g.setColor(Color.black);
		if (input.getMouseX() >=600 && input.getMouseX() <= 707 && input.getMouseY() >= 600 && input.getMouseY() <= 615) {
			g.setColor(Color.yellow);
		}
		g.drawString("INSTRUCTIONS", 600, 600);
		
		
		g.setColor(Color.white);
		
		
		
		
	}

	@Override
	public void init(GameContainer gec) throws SlickException {
		// TODO Auto-generated method stub
		gec.setAlwaysRender(true);
		gec.setShowFPS(true);
		gec.setVSync(true);
		gec.setMaximumLogicUpdateInterval(60);
	}

	@Override
	public void update(GameContainer gec, int delta) throws SlickException {
	}





}
