package edu.neumont.csc110.a.drills;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import patpackages.input.*;

public class JavaDrills2 {
	private static void Drill1BranchingElif() throws IOException{
		String str = ConsoleUI.promptForInput("What's your name?", false);
		if(str.equals("Fred")){
			String ing = ConsoleUI.promptForInput("What's your last name?", false);
			System.out.println("Hi there Fred " + ing);
		}else{
			String ing = ConsoleUI.promptForInput("What's your favorite color?", false);
			System.out.println("Hi ther Mr. " + ing + " not Fred");
		}
	}
	
	private static void Drill2IsFred() throws IOException{
		String str = ConsoleUI.promptForInput("What's your name?", false);
		if(str.equals("Fred")){
			String ing = ConsoleUI.promptForInput("What's your last name?", false);
			System.out.println("Hi there Fred " + ing);
		}else{
			System.out.println("Hi ther Mr. not Fred");
		}
	}
	
	private static void Drill3IsFredColor() throws IOException{
		String str = ConsoleUI.promptForInput("What's your name?", false);
		if(str.equals("Fred")){
			System.out.println("Hi there Fred!");
		}else{
			String ing = ConsoleUI.promptForInput("What's your favorite color?", false);
			System.out.println("Hi ther Mr. " + ing + " not Fred");
		}
	}
	
	private static void Drill4Flow(){
		System.out.println(   "Drill 1: \n"
				+ "	Get user name -> Is name 'Fred'?  -Yes-> Get user last name -> print 'hi, [first name] [last name]\n"
				+ "									  -No--> Get user favorite color -> print 'hi [color] [name]'");
		System.out.println(   "Drill 2: \n"
				+ "	Get user name -> Is name 'Fred'?  -Yes-> Get user last name -> print 'hi, [first name] [last name]\n"
				+ "									  -No--> print 'hi [name]'");
		System.out.println(   "Drill 3: \n"
				+ "	Get user name -> Is name 'Fred'?  -Yes-> print 'hi, [first name]\n"
				+ "									  -No--> Get user favorite color -> print 'hi [color] [name]'");
	}
	
	private static void Drill5FredPuns() throws IOException{
		String str = ConsoleUI.promptForInput("What's your name?", false);
		if(str.equals("Fred")){
			String ing = ConsoleUI.promptForInput("What's your last name?", false);
			if(ing.equals("Flintstone")){
				System.out.println("YABA-DABA-DOO!");
			}else{
				System.out.println("Hi there Fred not-Flintstone");
			}
		}else{
			String ing = ConsoleUI.promptForInput("What's your favorite color?", false);
			if(ing.equals("red")){
				System.out.println("I'd rather be red than Fred");
			}else{
				System.out.println("Hi ther Mr. " + ing + " not Fred");
			}
		}
	}
	
	private static void Drill6Bedrock() throws IOException{
		String str = ConsoleUI.promptForInput("What's your name?", false);
		if(str.equals("Fred")){
			System.out.println("Yapadapadoo");
		}else if(str.equals("Barney")){
			System.out.println("Rubble");
		}else if(str.equals("Dino")){
			System.out.println("go chase a car");
		}else{
			System.out.println("You�re not a flinstone...");
		}
	}
	
	private enum DayOfWeek{
		Monday,
		Tuesday,
		Wednesday,
		Thursday,
		Friday,
		Saturday,
		Sunday
	}
	private static void Drill7EnumSwitch(){
		DayOfWeek dayOf;
		
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
		dayOf = DayOfWeek.values()[calendar.get(Calendar.DAY_OF_WEEK)-1];
		
		switch(dayOf){
			case Monday:
				System.out.println("Garfeild's favorite...");
				return;
			case Tuesday:
				System.out.println("This is Tuesday Tue!");
				return;
			case Wednesday:
				System.out.println("Not going to say 'humpday'... Dang it!");
				return;
			case Thursday:
				System.out.println("Originally named for the norse god of storms!");
				return;
			case Friday:
				System.out.println("It's also a bad internet music video.");
				return;
			default:
				System.out.println("NO WORK TODAY!!!");
				return;
		}
	}
	
	private static void Drill8DoWhileThis() throws IOException{
		int rand = new Random().nextInt(10) + 1, guess = 0;

		do{;
			guess = ConsoleUI.promptForInt("What is your guess?", 1, 10);
			if(guess == rand){
				System.out.println("You got it!");
				return;
			}else{
				System.out.println("Sorry, try again!");
			}
		}while(true);
	}
	
	private static void Drill9DoWhileThisAgain() throws IOException{
		int rand = new Random().nextInt(10) + 1, guess = 0;
		
		do{
			guess = ConsoleUI.promptForInt("What is your guess?", 1, 10);
			if(guess == rand){
				System.out.println("You got it!");
				return;
			}else{
				System.out.println("Sorry, should have guessed " + ((guess>rand) ? "too high" : "too low") + ". Try again!");
			}
		}while(true);
	}
	
