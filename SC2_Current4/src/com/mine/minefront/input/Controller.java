package com.mine.minefront.input;

import com.mine.minefront.graphics.MagicAttacks;
import com.mine.minefront.Display;
import com.mine.minefront.Timer;

public class Controller {

	public double x, y, z, rotation, xa, za, rotationa;
	public static boolean turnLeft = false;
	public static boolean turnRight = false;
	public static boolean sprint = false;
	public static boolean walk = false;
	public static boolean crouchWalk = false;
	public static boolean sprintWalk = false;
	public static boolean fireball = false;
	private double mana2 = Display.mana;
	private boolean reg = true;

	public void tick(boolean forward, boolean back, boolean left, boolean right, boolean jump, boolean crouch, boolean sprint, boolean manareg, boolean timer, boolean fireball) {
		double rotationSpeed = .004 * Display.MouseSpeed;
		double walkSpeed = 0.5;
		double jumpHeight = 0.5;
		double crouchHeight = 0.3;
		double xMove = 0;
		double zMove = 0;

		if (forward) {
			zMove++;
			walk = true;

		}

		if (back) {
			zMove--;
			walk = true;
		}

		if (left) {
			xMove--;
			walk = true;
		}

		if (right) {
			xMove++;
			walk = true;
		}

		if (turnLeft) {

			rotationa -= rotationSpeed;
		}

		if (turnRight) {
			rotation += rotationSpeed;
		}

		if (jump) {
			y += jumpHeight;
			sprint = false;
			Timer.JumpTimer();
		}

		if (crouch) {
			y -= crouchHeight;
			sprint = false;
			crouchWalk = true;
			walkSpeed = 0.2;
		}

		if (sprint) {
			walkSpeed = 1;
			walk = true;
			sprintWalk = true;
		}

		if (!forward && !back && !left && !right) {
			walk = false;
		}
		if (!crouch) {
			crouchWalk = false;
		}
		if (!sprint) {
			sprintWalk = false;
		}
		if (manareg) {
			reg = true;
			if (reg) {
				mana2 = Display.mana;
				if (mana2 <= 50) {
					Display.mana += 0.5;
				} else {
					reg = false;
				}
			}
		}
		if (reg) {
			mana2 = Display.mana;
			if (mana2 < 100) {
				Display.mana += 1;
				fireball = false;
			} else {
				reg = false;
			}
		}
		if (fireball) {
			Timer.Attack();
			if (mana2 > 0) {
				MagicAttacks.fireball();
			}

		}
		xa += (xMove * Math.cos(rotation) + zMove * Math.sin(rotation)) * walkSpeed;
		za += (zMove * Math.cos(rotation) + xMove * Math.sin(rotation)) * walkSpeed;

		x += xa;
		y *= 0.9;
		z += za;
		xa *= 0.1;
		za *= 0.1;
		rotation += rotationa;
		rotationa *= 0.2;

	}

}
