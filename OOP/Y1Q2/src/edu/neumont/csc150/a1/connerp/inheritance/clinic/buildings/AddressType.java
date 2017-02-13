package edu.neumont.csc150.p0111.connerp.inheritance.clinic.buildings;

import java.lang.reflect.Type;

public enum AddressType {
	Work (Work.class),
	Home (House.class);
	
	@SuppressWarnings("rawtypes")
	private final Class myType;
	
	private AddressType(Class typeCheck){
		if(typeCheck == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		this.myType = typeCheck;
	}
	
	public boolean validateType(Object o){
		return o.getClass().isInstance(myType);
	}
}
