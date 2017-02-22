package edu.neumont.csc150.a1.connerp.inheritance.clinic.utilities;

import java.util.Random;

public class RandomStringGenerator {
	public static String Generate(long characterCount){
		String ret = "";
		Random rand = new Random();
		
		for(int i = 0; i < characterCount; i++){
			ret += (char)(rand.nextInt(26) + 'a');
		}
		return ret;
	}
	
	private static int a = 'a', z = 'z';
	public static String GetNextID(String lastAssignedID) {
		if(lastAssignedID == null) throw new IllegalArgumentException("Null values not acceptable!");
		
		String copy = new String(lastAssignedID);
		
		int workingIndex = 0;
		boolean breakReached = false;
		while(!breakReached){
			if(workingIndex >= lastAssignedID.length()){
				lastAssignedID += "a";
				break;
			}
			
			int i = lastAssignedID.charAt(workingIndex);
			i++;
			if(i > z){
				i = a;
				workingIndex++;
			}else{
				breakReached = true;
			}
			lastAssignedID = lastAssignedID.substring(0,workingIndex) + (char)i + lastAssignedID.substring(workingIndex+1);
		}
		
		return copy;
	}
}
