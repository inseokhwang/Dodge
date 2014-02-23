package com.engsoc.screen;

import com.engsoc.world.GameWorld;
import com.engsoc.world.GameRenderer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameScreen implements Screen {
	
	private GameWorld world;
	private GameRenderer renderer;

	
	public GameScreen () {
		world = new GameWorld();
		renderer = new GameRenderer(world);

		System.out.println("GameScreen Attached");
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		world.update(delta);
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		System.out.println("resized");
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("show'ed");
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		System.out.println("hidden");
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		System.out.println("paused");
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		System.out.println("resumed");
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		System.out.println("disposed");
	}

}
