package edu.neumont.csc150.p0111.connerp.inheritance.clinic.buildings;

public abstract class Address {
	private String address;
	
	public Address(String address) {
		if(address == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		this.address = address;
	}
	public void SetAdress(String address){
		this.address = address;
	}
	public String GetAdress(){
		return address;
	}
}
