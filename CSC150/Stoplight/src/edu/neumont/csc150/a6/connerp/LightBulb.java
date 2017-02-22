package edu.neumont.csc150.a6.connerp;

import java.awt.Graphics;

import javax.swing.JComponent;

public class LightBulb extends JComponent{
	private Sprite onState, offState;
	private boolean isOn;
	
	public LightBulb(Sprite on, Sprite off){
		if(on == null || off == null) throw new IllegalArgumentException("No null sprites allowed.");
		
		onState = on;
		offState = off;
		isOn = false;
		
		setSize(onState.getSize().width, onState.getSize().height + offState.getSize().height);
		
		add(onState);
		add(offState);
	}
	
	public void setOnState(boolean state){
		isOn = state;
	}
	
	@Override
	public void setLocation(int x, int y){
		onState.setLocation(x, y);
		offState.setLocation(x, y);
		super.setLocation(x, y);
	}

	@Override
	public void paint(Graphics g) {
		if(isOn){
			onState.paint(g);
		}else{
			offState.paint(g);
		}
	}
}
