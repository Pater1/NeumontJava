package edu.neumont.csc150.p0111.connerp.inheritance.clinic.databases;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import edu.neumont.csc150.p0111.connerp.inheritance.clinic.people.Patient;
import edu.neumont.csc150.p0111.connerp.inheritance.clinic.utilities.RandomStringGenerator;

public class PatientDatabase extends Database{
	private Map<String, Patient> patients = new HashMap<String, Patient>();
	
	public PatientDatabase(String key){
		super(key);
	}

	private String lastAssignedID = "a";
	public boolean AddPatient(Patient patient, String commonWriteKey) {
		if(patient == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		if(!GetWritePermissionsKey().equals(commonWriteKey)) return false;
		
		if(!patient.SetIndexID(lastAssignedID)){
			try{
				patients.get(patient.GetIndexID());
				return false;
			}catch(Exception ex){}
		}else{
			lastAssignedID = RandomStringGenerator.GetNextID(lastAssignedID);
		}
		
		patients.put(patient.GetIndexID(), patient);
		return true;
	}
}