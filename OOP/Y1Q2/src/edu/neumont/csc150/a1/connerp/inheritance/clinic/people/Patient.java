package edu.neumont.csc150.p0111.connerp.inheritance.clinic.people;

import edu.neumont.csc150.p0111.connerp.inheritance.clinic.data.InsuranceData;

public class Patient extends Person{
	private Doctor primaryCare;
	private InsuranceData insuranceData;
	
	@Override
	public String toString(){
		String tmp = "";
		
		tmp += "Patient [" + GetName() + "] \n";
		tmp += "Primary Care Physician: " + primaryCare.GetName() + "\n";
		tmp += "Insurance: " + ((insuranceData == null)? "Null" : insuranceData.toString());
		
		return tmp;
	}
	
	public Patient(String nameF, String nameL){
		super(nameF, nameL);
	}

	public Doctor GetPrimaryCare() {
		return primaryCare;
	}
	public void SetPrimaryCare(Doctor primaryCare) {
		if(primaryCare == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		primaryCare.AddPatient(this);
		if(this.primaryCare != null) this.primaryCare.RemovePatient(this);
		this.primaryCare = primaryCare;
	}

	public InsuranceData GetInsuranceData() {
		return insuranceData;
	}
	public void SetInsuranceData(InsuranceData insuranceData) {
		this.insuranceData = insuranceData;
	}
}
