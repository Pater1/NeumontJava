package edu.neumont.csc150.a6.connerp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class POE {
	private static final int actorCount = 50;
	
	public static void main(String[] args) {
		POEFrame stop = new POEFrame();
		stop.setVisible(true);
	}

	private static class POEFrame extends JFrame{
		public POEFrame(){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Dimension dim = new Dimension(1920, 1080);
			setSize(dim);
			setPreferredSize(dim);
			
			Stoplight light = new Stoplight();
			setContentPane(new JComponent(){{
				setSize(dim);
			}});
			
			this.getContentPane().add(light);
			//light.subscribe(new StoplightConsoleAlert());
			
			for(int i = 0; i < actorCount; i++){
				StoplightActor act = StoplightActor.randomActor(5, this);
				light.subscribe(act);
				this.getContentPane().add(act);
			}
			
			pack();
		}
		
		
	}
}