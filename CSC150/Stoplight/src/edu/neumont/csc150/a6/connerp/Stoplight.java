package edu.neumont.csc150.a6.connerp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Stoplight extends JPanel implements ITickListener{
	private LightBulb red, green, yellow;
	private StoplightState state = StoplightState.Red;
	private ArrayList<IStoplightListener> listeners = new ArrayList<IStoplightListener>();
	
	public Stoplight(){
		red = new LightBulb(
				new Sprite("/resources/stoplight/Red-On.png"),
				new Sprite("/resources/stoplight/Red-Off.png")
			);
		yellow = new LightBulb(
				new Sprite("/resources/stoplight/Yellow-On.png"),
				new Sprite("/resources/stoplight/Yellow-Off.png")
			);
		green = new LightBulb(
				new Sprite("/resources/stoplight/Green-On.png"),
				new Sprite("/resources/stoplight/Green-Off.png")
			);
		 
		setSize(new Dimension(red.getSize().width, 
				(red.getSize().height + green.getSize().height + yellow.getSize().height)/2));
		
		setLayout(null);
		
		yellow.setLocation(red.getLocation().x, 50);
		green.setLocation(red.getLocation().x, 100);
		
		add(red);
		add(yellow);
		add(green);
		
		DelayEnded();
	}

	@Override
	public void DelayEnded() {
		red.setOnState(false);
		yellow.setOnState(false);
		green.setOnState(false);

		for(IStoplightListener listen : listeners){
			listen.LightChanged(state);
		}
		
		switch(state){
			case Red:
				state = StoplightState.Green;
				red.setOnState(true);
				break;
			case Yellow:
				state = StoplightState.Red;
				yellow.setOnState(true);
				break;
			case Green:
				state = StoplightState.Yellow;
				green.setOnState(true);
				break;
		}
		
		Ticker.DelayStart(state.GetDelay(), this);
		repaint();
	}

	public void subscribe(IStoplightListener stoplightConsoleAlert) {
		listeners.add(stoplightConsoleAlert);
	}
	public void unsubscribe(IStoplightListener stoplightConsoleAlert) {
		listeners.remove(stoplightConsoleAlert);
	}
	

	/*@Override
	public void paint(Graphics g) {
		red.paint(g);
		yellow.paint(g);
		green.paint(g);
	}*/
}