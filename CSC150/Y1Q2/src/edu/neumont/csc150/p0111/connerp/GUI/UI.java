package edu.neumont.csc150.p0111.connerp.GUI;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class UI extends JFrame{
	private PersonBuilder builder = new PersonBuilder();
	private PersonDisplay display = new PersonDisplay();
	
	public UI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new JPanel(){{
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			add(builder);
			add(display);
		}});
		
		setSize(800, 600);
	}
	
	public void Update(){
		GUIPerson person = builder.CheckBuild();
		if(person != null){
			display.AddPerson(person);
		}
	}
}
