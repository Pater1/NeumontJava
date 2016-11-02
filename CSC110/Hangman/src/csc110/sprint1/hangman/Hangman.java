package csc110.sprint1.hangman;

import java.io.IOException;
import java.util.*;
import patpackages.input.*;

public class Hangman {
	//statics
	public static final List<String> puzzels = Arrays.asList(new String[]{
			"Jonny's apple seed became an apple tree",
			"Hello World, how is life?",
			"Sally sold sea shells by the sea shore",
			"THIS IS A PUZZEL!!!"
	});
	public static final int deadCap = 6;
	
	public static void main(String[] args) throws IOException {
		GameMaster();
	}
	
	public static void GameMaster() throws IOException{
		Hangman hang;
		boolean isPlaying = true;
		do{
			hang = NewHangmanGame();
			isPlaying = hang.StartGame();
		}while(isPlaying);
	}
	
	public static Hangman NewHangmanGame() throws IOException{
		Hangman hm = new Hangman();
		hm.activePuzzel = SetNewPuzzle();
		hm.calledChars = new ArrayList<Character>();
		hm.deadness = 0;
		return hm;
	}
	
	public static List<Character> SetNewPuzzle() throws IOException{
		if(ConsoleUI.promptForBool("Do you want to use a custom Puzzle?", "Yes", "No")){
			String customPuzzle = "";
			int wordCount = 0;
			do{
				wordCount = 1;
				customPuzzle = ConsoleUI.promptForInput("Please input a phrase between 1 and 8 words", false);
				
				for(int i = 0; i < customPuzzle.length(); i++){
					if(customPuzzle.charAt(i) == ' '){
						wordCount++;
					}
				}

				if(wordCount > 8) System.out.println("Make sure the custom puzzle has fewer than eight words please!");	
			}while(wordCount > 8);
			
			return StringToCharArray(customPuzzle);
		}else{
			return CharArrayFromRandomStringInList(puzzels);
		}
	}
   	private static List<Character> CharArrayFromRandomStringInList(List<String> listToPullFrom){
		return StringToCharArray( RandInList(listToPullFrom) );
	}
	private static List<Character> StringToCharArray(String input){
		ArrayList<Character> chars = new ArrayList<Character>();
		for(int i = 0; i < input.length(); i++){
			chars.add(input.charAt(i));
		}
		return chars;
	}
	private static String RandInList(List<String> randIn){
		return randIn.get(new Random().nextInt(randIn.size()-1));
	}
	
 	private static void PrintGallows(int howDead){
 		int deadness = 0 + ((6 - 0) / (deadCap - 0)) * (howDead - 0);
		if(deadness <= 6){
			    System.out.println("  _____________   "); 
			    System.out.println("  |           |   "); 
		    if (deadness == 0){ // Now the head 
		    	System.out.println("  |               "); 
		    	System.out.println("  |               "); 
		        System.out.println("  |               "); 
		        System.out.println("  |               "); 
		    } else { 
		    	System.out.println("  |           o   "); 
		    	System.out.println("  |         o   o  "); 
		    	System.out.println("  |         o   o  "); 
		    	System.out.println("  |           o   "); 
		    } 
		    if (deadness <= 1) { //The body and arms
		    	System.out.println("  |               "); 
		    	System.out.println("  |               "); 
		    	System.out.println("  |               "); 
		    }else if (deadness == 2) { 
		    	System.out.println("  |           |   "); 
		    	System.out.println("  |           |   "); 
		    	System.out.println("  |           |   "); 
		    }else if (deadness == 3) { 
		    	System.out.println("  |           |   "); 
		    	System.out.println("  |          /|   "); 
		    	System.out.println("  |         / |   "); 
		    }else if (deadness > 3) { 
		    	System.out.println("  |           |   "); 
		    	System.out.println("  |          /|\\ "); 
		    	System.out.println("  |         / | \\"); 
		    }  
		    if (deadness <= 4) { //The legs
		    	System.out.println("  |             "); 
		    	System.out.println("  |          "); 
		    	System.out.println("  |        "); 
		    	System.out.println("  |        "); 
		    	System.out.println("  |        "); 
		    	System.out.println("  |        "); 
		    	System.out.println("/---------------\\"); 
		    }else if (deadness == 5) { 
		    	System.out.println("  |          /    "); 
		    	System.out.println("  |         /    "); 
		    	System.out.println("  |        /     "); 
		    	System.out.println("  |        "); 
		    	System.out.println("  |        "); 
		    	System.out.println("  |        "); 
		    	System.out.println("/---------------\\"); 
		    }else if (deadness > 5) { 
		    	System.out.println("  |          / \\   "); 
		    	System.out.println("  |         /   \\ "); 
		    	System.out.println("  |        /     \\"); 
		    	System.out.println("  |        "); 
		    	System.out.println("  |        "); 
		    	System.out.println("  |        "); 
		    	System.out.println("/---------------\\"); 
		    }
		}else{ 
		    System.out.println("  _____________   "); 
		    System.out.println("  |           |   "); 
	    	System.out.println("  |           o   "); 
	    	System.out.println("  |         o   o  "); 
	    	System.out.println("  |         o   o  "); 
	    	System.out.println("  |           o   "); 
	    	System.out.println("  |           |   "); 
	    	System.out.println("  |          /|\\ "); 
	    	System.out.println("  |         / | \\"); 
	    	System.out.println("  |          / \\   "); 
	    	System.out.println("  |         /   \\ "); 
	    	System.out.println("  |        /     \\"); 
	    	System.out.println("  |        "); 
	    	System.out.println("  |        "); 
	    	System.out.println("  |        "); 
	    	System.out.println("/---------------\\"); 
	    	

		    System.out.println("  _____________   "); 
		    System.out.println("  |           |   "); 
		    System.out.println("  |           |   "); 
	    	System.out.println("  |           o   "); 
	    	System.out.println("  |         o   o  "); 
	    	System.out.println("  |         o   o  "); 
	    	System.out.println("  |           o   "); 
	    	System.out.println("  |           |   "); 
	    	System.out.println("  |          /|\\ "); 
	    	System.out.println("  |         / | \\"); 
	    	System.out.println("  |          / \\   "); 
	    	System.out.println("  |         /   \\ "); 
	    	System.out.println("  |        /     \\"); 
	    	System.out.println("  |        "); 
	    	System.out.println("  |        "); 
	    	System.out.println("/---------------\\"); 
	    } 
	}
 	private static void PrintPuzzel(List<Character> puzzel, List<Character> map, boolean bypass){
 		String print = "", floor = "";
 		for(int i = 0; i < puzzel.size(); i++){
 			if(Character.isLetter(puzzel.get(i))){
 	 			//if this character was guessed
	 			if(map.contains(Character.toUpperCase(puzzel.get(i))) || bypass){
	 				//puzzel character followed by TAB
	 				print += puzzel.get(i) + " ";
	 			}else{
	 				//space followed by TAB
	 				print += "  ";
	 			}
				//underscore followed by TAB
	 			floor += "_ ";
 			}else{
 				//prints non-letter characters
 				print += puzzel.get(i) + " ";

	 	 		floor += "  ";
 			}
 		}
 		System.out.println(print);
 		System.out.println(floor);
 	}
	
