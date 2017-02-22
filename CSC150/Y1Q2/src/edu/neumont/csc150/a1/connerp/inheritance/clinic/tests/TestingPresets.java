package edu.neumont.csc150.a1.connerp.inheritance.clinic.tests;

import java.util.Date;

import edu.neumont.csc150.a1.connerp.inheritance.clinic.buildings.AddressType;
import edu.neumont.csc150.a1.connerp.inheritance.clinic.buildings.House;
import edu.neumont.csc150.a1.connerp.inheritance.clinic.buildings.Work;
import edu.neumont.csc150.a1.connerp.inheritance.clinic.data.BillableService;
import edu.neumont.csc150.a1.connerp.inheritance.clinic.data.InsuranceData;
import edu.neumont.csc150.a1.connerp.inheritance.clinic.data.PhoneData;
import edu.neumont.csc150.a1.connerp.inheritance.clinic.data.PhoneType;
import edu.neumont.csc150.a1.connerp.inheritance.clinic.data.Procedures;
import edu.neumont.csc150.a1.connerp.inheritance.clinic.people.Doctor;
import edu.neumont.csc150.a1.connerp.inheritance.clinic.people.Patient;

public class TestingPresets {
	public static Patient patient0(){
		//home and work addresses and phone numbers, no cell phone.
		//The patient has insurance.
		
		Patient pat = new Patient("John", "Doe");
		pat.SetPhone(PhoneType.Home, new PhoneData("5412360987"));
		pat.SetPhone(PhoneType.Work, new PhoneData("8012447980"));
		//no cell

		pat.SetAdress(AddressType.Work, new Work("432 Gergublerb Ave. Middle-of-Nowhere AZ 12345"));
		pat.SetAdress(AddressType.Home, new House("999 Bigg Str. Edge-of-Anywhere AZ 12378"));
		
		pat.SetInsuranceData(new InsuranceData("Aflac"));
		
		return pat;
	}

	public static Patient patient1() {
		//Create a patient instance with a home but no work address.  Cell phone only.
		//The patient has no insurance and will be paying with cash.
		
		Patient pat = new Patient("Jim", "Beam");
		pat.SetAdress(AddressType.Home, new House("The bottle"));
		
		pat.SetPhone(PhoneType.Cell, new PhoneData("1234567890"));
		
		return pat;
	}
	
	public static Doctor doctor0(){
		Doctor doc = new Doctor("Roseanne", "Conner");
		
		//work phone set when added to database (any one set here would be overwritten then)
		doc.SetPhone(PhoneType.Home, new PhoneData("2921894357"));
		doc.SetPhone(PhoneType.Cell, new PhoneData("7732903745"));
		
		//work address set when added to database (any one set here would be overwritten then)
		doc.SetAdress(AddressType.Home, new House("someplace, somewhere..."));
		
		return doc;
	}

	public static BillableService bill0(Patient pat, Doctor doc) {
		Date dt = new Date();
		BillableService bill = new BillableService(pat, doc, dt, Procedures.Visit);
		bill.SetNotes("Looks like flu season again...");
		bill.Finalize();
		return bill;
	}
	
	public static BillableService bill1(Patient pat, Doctor doc) {
		Date dt = new Date();
		BillableService bill = new BillableService(pat, doc, dt, Procedures.Visit);
		bill.SetNotes("Kids, don't jump off your skateboards mid-30ft-jump; it hurts. Kid got away with no worse than intense bruising though... friggin' miracle!");
		bill.Finalize();
		return bill;
	}
	public static BillableService bill2(Patient pat, Doctor doc) {
		Date dt = new Date();
		BillableService bill = new BillableService(pat, doc, dt, Procedures.Procedure);
		bill.SetNotes("Dislocated shoulder. Reset, but will need follow-up.");
		return bill;
	}
}
