package dev.ghevi.tilegame.states;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dev.ghevi.tilegame.Game;
import dev.ghevi.tilegame.Handler;
import dev.ghevi.tilegame.display.Display;
import dev.ghevi.tilegame.gfx.ImageLoader;

public abstract class State {
	
	//game state manager
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	//CLASS
	protected Handler handler;
	private Canvas canvas;
	private JFrame frame;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public void render(Graphics g) {
		
	}
	
}
	


