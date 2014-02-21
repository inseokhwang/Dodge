package com.engsoc.dodge;

import com.badlogic.gdx.Game;
import com.engsoc.screen.GameScreen;
 
public class DGame extends Game {

	@Override
	public void create() {
		// TODO Auto-generated method stub
		System.out.println("DGame created");
		setScreen(new GameScreen());
	}
	
}