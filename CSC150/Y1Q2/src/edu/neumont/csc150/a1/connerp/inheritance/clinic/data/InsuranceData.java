package edu.neumont.csc150.a1.connerp.inheritance.clinic.data;

public class InsuranceData {
	private String carrier;
	
	public InsuranceData(String carrier){
		if(carrier == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		this.carrier = carrier;
	}
	
	@Override
	public String toString(){
		return carrier;
	}
}
