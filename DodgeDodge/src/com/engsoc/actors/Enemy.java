package com.engsoc.actors;

import com.badlogic.gdx.math.Vector2;
import com.engsoc.world.GameWorld;

public class Enemy extends Actor {
	public Enemy(float x, float y, Vector2 vel, Vector2 acc) {
		super("Enemy", x, y, (float) Math.random() * 10 + 5);
		setVelocity(vel);
		setAcceleration(acc);
	}
	
	@Override
	public boolean update(float delta, GameWorld world) {
		return super.update(delta, world);
	}
	
	public static float random(float max) {
		return (float) (Math.random() * max * 2 - max);
	}
}
