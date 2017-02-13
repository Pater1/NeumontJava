package edu.neumont.csc150.p0111.connerp.inheritance.pets;

public class Pet {
	public final String name; 
	
	public Pet(String name){
		if(name == null) throw new IllegalArgumentException("No null names!");
		
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(obj == this){
			return true;
		}

		if(obj instanceof Pet){
			Pet pt = (Pet)obj;
			return pt.name.equals(name);
		}else if(obj instanceof String){
			String st = (String)obj;
			return st.equals(name);
		}
		
		return false;
	}
}