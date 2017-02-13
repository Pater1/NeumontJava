package edu.neumont.csc150.day0127.pm;

import javax.swing.JFrame;

public class GUIIntro {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ReboundPanel panel = new ReboundPanel();
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}
}