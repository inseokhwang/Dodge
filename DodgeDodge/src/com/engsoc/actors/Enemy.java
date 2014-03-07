package com.engsoc.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.engsoc.world.GameWorld;

public class Enemy extends Actor {
	public Enemy(float x, float y, Vector2 vel, Vector2 acc, float size) {
		super("Enemy", x, y, size / 150);
		setVelocity(vel);
		setAcceleration(acc);
		picture = new Texture("data/enemy.png");
	}
	
	@Override
	public boolean update(float delta, GameWorld world) {
		return super.update(delta, world);
	}
	
	public static float random(float max) {
		return (float) (Math.random() * max * 2 - max);
	}
}
