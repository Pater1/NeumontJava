package edu.neumont.csc150.a6.connerp;

import javax.swing.JFrame;

public class Person extends StoplightActor{
	private static final String spritePath = "/resources/actors/person.png";
	private static final int greenSpeed = 4, yellowSpeed = 6, redSpeed = 0;
	
	public Person(int tick, JFrame frame) {
		super(tick, spritePath, frame);
		setMoveSpeed(redSpeed);
		acceleration = 0.8;
	}

	@Override
	public void LightChanged(StoplightState changedTo) {
		switch(changedTo){
			case Red:
				setMoveSpeed(redSpeed);
				break;
			case Yellow:
				setMoveSpeed(yellowSpeed);
				break;
			case Green:
				setMoveSpeed(greenSpeed);
				break;
		}
	}
}
