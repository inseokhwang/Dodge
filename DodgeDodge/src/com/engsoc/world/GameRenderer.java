package com.engsoc.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.engsoc.actors.Enemy;

public class GameRenderer {
	
	private GameWorld world;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;

	public GameRenderer(GameWorld world) {
		this.world = world;
		cam = new OrthographicCamera();
		cam.setToOrtho(true);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
	}

	public void render() {
        /*
         * White background
         */

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        /*
         * 2. We draw the Filled rectangle
         */
        if(!world.gameOver) {
	        shapeRenderer.begin(ShapeType.Filled);
	
	        shapeRenderer.setColor(255/255f, 0/255f, 0/255f, 1);
	        shapeRenderer.circle(world.getPlayer().getCircle().x, world.getPlayer().getCircle().y, world.getPlayer().getCircle().radius);
	        
	        shapeRenderer.setColor(0/255f, 0/255f, 255/255f, 1);
	        
	        for(Enemy e: world.getEnemy()) {
	        	shapeRenderer.circle(e.getCircle().x,e.getCircle().y,e.getCircle().radius);
	        }
	        
	        shapeRenderer.end();
        } else {
        	
        }
	}

}
