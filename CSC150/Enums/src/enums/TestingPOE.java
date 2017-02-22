package enums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import enums.usageExample.*;
import exceptions.InvalidCoinException;

public class TestingPOE {

	public static void main(String[] args) throws Exception {
		AskForCoin();
	}
	
	public static void AskForCoin() throws IOException{
		do{
			System.out.println("Please select a coin to display:");
			PrintList(Coinage.NameAndInitials());
			
			try{
				System.out.println(Coinage.convert(PromptUser("Please make your selection")));
				break;
			}catch(InvalidCoinException ex){
				System.out.println("Not a valid selection. Please try again");
				System.out.println();
			}
		}while(true);
	}
	
	public static char PromptUser(String prompt) throws IOException{
		System.out.println(prompt);
		
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		return Character.toUpperCase(buff.readLine().charAt(0));
	}
	
	public static void PrintList(ArrayList<String> toPrint){
		for(String str : toPrint){
			System.out.println(str);
		}
	}

}
