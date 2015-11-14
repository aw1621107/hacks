package display;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DisplayMAin {

	private static String TITLE = "TITLE";
	public static int HEIGHT = 800;
	public static int WIDTH = 720;
	private static JFrame frame = new JFrame();
	public static String tempout = "";
	public static int num_of_out = 0;
	
	
	public static void main(String[] args) {

		frame.setSize(HEIGHT, WIDTH);
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
	
		frame.setVisible(true);
		
		
		
	}

	public static void adder() {
		JLabel jlbempty = new JLabel(tempout);
		jlbempty.setPreferredSize(new Dimension(175, 100));
		frame.getContentPane().add(jlbempty, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);

	}

}
