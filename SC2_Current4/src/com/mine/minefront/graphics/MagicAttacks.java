package com.mine.minefront.graphics;

import com.mine.minefront.Display;
import com.mine.minefront.input.Controller;

public class MagicAttacks {

	
	public static void fireball(){
		double manaFireCost = 0.5;
		double speed = 1;
		double fireAcceleration = 4;
		double currentSpeed = 0;
		double currentMana = Display.mana;
		
			if (currentMana > 0){
			Display.mana -= manaFireCost;
			}
	}
	
	public static void manaregen(){
		
		double currentMana = Display.mana;
		while (currentMana < 50){
			Display.mana+=0.5;
		}
		
		
	}
}