 	private static boolean DidWin(List<Character> puzzel, List<Character> called){
		for(int i = 0; i < puzzel.size(); i++){
			if(!called.contains(Character.toUpperCase(puzzel.get(i))) && Character.isLetter(puzzel.get(i))) return false;
		}
		return true;
	}

	//non-statics
	public List<Character> activePuzzel = new ArrayList<Character>();
	public List<Character> calledChars = new ArrayList<Character>();
	public int deadness = 0;
	
	public boolean StartGame() throws IOException{
		calledChars = new ArrayList<Character>();
		RunGame();
		return ConsoleUI.promptForBool("Play another game?", "Yes", "No");
	}
	private void RunGame() throws IOException{
		while (deadness < deadCap && !DidWin(activePuzzel, calledChars)){
			OneTurn();
		}
		PrintStatus(true);
		if(DidWin(activePuzzel, calledChars)){
			System.out.println("You won, well done!");
		}else{
			System.out.println("Sorry, but you've been hung...");
		}
	}
	
	private void OneTurn() throws IOException{
		PrintStatus(false);
		int move = ConsoleUI.promptForMenuSelection(new String[]{
				"1- Guess a letter",
				"2- Guess the whole phrase",
				"3- give up"
		}, true);
		
		switch(move){
			case 1:
				MovePickChar();
				break;
			case 2:
				MoveGuessSolution();
				break;
			case 3:
				deadness = deadCap + 1;
				break;
			default:
				break;
		}
	}
	private void MoveGuessSolution() throws IOException{
		String guess = ConsoleUI.promptForInput("What is your guess?", false);
		ArrayList<Character> guessChar = new ArrayList<Character>();
		for(int i = 0; i < guess.length(); i++){
			if(Character.isLetter(guess.charAt(i))){
				guessChar.add(Character.toUpperCase(guess.charAt(i)));
			}
		}
		
		if(DidWin(activePuzzel,guessChar)){
			System.out.println("That's it!");
			//make sure DidWin() returns true with calledChars
			calledChars = guessChar;
		}else{
			deadness++;
			System.out.println("Sorry, " + guess + " is not the solution. You have " + (deadCap - deadness) + " tries left!");
		}
	}
	private void MovePickChar() throws IOException{
		char selection = ' ';
		boolean goodSelection = false;
		do{
			selection = Character.toUpperCase(ConsoleUI.promptForChar("Please input what letter you would like to guess.",'A','z'));
			goodSelection = !calledChars.contains(selection);
			if(!goodSelection){
				System.out.println("You already guessed " + selection + "! Please try a new letter.");
			}
		}while(!goodSelection);

		calledChars.add(selection);
		if(!activePuzzel.contains(selection) && !activePuzzel.contains(Character.toLowerCase(selection))){
			deadness++;
			System.out.println("Sorry, " + selection + " is not in this puzzel. You have " + (deadCap - deadness) + " tries left!");
		}else{
			System.out.println("Good Job! Found a " + selection + " in this puzzel, and you still have " + (deadCap - deadness) + " tries left!");
		}
	}
	
	private void PrintStatus(boolean bypass){
		PrintGallows(deadness);
		System.out.println("");
		PrintPuzzel(activePuzzel, calledChars, bypass);
		System.out.println("");
		System.out.println("");
	}
}