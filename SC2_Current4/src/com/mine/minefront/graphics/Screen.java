package com.mine.minefront.graphics;

import java.util.Random;

import com.mine.minefront.Game;

public class Screen extends Render {

	private Render test;
	private Render3D render;
	
	public Screen(int width, int height) {
		super(width, height);
		Random random = new Random();
		render = new Render3D(width, height);
		test = new Render(266, 256);
		for (int i =0; i <256*266; i++){
			test.pixels[i] = random.nextInt() * (random.nextInt(5)/ 4);
		}
	
	}
	
	public void render(Game game){
		for ( int i = 0; i<width*height; i++){
			pixels[i] = 0;
		}
		render.floor(game);
		/*
		render.renderWall(0, 0.5, 1.5, 1.5, 0);
		render.renderWall(0, 0, 1, 1.5, 0);
		render.renderWall(0, 0.5, 1, 1, 0);
		render.renderWall(0.5, 0.5, 1, 1.5, 0);
		
		render.renderWall(0, 0.5, 1.5, 1.5, 0.5);
		render.renderWall(0, 0, 1, 1.5, 0.5);
		render.renderWall(0, 0.5, 1, 1, 0.5);
		render.renderWall(0.5, 0.5, 1, 1.5, 0.5);
	*/	
		render.renderDistanceLimiter();
		
		draw(render, 0, 0);
	}
}
