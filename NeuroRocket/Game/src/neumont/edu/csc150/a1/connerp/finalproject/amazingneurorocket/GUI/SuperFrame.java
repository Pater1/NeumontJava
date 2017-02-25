package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.GameDisplay;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.mazerocketgame.MazeRocket;

public class SuperFrame extends JFrame{
	private static final long serialVersionUID = 7327809067630674611L;
	
	private GameDisplay gameDisplay;
	private JPanel brainDisplay, neuronDisplay, gameSettingsDisplay, header;
	
	public SuperFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameSettingsDisplay = new JPanel(){
			private static final long serialVersionUID = 7900219147301422751L;
			{
				setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			}
		};
		header = new JPanel();
		gameDisplay = new MazeRocket(gameSettingsDisplay, header);

		setLayout(new BorderLayout());
		add(gameDisplay, BorderLayout.CENTER);
	//	add(brainDisplay, BorderLayout.EAST);
		add(gameSettingsDisplay, BorderLayout.WEST);
		add(header, BorderLayout.NORTH);
	//	add(neuronDisplay, BorderLayout.SOUTH);

		
		gameDisplay.setLocation(0, 0);
		
		setSize(1200, 1200);
		
		pack();
		
		//System.out.println("In Super Frame:	" + gameDisplay.getSize().toString());
		
		setBackground(Color.red);
		
		repaint();
	}
}