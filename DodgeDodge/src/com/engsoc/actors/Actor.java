package com.engsoc.actors;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.engsoc.world.GameWorld;

public abstract class Actor implements Runnable {
	private String actorType;
	private Circle circle;
	protected Vector2 position;
	protected Vector2 velocity;
	protected Vector2 acceleration;
	protected static float delta;
	protected static GameWorld world;
	public boolean toBeRemoved;
	
	public Actor(String actorType, float x, float y, float r) {
		this.actorType = actorType;
		position = new Vector2(x,y);
		velocity = new Vector2(0,0);
		acceleration = new Vector2(0,0);
		circle = new Circle(x,y,r);
		toBeRemoved = false;
	}
	
	public Circle getCircle() {
		return circle;
	}
	
	public void update() {
		// Increase velocity due to acceleration and verify velocity limit
		velocity.add(acceleration.cpy().scl(delta));
		if (velocity.x > 300)
			velocity.x = 300;
		if (velocity.x < -300)
			velocity.x = -300;
		if (velocity.y > 300)
			velocity.y = 300;
		if (velocity.y < -300)
			velocity.y = -300;
		
		// Changing position of the actor
		position.add(velocity.cpy().scl(delta));		
		circle.setPosition(position);
		
		if (position.y > world.getH() + 50f)
			toBeRemoved = true;
		if (position.y < -100)
			toBeRemoved = true;
	}
	
	public void setVelocity(Vector2 add) {
		velocity.add(add);
	}
	
	public void setAcceleration(Vector2 add) {
		acceleration.add(add);
	}
	
	@Override
	public void run() {
	}
	
	public static void setDelta(float change) {
		delta = change;
	}
	
	public static void setWorld(GameWorld newWorld) {
		world = newWorld;
	}
}
