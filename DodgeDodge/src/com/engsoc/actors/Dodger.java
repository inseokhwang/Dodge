package com.engsoc.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.engsoc.world.GameWorld;

public class Dodger extends Actor {
	
	
	public Dodger() {
		super("Dodger", 240, 160, 10);
	}
	
	@Override
	public boolean update(float delta, GameWorld world) {
		// Update velocity
		float z = Gdx.input.getAzimuth();
		float x = Gdx.input.getPitch();
		float y = Gdx.input.getRoll();
		
		if (x < -30)
			x = -30;
		if (x >  30)
			x = 30;
		if (y < -30)
			y = -30;
		if (y >  30)
			y = 30;
		
		// Multiply by acc of 10, so 30 / 10 = 3
		x = x * -30;
		y = y * -30;
		
		velocity = new Vector2(x , y);
		
		// Changing position of the actor
		position.add(velocity.cpy().scl(delta));		
		getCircle().setPosition(position);
		
		return false;
	}
	
	public String geoStatus() {
		float z = Gdx.input.getAzimuth();
		float x = Gdx.input.getPitch();
		float y = Gdx.input.getRoll();
		String s = new String("Azimuth: " + z + "\nPitch: " + x + "\nRoll: " + y);
		return s;
	}
}
