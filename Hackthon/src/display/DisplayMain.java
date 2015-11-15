package display;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DisplayMain extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private static String TITLE = "TITLE";
	public static int HEIGHT = 800;
	public static int WIDTH = 720;
	private static JFrame frame = new JFrame();

	public static String tempout = "this is a test";

	// private static JLabel lable = new JLabel(tempout);

	// private static JButton button2 = new JButton("5 (LINE_END)");

	// private JButton button = new JButton();

	public static void main(String [] args) {
		JFrame frame = new JFrame();
		
		frame.setLayout(new FlowLayout());
		frame.setSize(HEIGHT, WIDTH);
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		

		// Container pane = aFrame.getContentPane()...
		JButton button = new JButton("Button 1 (PAGE_START)");
		frame.add(button, BorderLayout.PAGE_START);

		// Make the center component big, since that's the
		// typical usage of BorderLayout.
		button = new JButton("Button 2 (CENTER)");
		// button.setPreferredSize(new Dimension(200, 100));
		frame.add(button, BorderLayout.CENTER);

		button = new JButton("Button 3 (LINE_START)");
		frame.add(button, BorderLayout.LINE_START);

		button = new JButton("Long-Named Button 4 (PAGE_END)");
		frame.add(button, BorderLayout.PAGE_END);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("does it work");
			}
		;});
		
		
		
		
		
		
		
		
		JButton button2 = new JButton("5 (LINE_END)");
		
		frame.add(button, BorderLayout.LINE_END);
		button2.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e) {
		System.out.println("does it work");
	}
;});}
// JTextArea textArea = new JTextArea(5, 20);
// JScrollPane scrollPane = new JScrollPane(textArea);
// textArea.setEditable(false);// frame.add(textArea);

}


