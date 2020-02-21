package dev.ghevi.tilegame.states.settings;

import java.awt.Graphics;
import java.net.MalformedURLException;

import dev.ghevi.tilegame.Handler;
import dev.ghevi.tilegame.gfx.Assets;
import dev.ghevi.tilegame.states.State;
import dev.ghevi.tilegame.tile.Tile;
import dev.ghevi.tilegame.ui.ClickListener;
import dev.ghevi.tilegame.ui.UIImageButton;
import dev.ghevi.tilegame.ui.UIManager;

public class SettingsState extends State {

	private UIManager uiManager;

	
	
	public SettingsState(Handler handler) {
		super(handler);
		
		uiManager = new UIManager(handler);
		
		
		if(State.getState() == handler.getGame().settingsState) {
		
		
		
		uiManager.addObject(new UIImageButton((500 - Tile.TILEWIDTH), 200, 128, 64, Assets.btn_bugs, new ClickListener(){
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().bugsState);
			}
		}));
		}
		
	}
	
	@Override
	public void tick() {
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.tick();
		
		/*Temporarily skip the menu state
		handler.getMouseManager().setUIManager(null);
		State.setState(handler.getGame().gameState);
		*/
		
	/* 	Test code		
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
			State.setState(handler.getGame().gameState);
	
	*/
	}

	@Override
	public void render(Graphics g) {
		handler.getMouseManager().setUIManager(uiManager);
		g.drawImage(Assets.backgroundScreen, 0, 0, handler.getGame().getWidth(), handler.getGame().getHeight(), null);
		uiManager.render(g);
		
		
	/* Test code
		g.setColor(Color.red);
		g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
	*/
	}
	
	
	
}
