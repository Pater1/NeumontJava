package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.mazerocketgame;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.localUtils.Vector2;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.localUtils.Vector2UIWrapper;

public class MazeSettings extends JPanel{
	private static final long serialVersionUID = -14954658256798332L;
	
	private Dimension commonDimensions;
	private Vector2UIWrapper size, start, jump;
	
	public MazeSettings(Dimension dimensions){
		this.commonDimensions = dimensions;
		size = new Vector2UIWrapper("Maze Size", new Vector2(11,11), commonDimensions);
		start = new Vector2UIWrapper("Maze Generation Starting Offset", new Vector2(1, 1), commonDimensions);
		jump = new Vector2UIWrapper("Maze Wall Thickness", new Vector2(2, 2), commonDimensions);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(size);
		add(start);
		add(jump);
	}

	public Vector2 getMazeSize(){
		return size.getVector();
	} 
	public Vector2 getMazeStart(){
		return start.getVector();
	} 
	public Vector2 getMazeJump(){
		return jump.getVector();
	}
}
