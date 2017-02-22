package edu.neumont.csc150.a6.connerp;

public enum StoplightState {
	Red		(3000),
	Yellow	(1500),
	Green	(3000);
	
	int milliDelay;
	private StoplightState(int i){
		milliDelay = i;
	}
	
	public int GetDelay(){
		return milliDelay;
	}
}