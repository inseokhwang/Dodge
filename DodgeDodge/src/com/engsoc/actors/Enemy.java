package com.engsoc.actors;

import com.badlogic.gdx.math.Vector2;

public class Enemy extends Actor {
	public Enemy(float x, float y, Vector2 vel, Vector2 acc) {
		super("Enemy", x, y, (float) Math.random()*50);
		setVelocity(vel);
		setAcceleration(acc);
	}
}
