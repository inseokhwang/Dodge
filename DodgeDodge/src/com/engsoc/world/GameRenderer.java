package com.engsoc.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.engsoc.actors.Enemy;

public class GameRenderer {
	
	private GameWorld world;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	private BitmapFont font;
	private String geoStatus;
	private SpriteBatch batch;

	public GameRenderer(GameWorld world) {
		this.world = world;
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
		font = new BitmapFont(true);
		font.setColor(Color.RED);
		batch = new SpriteBatch(); 
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
	}

	public void render() {
        /*
         * White background
         */
		
		batch.begin();
		
		font.drawMultiLine(batch, world.player.geoStatus(), 0, 0);

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeType.Filled);
        if (!world.gameOver) {
        	shapeRenderer.setColor(255/255f, 0/255f, 0/255f, 1);
			shapeRenderer.circle(world.getPlayer().getCircle().x, world.getPlayer().getCircle().y, world.getPlayer().getCircle().radius);
		}
        shapeRenderer.setColor(0/255f, 0/255f, 255/255f, 1);
		for(Enemy e: world.getEnemy()) {
			shapeRenderer.circle(e.getCircle().x,e.getCircle().y,e.getCircle().radius);
		}
		
		shapeRenderer.end();
		batch.end();
	}

}
