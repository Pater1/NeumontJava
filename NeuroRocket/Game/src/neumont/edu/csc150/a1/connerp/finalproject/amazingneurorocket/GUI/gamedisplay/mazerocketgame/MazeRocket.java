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
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai.GeneticMaskAI;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai.IAI;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai.IGeneticLearner;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai.ITrainer;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.itsaMAZEing.Maze;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.itsaMAZEing.MazeSpace;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.localUtils.Vector2;
 
public class MazeRocket<AITrainer extends ITrainer, AI extends IAI<Double, double[][]>> extends GameDisplay{
    private static final long serialVersionUID = -2663350514988260196L;
    private final int milliDelay = 40;
   
    private MazeSettings mazeSettings;
    private SpriteSettings spriteSettings;
   
    private Maze maze;
    private Sprite player, goal, start, wall;
    private Timer localTimer;
    
    private Vector2 rocketDir = new Vector2(1,0);
    private double rocketSpeed = 5;
   
    public MazeRocket(double scale, boolean populate, JPanel settings, JPanel header){
       super(populate, settings, header);
       if(populate){
	       mazeSettings = new MazeSettings(new Dimension(100,50));
	       settings.add(mazeSettings);
	      
	       spriteSettings = new SpriteSettings();
	       spriteSettings.addSpriteBuilder("Rocket", "/resources/sprites/rocket.png");
	       spriteSettings.addSpriteBuilder("Wall", "/resources/sprites/black_square.jpg");
	       spriteSettings.addSpriteBuilder("Start", "/resources/sprites/start.png");
	       spriteSettings.addSpriteBuilder("Goal", "/resources/sprites/Goal.png");
	       settings.add(spriteSettings);
       }else{
    	   for(int i = 0; i < settings.getComponentCount(); i++){
    		   try{
    			   mazeSettings = (MazeSettings)settings.getComponent(i);
    		   }catch(ClassCastException a){}
    		   try{
    			   spriteSettings = (SpriteSettings)settings.getComponent(i);
    		   }catch(ClassCastException a){}
    	   }
       }
       player = new Sprite(spriteSettings.getSprite("Rocket"));
       add(player);
       
       goal = new Sprite(spriteSettings.getSprite("Goal"));
       add(goal);
       
       start = new Sprite(spriteSettings.getSprite("Start"));
       add(start);

       wall = new Sprite(spriteSettings.getSprite("Wall"));

       player.setScale(scale);
       goal.setScale(scale);
       start.setScale(scale);
       wall.setScale(scale);
    }
    
    private long framesSurvived, maxFramesSurvived = 250;
	@SuppressWarnings("unchecked")
	private void Tick(){
    	//not try-catching this risky cast on purpose
    	rocketDir = Vector2.resolveFromAngle((Math.PI/2) * Math.floor(((double)currentAI.calcualateInputs(centerMaze(player))*4)));
    	//System.out.println(rocketDir);
    	
    	rocketDir.normalize().multiply(rocketSpeed);
    	player.setLocation(new Point((int)(player.getLocation().x + rocketDir.x), (int)(player.getLocation().y + rocketDir.y)));
 
    	framesSurvived++;
    	//System.out.println(framesSurvived);
    	if(outOfBounds(player) || maze.checkCollisions(player) || framesSurvived > maxFramesSurvived){
    		framesSurvived = 0;
    		
    		try{
    			@SuppressWarnings("rawtypes")
				IGeneticLearner genes = (IGeneticLearner)currentAI;
    			
    			double staGoaDist = start.getLocation().distanceSq(goal.getLocation());
    			double plaGoaDist = player.getLocation().distanceSq(goal.getLocation());
    			double plaStaDist = player.getLocation().distanceSq(start.getLocation());

    			genes.calcFitness(staGoaDist - plaGoaDist);
    		}catch(ClassCastException cce){}

    		aiTrainer.evaluateCurrentLearner(currentAI);
    		currentAI = (IAI<Double, double[][]>) aiTrainer.getNextLearner();
    		
    		MazeSetup();
    	}
    	if(goal.collide(player)){
    		framesSurvived = 0;
    		
    		try{
    			@SuppressWarnings("rawtypes")
				IGeneticLearner genes = (IGeneticLearner)currentAI;

    			double staGoaDist = start.getLocation().distanceSq(goal.getLocation());
    			
    			genes.calcFitness(staGoaDist + framesSurvived);
    		}catch(ClassCastException cce){}

    		aiTrainer.evaluateCurrentLearner(currentAI);
    		currentAI = (IAI<Double, double[][]>) aiTrainer.getNextLearner();
    		
    		MazeSetup();
    	}
    	
    	repaint();
    }
	
