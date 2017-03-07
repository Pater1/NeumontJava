package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.engine.runtime;

import java.awt.Color;
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
		this.scale = renderSprite.scale;
		setSprite(renderSprite.filePath);
		setOpaque(true);
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
	public String toString(){
		return "Sprite @\n	Bounds: " + getBounds().toString() + "\n	Path: " + filePath;
	}
	
	@Override
	public void paint(Graphics g) {
	g.drawImage(mainSpriteImage, 
			0, 0, 
			(int)getBounds().width, (int)getBounds().height, 
			0, 0, 
			mainSpriteImage.getWidth(null), mainSpriteImage.getHeight(null), 
		null);
	}
	public boolean collide(Sprite check) {
		return getBounds().intersects(check.getBounds());
	}
	public boolean inBounds(Vector2 vec) {
		boolean ret = vec.x > getBounds().getMinX() && vec.x < getBounds().getMaxX() && vec.y > getBounds().getMinY() && vec.y < getBounds().getMaxY();
		
		return ret;
	}
	public void setScale(double d) {
		scale = d;
		setSize((int)(mainSpriteImage.getWidth(null) * scale), (int)(mainSpriteImage.getHeight(null) * scale));
	}
}