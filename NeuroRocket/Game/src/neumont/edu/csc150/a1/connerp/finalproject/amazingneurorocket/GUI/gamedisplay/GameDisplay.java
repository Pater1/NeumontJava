package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ITypeGrab;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.SuperFrame;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.engine.runtime.Sprite;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai.IAI;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai.ITrainer;

public abstract class GameDisplay<AITrainer extends ITrainer, AI extends IAI> extends JPanel implements ITypeGrab<GameDisplay>{
    private JPanel settingsPanel, header;

    protected AITrainer aiTrainer;
    protected AI currentAI;

    public void setAITrainer(AITrainer trainer){
    	aiTrainer = trainer;
    	try{
    		currentAI = (AI)aiTrainer.getNextLearner();
    	}catch(Exception ex){
    		System.err.println("GameDisplay's AI type must match it's trainer's type");
    	}
    }
	
	public GameDisplay(boolean populate, JPanel settings, JPanel header) {
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
	}
	
	
	
    protected boolean outOfBounds(Sprite check) {
		return 	check.getBounds().getMinX() < 0 || 					//left
				check.getBounds().getMinY() < 0 || 					//top
				check.getBounds().getMaxX() > getBounds().width || 	//right
				check.getBounds().getMaxY() > getBounds().height;	//bottom
	}

	public abstract void startGame();
	public abstract void pauseGame();
	public abstract void resetGame();

}
