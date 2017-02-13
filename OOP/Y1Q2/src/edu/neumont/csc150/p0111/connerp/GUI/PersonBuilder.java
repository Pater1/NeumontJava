package edu.neumont.csc150.p0111.connerp.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PersonBuilder extends JPanel {
	private JLabel label = new JLabel("Make a person here!"), error = new JLabel("");
	private JTextField nameF = new JTextField(), nameL = new JTextField();
	private JButton build = new JButton("Build This Person!");
	
	public PersonBuilder(){
		setLayout(new FlowLayout());
		
		build.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent event) {
			     Validate();
			 }
		});

		label.setPreferredSize(new Dimension(150,50));
		build.setPreferredSize(new Dimension(200,40));
		nameF.setPreferredSize(new Dimension(200, 40));
		nameL.setPreferredSize(new Dimension(150,40));
		
		add(label);
		add(nameF);
		add(nameL);
		add(build);
		add(error);
	}
	
	private void Validate(){
		String message = "";
		boolean err = false;
		
		if(!GUIPerson.ValidateName(nameF.getText())){
			nameF.setBackground(Color.PINK);
			message += "First name must not be null or empty! \n";
			err = true;
		}else{
			nameF.setBackground(Color.white);
		}
		
		if(!GUIPerson.ValidateName(nameL.getText())){
			nameL.setBackground(Color.PINK);
			message += "Last name must not be null or empty! \n";
			err = true;
		}else{
			nameL.setBackground(Color.white);
		}
		
		error.setText(message);
		error.setVisible(err);
	}
	
	public GUIPerson CheckBuild(){
		GUIPerson perp = null;
		
		try{
			if(build.getModel().isPressed()){
				perp = new GUIPerson(nameF.getText(), nameL.getText());
			}
		}catch(IllegalArgumentException ex){
			
		}
		
		return perp;
		/*if(!(nameF.getText() == null || nameF.getText().equals("") || nameL.getText() == null || nameL.getText().equals(""))){
			if(build.getModel().isPressed()){
				GUIPerson person = new GUIPerson(nameF.getText(), nameL.getText());
				
				nameF.setText("");
				nameL.setText("");
				
				return person;
			}
			build.setText("Build This Person!");
			build.setVisible(true);
		}else{
			build.setText("");
			build.setVisible(false);
		}
		return null;*/
	}
	
}
