package edu.neumont.csc150.a1.connerp.inheritance.clinic.data;

import java.util.Calendar;
import java.util.Date;

import edu.neumont.csc150.a1.connerp.inheritance.clinic.people.Doctor;
import edu.neumont.csc150.a1.connerp.inheritance.clinic.people.Patient;

public class BillableService {
	private Patient billTo;
	private Doctor provider;
	private Date dateOfService;
	private Procedures procedure; //contains billable amount
	public final String dayCreated;
	
	public BillableService(Patient billTo, Doctor provider, Date date, Procedures procedure){
		if(billTo == null) throw new IllegalArgumentException("Null values not acceptable!");
		this.billTo = billTo;
		
		if(provider == null) throw new IllegalArgumentException("Null values not acceptable!");
		this.provider = provider;
		
		if(date == null) throw new IllegalArgumentException("Null values not acceptable!");
		this.dateOfService = date;
		
		if(procedure == null) throw new IllegalArgumentException("Null values not acceptable!");
		this.procedure = procedure;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.GetDateOfService());
		String DDMMYYY = "" + calendar.get(Calendar.DAY_OF_MONTH) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.YEAR);
		this.dayCreated = DDMMYYY;
	}
	
	@Override
	public String toString(){
		String tmp = "";
		
		tmp += "Service billable of type " + procedure.name() + " for $" + procedure.cost + "\n";
		tmp += "	Service performed on date: " + dayCreated + "\n";
		tmp += "	Service billable to the patient: " + billTo.toString() + "\n";
		tmp += "	Service provided by staff member: " + provider.toString() + "\n";
		tmp += "	Service's current status: \n";
		tmp += "		Notes finalized: " + finalized + "\n";
		tmp += "		Procedure completed: " + procedureComplete + "\n";
		tmp += "		Service payment completed: " + payed + "\n";
		tmp += "	Provider's notes: \n";
		tmp += "		" + providerNotes;
		
		return tmp;
	}
	
	public Patient GetPatientBilled(){
		return billTo;
	}
	public Doctor GetProvider(){
		return provider;
	}
	public Date GetDateOfService(){
		return dateOfService;
	}
	public Procedures GetProcedure(){
		return procedure;
	}
	
	private String providerNotes;
	private boolean finalized = false, payed = false, procedureComplete = false;
	
	public String GetNotes(){
		return new String(providerNotes);
	}
	public boolean SetNotes(String notes){
		if(notes == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		if(!finalized){
			providerNotes = notes;
		}
		return !finalized;
	}
	
	public void Finalize(){
		finalized = true;
	}
	public void FlagPayed(){
		payed = true;
	}
	public void FlagComplete(){
		procedureComplete = true;
	}
	

	public boolean IsFinal(){
		return finalized;
	}
	public boolean IsPayed(){
		return payed;
	}
	public boolean IsComplete(){
		return procedureComplete;
	}
	/*
Patient
Doctor
Date (use a validated string for the date in MM/DD/YYYY format)
ServiceType (one of office visit, surgery, or procedure (like setting a broken bone))
Notes, completed by the doctor.
Billable amount (visit is $200, surgery is $5000, and procedure is $1000)
	 */
}
