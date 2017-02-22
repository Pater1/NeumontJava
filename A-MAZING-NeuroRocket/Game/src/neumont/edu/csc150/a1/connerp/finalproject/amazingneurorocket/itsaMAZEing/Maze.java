package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.itsaMAZEing;
 
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
 
import javax.swing.JButton;
import javax.swing.JPanel;
 
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.engine.runtime.Sprite;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.localUtils.Vector2;
 
public class Maze extends JPanel{
    private static final long serialVersionUID = -755241159187174588L;
 
    private MazeSpace[][] maze;
    private int mazeWidth, mazeHeight;
 
	public int getMazeWidth(){
	   return mazeWidth;
	}
	public int getMazeHeight(){
	   return mazeHeight;
	}
 
	private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
    public void populateSprites(Sprite reffWallSprite) {
        setLayout(null);
        
        for(int i = 0; i < sprites.size(); i++){
        	remove(sprites.get(i));
        }
        sprites.clear();
        
    	Dimension wallSpriteSize = new Dimension(reffWallSprite.getSize().width, reffWallSprite.getSize().height);

		for(int i = 0; i < mazeWidth; i++){
		    for(int j = 0; j < mazeHeight; j++){
		        if(maze[i][j] == MazeSpace.wall){
		           Sprite wallSprite = new Sprite(reffWallSprite);
		           wallSprite.setBounds(i * wallSpriteSize.width/2, j * wallSpriteSize.height/2, i * wallSpriteSize.width/2 + wallSprite.getSize().width, j * wallSpriteSize.height/2 + wallSprite.getSize().height);
		           add(wallSprite);
		           sprites.add(wallSprite);
		        }
		    }
		}
     
		setBounds(0, 0, wallSpriteSize.width * mazeWidth, wallSpriteSize.height * mazeHeight);

		repaint();
    }

   public Maze(){}
  private Maze(Vector2 size){
     this.maze = new MazeSpace[size.y][size.x];
     for(int i = 0; i < size.y; i++){
         for(int j = 0; j < size.x; j++){
             this.maze[i][j] = MazeSpace.wall;
         }
     }

     this.mazeWidth = size.x;
     this.mazeHeight = size.x;
  }
	 
  public String toString(){
	  return drawTextMaze(maze);
  }
	 
