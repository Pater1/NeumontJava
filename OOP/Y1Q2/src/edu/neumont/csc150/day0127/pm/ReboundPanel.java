package edu.neumont.csc150.day0127.pm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ReboundPanel extends JPanel {

	private final int WIDTH = 300, HEIGHT = 100;
	private final int DELAY = 30, IMAGE_SIZE = 35;
	
	private ImageIcon image;
	private Timer timer;
	private int x, y, moveX, moveY;
	
	public ReboundPanel() {
		timer = new Timer(DELAY, new ReboundListener());
		
		image = new ImageIcon("giphy.gif");
		
		x = 0;
		y = 40;
		moveX = 3;
		moveY = moveX;
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(Color.BLACK);
		timer.start();
		
	}
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		image.paintIcon(this, page, x, y);
	}
	
	private class ReboundListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			x += moveX;
			y += moveY;
			//System.out.println("x: " + x + " y: " + y);
			
			if (x <= 0 || x >= WIDTH - IMAGE_SIZE) {
				moveX *= -1;
			}
			
			if (y <= 0 || y >= HEIGHT - IMAGE_SIZE) {
				moveY *= -1;
			}
			
			
			repaint();
			
			
			
		}
		
	}
}
