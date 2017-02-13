package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.mazerocketgame;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.GameDisplay;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.engine.editor.SpriteSettings;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.itsaMAZEing.Maze;

public class MazeRocket extends GameDisplay{
	private static final long serialVersionUID = -2663350514988260196L;
	
	private MazeSettings mazeSettings;
	private SpriteSettings spriteSettings;
	
	private Maze maze;
	
	public MazeRocket(JPanel settings){
		super(settings);
		
		mazeSettings = new MazeSettings(new Dimension(100,50));
		settings.add(mazeSettings);
		
		spriteSettings = new SpriteSettings();
		spriteSettings.addSpriteBuilder("Rocket", "/resources/sprites/rocket.jpg");
		spriteSettings.addSpriteBuilder("Wall", "/resources/sprites/black_square.jpg");
		
		settings.add(spriteSettings);
		
		maze = Maze.generateMaze(mazeSettings.getMazeSize(), mazeSettings.getMazeStart(), mazeSettings.getMazeJump());
		add(maze);
	}
	
	public void paint(Graphics g) {
		maze.setWallSprite(spriteSettings.getSprite("Wall"));
		maze.paint(g);
	}
}
