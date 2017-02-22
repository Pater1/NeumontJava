package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay;

import javax.swing.JPanel;

public abstract class GameDisplay extends JPanel{
	private JPanel settingsPanel, header;
	
	public GameDisplay(JPanel settings, JPanel header) {
		settingsPanel = settings;
		this.header = header;
		setLayout(null);
	}

}
