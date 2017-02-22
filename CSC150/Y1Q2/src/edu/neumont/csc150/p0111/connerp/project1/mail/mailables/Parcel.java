package edu.neumont.csc150.p0111.connerp.project1.mail.mailables;

import edu.neumont.csc150.p0111.connerp.project1.mail.POE;
import edu.neumont.csc150.p0111.connerp.project1.mail.addresses.Address;

public class Parcel extends Mailable {
	float l, w, h, m;
	
	@Override
	public float GetVolume() {
		return l*w*h;
	}

	@Override
	public float GetMass() {
		return m;
	}

	public Parcel(Address destination, float length, float width, float height, float mass) {
		super(destination);
		this.l = length;
		this.w = width;
		this.h = height;
		this.m = mass;
	}
	
	public String toString(){
		String ret = "";
		ret += "Parsel \n";
		ret += super.toString();
		ret += "" + l + "\'x" + w + "\'x" + h + "\' volume: " + GetVolume() + "\n"; 
		ret += "" + m + "kg\n";
		return ret;
	}

	public static Parcel RandomParcel(double l, double w, double h, double m) {
		return new Parcel(Address.RandomAddress(), (
				(float)(POE.randomNumberGenerator.nextDouble() * l)+1), 
				((float)(POE.randomNumberGenerator.nextDouble() * w)+1), 
				((float)(POE.randomNumberGenerator.nextDouble() * h))+1, 
				((float)(POE.randomNumberGenerator.nextDouble() * m))+1);
	}
}
