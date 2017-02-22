package edu.neumont.csc150.a6.connerp;

public class StoplightConsoleAlert implements IStoplightListener{
	public void LightChanged(StoplightState changedTo) {
		System.out.println("Stoplight Changed to: " + changedTo.toString());
	}
}