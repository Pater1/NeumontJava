//Calculator made by Patrick R. Conner to test Java. Written without an IDE.
//started 12:33 9/26/2016
//finished 7:07 9/26/2016


/*updated 10/3/2016 to add:
sin - fsin
cos - fcos
random, ranged - frand
Far->Cel - fFaren
Cel->Far - fCelsius

running $ tally
*/

import java.util.*;
import java.io.*;

public class SpeedCalculator{
	public static List<Character> operators = Arrays.asList('f','^','~','l','*','/','+','-');
	public static List<Character> operationOrderModifierOpeners = Arrays.asList('|','[','{','(');
	public static List<Character> coorespondingOrderModifierClosers = Arrays.asList('|',']','}',')');
	public static List<Character> legalNumber = Arrays.asList('.','1','2','3','4','5','6','7','8','9','0','n');
	public static List<Character> SpecialChars = Arrays.asList(',','H','e','l','p','D','o','n','e');
	
	public static List<String> functions = Arrays.asList("sin","cos","tan","ftoc","ctof","radtodeg","degtorad","randRecursive","randRanged","randBased");
	
	public static List<Character> legalFunctionChars = new ArrayList<Character>();
	public static List<Character> LegalNonFunctionInput = new ArrayList<Character>();
	public static List<Character> AllLegalInput = new ArrayList<Character>();
	
	public static String test = "1+(2+3)*2+(3*(2^2+1))";
	
	public int indentDepth = 0;
	
	public Boolean divBy0 = false, logBase0 = false, noClosedOrderMod = false, noNumberForOperator = false, th0Root = false;
	
	public double costToCalculate = 0;
	
	public void Tab(double addIn){
		System.out.println(Indent() + "adding " + addIn + " dollars to tab for operation");
		costToCalculate += addIn;
	}
	
	public String Indent(){
		String ind = "";
		for(int i = 0; i < indentDepth; i++){
			ind += "	";
		}
		return ind;
	}
	
	public static void main(String[] args) throws IOException{
		listInitialisation();
		SpeedCalculator spd = new SpeedCalculator();
		spd.Result();
	}
	
	public static void listInitialisation(){		
		for(int i = 0; i < functions.size(); i++){
			String str = functions.get(i);
			for(int s = 0; s < str.length(); s++){
				Character cha = str.charAt(s);
				if(legalFunctionChars.size() > 0){
					if(!legalFunctionChars.contains(cha)){
						legalFunctionChars.add(cha);
					}
				}else{
					legalFunctionChars.add(cha);
				}
			}
		}
		
		LegalNonFunctionInput = CombineCharLists(Arrays.asList(operators, operationOrderModifierOpeners, coorespondingOrderModifierClosers, legalNumber, SpecialChars), true);
		
		AllLegalInput = CombineCharLists(Arrays.asList(legalFunctionChars, LegalNonFunctionInput), true);
	}
	
	public static List<Character> CombineCharLists(List<List<Character>> put, boolean exclusive){
		List<Character> chars = new ArrayList<Character>();
		for(int j = 0; j < put.size(); j++){
			for(int i = 0; i < put.get(j).size(); i++){
				if(exclusive){
					if(!chars.contains(put.get(j).get(i))){
						chars.add(put.get(j).get(i));
					}
				}else{
					chars.add(put.get(j).get(i));
				}
			}
		}
		
		return chars;
	}
	
	public String GetFormula() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input your formula to calculate");
		String formula = input.readLine();
		
		String fm = "";
		for(int i = 0; i < formula.length(); i++){
			if(AllLegalInput.contains(formula.charAt(i))){
				fm = fm + formula.charAt(i);
			}
		}
		
