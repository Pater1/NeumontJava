package edu.neumont.csc150.a6.connerp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Sprite extends JComponent{
	private static final long serialVersionUID = 7372819281746893742L;
	
	private Image mainSpriteImage;
	private String filePath; // "/edu/neumont/csc150/a9/warnerm/images/DefaultUglyImage bu.jpg"
	
	public Sprite(){}
	public Sprite(String spritePath) {
		setSprite(spritePath);
	}
	public Sprite(Sprite renderSprite) {
		setSprite(renderSprite.filePath);
	}
	
	public void setSprite(String filePath){
		try{
			mainSpriteImage = new ImageIcon(this.getClass().getResource(filePath)).getImage();
			setSize((int)(mainSpriteImage.getWidth(null)), (int)(mainSpriteImage.getHeight(null)));
			this.filePath = filePath;
		}catch(Exception ex){
			throw ex;
		}
	}

	@Override
	public void paint(Graphics g) {
		/*System.out.println(filePath);
		System.out.println(this.getLocation());
		System.out.println(this.getSize());*/
		g.drawImage(mainSpriteImage, 0, 0, this);
	}
}