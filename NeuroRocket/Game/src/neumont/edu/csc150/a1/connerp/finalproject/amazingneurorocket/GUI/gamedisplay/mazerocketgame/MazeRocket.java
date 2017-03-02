package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.mazerocketgame;
 
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.GameDisplay;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.engine.editor.SpriteSettings;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.engine.runtime.Sprite;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.itsaMAZEing.Maze;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.localUtils.Vector2;
 
public class MazeRocket extends GameDisplay{
    private static final long serialVersionUID = -2663350514988260196L;
    private final int milliDelay = 40;
   
    private MazeSettings mazeSettings;
    private SpriteSettings spriteSettings;
   
    private Maze maze;
    private Sprite player, goal;
    private Timer localTimer;
    
    private Vector2 rocketDir = new Vector2(1,0);
    private double rocketSpeed = 5;
   
    public MazeRocket(JPanel settings, JPanel header){
       super(settings, header);
      
       mazeSettings = new MazeSettings(new Dimension(100,50));
       settings.add(mazeSettings);
      
       spriteSettings = new SpriteSettings();
       spriteSettings.addSpriteBuilder("Rocket", "/resources/sprites/rocket.png");
       spriteSettings.addSpriteBuilder("Wall", "/resources/sprites/black_square.jpg");
       spriteSettings.addSpriteBuilder("Start", "/resources/sprites/start.jpg");
       spriteSettings.addSpriteBuilder("Goal", "/resources/sprites/Goal.png");
       settings.add(spriteSettings);

       header.add(new JButton("Refresh"){/**
		 * 
		 */
		private static final long serialVersionUID = -3953300504774356471L;

	{
    	   addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					MazeSetup();
				}
    	   });
       }});
       
       player = new Sprite(spriteSettings.getSprite("Rocket"));
       player.setSize(player.getPreferredSize());
       add(player);
       
       goal = new Sprite(spriteSettings.getSprite("Goal"));
       goal.setSize(goal.getPreferredSize());
       add(goal);
       
       MazeSetup();
       
       repaint();
       
       localTimer = new Timer(milliDelay, new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			Tick();
			localTimer.start();
		}
    	   
       });
       localTimer.start();
    }
    
    private void Tick(){
    	rocketDir.normalize().multiply(rocketSpeed);
    	player.setLocation(new Point((int)(player.getLocation().x + rocketDir.x), (int)(player.getLocation().y + rocketDir.y)));
 
    	if(outOfBounds(player) || maze.checkCollisions(player)){
    		System.out.println("Fail");
    		MazeSetup();
    	}
    	if(goal.collide(player)){
    		System.out.println("Success");
    		MazeSetup();
    	}
    	
    	repaint();
    }

	private void MazeSetup(){
    	if(maze != null){
    		remove(maze);
    	}
    	
        maze = Maze.generateMaze(mazeSettings.getMazeSize(), mazeSettings.getMazeStart(), mazeSettings.getMazeJump());
        maze.populateSprites(new Sprite(spriteSettings.getSprite("Wall")), new Sprite[]{player}, new Sprite[]{goal});
        
        setSize(maze.getSize());
        setPreferredSize(maze.getSize());   

        this.add(maze);
        repaint();
    }

	@Override
	public Object findType(Class typeWanted) {
		if(typeWanted == this.getClass()){
			return this;
		}else{
			return null;
		}
	}
}