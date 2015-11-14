package algorithm;

import javax.swing.JFrame;

public class DisplayMAin {

	private static String TITLE = "TITLE";
	public static int HEIGHT = 800;
	public static int WIDTH = 720;
	
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		
		frame.setSize(HEIGHT, WIDTH);
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
