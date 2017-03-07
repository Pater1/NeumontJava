package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket;

import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.SuperFrame;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.mazerocketgame.MazeRocket;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai.GeneticMaskAIBreeder;

public class POE {
	public static void main(String[] args) {
		GeneticMaskAIBreeder aiTrainer = new GeneticMaskAIBreeder(10, 2, 2, 5, 0.3);
		SuperFrame main = new SuperFrame(1,1,true,aiTrainer);
		SuperFrame backGround = new SuperFrame((22*11),0.1,false,aiTrainer);

		aiTrainer.populateHeader(main.getHeader());
		aiTrainer.populateHeader(backGround.getHeader());
	}
}