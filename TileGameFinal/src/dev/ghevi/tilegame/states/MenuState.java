package dev.ghevi.tilegame.states;


import java.awt.Graphics;

import dev.ghevi.tilegame.Handler;
import dev.ghevi.tilegame.gfx.Assets;
import dev.ghevi.tilegame.tile.Tile;
import dev.ghevi.tilegame.ui.ClickListener;
import dev.ghevi.tilegame.ui.UIImageButton;
import dev.ghevi.tilegame.ui.UIManager;

public class MenuState extends State {
	
	private UIManager uiManager;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton((500 - Tile.TILEWIDTH), 200, 128, 64, Assets.btn_start, new ClickListener(){
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
		
		uiManager.addObject(new UIImageButton((500 - Tile.TILEWIDTH), 300, 128, 64, Assets.btn_settings, new ClickListener(){
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().settingsState);
			}
		}));
	}
	
	@Override
	public void tick() {
		uiManager.tick();
		
		/*Temporarily skip the menuState and goes to gameState
		handler.getMouseManager().setUIManager(null);
		State.setState(handler.getGame().gameState);
		*/
		
		/*Temporarily skip the menuState and goes to settingsState
		handler.getMouseManager().setUIManager(null);
		State.setState(handler.getGame().settingsState);
		*/
		
	/* 	Test code		
		if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
			State.setState(handler.getGame().gameState);
	
	*/
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.backgroundScreen, 0, 0, handler.getGame().getWidth(), handler.getGame().getHeight(), null);
		uiManager.render(g);
		
		
	/* Test code
		g.setColor(Color.red);
		g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 8, 8);
	*/
	}

}
