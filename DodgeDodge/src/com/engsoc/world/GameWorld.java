package com.engsoc.world;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.engsoc.actors.Dodger;
import com.engsoc.actors.Enemy;

import java.util.ArrayList;

public class GameWorld {
	
	private Dodger player;
	private ArrayList<Enemy> enemy;
	private float timer, difficulty;
	private Enemy toRemove;
	private long score;
	public boolean gameOver;
	
	public GameWorld() {
		//init initial variables
		enemy = new ArrayList<Enemy>();
		player = new Dodger();
		timer = 0f;
		difficulty = 1f;
		score = 0;
		toRemove = null;
		
		//initialize each enemy with random velocity and x-acceleration, but always a random positive y-acceleration
		for(int i = 0; i < 10; i++)
			enemy.add(new Enemy((float) Enemy.random(300), -50f, new Vector2(Enemy.random(10),Enemy.random(10)),new Vector2(Enemy.random(10),(float) Math.random() * 10)));
		gameOver = false;
	}
	
	public Dodger getPlayer() {
		return player;
	}
	
	public ArrayList<Enemy> getEnemy() {
		return enemy;
	}
	
	private void increaseEnemy() {
		enemy.add(new Enemy((float) Enemy.random(300), -50f, new Vector2(Enemy.random(10),Enemy.random(10)),new Vector2(Enemy.random(10),(float) Math.random() * 10)));
	}
	
	public void update(float delta) {
		timer = timer + delta;
		if (timer > 1.0f) {
			increaseEnemy();
			timer = timer - difficulty;
			System.out.println("increased");
			if (difficulty > .2f)
				difficulty -= 0.01f;
			
			score++;
		}
		
		if (!gameOver) {
			for (Enemy e : enemy) {
				if (Intersector.overlaps(player.getCircle(), e.getCircle())) {
					gameOver = true;
					System.out.println("GameOVER");
				}
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