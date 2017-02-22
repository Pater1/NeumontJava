package edu.neumont.csc150.p0111.connerp.project1.mail.mailables;

import edu.neumont.csc150.p0111.connerp.project1.mail.addresses.Address;

public abstract class Mailable{
	public Address destination;
	
	public Mailable(Address destination){
		this.destination = destination;
	}
	
	public String toString(){
		String ret = "";
		ret += "Mail to : ";
		ret += destination.toString() + "\n";
		return ret;
	}
	public String toString(Address reff) {
		String ret = toString();
		ret += "Distance: " + destination.DistanceFrom(reff) + "m\n";
		ret += "Angle: " + destination.AngleFrom(reff) + "d\n";
		return ret;
	}

	public abstract float GetVolume();

	public abstract float GetMass();
}