  public static Maze generateMaze(Vector2 size, Vector2 start, Vector2 jump){
     Maze mz = new Maze(size);
     mz.maze = generateMaze(mz.maze,start,start,jump, 0);
     return mz;
  }
  private static MazeSpace[][] generateMaze(MazeSpace[][] m, Vector2 place, Vector2 wall, Vector2 jump, int depth){
     Random rand = new Random();
     ArrayList<LegalMoves> mvs = new ArrayList<LegalMoves>();
     ArrayList<Vector2> log = new ArrayList<Vector2>();
     log.add(place);
    
     do{
         place = log.get(log.size()-1);
         mvs.removeAll(mvs);
         mvs = legalMoves(m,place,jump);
        
         while(mvs.size() <= 0){
             log.remove(log.size()-1);
             if(log.size() <= 0){
                return generateMazeExits(m,jump);
             }else{
                place = log.get(log.size()-1);
             }
             mvs.removeAll(mvs);
             mvs = legalMoves(m,place,jump);
         }
        
         LegalMoves mv = mvs.get(rand.nextInt(mvs.size()));
        
         switch(mv){
             case up:
                m = flipSpaceBits(m,place,new Vector2(0, jump.y));
                log.add(new Vector2(place.x, place.y+jump.y));
                break;
             case down:
                m = flipSpaceBits(m,place,new Vector2(0, -jump.y));
                log.add(new Vector2(place.x, place.y-jump.y));
                break;
             case right:
                m = flipSpaceBits(m,place,new Vector2(jump.x, 0));
                log.add(new Vector2(place.x+jump.x, place.y));
                break;
             case left:
                m = flipSpaceBits(m,place,new Vector2(-jump.x, 0));
                log.add(new Vector2(place.x-jump.x, place.y));
                break;
         }
     }while(true);
  }
  private static MazeSpace[][] flipSpaceBits(MazeSpace[][] m, Vector2 placeOld, Vector2 moveDir){
     if(moveDir.x != 0){
         for(int j = placeOld.x; j != placeOld.x + moveDir.x + ((0 > moveDir.x) ? -1 : +1); j = ((0 > moveDir.x) ? j-1 : j+1)){
             if(j < m[placeOld.y].length && j >= 0){
                m[placeOld.y][j] = MazeSpace.space;
             }
         }
     }else{
         for(int i = placeOld.y; i != placeOld.y + moveDir.y + ((0 > moveDir.y) ? -1 : +1); i = ((0 > moveDir.y) ? i-1 : i+1)){
             if(i < m.length && i >= 0){
                m[i][placeOld.x] = MazeSpace.space;
             }
         }
     }
     return m;
  }
  private static MazeSpace[][] generateMazeExits(MazeSpace[][] m, Vector2 jump){
     ArrayList<Vector2> possibleDoors = new ArrayList<Vector2>(), doorDirs = new ArrayList<Vector2>();
     for(int i = 0; i < m.length; i += m.length-1){
         for(int j = 0; j < m[i].length; j++){
             if(m[i + ((i==0)?jump.y:-jump.y)][j] == MazeSpace.space){
                possibleDoors.add(new Vector2(i, j));
                doorDirs.add(new Vector2(((i==0)?jump.y:-jump.y),0));
             }
         }
     }
     for(int i = 0; i < m[0].length; i += m[0].length-1){
         for(int j = 0; j < m.length; j++){
             if(m[j][i + ((i==0)?jump.x:-jump.x)] == MazeSpace.space){
                possibleDoors.add(new Vector2(j, i));
                doorDirs.add(new Vector2(0,((i==0)?jump.x:-jump.x)));
             }
         }
     }
    
     Random rand = new Random();
    
     int a = rand.nextInt(possibleDoors.size());
     m = flipSpaceBits(m,possibleDoors.get(a),doorDirs.get(a));

     possibleDoors.remove(a);
     doorDirs.remove(a);
    
     a = rand.nextInt(possibleDoors.size());
     m = flipSpaceBits(m,possibleDoors.get(a),doorDirs.get(a));
    
     return m;
  }
// 
  private static ArrayList<LegalMoves> legalMoves(MazeSpace[][] m, Vector2 place, Vector2 jump){
     ArrayList<LegalMoves> mvs = new ArrayList<LegalMoves>();
    
     //check up
     int u = place.y + jump.y;
     if(u < m.length && m[u][place.x] == MazeSpace.wall){
         mvs.add(LegalMoves.up);
     }
     //check down
     int d = place.y - jump.y;
     if(d >= 0 && m[d][place.x] == MazeSpace.wall){
         mvs.add(LegalMoves.down);
     }
     //check left
     int l = place.x - jump.x;
     if(l >= 0 && m[place.y][l] == MazeSpace.wall){
         mvs.add(LegalMoves.left);
     }
     //check right
     int r = place.x + jump.x;
     if(r < m[0].length && m[place.y][r] == MazeSpace.wall){
         mvs.add(LegalMoves.right);
     }
    
     return mvs;
  }
 
	private static String drawTextMaze(MazeSpace[][] m){
	   return drawTextMaze(m, null);
	}
	private static String drawTextMaze(MazeSpace[][] m, Vector2 vec){
	   String ret = "";
	    
	   for(int i = 0; i < m.length; i++){
	       for(int j = 0; j < m[i].length; j++){
	           if(vec != null && i == vec.y && j == vec.x){
	              ret += "&&";
	           }else{
	              if(m[i][j] == MazeSpace.space){
	                  ret += "  ";
	              }else{
	                  ret += "++";
	              }
	           }
	       }
	       ret += "\n";
	   }
	  
	   return ret;
	}
}