package edu.neumont.csc110.a.drills;

import java.io.IOException;
import java.util.Calendar;
import patpackages.input.*;

public class JavaDrills {
	private static void Drill1CalcBirthYear() throws IOException{
		int y = Calendar.getInstance().get(Calendar.YEAR) - ConsoleUI.promptForInt("How old are you?", 0, 120) + (ConsoleUI.promptForBool("Have you had your birthday yet this year?", "yes", "no") ? 1 : 0) -1;
		TermPrint("You were born in " + y + "!");
	}
	
	private static void Drill2MeaninglessOps() throws IOException{
		int ret = ((ConsoleUI.promptForInt("input a number", Integer.MIN_VALUE, Integer.MAX_VALUE) + 5) * 3) % 7;
		TermPrint("" + ret);
	}
	
	private static void Drill3MeaninglessOps2() throws IOException{
		int a = ConsoleUI.promptForInt("input a number", Integer.MIN_VALUE, Integer.MAX_VALUE);
		int ret = (a+7)*(a-9);
		TermPrint("" + ret);
	}
	
	private static void Drill4FloatingAway() throws IOException{
		int a = ConsoleUI.promptForInt("input a number", Integer.MIN_VALUE, Integer.MAX_VALUE), b = ConsoleUI.promptForInt("input another number", Integer.MIN_VALUE, Integer.MAX_VALUE);
		float ret = (float) (Math.pow(((float)a/(float)b),3)+Math.PI);
		TermPrint("" + ret);
	}
	
	private static void Drill5char2int() throws IOException{
		TermPrint("" + ((int)ConsoleUI.promptForChar("input a letter", (char)0, (char)255)));
	}
	
	private static void Drill6int2char() throws IOException{
		TermPrint("" + ((char)ConsoleUI.promptForByte("input a number 0-" + Byte.MAX_VALUE, (byte)0, Byte.MAX_VALUE)));
	}
	
	private static void Drill7PrintCircumference() throws IOException{
		TermPrint( "The circumference is: " + (ConsoleUI.promptForDouble("Please enter a circle's radius", 0, Double.MAX_VALUE)*2*Math.PI) );
	}
	
	private static void Drill8AreaOfParralellogram() throws IOException{
		TermPrint("The area is: " + (ConsoleUI.promptForDouble("What is the width?", 0, Double.MAX_VALUE)*ConsoleUI.promptForDouble("What is the height?", 0, Double.MAX_VALUE)));
	}
	
	private static void Drill9Sum() throws IOException{
		TermPrint("" + (ConsoleUI.promptForInt("1st int to sum", Integer.MIN_VALUE, Integer.MAX_VALUE)+
						ConsoleUI.promptForInt("2nd int to sum", Integer.MIN_VALUE, Integer.MAX_VALUE)+
						ConsoleUI.promptForInt("3rd int to sum", Integer.MIN_VALUE, Integer.MAX_VALUE)));
	}
	
	private static void Drill10MathItUp() throws IOException{
		int a = ConsoleUI.promptForInt("1st operand", Integer.MIN_VALUE, Integer.MAX_VALUE),
			b = ConsoleUI.promptForInt("2nd operand", Integer.MIN_VALUE, Integer.MAX_VALUE);
		TermPrint("\n"+
				a + " + " + b + " = " + (a+b) + "\n"+
				a + " - " + b + " = " + (a-b) + "\n"+
				a + " / " + b + " = " + (a/b) + "\n"+
				a + " * " + b + " = " + (a*b) + "\n"+
				a + " % " + b + " = " + (a%b));
	}
	
	private static void Drill11Rot13() throws IOException{
		char a = 'a', z = 'z', u = ConsoleUI.promptForChar("Letter to encode", a, z);
		int out = ((u-a+13)%(z-a+1))+a;
		TermPrint("" + ((char)out) );
	}
	
