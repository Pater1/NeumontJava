package edu.neumont.csc150.p0111.connerp.project1.mail;

import java.util.ArrayList;

import edu.neumont.csc150.p0111.connerp.project1.mail.mailables.Mailable;
import edu.neumont.csc150.p0111.connerp.project1.mail.services.DeliverPackage;
import edu.neumont.csc150.p0111.connerp.project1.mail.services.MailService;
import edu.neumont.csc150.p0111.connerp.project1.mail.services.OfficeReturn;

public class MailTruck {
	private final double maxVolume = 100, maxMass = 1000;
	private double curVolume, curMass, totalTravelDistance;
	public ArrayList<MailService> route = new ArrayList<MailService>();
	public PostOffice office;
	
	public MailTruck (PostOffice office){
		this.office = office;
	}

	@SuppressWarnings("static-access")
	public void PickupMail(boolean newRoute) {
		if(newRoute){
			route.clear();
			totalTravelDistance = 0;
		}
		curVolume = 0;
		curMass = 0;
		double localDistance = 0;
		
		if(office.mail.size() <= 0) return;
		
		while(office.mail.size() > 0){
			Mailable closest = office.mail.get(0);
			if(route.size() > 0){
				closest = office.FindClosestMail(route.get(route.size()-1).Delivery(this));
			}else{
				closest = office.mail.get(office.mail.size() - 1);
			}
			
			if(curVolume + closest.GetVolume() > maxVolume || curMass + closest.GetMass() > maxMass){
				break;
			}
			
			curVolume += closest.GetVolume();
			curMass += closest.GetMass();
			
			if(route.size() > 0){
				localDistance = closest.destination.DistanceFrom(route.get(route.size()-1).GetDestination(this));
			}else{
				localDistance = closest.destination.DistanceFrom(office.refference);
			}
			
			totalTravelDistance += localDistance;
			route.add(new DeliverPackage(closest, localDistance));
			office.PopMail(closest);
		}
		
		localDistance = office.refference.DistanceFrom(route.get(route.size()-1).GetDestination(this));
		totalTravelDistance += localDistance;
		
		route.add(new OfficeReturn(localDistance));
	}

	public void PopDelivery() {
		route.remove(0);
	}

	public String routeMetrics() {
		String ret = "";
		
		ret += "Mail delivered: " + (route.size() -1) + "\n";
		ret += "Volume Used: " + curVolume + "\n";
		ret += "Mass Used: " + curMass + "kg\n";
		ret += "Total Distance Traveled: " + totalTravelDistance + "m\n";
		
		return ret;
	}
}