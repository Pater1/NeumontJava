package edu.neumont.csc150.a1.connerp.inheritance.clinic.tests;

import java.util.ArrayList;

import edu.neumont.csc150.a1.connerp.inheritance.clinic.buildings.Clinic;
import edu.neumont.csc150.a1.connerp.inheritance.clinic.data.BillableService;
import edu.neumont.csc150.a1.connerp.inheritance.clinic.data.PhoneData;
import edu.neumont.csc150.a1.connerp.inheritance.clinic.people.Doctor;
import edu.neumont.csc150.a1.connerp.inheritance.clinic.people.Patient;

public class ClinicTester {
	public static Clinic testClinic;
	public static void main(String[] args) {
		testClinic = new Clinic("975 Panik ln. Somewhere AZ 19864");
		testClinic.SetPhone(new PhoneData("0987654321"));
		
		//Create a patient instance with home and work addresses and phone numbers, no cell phone.  The patient has insurance.
		Patient pat = TestingPresets.patient0();
		
		//Create a doctor instance with home and work addresses and phone numbers, including a cell phone.
		Doctor doc = TestingPresets.doctor0();
		
		//Both the patient and doctor (in 1, 2 above) are part of a medical clinic.
		testClinic.AddMedicalStaff(doc);
		
		pat.SetPrimaryCare(testClinic.FindMostFreeDoctor());
		testClinic.AddPatient(pat);
		
		//Patient (from 1) has received one service (from Doctor 2): an office visit.  
		//The doctor has finished her notes on the visit.
		BillableService bill = TestingPresets.bill0(pat, doc);
		testClinic.AddBill(bill);
		
		//Create a patient instance with a home but no work address.  Cell phone only.
		//The patient has no insurance and will be paying with cash.
		Patient ient = TestingPresets.patient1();
		ient.SetPrimaryCare(testClinic.FindMostFreeDoctor());
		
		//The patient (from 5) is part of the medical clinic.
		testClinic.AddPatient(ient);
		
		//Patient (from 5) has received two services (from Doctor 2): an office visit and a procedure.  
		//The doctor has finished her notes on the office visit but not the procedure.
		/*I'm running out of random variable names!*/
		BillableService bob = TestingPresets.bill1(ient, doc);
		BillableService joe = TestingPresets.bill2(ient, doc);
		testClinic.AddBill(bob);
		testClinic.AddBill(joe);
		
		//Display all the billable services from the clinic for a month that shows the total revenue 
		//for the clinic.  Only services whose notes are complete are considered complete and billable.  
		//This must be accomplished by a method in Medical Clinic.
		ArrayList<BillableService> bills = testClinic.GetBillable(null, true, null, false);
		int totalOutstandingRevenue = 0;
		for(BillableService bl : bills){
			System.out.println(bl.toString());
			totalOutstandingRevenue += bl.GetProcedure().cost;
		}
		System.out.println("Outstanding collectable: $" + totalOutstandingRevenue);
		System.out.println();
		
		//Display all the incomplete services for the clinic for a month that shows the doctor and the 
		//incomplete service (incomplete services have been provided, but the notes are incomplete).  
		//Again, this must be accomplished by a method in Medical Clinic.
		bills = testClinic.GetBillable(null, false, null, false);
		totalOutstandingRevenue = 0;
		for(BillableService bl : bills){
			System.out.println(bl.toString());
			totalOutstandingRevenue += bl.GetProcedure().cost;
		}
		System.out.println("Outstanding uncollectable: $" + totalOutstandingRevenue);
		
		//Demonstrate all these method calls through main in the MedicalTester class.
		/*Umm... Done?*/
		
		//Separate all entities (business classes) from main using a separate package nested under yourlastnamefirstinitial. 
		/*Did (I believe)*/
	}
}
