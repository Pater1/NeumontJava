package edu.neumont.csc150.p0111.connerp.project1.mail.services;

import edu.neumont.csc150.p0111.connerp.project1.mail.MailTruck;
import edu.neumont.csc150.p0111.connerp.project1.mail.addresses.Address;
import edu.neumont.csc150.p0111.connerp.project1.mail.mailables.Letter;
import edu.neumont.csc150.p0111.connerp.project1.mail.mailables.Mailable;

public class OfficeReturn extends MailService{
	

	public OfficeReturn(double localDistance) {
		super(localDistance);
	}

	public String toString(){
		String ret = "";
		ret += "Return to office...\n";
		ret += "Distance to travel: " + distance + "m\n";
		return ret;
	}

	@SuppressWarnings("static-access")
	@Override
	public Address GetDestination(MailTruck truck) {
		return truck.office.refference;
	}

	@Override
	public void OnArrival(MailTruck truck) {
		//truck.PickupMail();
	}

	@SuppressWarnings("static-access")
	@Override
	public Mailable Delivery(MailTruck truck) {
		return new Letter(truck.office.refference);
	}

}
