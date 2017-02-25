package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.engine.editor;

import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.engine.runtime.Sprite;

public class SpriteSettings extends JPanel{
	private Map<String, SpriteBuilder> spriteMap = new HashMap<String, SpriteBuilder>();
	
	public SpriteSettings(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public void addSpriteBuilder(String callbackName, String defaultFilePath){
		SpriteBuilder spriteBuilder = new SpriteBuilder();
		spriteBuilder.setSprite(defaultFilePath);
		spriteMap.put(callbackName, spriteBuilder);
		add(spriteBuilder);
	}
	public void removeSpriteBuilder(String callbackName){
		JPanel toRemove = spriteMap.get(callbackName);
		remove(toRemove);
		spriteMap.remove(callbackName);
	}

	public Sprite getSprite(String callbackName){
		return spriteMap.get(callbackName).getSprite();
	}
}
