package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ITypeGrab;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.SuperFrame;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.engine.runtime.Sprite;

public abstract class GameDisplay extends JPanel implements ITypeGrab<GameDisplay>{
	private JPanel settingsPanel, header;
	
	public GameDisplay(JPanel settings, JPanel header) {
		settingsPanel = settings;
		this.header = header;
		setLayout(null);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		BufferedImage myImage = new BufferedImage(getSize().width, getSize().height, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2 = myImage.createGraphics();
	    super.paint(g2);
	    System.out.println(myImage.getRGB(0,0));
	}
	
	
	
    protected boolean outOfBounds(Sprite check) {
		return 	check.getBounds().getMinX() < 0 || 					//left
				check.getBounds().getMinY() < 0 || 					//top
				check.getBounds().getMaxX() > getBounds().width || 	//right
				check.getBounds().getMaxY() > getBounds().height;	//bottom
	}

}
