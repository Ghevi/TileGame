package dev.ghevi.tilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	private static JFrame frame;
	private Canvas canvas;
	
	
	private String title;
	private int width, height; //in pixels
	
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
		
	}
	
	
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		createCanvas();
		
		frame.add(canvas);
		frame.pack();
		
	}
	
	private void createCanvas() {
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public static JFrame getFrame() {
		return frame;
	}
	
	
	
}