	private static void Drill12MeanFloats() throws IOException{
		int a = ConsoleUI.promptForInt("1st operand", Integer.MIN_VALUE, Integer.MAX_VALUE),
			b = ConsoleUI.promptForInt("2nd operand", Integer.MIN_VALUE, Integer.MAX_VALUE),
			c = ConsoleUI.promptForInt("3rd operand", Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		TermPrint("" + (((float)a+b+c)/3));
	}
	
	private static void Drill13IntString() throws IOException{
		Integer read = null;
		boolean negative = false;
		do{
			String in = ConsoleUI.promptForInput("a number please", false);
			negative = false;
			
			for(int i = 0; i < in.length(); i++){
				char here = in.charAt(i);
				if(here == '-'){
					if(i == 0){
						negative = true;
					}else{
						break;
					}
				}else{
					Integer abouts = null;
					try{
						abouts = Integer.parseInt("" + here);
					}catch(Exception ex){
						break;
					}
					
					if(read == null){
						read = abouts;
					}else{
						read = read*10 + abouts;
					}
				}
			}
			
			if(read != null && negative){
				read = -read;
			}
		}while(read == null);
		
		TermPrint("" + (negative ? "-":"") + ( ("" + ( (float)(read/Math.PI) ) ).charAt(negative ? 1:0)));
	}
	
	private static void Drill14FindThe$() throws IOException{
		Integer read = null;
		do{
			String in = ConsoleUI.promptForInput("something containing a $", false);
			
			for(int i = 0; i < in.length(); i++){
				if(in.charAt(i) == '$'){
					read = i;
				}
			}
		}while(read == null);
		TermPrint("$ at index: " + read);
	}
	
	private static void Drill15BeforeAndAfterThe$() throws IOException{
		Integer read = null;
		String open = "", close = "";
		do{
			String in = ConsoleUI.promptForInput("something containing a $", false);
			open = ""; close = "";
			
			for(int i = 0; i < in.length(); i++){
				if(in.charAt(i) == '$'){
					read = i;
				}else{
					if(read == null){
						open += in.charAt(i);
					}else{
						close += in.charAt(i);
					}
				}
			}
		}while(read == null);
		TermPrint("Before: " + open + "\n" + "After: " + close);
	}
	
	private static void Drill16BetweenThe$s() throws IOException{
		Integer read1 = null, read2 = null;
		String open = "", mid = "", close = "";
		do{
			String in = ConsoleUI.promptForInput("something containing a $", false);
			open = ""; close = ""; mid = "";
			
			for(int i = 0; i < in.length(); i++){
				if(in.charAt(i) == '$'){
					if(read1 == null){
						read1 = i;
					}else{
						read2 = i;
					}
				}else{
					if(read1 == null){
						open += in.charAt(i);
					}else if(read2 == null){
						mid += in.charAt(i);
					}else{
						close += in.charAt(i);
					}
				}
			}
		}while(read1 == null || read2 == null);
		
		String between = "";
		for(int i = 0; i < mid.length(); i++){
			between += mid.charAt(mid.length() - 1 - i);
		}
		
		TermPrint("Before: " + open + "\n Backwards Between: " + between + "\n After: " + close);
	}
	
	private static void Drill17TruncateFloat() throws IOException{
		String tt = "", broken = "";
		do{
			tt = "" + ConsoleUI.promptForFloat("a decimal", Float.MIN_VALUE, Float.MAX_VALUE);
			broken = "";
			
			for(char i = ('a'-'a'); i < tt.length(); i += ('b'-'a')){
				if(tt.charAt(i) == '.'){
					break;
				}else{
					if(Character.isDigit(tt.charAt(i))){
						broken += tt.charAt(i);
					}else{
						break;
					}
				}
			}
		}while(broken.length() <= ('a'-'a'));
		TermPrint(broken);
	}
	
	private static void Drill18MovingThe$() throws IOException{
		String in = ConsoleUI.promptForInput("something containing a $", false);
		String close = "";
		
		for(int i = 0; i < in.length(); i++){
			if(in.charAt(i) == '$'){
				close += in.charAt(i+1) + "$";
				i++;
			}else{
				close += in.charAt(i);
			}
		}
		TermPrint(close);
	}
	
	private static void Drill19OneInTheOther() throws IOException{
		String thisIn = ConsoleUI.promptForInput("something to put...", false),
				toThis = ConsoleUI.promptForInput("inside something here!", false),
				together = "";
		
		for(int i = 0; i < toThis.length(); i++){
			if(i == toThis.length()/2){
				for(int j = 0; j < thisIn.length(); j++){
					together += thisIn.charAt(j);
				}
			}
			together += toThis.charAt(i);
		}
		
		TermPrint(together);
	}
	
	private static void Drill20IsYouFred() throws IOException{
		String name = ConsoleUI.promptForInput("Your first name please", false);
		if(name.equalsIgnoreCase("Fred")){
			TermPrint("Hi Fred!");
		}
	}
	
	private static void Drill21IsYouFredOrBarney() throws IOException{
		String name = ConsoleUI.promptForInput("Your first name please", false);
		if(name.equalsIgnoreCase("Fred") || name.equalsIgnoreCase("Barney")){
			TermPrint("Hi " + name + "!");
		}
	}
	
	private static void Drill22IsYouFlintsone() throws IOException{
		String name = ConsoleUI.promptForInput("Your first name please", false),
				lName = ConsoleUI.promptForInput("Your last name please", false);
		if(name.equalsIgnoreCase("Fred") && lName.equalsIgnoreCase("Flintstone")){
			TermPrint("Hi " + name + "!");
		}
	}
	
	private static void Drill23IsYouNotFred() throws IOException{
		String name = ConsoleUI.promptForInput("Your first name please", false);
		if(!name.equalsIgnoreCase("Fred")){
			TermPrint("Hi not Fred!");
		}
	}
	
	private static void Drill24IsYouFredOrNot() throws IOException{
		String name = ConsoleUI.promptForInput("Your first name please", false);
		if(!name.equalsIgnoreCase("Fred")){
			TermPrint("Hi not Fred!");
		}else{
			TermPrint("Hi Fred!");
		}
	}
	
	private static void Drill25IsYouFredWithLastName() throws IOException{
		String name = ConsoleUI.promptForInput("Your first name please", false);
		if(name.equalsIgnoreCase("Fred")){
			String lName = ConsoleUI.promptForInput("Your last name please", false);
			TermPrint("Hi" + name + " " + lName + "!");
		}
	}
	
	public static void TermPrint(String str){
		System.out.println(str);
	}
}