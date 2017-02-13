package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.GameDisplay;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.mazerocketgame.MazeRocket;

public class SuperFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7327809067630674611L;
	
	private GameDisplay gameDisplay;
	private JPanel brainDisplay, neuronDisplay, gameSettingsDisplay, header;
	
	public SuperFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameSettingsDisplay = new JPanel(){{
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		}};
		gameDisplay = new MazeRocket(gameSettingsDisplay);

		add(new JPanel(){
			private static final long serialVersionUID = 1L;
			{
				setLayout(new BorderLayout());
				add(gameDisplay, BorderLayout.CENTER);
			//	add(brainDisplay, BorderLayout.EAST);
				add(gameSettingsDisplay, BorderLayout.WEST);
			//	add(header, BorderLayout.NORTH);
			//	add(neuronDisplay, BorderLayout.SOUTH);
			}
		});
		
		setSize(800, 600);
	}
}