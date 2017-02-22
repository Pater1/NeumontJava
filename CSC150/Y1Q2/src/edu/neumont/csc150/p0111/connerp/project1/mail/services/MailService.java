package edu.neumont.csc150.p0111.connerp.project1.mail.services;

import edu.neumont.csc150.p0111.connerp.project1.mail.MailTruck;
import edu.neumont.csc150.p0111.connerp.project1.mail.addresses.Address;
import edu.neumont.csc150.p0111.connerp.project1.mail.mailables.Mailable;

public abstract class MailService {
	public final double distance;
	
	public MailService(double localDistance) {
		distance = localDistance;
	}
	
	public abstract Address GetDestination(MailTruck truck);
	public abstract void OnArrival(MailTruck truck);
	public abstract Mailable Delivery(MailTruck truck);
}
