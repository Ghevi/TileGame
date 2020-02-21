package dev.ghevi.tilegame.states.settings;

import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;

import javax.swing.JTextField;

import dev.ghevi.tilegame.Handler;
import dev.ghevi.tilegame.display.Display;
import dev.ghevi.tilegame.gfx.Assets;
import dev.ghevi.tilegame.states.State;


public class BugsState extends State {

	private JFrame frame;

	static JTextField textField1;
	
	public BugsState(Handler handler) {
		super(handler);
		
				frame = Display.getFrame();
		
	
	}
				
	

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.backgroundScreen, 0, 0, handler.getGame().getWidth(), handler.getGame().getHeight(), null);
		
	}

}
