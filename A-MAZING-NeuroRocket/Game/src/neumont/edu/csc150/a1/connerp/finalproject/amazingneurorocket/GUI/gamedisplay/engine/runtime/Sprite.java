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
	
	public Sprite(){}
	public Sprite(double scale){
		this.scale = scale;
	}
	
	public Sprite(Sprite renderSprite) {
		this.mainSpriteImage = renderSprite.mainSpriteImage;
		this.filePath = renderSprite.filePath;
		this.scale = renderSprite.scale;
	}
	public void setSprite(String filePath){
		try{
			mainSpriteImage = new ImageIcon(this.getClass().getResource(filePath)).getImage();
			setSize((int)(mainSpriteImage.getWidth(null) * scale), (int)(mainSpriteImage.getHeight(null) * scale));
			this.filePath = filePath;
		}catch(Exception ex){
			throw ex;
		}
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(mainSpriteImage, this.getLocation().x, this.getLocation().y, this.getSize().width, this.getSize().height, null);
	}
	public void setSize(Vector2 scaledSize) {
		this.setSize(new Dimension(scaledSize.x, scaledSize.y));
	}
	public void setLocation(Vector2 local) {
		Point pnt = new Point();
		pnt.setLocation(local.x, local.y);
		this.setLocation(pnt);
	}
}