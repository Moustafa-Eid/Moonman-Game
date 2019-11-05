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
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import java.util.*;

public class TestGame extends BasicGame {
	
	public static char state = 'm';
	public static int x = 90;
	public static boolean right;
	public int fireBallx = 2000;
	public ArrayList<fireBall> fireBalls = new ArrayList<fireBall>();
	public Player moonman;
	public Map Map = new Map();
	public Moon Moon = new Moon();
	public int speed = 5;
	Music mainMusic;
	

	public TestGame(java.lang.String string) {
		super(string);
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
		if (state == 'm') {

			Input input = gec.getInput();
			Map.drawSelf(g);
			Moon.drawSelf(g);
			g.setColor(Color.red);
			g.drawString("The Adventures Of Moon Man", 540, 60);
			g.setColor(Color.black);
			if (input.getMouseX() >=630 && input.getMouseX() <= 680 && input.getMouseY() >= 200 && input.getMouseY() <= 220) {
				g.setColor(Color.yellow);
				if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
					state = 'g';
				}
			}
			
			g.drawString("PLAY", 638, 200);
			g.setColor(Color.black);
			if (input.getMouseX() >=600 && input.getMouseX() <= 707 && input.getMouseY() >= 600 && input.getMouseY() <= 615) {
				g.setColor(Color.yellow);
				if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
					state = 'i';
				}
			}
			g.drawString("INSTRUCTIONS", 600, 600);
			
			
			g.setColor(Color.white);
		}
		if (state == 'g') {
			Map.drawSelf(g);
			if (moonman.gameOver == false) {
				moonman.drawSelf(g,right);
			}
			for (int i = 0; i < fireBalls.size(); i++) {
				fireBalls.get(i).drawSelf(g);
			}
			g.setColor(Color.green);
			g.drawString("Health:" + moonman.health, 1100, 20);
		}
		else if (state == 'i') {
			showInstructions(gec,g);
		}
	}

	@Override
	public void init(GameContainer gec) throws SlickException {
	    mainMusic = new Music("G:\\Sprites\\music.ogg");
	    mainMusic.loop();
		// TODO Auto-generated method stub
		gec.setAlwaysRender(true);
		gec.setShowFPS(true);
		gec.setVSync(true);
		gec.setMaximumLogicUpdateInterval(100);
		moonman = new Player(90,90);


	}
	@Override
	public void update(GameContainer gec, int delta) throws SlickException {
		if (state == 'g') {
			updateGame(gec,delta);
		}
		if (state == 'i') {
			Input input = gec.getInput();
			if (input.isKeyPressed(Input.KEY_ESCAPE)) {
				state = 'm';
			}
		}

	}
	
	public void updateGame(GameContainer gec,int delta) throws SlickException {
		if (moonman.gameOver == false) {
			Input input = gec.getInput();
			if (input.isKeyDown(Input.KEY_W) ||input.isKeyDown(Input.KEY_UP)) {
				moonman.y -= speed;
			}
			if (input.isKeyDown(Input.KEY_S) ||input.isKeyDown(Input.KEY_DOWN)) {
				moonman.y += speed;
			}
			if (input.isKeyDown(Input.KEY_A) ||input.isKeyDown(Input.KEY_LEFT)) {
				moonman.x -= speed;
				right = false;
			}
			if (input.isKeyDown(Input.KEY_D) ||input.isKeyDown(Input.KEY_RIGHT)) {
				moonman.x += speed;
				right = true;
			}
			
			if (input.isKeyPressed(Input.KEY_ENTER)) {
				for (int i = 0; i < 5; i++) {
					fireBalls.add(new fireBall((int) (Math.random() * 1280),(int) (Math.random() * 720),10,1,1));
				}
			}
			moonman.hit = false;
			for (int i = 0; i < fireBalls.size(); i++) {
				if ((moonman.hitBox).intersects((fireBalls.get(i)).hitBox)){
					moonman.hit = true;
					moonman.health-=1;
					fireBalls.get(i).dead = true;
				}
			}
			
			for (int i = 0; i < fireBalls.size(); i++) {
					if (fireBalls.get(i).dead) {
						fireBalls.remove(i);
					}
			}

			moonman.update();
		}
		
		for (int i = 0; i < fireBalls.size(); i++) {
			fireBalls.get(i).update();
		}
	}
	
	public void showInstructions(GameContainer gec, Graphics g) throws SlickException {
		Map.drawSelf(g);
		g.setColor(Color.yellow);
		g.drawString("The objective is to avoid the objects", 480, 200);
		g.drawString("Press Enter to Spawn Fire Balls", 550, 300);
		g.drawString("Press W to move up ", 550, 350);
		g.drawString("Press A to move left ", 550, 450);
		g.drawString("Press S to move down ", 550, 550);
		g.drawString("Press D to move right ", 550, 650);
	}
	
}
