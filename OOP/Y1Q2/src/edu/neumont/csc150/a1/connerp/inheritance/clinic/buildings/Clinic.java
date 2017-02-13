package edu.neumont.csc150.p0111.connerp.inheritance.clinic.buildings;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import edu.neumont.csc150.p0111.connerp.inheritance.clinic.data.BillableService;
import edu.neumont.csc150.p0111.connerp.inheritance.clinic.data.PhoneType;
import edu.neumont.csc150.p0111.connerp.inheritance.clinic.databases.BillableServiceDatabase;
import edu.neumont.csc150.p0111.connerp.inheritance.clinic.databases.MedicalStaffDatabase;
import edu.neumont.csc150.p0111.connerp.inheritance.clinic.databases.PatientDatabase;
import edu.neumont.csc150.p0111.connerp.inheritance.clinic.databases.ProcedureCostDatabase;
import edu.neumont.csc150.p0111.connerp.inheritance.clinic.people.Doctor;
import edu.neumont.csc150.p0111.connerp.inheritance.clinic.people.Patient;
import edu.neumont.csc150.p0111.connerp.inheritance.clinic.utilities.RandomStringGenerator;

public class Clinic extends Work{
	private final long keyCharacterLength;
	private final String commonWriteKey;
	
	private PatientDatabase patients;
	private MedicalStaffDatabase doctorsOnStaff;
	private BillableServiceDatabase billableServices;
	private ProcedureCostDatabase procedues;
	
 	public Clinic(String address){
		super(address);
		keyCharacterLength = 500;
		
		commonWriteKey = RandomStringGenerator.Generate(keyCharacterLength);
		patients = new PatientDatabase(commonWriteKey);
		doctorsOnStaff = new MedicalStaffDatabase(commonWriteKey);
		billableServices = new BillableServiceDatabase(commonWriteKey);
		procedues = new ProcedureCostDatabase(commonWriteKey);
	}
	public Clinic(String address,long keyLength){
		super(address);
		keyCharacterLength = keyLength;
		
		commonWriteKey = RandomStringGenerator.Generate(keyCharacterLength);
		patients = new PatientDatabase(commonWriteKey);
		doctorsOnStaff = new MedicalStaffDatabase(commonWriteKey);
		billableServices = new BillableServiceDatabase(commonWriteKey);
	}
	
	public void AddPatient(Patient patient) {
		if(patient == null) throw new IllegalArgumentException("Null values not acceptable!");
	
		patients.AddPatient(patient, commonWriteKey);
	}
	public void AddMedicalStaff(Doctor doctor) {
		if(doctor == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		doctor.SetAdress(AddressType.Work, this);
		doctor.SetPhone(PhoneType.Work, GetPhone());
		doctorsOnStaff.AddStaff(doctor, commonWriteKey);
	}
	public Doctor FindMostFreeDoctor() {
		return doctorsOnStaff.FindStaffWithFewestPatients();
	}
	public void AddBill(BillableService bill) {
		if(bill == null) throw new IllegalArgumentException("Null values not acceptable!");
	
		billableServices.AddBill(bill);
	}
	public ArrayList<BillableService> GetBillable(Calendar cal, Boolean finalized, Boolean complete, Boolean payed) {
		if(cal == null) return billableServices.GetServices(null, finalized, complete, payed);
		
		String DDMMYYY = "" + cal.get(Calendar.DAY_OF_MONTH) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.YEAR);
		return billableServices.GetServices(DDMMYYY, finalized, complete, payed);
	}
}