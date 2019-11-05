package test;
import org.lwjgl.*;

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
import org.newdawn.slick.geom.Rectangle;
import java.util.*;

public class TestGame2 extends BasicGame {

	public static int x = 90;
	public static boolean right;
	public int fireBallx = 2000;
	public ArrayList<fireBall> fireBalls = new ArrayList<fireBall>();
	public Player moonman;
	public Map Map = new Map();
	public int speed = 20;
	public double pipeHeight = Math.floor(Math.random()*(600-120))+120;
	public int topPipeY = (int)pipeHeight-100; 
	public int bottomPipeY = (int)pipeHeight+100;
	public int obstacleX = 1300;

	public TestGame2(java.lang.String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new TestGame2("MLH"));
			appgc.setDisplayMode(1280, 720, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(TestGame2.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void render(GameContainer gec, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		Map.drawSelf(g);
		if (moonman.gameOver == false) {
			moonman.drawSelf(g,right);
		}
		obstacleX -= 10;
		g.fillRect(obstacleX, topPipeY, 75, -1000);
		g.fillRect(obstacleX, bottomPipeY, 75, 1000);
		if (obstacleX <= -20) {
			obstacleX = 1300;
			pipeHeight = Math.floor(Math.random()*(600-120))+120;
			topPipeY = (int)pipeHeight-100; 
			bottomPipeY = (int)pipeHeight+100;
		}


		
		g.setColor(Color.green);
		g.drawString("" + moonman.health, 20, 20);
	}

	@Override
	public void init(GameContainer gec) throws SlickException {
		// TODO Auto-generated method stub
		gec.setAlwaysRender(true);
		gec.setShowFPS(true);
		gec.setVSync(true);
		gec.setMaximumLogicUpdateInterval(0);
		moonman = new Player(90,90);
	

	}
	@Override
	public void update(GameContainer gec, int delta) throws SlickException {
		if (moonman.gameOver == false) {
			Input input = gec.getInput();
			if (input.isKeyDown(Input.KEY_W)) {
				moonman.y -= speed;
			}
			if (input.isKeyDown(Input.KEY_S)) {
				moonman.y += speed;
			}
			if (input.isKeyDown(Input.KEY_A)) {
				moonman.x -= speed;
				right = false;
			}
			if (input.isKeyDown(Input.KEY_D)) {
				moonman.x += speed;
				right = true;
			}
			
			moonman.hit = false;
			for (int i = 0; i < fireBalls.size(); i++) {
				if ((moonman.hitBox).intersects(new Rectangle (obstacleX, topPipeY, 75, -1000)) || (moonman.hitBox).intersects(new Rectangle (obstacleX, topPipeY, 75, 1000)) ){
					moonman.hit = true;
					moonman.health-=1;
					fireBalls.get(i).dead = true;
				}
			}
			
			moonman.update();
		}
		
		
		
	}
	
}
