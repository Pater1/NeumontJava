package edu.neumont.csc150.p0111.connerp.project1.mail.addresses.reffpool;

import edu.neumont.csc150.p0111.connerp.project1.mail.POE;
import edu.neumont.csc150.p0111.connerp.project1.mail.addresses.Address;

public class UtahCity{
	public final int zipCode;
	public final double xOff, yOff, distanceStreetsNS, distanceStreetsEW;
	public final int countStreetsN, countStreetsS, countStreetsE, countStreetsW;
	
	protected UtahCity(	int zip,
								double xOff, double yOff, double distanceStreetsNS, double distanceStreetsEW, 
								int countStreetsN, int countStreetsS, int countStreetsE, int countStreetsW){
		this.zipCode = zip;
		this.xOff = xOff;
		this.yOff = yOff;
		this.distanceStreetsNS = distanceStreetsNS;
		this.distanceStreetsEW = distanceStreetsEW;
		this.countStreetsN = countStreetsN;
		this.countStreetsS = countStreetsS;
		this.countStreetsE = countStreetsE;
		this.countStreetsW = countStreetsW;
	}
	
	public Address RandomAddress(){
		int randNS = (int)(POE.randomNumberGenerator.nextDouble() * (countStreetsN + countStreetsS)) - countStreetsS;
		int randEW = (int)(POE.randomNumberGenerator.nextDouble() * (countStreetsE + countStreetsW)) - countStreetsW;
		return new Address(zipCode, randEW, randNS);
	}
}