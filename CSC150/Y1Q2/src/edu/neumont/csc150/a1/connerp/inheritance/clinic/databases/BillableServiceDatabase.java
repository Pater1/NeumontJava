package edu.neumont.csc150.a1.connerp.inheritance.clinic.databases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.neumont.csc150.a1.connerp.inheritance.clinic.data.BillableService;
import edu.neumont.csc150.a1.connerp.inheritance.clinic.people.Doctor;

public class BillableServiceDatabase extends Database {
	private Map<String, ArrayList<BillableService>> serviceBillableDatabase = new HashMap<String, ArrayList<BillableService>>();

	public BillableServiceDatabase(String key){
		super(key);
	}

	public void AddBill(BillableService bill) {
		if(bill == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		ArrayList<BillableService> billsOnDate = serviceBillableDatabase.get(bill.dayCreated);
		
		if(billsOnDate == null){
			billsOnDate = new ArrayList<BillableService>();
			serviceBillableDatabase.put(bill.dayCreated, billsOnDate);
		}
		
		if(!billsOnDate.contains(bill)){
			billsOnDate.add(bill);
		}
	}

	public ArrayList<BillableService> GetServices(String dDMMYYY, Boolean finalized, Boolean complete, Boolean payed) {
		ArrayList<BillableService> billsMasked = new ArrayList<BillableService>();
	
		if(dDMMYYY != null){
			ArrayList<BillableService> billsOnDate = null;
			try{
				billsOnDate = serviceBillableDatabase.get(dDMMYYY);
			}catch(Exception ex){
				return billsMasked;
			}
			
			for(int i = 0; i < billsOnDate.size(); i++){
				if( (finalized != null ? finalized == billsOnDate.get(i).IsFinal() : true) &&
					(complete != null ? complete == billsOnDate.get(i).IsComplete() : true) &&
					(payed != null ?  payed == billsOnDate.get(i).IsPayed() : true)
				){
					billsMasked.add(billsOnDate.get(i));
				}
			}
		}else{
			for (Map.Entry<String, ArrayList<BillableService>> entry : serviceBillableDatabase.entrySet()){
				for(int i = 0; i < entry.getValue().size(); i++){
					if( (finalized != null ? finalized == entry.getValue().get(i).IsFinal() : true) &&
							(complete != null ? complete == entry.getValue().get(i).IsComplete() : true) &&
							(payed != null ?  payed == entry.getValue().get(i).IsPayed() : true)
						){
							billsMasked.add(entry.getValue().get(i));
						}
				}
			}
		}
		
		return billsMasked;
	} 
}
