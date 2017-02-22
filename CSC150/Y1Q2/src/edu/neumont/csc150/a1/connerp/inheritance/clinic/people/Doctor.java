package edu.neumont.csc150.a1.connerp.inheritance.clinic.people;

import java.util.ArrayList;

public class Doctor extends Person {
	private ArrayList<Patient> responciblePatients = new ArrayList<Patient>();
	
	public String toString(){
		String tmp = "";
		
		tmp += "Physician [" + super.toString() + "] \n";
		tmp += "Assigned Patients: \n{";
		for(Patient pat : responciblePatients){
			tmp += "\n";
			
			tmp += pat.GetName();
			
			tmp += "\n";
		}
		tmp += "} \nTotal: " + responciblePatients.size();
		
		return tmp;
	}
	
	public Doctor(String nameF, String nameL){
		super(nameF, nameL);
	}

	public void AddPatient(Patient pat){
		if(pat == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		responciblePatients.add(pat);
	}
	public void RemovePatient(Patient pat){
		if(pat == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		responciblePatients.remove(pat);
	}
	public int GetPatientCount(){
		return responciblePatients.size();
	}
}
