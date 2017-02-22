package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.mazerocketgame;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
 
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.GameDisplay;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.engine.editor.SpriteSettings;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.engine.runtime.Sprite;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.itsaMAZEing.Maze;
 
public class MazeRocket extends GameDisplay{
    private static final long serialVersionUID = -2663350514988260196L;
   
    private MazeSettings mazeSettings;
    private SpriteSettings spriteSettings;
   
    private Maze maze;
   
    public MazeRocket(JPanel settings, JPanel header){
       super(settings, header);
      
       mazeSettings = new MazeSettings(new Dimension(100,50));
       settings.add(mazeSettings);
      
       spriteSettings = new SpriteSettings();
       spriteSettings.addSpriteBuilder("Rocket", "/resources/sprites/rocket.jpg");
       spriteSettings.addSpriteBuilder("Wall", "/resources/sprites/black_square.jpg");
       spriteSettings.addSpriteBuilder("Start", "/resources/sprites/start.jpg");
       spriteSettings.addSpriteBuilder("Goal", "/resources/sprites/Goal.jpg");
       settings.add(spriteSettings);
       
       header.add(new JButton("Refresh"){{
    	   addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					MazeSetup();
				}
    	   });
       }});
       
       MazeSetup();
       maze.setBackground(Color.yellow);
       this.add(maze);
       
       //System.out.println("In MazeRocket:  " + getSize().toString());
    }
    
    private void MazeSetup(){
        maze = Maze.generateMaze(mazeSettings.getMazeSize(), mazeSettings.getMazeStart(), mazeSettings.getMazeJump());
        maze.populateSprites(new Sprite(spriteSettings.getSprite("Wall")));
        
        setSize(maze.getSize());
        setPreferredSize(maze.getSize());
    }
}