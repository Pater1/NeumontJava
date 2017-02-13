package edu.neumont.csc150.p0111.connerp.GUI;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PersonDisplay extends JPanel{
	
	public PersonDisplay(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	public void AddPerson(GUIPerson person){
		add(new JLabel(person.toString()));
	}
}
