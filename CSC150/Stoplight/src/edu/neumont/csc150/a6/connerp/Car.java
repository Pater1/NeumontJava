package edu.neumont.csc150.a6.connerp;

import javax.swing.JFrame;

public class Car extends StoplightActor{
	private static final String spritePath = "/resources/actors/car.png";
	private static final int greenSpeed = 12, yellowSpeed = 10, redSpeed = 0;

	public Car(int tick, JFrame frame) {
		super(tick, spritePath, frame);
		setMoveSpeed(redSpeed);
		acceleration = 0.1;
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
