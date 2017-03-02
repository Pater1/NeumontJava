package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket;

import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.SuperFrame;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.mazerocketgame.MazeRocket;

public class POE {
	public static void main(String[] args) {
		SuperFrame sf = new SuperFrame();
		
		System.out.println(sf.findType(MazeRocket.class));
	}
}