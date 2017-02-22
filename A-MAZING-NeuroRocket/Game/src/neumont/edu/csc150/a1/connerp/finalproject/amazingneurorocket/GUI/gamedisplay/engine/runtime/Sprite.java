package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.engine.runtime;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.localUtils.Vector2;

public class Sprite extends JComponent{
	private static final long serialVersionUID = 7372819281746893742L;
	
	private Image mainSpriteImage;
	private String filePath; // "/edu/neumont/csc150/a9/warnerm/images/DefaultUglyImage bu.jpg"
	
	private double scale = 1;
	
	public Sprite(){
		setOpaque(true);
	}
	public Sprite(double scale){
		this.scale = scale;
		setOpaque(true);
	}
	
	public Sprite(Sprite renderSprite) {
		setSprite(renderSprite.filePath);
		this.scale = renderSprite.scale;
		setOpaque(true);
	}
	public void setSprite(String filePath){
		try{
			mainSpriteImage = new ImageIcon(this.getClass().getResource(filePath)).getImage();
			setSize((int)(mainSpriteImage.getWidth(null) * scale), (int)(mainSpriteImage.getHeight(null) * scale));
			setLocation(0, 0);
			//System.out.println("New Sprite Size:	" + getSize().toString());
			this.filePath = filePath;
		}catch(Exception ex){
			throw ex;
		}
	}

	@Override
	public void paint(Graphics g) {
		//System.out.println("Printing Sprite- \n	Location: " + getLocation().toString() + ",\n	Size: " + getSize().toString());
		//g.drawImage(mainSpriteImage, this.getLocation().x, this.getLocation().y, this.getSize().width, this.getSize().height, null);
		g.drawImage(mainSpriteImage, this.getLocation().x, this.getLocation().y, null);
	}
}