package com.engsoc.actors;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public abstract class Actor {
	private String actorType;
	private Circle circle;
	protected Vector2 position;
	protected Vector2 velocity;
	protected Vector2 acceleration;
	
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
		if (velocity.x > 200)
			velocity.x = 200;
		if (velocity.x < -200)
			velocity.x = -200;
		if (velocity.y > 200)
			velocity.y = 200;
		if (velocity.y < -200)
			velocity.y = -200;
		
		// Changing position of the actor
		position.add(velocity.cpy().scl(delta));		
		circle.setPosition(position);
		
		if (position.y > 370)
			return true;
		if (position.y < -100)
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
