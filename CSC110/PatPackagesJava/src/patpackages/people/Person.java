package patpackages.people;

public class Person {
	public static final int STANDARDFORMAT = 0, INVERTEDFORMAT = 1, ABBREVIATEDFORMAT = 2;
	// for names:			First Mid. Last		Last, First Mid.	Initials, FLM
	// for birthDates:		DD/MM/YYYY			YYYY, DD/MM			Current Age
	
	//name
	private String firstName, lastName;
	private Character middleInitial;
	
	public void _SetName(String first, String last, Character mid){
		if(first == null || first.length() <= 0 || last == null || last.length() <= 0){
			IllegalArgumentException iae = new IllegalArgumentException("Non empty string required!");
			throw iae;
		}
		if(mid == null){
			IllegalArgumentException iae = new IllegalArgumentException("Non null character required!");
			throw iae;
		}
		firstName = first;
		lastName = last;
		middleInitial = mid;
	}
	public void _SetName(String first, String last){
		if(first == null || first.length() <= 0 || last == null || last.length() <= 0){
			IllegalArgumentException iae = new IllegalArgumentException("Non empty string required!");
			throw iae;
		}
		firstName = first;
		lastName = last;
	}
	public void _SetName(String first){
		if(first == null || first.length() <= 0){
			IllegalArgumentException iae = new IllegalArgumentException("Non empty string required!");
			throw iae;
		}
		firstName = first;
	}
	
	public String _GetName(){
		return firstName + " " + middleInitial + ". " + lastName;
	}
	public String _GetName(int format){
		switch(format){
			case 0: return firstName + " " + middleInitial + ". " + lastName;
			case 1: return lastName + ", " + firstName + " " + middleInitial + ".";
			case 2: return "" + firstName.charAt(0) + middleInitial + lastName.charAt(0);
			default: return null;
		}
	}
	
	//age
	//day[0], month[1], year[2]
	private int[] birthDate = new int[3];
}
