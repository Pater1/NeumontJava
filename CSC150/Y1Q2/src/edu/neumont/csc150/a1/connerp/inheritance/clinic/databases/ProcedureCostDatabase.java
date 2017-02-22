package edu.neumont.csc150.a1.connerp.inheritance.clinic.databases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.neumont.csc150.a1.connerp.inheritance.clinic.data.BillableService;

public class ProcedureCostDatabase extends Database{
	private Map<String, Integer> procedures = new HashMap<String, Integer>(){
		{
			put("visit" , 200);
			put("surgery" , 5000);
			put("procedure" , 1000);
		}
	};
	
	private ArrayList<String> nameBuffer = new ArrayList<String>();
	public ArrayList<String> KnownProcedures(){
		nameBuffer.clear();
		for(String key : procedures.keySet()){
			nameBuffer.add(key);
		}
		return nameBuffer;
	}

	public ProcedureCostDatabase(String key) {
		super(key);
	}
}
