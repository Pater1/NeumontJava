package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.engine.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.engine.ErrorWindow;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.engine.runtime.Sprite;

public class SpriteBuilder extends JPanel{
	private static final long serialVersionUID = 5935664294679962313L;
	
	private Sprite theSprite;
	private JLabel filePath;
	private JButton exploreFiles;
	
	public Sprite getSprite(){
		theSprite.setSprite(filePath.getText());
		return theSprite;
	}
	
	public void setSprite(String path){
		filePath.setText(path);
		theSprite.setSprite(filePath.getText());
	}
	
	public SpriteBuilder(){
		theSprite = new Sprite();
		filePath = new JLabel("");
		exploreFiles = new JButton("Select Image"){
			private static final long serialVersionUID = 1863424711278785891L;
			{
				addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String path = filePath.getText();
							try {
								Runtime.getRuntime().exec("explorer.exe /select," + path);
							} catch (IOException e1) {
								(new ErrorWindow("file does not exist!", true)).setVisible(true);
							}
						}
					}
				);
			}
		};
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(theSprite);
		add(
			new JPanel(){
				private static final long serialVersionUID = 8975149981738944966L;
				{
					setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
					add(exploreFiles);
					add(filePath);
				}
			}
		);
	}
}