	private static void Drill10DoWhileThisOnceMore() throws IOException{
		int rand = new Random().nextInt(10) + 1, guess = 0;
		
		do{
			guess = ConsoleUI.promptForInt("What is your guess?", 1, 10);
			if(guess == rand){
				System.out.println("You got it!");
				break;
			}else{
				System.out.println("Sorry, should have guessed " + ((guess>rand) ? "too high" : "too low") + ". Try again!");
			}
		}while(true);
	}
	
	private static void Drill11WhileSpacingOut() throws IOException{
		String str = ConsoleUI.promptForInput("Type something!", false);
		StringBuilder myName = new StringBuilder(str);
		
		System.out.println(myName);
		while(str.indexOf(' ') > -1){
			myName.setCharAt(str.indexOf(" "), 'X');
			str = myName.toString();
			myName = new StringBuilder(str);
			System.out.println(str);
		}
	}
	
	private static void Drill12ForString() throws IOException{
		String str = ConsoleUI.promptForInput("Type something!", false);
		
		for(int i = 0; i < str.length(); i++){
			System.out.println("" + str.charAt(i));
		}
	}
	
	private static void Drill13ForInt() throws IOException{
		int str = ConsoleUI.promptForInt("Type some number!", 0, Integer.MAX_VALUE);
		int output = 0;
		for(int i = 1; i <= str; i++){
			output += i;
		}
		System.out.println(output);
	}
	
	private static void Drill14RevString() throws IOException{
		String outp = "" , str = ConsoleUI.promptForInput("Type something!", false);
		
		for(int i = str.length()-1; i >= 0; i--){
			outp += str.charAt(i);
		}
		
		System.out.println(outp);
	}
	
	private static void Drill15ForContinue(){
		for(int i = 0; i <= 25; i++){
			if(i%3 == 0){
				continue;
			}
			System.out.println(i);
		}
	}
	
	enum Flintstones{
		Fred,
		Wilma,
		Pebbles,
		Dino
	}
	private static void Drill16Foreach(){
		for(Flintstones flint : Flintstones.values()){
			System.out.println(flint);
		}
	}
	
	private static void Drill17NetingLoops(){
		for(int i = 0; i < 10; i ++){
			for(int j = 0; j < 10; j ++){
				System.out.println("" + i + j);
			}
		}
	}
	
	private static void Drill18Dwarfs(){
		String[] littlePeople = new String[]{
				"Grumpy",
				"Happy",
				"Dopey",
				"Sleepy",
				"Bashful",
				"Sneezy",
				"Doc"
		};
		
		for(String str : littlePeople){
			System.out.println(str);
		}
	}
	
	private static void Drill1942Ints(){
		int[] is = new int[100];
		Arrays.fill(is, 42);
		for(int i = 0; i < is.length; i++){
			System.out.println(is[i]);
		}
	}
	
	private static void Drill20100Ints(){
		int[] is = new int[100];
		for(int i = 0; i < is.length; i++){
			is[i] = i+1;
			System.out.println(is[i]);
		}
	}
	
	private static void Drill21EvenInts(){
		int[] is = new int[100];
		for(int i = 0; i <= (is.length-1)*2; i+=2){
			is[i/2] = i;
			System.out.println(is[i/2]);
		}
	}
	
	private static void Drill22FibonachiGoesLong(){
		long[] is = new long[90];
		
		long a = 1, b = 1;
		is[0] = 1;
		is[1] = 1;
		System.out.println(is[0]);
		System.out.println(is[1]);
		
		for(int i = 2; i < is.length; i++){
			long c = a+b;
			is[i] = c;
			System.out.println(is[i]);
			a = b;
			b = c;
		}
	}
	
	private static void Drill23RandArray(){
		int[] rands = new int[10];
		Arrays.fill(rands, 0);
		
		Random rand = new Random();
		
		for(int i = 0; i < rands.length; i++){
			for(int j = 0; j < 100; j++){
				rands[i] += rand.nextInt(11);
			}
			for(int j = 0; j < rands[i]; j++){
				System.out.print("+");
			}
			System.out.println("");
		}
	}
	
	private static void Drill24Scaleogram(){
		int[] rands = new int[10];
		Arrays.fill(rands, 0);
		
		Random rand = new Random();
		int bigest = 0;
		
		for(int i = 0; i < rands.length; i++){
			for(int j = 0; j < 100; j++){
				rands[i] += rand.nextInt(11);
			}
			if(rands[i] > bigest){
				bigest = rands[i];
			}
		}
		
		int scalar = bigest/10;
		
		for(int i = 0; i < rands.length; i++){
			for(int j = 0; j < rands[i]/scalar; j++){
				System.out.print("+");
			}
			System.out.println("");
		}
	}
	
	private static void Drill25DwarfAgain(){
		String[] littlePeople = new String[]{
				"Grumpy",
				"Happy",
				"Dopey",
				"Sleepy",
				"Bashful",
				"Sneezy",
				"Doc"
		};
		System.out.println(Arrays.toString(littlePeople));
	}
}
