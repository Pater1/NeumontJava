package edu.neumont.csc150.p0111.connerp.GUI;

public class GUIPerson {
	private String first, last;
	
	public GUIPerson(String first, String last){
		if(ValidateName(first) || ValidateName(last))
			throw new IllegalArgumentException("Null and empty names not allowed!");
			
		this.first = first;
		this.last = last;
	}

	public static boolean ValidateName(String validate){
		return !(validate == null || validate.equals(""));
	}
	
	public String toString(){
		return "" + first + " " + last;
	}
}