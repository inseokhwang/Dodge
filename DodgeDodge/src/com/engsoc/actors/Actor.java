package com.engsoc.actors;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public abstract class Actor {
	private String actorType;
	private Circle circle;
	private Vector2 position;
	private Vector2 velocity;
	private Vector2 acceleration;
	
	public Actor(String actorType, float x, float y, float r) {
		this.actorType = actorType;
		position = new Vector2(x,y);
		velocity = new Vector2(0,0);
		acceleration = new Vector2(0,0);
		circle = new Circle(x,y,r);
	}
	
	public Circle getCircle() {
		return circle;
	}
	
	public boolean update(float delta) {
		// Increase velocity due to acceleration and verify velocity limit
		velocity.add(acceleration.cpy().scl(delta));
		if (velocity.x > 100)
			velocity.x = 50;
		if (velocity.y > 100)
			velocity.y = 50;
		
		// Changing position of the actor
		position.add(velocity.cpy().scl(delta));		
		circle.setPosition(position);
		
		if (position.y > 370)
			return true;
		return false;
	}
	
	public void setVelocity(Vector2 add) {
		velocity.add(add);
	}
	
	public void setAcceleration(Vector2 add) {
		acceleration.add(add);
	}
	
}