		System.out.println("Calculating for: " + fm);
		return fm;
	}
	
	public void Result() throws IOException{
		Help();
		
		Result(GetFormula());
	}
	
	private void Done(){
		System.out.println("Your tab is $" + costToCalculate + " please pay at the front desk.");
	}
	
	private static void Help(){
		System.out.println(" ");
		System.out.println("Thank You for trying Patrick's Speed Calculator*!");
		System.out.println("*name not intended to be indicative of performance, just funny...");
		System.out.println(" ");
		System.out.println("Operators:");
		System.out.println("'f' calls a function calculation. Example: 'fsin90' returns the sin of 90 radians. Charge:see functions");
		System.out.println("'^' 'A^B' A raised to the power of B. Charge:$.04");
		System.out.println("'~' 'A~B' Bth root of A. Charge:$.04");
		System.out.println("'l' 'AlB' log of A in base B. Charge:$.04");
		System.out.println("'*' 'A*B' A mulitplied by B. Charge:$.01");
		System.out.println("'/' 'A/B' A divided by B. Charge:$.01");
		System.out.println("'+' 'A+B' A added to B. Charge:$.01");
		System.out.println("'-' 'A-B' B subtracted from A. Charge:$.01");
		System.out.println(" ");
		System.out.println("Functions:");
		System.out.println("'sin' 'fsinA,B,C' returns sin of A, B, and C separately. Charge:$.25");
		System.out.println("'cos' 'fcosA,B,C' returns cos of A, B, and C separately. Charge:$.25");
		System.out.println("'tan' 'ftanA,B,C' returns tan of A, B, and C separately. Charge:$.25");
		System.out.println("'ftoc' 'fftocA,B,C' converts A, B, and C into celcius from fahrenheight separately. Charge:$.25");
		System.out.println("'ctof' 'fctofA,B,C' converts A, B, and C into fahrenheight from celcius separately. Charge:$.25");
		System.out.println("'degtorad' 'fdegtoradA,B,C' converts A, B, and C into radians from degrees separately. Charge:$.25");
		System.out.println("'radtodeg' 'fradtodegA,B,C' converts A, B, and C into degrees from radians separately. Charge:$.25");
		System.out.println("'randRecursive' 'frandRecursiveA,B,C,D' Returns a random value between random values between A and B, and C and D until there is only one value. Charge:$.25");
		System.out.println("'randRanged' 'frandRangedA,B,C,D' Returns a random value between A and B, C and D, for half the number of random outputs as inputs. Charge:$.04");
		System.out.println("'randBased' 'frandBasedA,B,C' Returns a random value between 0 and A, 0 and B, and 0 and C separately. Charge:$.04");
		System.out.println(" ");
		System.out.println("Use 'n' before a number to denote negative, not '-'");
		System.out.println(" ");
		System.out.println("Parenthesis -'(',')'- and Absolute Value Markers -'|', '|'- are supported");
		System.out.println("Brackets -'[', ']'-, Braces -'{', '}'- are treated as Parenthesis");
		System.out.println(" ");
		System.out.println("hit Enter/Return to submit formula for calculation");
		System.out.println("type 'Help' to see these instructions again");
		System.out.println("type 'Done' to get your tab and exit calculator");
		System.out.println(" ");
	}
	
	public void Result(String formula) throws IOException{
		if(formula.equals("Done")){
			Done();
			return;
		}
		if(formula.equals("Help")){
			Help();
			Result(GetFormula());
		}
		System.out.println("Answer = " + FormulaCalculate(formula));
		
		divBy0 = false;
		th0Root = false;
		noClosedOrderMod = false;
		noNumberForOperator = false;
		
		Result(GetFormula());
	}
	
	public String FormulaCalculate(String calc){
		for(int i = 0; i < calc.length(); i++){
			if(operationOrderModifierOpeners.contains(calc.charAt(i))){
				calc = SubFormula(calc, i);
				if(calc == "null"){
					break;
				}
			}
		}
		if(calc != "null"){
			for(int i = 0; i < operators.size(); i ++){	
				for(int j = 0; j < calc.length(); j++){
					if(calc.charAt(j) == operators.get(i)){
						System.out.println(Indent() + "Calculating Operation:");
						calc = Operate(calc,j);
						j=0;
						if(calc == "null"){
							break;
						}
						System.out.println(Indent() + "Operated formula = " + calc);
					}
				}
			}
		}
		
		if(divBy0 == true){
			return "Error: Divide by 0!";
		}
		if(th0Root == true){
			return "Error: Can't have the 0th root of something";
		}
		if(logBase0 == true){
			return "Error: Can't have a log with base 0";
		}
		if(noClosedOrderMod == true){
			return "Error: no close for opened parenthesis";
		}
		if(noNumberForOperator == true){
			return "Error: all operators require values on both sides of them";
		}
		
		return calc;
	}
	
	public String SubFormula(String calc, int i){
		System.out.println(Indent() + "Sub Formula Found, parcing");
		String subFormula = "";
		int open = i, close = -1, depth = 0;
		Character opener = calc.charAt(i), closer = coorespondingOrderModifierClosers.get(operationOrderModifierOpeners.indexOf(calc.charAt(i)));
		for(int j = i+1; j < calc.length(); j++){
			Character test = calc.charAt(j);
			
			if(test == closer){
				depth --;
			}else if(test == opener){
				depth ++;
			}
			
			System.out.println(Indent() + "	subFormula " + test + " " + Integer.toString(depth));
			
			if(depth >= 0){
				subFormula += test;
			}else{
				close = j+1;
				break;
			}
		}
		if(close == -1){
			noClosedOrderMod = true;
			return "null";
		}
		System.out.println(Indent() + "	Final Sub Formula = " + subFormula);
		indentDepth ++;
		String result = SpliceString(calc, FormulaCalculate(subFormula), open, close);
		if(calc.charAt(i) == coorespondingOrderModifierClosers.get(0)){
			System.out.println(Indent() + "Returning absolute value");
			String res = "";
			for(int w = 0; w < result.length(); w++){
				if(result.charAt(w) != 'n'){
					res = res + result.charAt(w);
				}
			}
			result = res;
		}
		indentDepth --;
		return result;
	}
	
	public String Operate(String calc, int operand){
		System.out.println(Indent() + "Operating on: " + calc);
		
		if(calc.charAt(operand) == 'f')	{
			System.out.println(Indent() + "	Function detected! Calculating...");
			indentDepth += 2;
			String func = Function(calc, operand);
			indentDepth -= 2;
			return func;
		}

		String As = "", Bs = "";
		Boolean An = false, Bn = false;
		int open = -1, close = -1;
		for(int i = operand-1; i >= 0; i--){
			if(legalNumber.contains(calc.charAt(i))){
				if(calc.charAt(i) != 'n'){
					As = calc.charAt(i) + As;
				}else{
					System.out.println(Indent() + "		A is negative");
					An = !An;
				}
			}else{
				open = i+1;
				System.out.println(Indent() + "	Opening at: " + Integer.toString(open));
				break;
			}
		}
		if(open == -1){
			open = 0;
			System.out.println(Indent() + "	Opening at beginning: " + Integer.toString(open));
		}
		
		for(int i = operand+1; i < calc.length(); i++){
			if(legalNumber.contains(calc.charAt(i))){
				if(calc.charAt(i) != 'n'){
					Bs = Bs + calc.charAt(i);
				}else{
					System.out.println(Indent() + "		B is negative");
					Bn = !Bn;
				}
			}else{
				close = i;
				System.out.println(Indent() + "	Closing at: " + Integer.toString(close));
				break;
			}
		}
		if(close == -1){
			close = calc.length() - 1;
			System.out.println(Indent() + "	Closing at end: " + Integer.toString(close));
		}
		
		if(As == "" || Bs == ""){
			noNumberForOperator = true;
			return "null";
		}
		
		double A = Double.parseDouble(As), B = Double.parseDouble(Bs);
		if(An == true){
			A = -A;
		}
		if(Bn == true){
			B = -B;
		}
		int op = operators.indexOf(calc.charAt(operand));
		double C = 0;
        switch (op) {
	        case 1:  
				C = java.lang.Math.pow(A, B);
				Tab(.04);
				break;
            case 2:
            	//root
				if(B == 0){
					th0Root = true;
				}
				if(A < 0){
					C = -(java.lang.Math.pow(Math.abs(A), 1/B));
				}else{
					C = java.lang.Math.pow(A, 1/B);
				}
				Tab(.04);
				break;
            case 3:  
				if(B == 0){
					logBase0 = true;
				}
				Tab(.04);
				C = Math.log(A) / Math.log(B);
				break;
            case 4:  
				C = A*B;
				Tab(.01);
				break;
            case 5:  
				if(B == 0){
					divBy0 = true;
				}
				C = A/B;
				Tab(.01);
				break;
            case 6:  
				C = A+B;
				Tab(.01);
				break;
            case 7:
				C = A-B;
				Tab(.01);
				break;
            default:
				return "null";
        }
		
		String Cs = "";
		if(C < 0){
			Cs += "n";
		}
		Cs += Double.toString(Math.abs(C));
		
		System.out.println(Indent() + "	Operant result: " + Cs);
		
		return SpliceString(calc, Cs, open, close);
	}

	public String Function(String calc, int operand){
		String function = "";
		String input = "";
		List<Double> inputs = new ArrayList<Double>();
		int close = -1;

		for(int i = operand+1; i < calc.length(); i++){
			if(calc.charAt(i) == 'n'){
				if(!functions.contains(function)){
					function += calc.charAt(i);
				}else{
					input += calc.charAt(i);
				}
			}else if(legalNumber.contains(calc.charAt(i))){
				input += calc.charAt(i);
			}else if(legalFunctionChars.contains(calc.charAt(i))){
				if(!functions.contains(function)){
					function += calc.charAt(i);
				}
			}else if(calc.charAt(i) == ','){
				String inpt = "";
				boolean neg = false;
				for(int w = 0; w < input.length(); w++){
					if(input.charAt(w) == 'n'){
						neg = !neg;
					}else{
						inpt += input.charAt(w);
					}
				}
				Double d = Double.parseDouble(inpt);
				if(neg){
					d = -d;
				}
				inputs.add(d);
				input = "";
			}else{
				String inpt = "";
				boolean neg = false;
				for(int w = 0; w < input.length(); w++){
					if(input.charAt(w) == 'n'){
						neg = !neg;
					}else{
						inpt += input.charAt(w);
					}
				}
				Double d = Double.parseDouble(inpt);
				if(neg){
					d = -d;
				}
				inputs.add(d);
				input = "";
				
				close = i;
				break;
			}
		}
		if(close == -1){
			close = calc.length() - 1;
		}
		if(!input.equals("")){
			String inpt = "";
			boolean neg = false;
			for(int w = 0; w < input.length(); w++){
				if(input.charAt(w) == 'n'){
					neg = !neg;
				}else{
					inpt += input.charAt(w);
				}
			}
			Double d = Double.parseDouble(inpt);
			if(neg){
				d = -d;
			}
			inputs.add(d);
			input = "";
		}
		
		System.out.println(Indent() + "Running " + function + " function on " + inputs.size() + " values");
		

		List<Double> outputs = new ArrayList<Double>();
		
		//("sin","cos","tan","ftoc","ctof","radtodeg","degtorad","randRecursive","randRanged","randBased")
		//   0     1      2     3      4        5          6           7              8            9
		int op = functions.indexOf(function);
        switch (op) {
        	case 0://sin
        		for(int i = 0; i < inputs.size(); i++){
        			System.out.println(Indent() + "	Calculating " + function + " of " + inputs.get(i));
        			outputs.add(Math.sin(inputs.get(i)));
        		}
        		Tab(.25);
        		break;
        	case 1: //cos 
        		for(int i = 0; i < inputs.size(); i++){
        			System.out.println(Indent() + "	Calculating " + function + " of " + inputs.get(i));
        			outputs.add(Math.cos(inputs.get(i)));
        		}
        		Tab(.25);
				break;
            case 2://tan
        		for(int i = 0; i < inputs.size(); i++){
        			System.out.println(Indent() + "	Calculating " + function + " of " + inputs.get(i));
        			outputs.add(Math.tan(inputs.get(i)));
        		}
        		Tab(.25);
				break;
            case 3: //ftoc
        		for(int i = 0; i < inputs.size(); i++){
        			System.out.println(Indent() + "	Calculating " + function + " of " + inputs.get(i));
        			outputs.add( ((5.0/9.0) * (inputs.get(i) - 32.0)) );
        		}
        		Tab(.25);
				break;
            case 4:  //ctof
            	for(int i = 0; i < inputs.size(); i++){
        			System.out.println(Indent() + "	Calculating " + function + " of " + inputs.get(i));
        			outputs.add( ((9.0/5.0) * inputs.get(i) + 32.0) );
        		}
            	Tab(.25);
				break;
            case 5: //radtodeg
            	for(int i = 0; i < inputs.size(); i++){
        			System.out.println(Indent() + "	Calculating degrees from " + inputs.get(i) + " radians");
        			outputs.add( Math.toDegrees(inputs.get(i)) );
        		}
            	Tab(.25);
				break;
            case 6: //degtorad
            	for(int i = 0; i < inputs.size(); i++){
        			System.out.println(Indent() + "	Calculating radians from " + inputs.get(i) + " degrees");
        			outputs.add( Math.toRadians(inputs.get(i)) );
        		}
            	Tab(.25);
				break;
            case 7: //randRecursive
            		while (inputs.size() > 1){
            			List<Double> reputs = new LinkedList<Double>();
	            		for(int i = 1; i < inputs.size(); i += 2){
	            			System.out.println(Indent() + "	Calculating random value from " + inputs.get(i-1) + " to " + inputs.get(i));
	            			reputs.add( Math.random() * (inputs.get(i-1)-inputs.get(i)) + inputs.get(i) );
	            		}
	            		inputs = reputs;
            		}
            		Tab(.25);
        			outputs.add( inputs.get(0) );
				break;
            case 8: //randRanged
            	for(int i = 1; i < inputs.size(); i += 2){
        			System.out.println(Indent() + "	Calculating random value from " + inputs.get(i-1) + " to " + inputs.get(i));
        			outputs.add( Math.random() * (inputs.get(i-1)-inputs.get(i)) + inputs.get(i) );
        		}
            	Tab(.04);
				break;
            case 9: //randBased
            	for(int i = 0; i < inputs.size(); i++){
        			System.out.println(Indent() + "	Calculating random value from 0 to " + inputs.get(i));
        			outputs.add( inputs.get(i)*Math.random() );
        		}
            	Tab(.04);
				break;
            default:
				return "null";
        }
        
        String answers = "";
        for(int i = 0; i < outputs.size(); i++){
        	if(i > 0){
            	answers += ',';
        	}
        	if(outputs.get(i) < 0){
        		answers += "n";
        	}
        	answers += Math.abs(outputs.get(i));
        }
        
        return SpliceString(calc, answers, operand, close);
	}
	
 	public String SpliceString(String original, String spliceIn, int startSpice, int endSplice){
		String spliced = "";
		
		System.out.println(Indent() + "Splicing " + spliceIn + " into " + original + ", from index " + Integer.toString(startSpice) + " to index " + Integer.toString(endSplice));
		
		for(int i = -1; i < startSpice; i++){
			if(i >= 0){
				System.out.println(Indent() + "	Start " + Integer.toString(i) + " " + original.charAt(i));
				
				spliced += original.charAt(i);
			}
		}
		for(int i = 0; i < spliceIn.length(); i++){
			System.out.println(Indent() + "	Splice " + Integer.toString(i) + " " + spliceIn.charAt(i));
			
			spliced += spliceIn.charAt(i);
		}
		if(endSplice < original.length() - 1){
			for(int i = endSplice; i < original.length(); i++){
				System.out.println(Indent() + "	End " + Integer.toString(i - endSplice) + " " + original.charAt(i));
				
				spliced += original.charAt(i);
			}
		}
		System.out.println(Indent() + "	Spliced Result = " + spliced);
		return spliced;
	}
}