package edu.neumont.csc150.a1.connerp.inheritance.clinic.databases;

public abstract class Database {
	private String writePermissionsKey;
	
	public Database(String key){
		if(key == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		this.writePermissionsKey = key;
	}

	public String GetWritePermissionsKey() {
		return writePermissionsKey;
	}
}
