package edu.neumont.csc150.p0111.connerp.inheritance.clinic.buildings;

import edu.neumont.csc150.p0111.connerp.inheritance.clinic.data.PhoneData;

public class Work extends Address{
	private PhoneData phone;

	public Work(String address) {
		super(address);
	}
	public PhoneData GetPhone() {
		return phone;
	}
	public void SetPhone(PhoneData phone) {
		if(phone == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		this.phone = phone;
	}
}
