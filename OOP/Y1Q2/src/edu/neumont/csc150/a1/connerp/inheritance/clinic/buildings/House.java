package edu.neumont.csc150.p0111.connerp.inheritance.clinic.buildings;

import java.util.ArrayList;

import edu.neumont.csc150.p0111.connerp.inheritance.clinic.data.PhoneData;
import edu.neumont.csc150.p0111.connerp.inheritance.clinic.people.Person;

public class House extends Address{
	private PhoneData phone;
	private Person owner;
	private ArrayList<Person> family;
	
	public House(String address) {
		super(address);
	}
	public PhoneData GetPhone() {
		return phone;
	}
	public void SetPhone(PhoneData phone) {
		if(phone == null) throw new IllegalArgumentException("Null values not acceptable!");
	
		this.phone = phone;
	}
	
	public Person GetOwner() {
		return owner;
	}
	public void SetOwner(Person owner) {
		if(owner == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		this.owner = owner;
	}
	
	public ArrayList<Person> GetFamily() {
		return family;
	}
	public boolean AddFamilyMember(Person member) {
		if(!this.family.contains(member)){
			this.family.add(member);
			return true;
		}
		return false;
	}
	public boolean RemoveFamilyMember(Person member) {
		if(this.family.contains(member)){
			this.family.remove(member);
			return true;
		}
		return false;
	}
}