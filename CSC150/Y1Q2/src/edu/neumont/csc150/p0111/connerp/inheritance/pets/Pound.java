package edu.neumont.csc150.p0111.connerp.inheritance.pets;

import java.util.ArrayList;

public class Pound {
	private ArrayList<Pet> pets = new ArrayList<Pet>();
	
	public boolean AddPet(Pet toAdd){
		if(pets.contains(toAdd)) return false;
		
		pets.add(toAdd);
		return true;
	}

	public Pet findPet(String name){
		if(pets.contains(name)){
			Pet pt = pets.get( pets.indexOf(name) );
			pets.remove(pt);
			return pt;
		}
		return null;
	}
}