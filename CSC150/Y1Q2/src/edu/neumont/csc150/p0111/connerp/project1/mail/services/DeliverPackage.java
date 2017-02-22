package edu.neumont.csc150.p0111.connerp.project1.mail.services;

import edu.neumont.csc150.p0111.connerp.project1.mail.MailTruck;
import edu.neumont.csc150.p0111.connerp.project1.mail.addresses.Address;
import edu.neumont.csc150.p0111.connerp.project1.mail.mailables.Mailable;

public class DeliverPackage extends MailService{
	public final Mailable mail;
	
	public DeliverPackage(Mailable mail, double localDistance){
		super(localDistance);
		this.mail = mail;
	}
	
	public String toString(){
		String ret = "";
		ret += mail.toString();
		ret += "Distance to travel: " + distance + "m\n";
		return ret;
	}
	
	@Override
	public Address GetDestination(MailTruck truck) {
		return mail.destination;
	}

	@Override
	public void OnArrival(MailTruck truck) {
		truck.PopDelivery();
	}

	@Override
	public Mailable Delivery(MailTruck truck) {
		return mail;
	}

}
