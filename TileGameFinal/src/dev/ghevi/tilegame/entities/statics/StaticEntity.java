package dev.ghevi.tilegame.entities.statics;

import dev.ghevi.tilegame.Handler;
import dev.ghevi.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity {
	
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}
	

}
