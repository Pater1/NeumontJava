package edu.neumont.csc150.day0127.pm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PushCounterPanel extends JPanel {

	private int count;
	private JButton push;
	private JLabel label;
	
	public PushCounterPanel(int increment) {
		count = 0;
		
		push = new JButton("Push me!");
		push.addActionListener(new ButtonListener(increment));
	

		label = new JLabel("Pushes: " + count);
		
		add(push);
		add(label);
		
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(300, 40));
	}
	
	private class ButtonListener implements ActionListener
	{
		private int increment;
		public ButtonListener(int increment) {
			this.increment = increment;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			count++;
			label.setText("Pushes: " + count);
			
		}
		
	}
	
}