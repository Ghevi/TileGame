package dev.ghevi.tilegame;


import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.ghevi.tilegame.display.Display;
import dev.ghevi.tilegame.gfx.Assets;
import dev.ghevi.tilegame.gfx.GameCamera;
import dev.ghevi.tilegame.gfx.ImageLoader;
import dev.ghevi.tilegame.gfx.SpriteSheet;
import dev.ghevi.tilegame.input.KeyManager;
import dev.ghevi.tilegame.input.MouseManager;
import dev.ghevi.tilegame.states.GameState;
import dev.ghevi.tilegame.states.MenuState;
import dev.ghevi.tilegame.states.State;
import dev.ghevi.tilegame.states.settings.BugsState;
import dev.ghevi.tilegame.states.settings.SettingsState;

public class Game implements Runnable{

	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread; //i threads permettono di avere prestazioni migliori eseguendo la classe Game, in questo caso, a parte rispetto al programma principale
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public State gameState;
	public State menuState;
	public State settingsState;
	public State bugsState;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}

	private void init() {
		display = new Display(title, width, height);
		Display.getFrame().addKeyListener(keyManager);
		Display.getFrame().addMouseListener(mouseManager);
		Display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		settingsState = new SettingsState(handler);
		bugsState = new BugsState(handler);
		State.setState(menuState);
	}
	
	
	
	private void tick() {
		keyManager.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
		
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy(); //assegna all'oggeto bs ciò che è contenuto nei buffers
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3); //3 max
			return;
		}
		g = bs.getDrawGraphics();
		//Clear screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		
		
		
		
		//End Drawing!
		bs.show();
		g.dispose();
		
		
		
	}
	
	@Override
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1_000_000_000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {   //game loop, aggiorna le variabili e poi visualizza il tutto a schermo
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1_000_000_000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public synchronized void start() {
		if(running) 
			return;
		running = true;
		thread = new Thread(this); //esegue questa classe (Game) in questo Thread
		thread.start(); //chiama il metodo run appena qua sopra
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