	@SuppressWarnings("unused")
	private double sigmoid(double in){
		return (in/(1+Math.abs(in)));
	}

	private double[][] centerMaze(Sprite player2) {
		int width = (int)currentAI.getInputSize().x, height = (int)currentAI.getInputSize().y;
		double[][] ret = new double[width][height];
		
		Dimension mazeSizePixels = maze.getSize();
//		System.out.println(mazeSizePixels);
		Vector2 mazeTileSizePixels = new Vector2(mazeSizePixels.width/maze.getMazeWidth(), mazeSizePixels.height/maze.getMazeHeight());
//		System.out.println(mazeTileSizePixels);
		Vector2 playerCenter = new Vector2(player.getLocation().x + (player.getSize().width/2), player.getLocation().y + (player.getSize().height/2));
//		System.out.println(playerCenter);
		
		Vector2 playerTileLocation = new Vector2(Math.round(playerCenter.x/mazeTileSizePixels.x), Math.round(playerCenter.y/mazeTileSizePixels.y));
//		System.out.println(playerTileLocation);
		Vector2 centeredMazeOriginCorner = new Vector2(playerTileLocation.x - (width/2), playerTileLocation.y - (height/2));
//		System.out.println(centeredMazeOriginCorner);
//		System.out.println("");
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				try{
					Vector2 loc = new Vector2(centeredMazeOriginCorner.x + i, centeredMazeOriginCorner.y + j);
//					System.out.println(loc);
					MazeSpace spce = maze.getSpace((int)loc.x, (int)loc.y);
					switch(spce){
						case wall:
							ret[i][j] = -1;
							break;
						case end:
							ret[i][j] = 1;
							break;
						default:
							Dimension plaDim = player.getSize();
							Point plaPlace = player.getLocation();
							
							if(	(
									plaPlace.x > loc.x && plaPlace.x < (loc.x + mazeTileSizePixels.x) ||
									plaPlace.x + plaDim.width > loc.x && plaPlace.x + plaDim.width < (loc.x + mazeTileSizePixels.x)
								)&&(
									plaPlace.y > loc.y && plaPlace.y < (loc.y + mazeTileSizePixels.y) ||
									plaPlace.y + plaDim.height > loc.y && plaPlace.y + plaDim.height < (loc.y + mazeTileSizePixels.y)
								)
							){
								ret[i][j] = 1;
							}else{
								ret[i][j] = 0;
							}
							break;
					}
				}catch(ArrayIndexOutOfBoundsException aoobe){
					ret[i][j] = -1.1;
				}
			}
		}
		
//		String str = "";
//		for(int i = 0; i < ret.length; i++){
//			str += "[";
//			for(int j = 0; j < ret[i].length; j++){
//				if(j != 0) str += ", ";
//				str += ret[i][j];
//			}
//			str +="]\n";
//		}
//		System.out.println(str);
		
		return ret;
	}

	private void MazeSetup(){
    	if(maze != null){
    		remove(maze);
    	}
    	
        maze = Maze.generateMaze(mazeSettings.getMazeSize(), mazeSettings.getMazeStart(), mazeSettings.getMazeJump());
        maze.populateSprites(new Sprite(wall), new Sprite[]{player, start}, new Sprite[]{goal});
        
        setSize(maze.getSize());
        setPreferredSize(maze.getSize());   

        this.add(maze);
        repaint();
    }

	@Override
	public Object findType(@SuppressWarnings("rawtypes") Class typeWanted) {
		if(typeWanted == this.getClass()){
			return this;
		}else{
			return null;
		}
	}

	@Override
    public void startGame(){
		resetGame();
		localTimer = new Timer(milliDelay, new ActionListener(){
			@Override
		 	public void actionPerformed(ActionEvent e) {
				Tick();
		 			localTimer.start();
		 		}  
		    });
		    localTimer.start();
		}

	@Override
	public void pauseGame() {
		localTimer.stop();
	}

	@Override
	public void resetGame() {
		 MazeSetup();
	     repaint();
	}
}