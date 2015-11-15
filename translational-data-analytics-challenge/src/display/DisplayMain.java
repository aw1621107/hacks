package display;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class DisplayMain extends JFrame/* implements ActionListener */ {

	private static final long serialVersionUID = 1L;

	public static int tickcount = 92;
	private static String TITLE = "results";
	public static int HEIGHT = 800;
	public static int WIDTH = 720;
	private static JFrame frame = new JFrame();
	public static int percenofkeyords = 7;

	public static int bwidth = 170;
	public static int bheight = 50;
	// private static JLabel lable = new JLabel(tempout);

	// private static JButton button2 = new JButton("5 (LINE_END)");

	// private JButton button = new JButton();
	private static Container pane = frame.getContentPane();
	private static JScrollPane panil = new JScrollPane();

	public static void main(String[] args) {

		JScrollBar vbar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 300);

		//panil.setLayout(new FlowLayout());
		frame.setSize(HEIGHT, WIDTH);
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		JLabel lable = new JLabel("the percen of applicants who used key words are " + percenofkeyords + "%");
		lable.setPreferredSize(new Dimension(800, bheight));
		frame.add(lable, BorderLayout.PAGE_START);
		frame.add(panil);

		for (int i = tickcount; i <= tickcount && i >= 0; i--) {

			JButton button = new JButton("Button 1)");
			button.setPreferredSize(new Dimension(bwidth, bheight));
			panil.add(button, BorderLayout.PAGE_START);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("this is from button one");
				};
			});

			// Make the center component big, since that's the
			// typical usage of BorderLayout.
			JButton button2 = new JButton("Buttton 2)");
			button2.setPreferredSize(new Dimension(bwidth, bheight));
			panil.add(button2, BorderLayout.CENTER);
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("this is from button two");
				};
			});

			JButton button3 = new JButton("Button 3");
			panil.add(button3, BorderLayout.LINE_START);
			button3.setPreferredSize(new Dimension(bwidth, bheight));
			button3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("this is from button three");
				};
			});

			JButton button4 = new JButton("Button 4");
			panil.add(button4, BorderLayout.PAGE_END);
			button4.setPreferredSize(new Dimension(bwidth, bheight));
			button4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("this is from button four");
					for (int i = tickcount; i <= tickcount && i >= 0; i--) {
						// Container pane = aFrame.getContentPane()...
						JButton button = new JButton("Button 1)");
						button.setPreferredSize(new Dimension(bwidth, bheight));
						panil.add(button, BorderLayout.PAGE_START);
						button.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println("this is from button one");
							};
						});

						// Make the center component big, since that's the
						// typical usage of BorderLayout.
						JButton button2 = new JButton("Buttton 2)");
						button2.setPreferredSize(new Dimension(bwidth, bheight));
						panil.add(button2, BorderLayout.CENTER);
						button2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println("this is from button two");
							};
						});

						JButton button3 = new JButton("Button 3");
						panil.add(button3, BorderLayout.LINE_START);
						button3.setPreferredSize(new Dimension(bwidth, bheight));
						button3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println("this is from button three");
							};
						});

						JButton button4 = new JButton("Button 4");
						panil.add(button4, BorderLayout.PAGE_END);
						button4.setPreferredSize(new Dimension(bwidth, bheight));
						button4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println("this is from button four");

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
