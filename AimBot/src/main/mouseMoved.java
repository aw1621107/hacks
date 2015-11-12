package main;

import java.awt.Dimension;
import java.awt.Robot;

public class mouseMoved {
	public static int mouseX;
	public static int mouseY;

	private Robot robot;

	public void mouseMoved(MouseEvent e) {
		Dimension size = Display.frame.getSize();
		int frameX = Display.frame.getX();
		int frameY = Display.frame.getY();

		try {
			robot = new Robot();
		} catch (AWTException ex) {
			ex.printStackTrace();
		}

		mouseX = e.getX();
		mouseY = e.getY();

		if (robot != null) {
			if (mouseY < 5) {
				robot.mouseMove(frameX + (mouseX - 4), (frameY - 10) + (size.height - 4));
			}
			if (mouseY > (size.height - 28) - 5) {
				robot.mouseMove(frameX + (mouseX - 4), (frameY + 28) + 10);
			}
			if (mouseX < 5) {
				robot.mouseMove((frameX - 10) + (size.width - 4), frameY + (mouseY + 28));
			}
			if (mouseX > (size.width - 4) - 5) {
				robot.mouseMove(frameX + 10, frameY + (mouseY + 28));
			}
		}
	}