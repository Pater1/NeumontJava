package edu.neumont.csc150.p0111.connerp.inheritance.clinic.data;

public class PhoneData {
	private String number;
	private boolean acceptsTexts = false;
	
	public PhoneData(String number) {
		this.SetNumber(number);
	}
	public String GetNumber() {
		return number;
	}
	public void SetNumber(String number) {
		if(number == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		this.number = number;
	}
	
	public boolean CanAcceptsTexts() {
		return acceptsTexts;
	}
	public void SetAcceptsTexts(boolean acceptsTexts) {
		this.acceptsTexts = acceptsTexts;
	}
	
	
}
