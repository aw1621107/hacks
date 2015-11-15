package com.mine.minefront.level;

import java.util.Random;

public class Level {
	public Block[] blocks;
	public final int width, height;
	
	
	public Level(int width, int height){
		this.width = width;
		this.height = height;
		blocks = new Block[width * height];
		Random random = new Random();
		for ( int y = 0; y< height; y++){
			for ( int x = 0; x < width; x++){
				Block block = null;
				if (random.nextInt(4) == 0){
					block = new SoildBlock();
					}else {
						block = new Block();
					}
					blocks[x+y * width] = block;
			
				}
			}
		}
	
	public Block Create (int x, int y){
		if (x < 0 || y<0 || x>= width || y >= height){
			return Block.soildWall;
		}
		return blocks[x + y * width];
	}
	
}
