package edu.neumont.csc150.p0111.connerp.project1.mail;

import java.util.ArrayList;
import java.util.Collections;

import edu.neumont.csc150.p0111.connerp.project1.mail.addresses.Address;
import edu.neumont.csc150.p0111.connerp.project1.mail.addresses.reffpool.CitiesServiced;
import edu.neumont.csc150.p0111.connerp.project1.mail.mailables.Letter;
import edu.neumont.csc150.p0111.connerp.project1.mail.mailables.Mailable;
import edu.neumont.csc150.p0111.connerp.project1.mail.mailables.Parcel;

public class PostOffice {
	public static final Address refference = new Address(CitiesServiced.cityPool.get(CitiesServiced.zipPool.get(0)).zipCode, 0, 0);

	public ArrayList<Mailable> mail = null;
	public ArrayList<MailTruck> fleet = new ArrayList<MailTruck>();
	private int parcelOdds = 15;
	
	public void GenerateMail(int count) {
		if(mail == null) mail = new ArrayList<Mailable>();
		mail.clear();
		
		for(int i = 0; i < count; i++){
			int rand = (int)(POE.randomNumberGenerator.nextDouble() * 100);
			if(rand < parcelOdds){
				mail.add(Parcel.RandomParcel(0.5f, 1.0f, 1.5f, 10));
			}else{
				mail.add(Letter.RandomLetter());
			}
		}
	}

	public void FillTrucks(int truckCount) {
		fleet.clear();
		
		for(int i = 0; i < truckCount; i++){
			MailTruck tmp = new MailTruck(this);
			tmp.PickupMail(true);
			fleet.add(tmp);
		}
		
		while(mail.size() > 0){
			for(int i = 0; i < truckCount; i++){
				fleet.get(i).PickupMail(false);
			}
		}
	}
	
	public void DistanceSortMail() {
		DistanceSortMail(new Letter(refference));
	}

	public void DistanceSortMail(Mailable reffMail) {
		Collections.sort(
			mail, 
			MailComparator.decending(
				MailComparator.getComparator(
					reffMail, 
					new MailComparator[]{
						MailComparator.Distance, 
						MailComparator.Angle, 
						MailComparator.LetterFirst, 
						MailComparator.Mass
					}
				)
			)
		);
	}

	public void PopMail(Mailable closest) {
		if(mail.remove(closest)){
			System.out.println(mail.size());
		}
	}

	public Mailable FindClosestMail(Mailable delivery) {
		Mailable closest = mail.get(0);
		double closestDist = -1;
		
		for(int i = mail.size()-1; i >= 0; i--){
			double dist = mail.get(i).destination.DistanceFrom(delivery.destination);
			if(closestDist < 0 || dist < closestDist){
				closest = mail.get(i);
				closestDist = dist;
			}
		}
		
		return closest;
	}

	/*public void DistanceSortMail() {
		Collections.sort(mail, (Comparator<Mailable>) (
				(Mailable o1, Mailable o2) ->
					(int)(
							((o1.destination.DistanceFrom(refference) - o2.destination.DistanceFrom(refference)) != 0)
								?
								o1.destination.DistanceFrom(refference) - o2.destination.DistanceFrom(refference)
								:
								((o1.destination.AngleFrom(refference) - o2.destination.AngleFrom(refference) > 45)
									?
									o1.destination.AngleFrom(refference) - o2.destination.AngleFrom(refference)
									:
									((o1 instanceof Parcel && o2 instanceof Parcel)
										?
										((Parcel)o2).volume() - ((Parcel)o1).volume()
										:
										((o1 instanceof Parcel)
											?
											1
											:
											((o2 instanceof Parcel)?
												-1
												:
												0
											)
										)
									)
								)
							)
				));
	}*/
}
