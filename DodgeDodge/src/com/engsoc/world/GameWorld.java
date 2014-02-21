package com.engsoc.world;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.engsoc.actors.Dodger;
import com.engsoc.actors.Enemy;

import java.util.ArrayList;

public class GameWorld {
	
	private Dodger player;
	private ArrayList<Enemy> enemy;
	private float timer;
	private Enemy toRemove;
	public boolean gameOver;
	
	public GameWorld() {
		enemy = new ArrayList<Enemy>();
		player = new Dodger();
		timer = 0f;
		toRemove = null;
		for(int i = 0; i < 5; i++)
			enemy.add(new Enemy((float) Math.random() * 400, -50f, new Vector2(10,10),new Vector2(10,10)));
		gameOver = false;
	}
	
	public Dodger getPlayer() {
		return player;
	}
	
	public ArrayList<Enemy> getEnemy() {
		return enemy;
	}
	
	private void increaseEnemy() {
		enemy.add(new Enemy((float) Math.random() * 200, -50.0f, new Vector2(10,10),new Vector2(10,10)));
	}
	
	public void update(float delta) {
		timer = timer + delta;
		if (timer > 1.0f) {
			increaseEnemy();
			timer = timer - 1.0f;
			System.out.println("increased");
		}
		for (Enemy e: enemy) {
			if (Intersector.overlaps(player.getCircle(), e.getCircle())) {
					gameOver = true;
					System.out.println("GameOVER");
			}
		}
        player.update(delta);
        for (Enemy e: enemy) {
        	if (e.update(delta))
        		toRemove = e;
        }
        enemy.remove(toRemove);
        System.out.println(enemy.size());
	}
}
