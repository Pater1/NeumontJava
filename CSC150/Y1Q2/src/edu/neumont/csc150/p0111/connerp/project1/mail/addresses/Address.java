package edu.neumont.csc150.p0111.connerp.project1.mail.addresses;

import edu.neumont.csc150.p0111.connerp.project1.mail.POE;
import edu.neumont.csc150.p0111.connerp.project1.mail.addresses.reffpool.CitiesServiced;

public class Address{
	public int zip, x, y;
	
	public int absLegDist(){
		return Math.abs(((x > 0)? x : -x) + ((y > 0)? y: -y));
	}
	
	public Address(int zip, int x, int y){
		this.zip = zip;
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		String ret = "";
		ret += "" + ((x > 0)? x + " E" : (-x) + " W") + " " + ((y > 0)? y + " N" : (-y) + " S") + ", " + zip;
		return ret;
	}

	public static Address RandomAddress() {
		return CitiesServiced.cityPool.get(CitiesServiced.zipPool.get(
					(int)(POE.randomNumberGenerator.nextDouble() * CitiesServiced.zipPool.size()))).RandomAddress();
	}

	public double DistanceFrom(Address reff) {
		double dist = 0;
		if(zip == reff.zip){
			dist = Math.abs(x - reff.x) + Math.abs(y - reff.y);
		}else{
			double hereOrigin = Math.abs(x) + Math.abs(y);
			double thereOrigin = Math.abs(reff.x) + Math.abs(reff.y);
			dist = (hereOrigin + thereOrigin + CitiesServiced.DistanceBetweenZips(zip, reff.zip));
		}
		return Math.abs(dist);
	}

	public float AngleFrom(Address refference) {
		return (float)Math.toDegrees(Math.atan2(y,x));
	}
}
