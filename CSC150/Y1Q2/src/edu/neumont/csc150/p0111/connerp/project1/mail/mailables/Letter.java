package edu.neumont.csc150.p0111.connerp.project1.mail.mailables;

import edu.neumont.csc150.p0111.connerp.project1.mail.addresses.Address;

public class Letter extends Mailable {

	public Letter(Address destination) {
		super(destination);
	}
	
	@Override
	public float GetVolume() {
		return 1f/1000f;
	}

	@Override
	public float GetMass() {
		return GetVolume()*20f;
	}
	
	public String toString(){
		String ret = "";
		ret += "Letter\n";
		ret += super.toString();
		return ret;
	}

	public static Letter RandomLetter() {
		return new Letter(Address.RandomAddress());
	}

	
}
