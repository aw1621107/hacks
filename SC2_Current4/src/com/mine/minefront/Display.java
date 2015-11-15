package com.mine.minefront;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.mine.minefront.graphics.Render;
import com.mine.minefront.graphics.Screen;
import com.mine.minefront.input.Controller;
import com.mine.minefront.input.InputHandler;

public class Display extends Canvas implements Runnable{

	/** 1.5.3
	 * @author SCott 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "SC pre-Alpha.09";
	public static int Health = 100;
	public static int mana = 0;
	public static int mainTimer;
	private Thread Thread;
	private Screen screen;
	private Game game;
	private BufferedImage img;
	private boolean running = false;
	private int[] pixels;
	private InputHandler input;
	
	private int newX =0;
	private int oldX =0;
	private int newy = 0;
	private int oldy = 0;
	
	private int fps;
	
	public static int MouseSpeed;
	
	public Display(){
		Dimension size = new Dimension(WIDTH, HEIGHT);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		
		screen = new Screen(WIDTH, HEIGHT);
		game = new Game();
		img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)img.getRaster().getDataBuffer()).getData();
	
		input = new InputHandler();
		addKeyListener(input);
		addFocusListener(input);
		addMouseListener(input);
		addMouseMotionListener(input);
	}
	
	public synchronized void  start(){
		if (running) return;
		running = true;
		Thread = new Thread(this);
		Thread.start();
	}
	
	public synchronized void  stop(){
		if (!running)
			return;
			running = false;
			try {
				Thread.join();
			} catch (Exception e){
				e.printStackTrace();
				System.exit(0);
			}
	}
	
		public void run(){
			int frames = 0;
			double unprocessedSeconds = 0;
			long previousTime = System.nanoTime();
			double secondsPerTick = 1 / 60.0;
			int tickCount = 0;
			boolean ticked = false;
			
			while (running = true){
				long currentTime = System.nanoTime();
				long passedTime = currentTime - previousTime;
				previousTime = currentTime;
				unprocessedSeconds += passedTime / 1000000000.0;
				requestFocus();
				
				while (unprocessedSeconds > secondsPerTick){
					tick();
					unprocessedSeconds -= secondsPerTick;
					ticked = true;
					tickCount++;
					if (tickCount % 60 == 0){
						//System.out.println(frames + "fps");
						fps = frames;
						previousTime += 1000;
						///System.out.println(tickCount);
					mainTimer = tickCount;
						frames = 0;
					}
				}
				if (ticked){
					render();
					frames++;
				}
				render();
				frames++;
				//System.out.println("x: " + InputHandler.MouseX + " Y: " + InputHandler.MouseY);
				newX = InputHandler.MouseX;
				if  (newX > oldX){
					//System.out.println("right");
					Controller.turnRight = true;
				}
				if (newX < oldX){
					//System.out.println("left");
					Controller.turnLeft = true;
				}
				if ( newX == oldX){
					//System.out.println("still");
					Controller.turnLeft = false;
					Controller.turnRight = false;
				}
				MouseSpeed = Math.abs(newX - oldX);
				oldX = newX;
				
				//y mouse
				newy = InputHandler.MouseX;
				if  (newy > oldy){
					System.out.println("up");
					Controller.turnRight = true;
				}
				if (newy < oldy){
					System.out.println("down");
					Controller.turnLeft = true;
				}
				if ( newy == oldy){
					System.out.println("still");
					Controller.turnLeft = false;
					Controller.turnRight = false;
				}
				MouseSpeed = Math.abs(newy - oldy);
				oldy = newy;
			}
		}
	
	private void tick(){
		game.tick(input.key);
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3);
			return;
		}
		
		screen.render(game);
		
		for (int i = 0; i<WIDTH * HEIGHT; i++){
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(img, 0, 0, WIDTH +10, HEIGHT + 10, null);
		
		
		
		g.setFont(new Font("Verdana", 0, 50));
		g.setColor(Color.YELLOW);
		g.drawString(fps + "FPS", 20, 50);
		
		g.setFont(new Font("verdana", 2, 20));
		g.setColor(Color.RED);
		g.drawString("health " + Health, 600, 570);
		g.setColor(Color.BLUE);
		g.drawString("mana "+ mana, 20, 570);
		g.dispose();
		bs.show();
	
	}
		
	public static void main(String[] args){
		BufferedImage cursor = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
		Cursor blank = Toolkit.getDefaultToolkit().createCustomCursor(cursor, new Point(0,0), "point");
		Display game = new Display();
		JFrame frame = new JFrame();
		frame.add(game);
		frame.pack();
		frame.getContentPane().setCursor(blank);
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		System.out.println("running");
		
		game.start();
	}
	
	
}
