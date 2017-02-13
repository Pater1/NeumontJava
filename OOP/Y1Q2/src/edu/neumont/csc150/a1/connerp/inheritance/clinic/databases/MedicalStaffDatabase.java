package edu.neumont.csc150.p0111.connerp.inheritance.clinic.databases;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import edu.neumont.csc150.p0111.connerp.inheritance.clinic.people.Doctor;
import edu.neumont.csc150.p0111.connerp.inheritance.clinic.people.Patient;
import edu.neumont.csc150.p0111.connerp.inheritance.clinic.utilities.RandomStringGenerator;

public class MedicalStaffDatabase extends Database{
	private Map<String, Doctor> medicalStaff = new HashMap<String, Doctor>();

	public MedicalStaffDatabase(String key){
		super(key);
	}

	private String lastAssignedID = "a";
	public boolean AddStaff(Doctor doctor, String commonWriteKey) {
		if(doctor == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		if(!GetWritePermissionsKey().equals(commonWriteKey)) return false;
		
		if(!doctor.SetIndexID(lastAssignedID)){
			try{
				medicalStaff.get(doctor.GetIndexID());
				return false;
			}catch(Exception ex){}
		}else{
			lastAssignedID = RandomStringGenerator.GetNextID(lastAssignedID);
		}
		
		medicalStaff.put(doctor.GetIndexID(), doctor);
		return true;
	}
	public ArrayList<Doctor> GetList() {
		ArrayList<Doctor> docs = new ArrayList<Doctor>();
		for (Map.Entry<String, Doctor> entry : medicalStaff.entrySet())
		{
			docs.add(entry.getValue());
		}
		return docs;
	}
	public Doctor FindStaffWithFewestPatients() {
		Doctor doc = null;
		int patientCount = -1;
		for (Map.Entry<String, Doctor> entry : medicalStaff.entrySet())
		{
			if(doc == null || entry.getValue().GetPatientCount() < patientCount){
				doc = entry.getValue();
				patientCount = entry.getValue().GetPatientCount();
			}
		}
		return doc;
	}
}
