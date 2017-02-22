package edu.neumont.csc150.a6.connerp;

import javax.swing.JFrame;

public class Dog extends StoplightActor{
	private static final String spritePath = "/resources/actors/dog.png";
	private static final int speed = 8;

	public Dog(int tick, JFrame frame) {
		super(tick, spritePath, frame);
		setMoveSpeed(speed);
	}

	@Override
	public void LightChanged(StoplightState changedTo) {}
}
