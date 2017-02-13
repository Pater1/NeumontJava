package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay;

import javax.swing.JComponent;
import javax.swing.JPanel;

public abstract class GameDisplay extends JComponent{
	private JPanel settingsPanel;
	
	public GameDisplay(JPanel settings) {
		settingsPanel = settings;
	}

}
