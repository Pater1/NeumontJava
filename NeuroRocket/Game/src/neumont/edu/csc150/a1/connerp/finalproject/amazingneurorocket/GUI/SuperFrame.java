package neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ITypeGrab;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.GameDisplay;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.GUI.gamedisplay.mazerocketgame.MazeRocket;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai.GeneticMaskAI;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai.GeneticMaskAIBreeder;
import neumont.edu.csc150.a1.connerp.finalproject.amazingneurorocket.ai.IAI;

public class SuperFrame extends JFrame implements ITypeGrab<SuperFrame>{
	private static final long serialVersionUID = 7327809067630674611L;
	
	protected ArrayList<GameDisplay> listeningGames = new ArrayList<GameDisplay>();
    protected ActionListener refereshListener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < listeningGames.size(); i++){
				listeningGames.get(i).resetGame();
			}
		}
    };
    protected ActionListener pauseListener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < listeningGames.size(); i++){
				listeningGames.get(i).pauseGame();
			}
		}
    };
    protected ActionListener startListener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < listeningGames.size(); i++){
				listeningGames.get(i).startGame();
			}
		}
    };
	
	private GameDisplay gameDisplay;
	private JPanel brainDisplay, neuronDisplay, gameSettingsDisplay, header;
	
	public SuperFrame(int itterationCount, double scale, boolean populate, GeneticMaskAIBreeder aiTrainer){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		header = new JPanel();
		header.add(new JButton("Refresh"){
			private static final long serialVersionUID = -3953300504774356471L;
			{
	    	   addActionListener(refereshListener);
	       }});
		header.add(new JButton("Pause"){
			private static final long serialVersionUID = -3953300504774356471L;
			{
	    	   addActionListener(pauseListener);
	       }});
		header.add(new JButton("Start"){
			private static final long serialVersionUID = -3953300504774356471L;
			{
	    	   addActionListener(startListener);
	       }});
		
		if(aiTrainer == null)
			aiTrainer = new GeneticMaskAIBreeder(10, 10, 10, 5, 0.3);
		
		JPanel center = new JPanel();
		center.setLayout(new FlowLayout());
		for(int i = 0; i < itterationCount; i++){
			if(i==0){
				gameSettingsDisplay = new JPanel(){
					private static final long serialVersionUID = 7900219147301422751L;
					{
						setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
					}
				};
			}
			gameDisplay = new MazeRocket<GeneticMaskAIBreeder, GeneticMaskAI>(scale, i==0, gameSettingsDisplay, header);
			gameDisplay.setAITrainer(aiTrainer);
			center.add(gameDisplay);

			listeningGames.add(gameDisplay);
		}

		setLayout(new BorderLayout());
		add(center, BorderLayout.CENTER);
	//	add(brainDisplay, BorderLayout.EAST);
	//	add(gameSettingsDisplay, BorderLayout.WEST);
		add(header, BorderLayout.NORTH);
	//	add(neuronDisplay, BorderLayout.SOUTH);

		this.setVisible(true);
		
		gameDisplay.setLocation(0, 0);
		
		setSize(1200, 1200);
		
		pack();
		
		//System.out.println("In Super Frame:	" + gameDisplay.getSize().toString());
		
		setBackground(Color.red);
		
		repaint();
	}

	@Override
	public Object findType(Class typeWanted) {
		if(typeWanted == this.getClass()){
			return this;
		}else{
			return gameDisplay.findType(typeWanted);
		}
	}

	public JPanel getHeader() {
		return header;
	}
}