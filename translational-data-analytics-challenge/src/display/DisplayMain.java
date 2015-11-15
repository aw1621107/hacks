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

public class DisplayMain extends JFrame/* implements ActionListener */ {

	private static final long serialVersionUID = 1L;

	public static int tickcount = 5;
	private static String TITLE = "TITLE";
	public static int HEIGHT = 800;
	public static int WIDTH = 720;
	private static JFrame frame = new JFrame();
	private static JFrame frame2 = new JFrame();
	public static String tempout = "this is a test";

	public static int bwidth = 170;
	public static int bheight = 50;
	// private static JLabel lable = new JLabel(tempout);

	// private static JButton button2 = new JButton("5 (LINE_END)");

	// private JButton button = new JButton();

	public static void main(String[] args) {

		frame.setLayout(new FlowLayout());
		frame.setSize(HEIGHT, WIDTH);
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		for (int i = tickcount; i <= tickcount && i >= 0; i--) {
			// Container pane = aFrame.getContentPane()...
			JButton button = new JButton("Button 1)");
			button.setPreferredSize(new Dimension(bwidth, bheight));
			frame.add(button, BorderLayout.PAGE_START);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("this is from button one");
				};
			});

			// Make the center component big, since that's the
			// typical usage of BorderLayout.
			JButton button2 = new JButton("Buttton 2)");
			button2.setPreferredSize(new Dimension(bwidth, bheight));
			frame.add(button2, BorderLayout.CENTER);
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("this is from button two");
				};
			});

			JButton button3 = new JButton("Button 3");
			frame.add(button3, BorderLayout.LINE_START);
			button3.setPreferredSize(new Dimension(bwidth, bheight));
			button3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("this is from button three");
				};
			});

			JButton button4 = new JButton("Button 4");
			frame.add(button4, BorderLayout.PAGE_END);
			button4.setPreferredSize(new Dimension(bwidth, bheight));
			button4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("this is from button four");
					for (int i = tickcount; i <= tickcount && i >= 0; i--) {
						// Container pane = aFrame.getContentPane()...
						JButton button = new JButton("Button 1)");
						button.setPreferredSize(new Dimension(bwidth, bheight));
						frame.add(button, BorderLayout.PAGE_START);
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println("this is from button one");
							};
						});

						// Make the center component big, since that's the
						// typical usage of BorderLayout.
						JButton button2 = new JButton("Buttton 2)");
						button2.setPreferredSize(new Dimension(bwidth, bheight));
						frame.add(button2, BorderLayout.CENTER);
						button2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println("this is from button two");
							};
						});

						JButton button3 = new JButton("Button 3");
						frame.add(button3, BorderLayout.LINE_START);
						button3.setPreferredSize(new Dimension(bwidth, bheight));
						button3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println("this is from button three");
							};
						});

						JButton button4 = new JButton("Button 4");
						frame.add(button4, BorderLayout.PAGE_END);
						button4.setPreferredSize(new Dimension(bwidth, bheight));
						button4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println("this is from button four");

								frame.setVisible(false);
							};
						});

					}
				}

			});
		}

		// JTextArea textArea = new JTextArea(5, 20);
		// JScrollPane scrollPane = new JScrollPane(textArea);
		// textArea.setEditable(false);// frame.add(textArea);

	}
}
