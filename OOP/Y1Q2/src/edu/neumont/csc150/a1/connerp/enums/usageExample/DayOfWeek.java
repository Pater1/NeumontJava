package edu.neumont.csc150.a1.connerp.enums.usageExample;

public enum DayOfWeek {
	Sunday		(1),
	Monday		(2),
	Tuesday		(4),
	Wednesday	(8),
	Thursday	(16),
	Friday		(32),
	Saturday	(64);
	
	DayOfWeek(int i) {	
	}
	
	public static DayOfWeek IntToDay(int index){
		try{
			return values()[index];
		}catch (Exception ex){
			String str = "";
			for(DayOfWeek day : DayOfWeek.values()){
				str += " " + day.ordinal();
			}
			
			throw new ArrayIndexOutOfBoundsException("Index not mappable to DayOfWeek enum! Please restrict range to the folowing values:" + str);
		}
	}
}