package edu.neumont.csc150.a1.connerp.inheritance.clinic.data;

public enum PhoneType {
	Home(false),
	Work(false),
	Cell(true);
	
	private boolean textable;
	private PhoneType(boolean textable){
		this.textable = textable;
	}
	
	public boolean IsTextable(){
		return textable;
	}
}
