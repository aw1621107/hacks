package com.mine.minefront;

import com.mine.minefront.Display;
import com.mine.minefront.input.*;
import com.mine.minefront.*;
public class Timer {
	private int level1;
	private int levil2;
	private int levil3;
	//private int jump;
	private int death;
	private int sprint;
	private static int  gametime;
	
	public static void GameTime(){
		gametime = Display.mainTimer;
		gametime =  Display.mainTimer;
	gametime /= 60;
	System.out.println(gametime);
	}
	public static void JumpTimer(){
		gametime = Display.mainTimer;
		gametime = 0;
		gametime /= 60;
		System.out.println(gametime);
		
	}
	public static void Attack(){
		int attack = Display.mainTimer;
		boolean start = true;
		if (start){
		System.out.println("attack");
		System.out.println(attack);
		start = false;
		
		}
		if (!start){
			gametime = Display.mainTimer;
			
			
		}
		
	}
	
	}