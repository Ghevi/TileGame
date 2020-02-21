package dev.ghevi.tilegame.states;

import java.awt.Graphics;

import dev.ghevi.tilegame.Game;
import dev.ghevi.tilegame.Handler;
import dev.ghevi.tilegame.entities.creatures.Player;
import dev.ghevi.tilegame.entities.statics.Tree;
import dev.ghevi.tilegame.gfx.Assets;
import dev.ghevi.tilegame.tile.Tile;
import dev.ghevi.tilegame.worlds.World;

public class GameState extends State {

	
	private World world;
	
	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
				
		/*camera test
		game.getGameCamera().move(0, 0);
		*/
	}
	
	@Override
	public void tick() {
		world.tick();
		
		/*camera test
		game.getGameCamera().move(1, 1);
		*/
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		
	}
	
	

}
