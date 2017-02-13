package edu.neumont.csc150.p0111.connerp.inheritance.clinic.people;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import edu.neumont.csc150.p0111.connerp.inheritance.clinic.buildings.Address;
import edu.neumont.csc150.p0111.connerp.inheritance.clinic.buildings.AddressType;
import edu.neumont.csc150.p0111.connerp.inheritance.clinic.data.PhoneData;
import edu.neumont.csc150.p0111.connerp.inheritance.clinic.data.PhoneType;

public class Person {
	private String nameFirst, nameLast;

	private Map<PhoneType, PhoneData> phones = new HashMap<PhoneType, PhoneData>();
	private Map<AddressType, Address> addresses = new HashMap<AddressType, Address>();
	
	@Override
	public String toString(){
		return GetName();
	}
	
	public String GetName(){
		return nameFirst + " " + nameLast;
	}

	public Person(String nameF, String nameL){
		if(nameF == null) throw new IllegalArgumentException("Null values not acceptable!");
		if(nameL == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		nameFirst = nameF;
		nameLast = nameL;
	}
	
	public void SetPhone(PhoneType phoneType, PhoneData phoneData){
		try{
			phones.get(phoneType);
			phones.remove(phoneType);
		}catch(NullPointerException ex){}
		phoneData.SetAcceptsTexts(phoneType.IsTextable());
		phones.put(phoneType, phoneData);
	}
	public PhoneData GetPhone(PhoneType phoneType){
		try{
			return phones.get(phoneType);
		}catch(NullPointerException ex){
			return null;
		}
	}
	
	public void SetAdress(AddressType addressType, Address addressData){
		if(addressType.validateType(addressData)){
			try{
				addresses.get(addressType);
				addresses.remove(addressType);
			}catch(NullPointerException ex){}
			addresses.put(addressType, addressData);
		}
	}
	public Address GetAdress(AddressType addressType){
		try{
			return addresses.get(addressType);
		}catch(NullPointerException ex){
			return null;
		}
	}
	
	private String uniqueID = null;

	public boolean SetIndexID(String nextID) {
		if(uniqueID != null)return false;
		
		uniqueID = nextID;
		return true;
	}
	public String GetIndexID() {
		return uniqueID;
	}
	
}
