package com.mine.minefront;

import java.awt.event.KeyEvent;

import com.mine.minefront.input.Controller;
import com.mine.minefront.level.Level;

public class Game {
	public int time;
	public Controller controls;
	public Level level;
	public Game(){
		controls = new Controller();
		level = new Level(20,20);
	}
	
	public void tick(boolean[] key){
		time++;
		boolean forward = key[KeyEvent.VK_W];
		boolean back = key[KeyEvent.VK_S];
		boolean left = key[KeyEvent.VK_A];
		boolean right = key[KeyEvent.VK_D];
		boolean jump = key[KeyEvent.VK_SPACE];
		boolean crouch = key[KeyEvent.VK_CONTROL];
		boolean sprint = key[KeyEvent.VK_SHIFT];
		boolean manareg = key[KeyEvent.VK_Q];
		boolean timer = key[KeyEvent.VK_X];
		boolean fireball =key[KeyEvent.VK_E];
		controls.tick(forward, back, left, right, jump, crouch, sprint, manareg, timer,fireball);
		
		
	}
	
}
