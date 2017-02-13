package edu.neumont.csc150.a1.connerp.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Utilities {
	public static void PrintList(ArrayList<String> toPrint){
		for(String str : toPrint){
			System.out.println(str);
		}
	}
	
	public static String PromptUser(String prompt) throws IOException{
		System.out.println(prompt);
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		return buff.readLine();
	}
}