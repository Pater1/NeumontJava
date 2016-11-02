import java.io.*;
import java.util.*;

public class IPComparator {
	public static final int BYTE_DIGIT_LENGTH = 8;
	
	public static void main(String[] args) throws IOException{
		GetAndCompairUserIPsAgainstSubnet();
	}
	
	public static void GetAndCompairUserIPsAgainstSubnet() throws IOException{
		System.out.println("Please input the first IP to check in subnet.");
		String IP1 = GetUserIP(true,false);
		System.out.println("Please input the subnet to compair the IPs within.");
		String subNet = GetUserIP(true,true);
		System.out.println("Please input the second IP to check in subnet.");
		String IP2 = GetUserIP(true,false);
		
		boolean check = IPsAreInSameSubnet(IP1,IP2,subNet);
		System.out.println(check);
		if(check){
			System.out.println("These two IP's are both within the provided subnet.");
		}else{
			System.out.println("These two IP's are not both within the provided subnet.");
		}
	}
	
	public static boolean IPsAreInSameSubnet(String IP1, String IP2, String subNet){
		return AndCompairBinaryStrings(IP1, subNet).equals(AndCompairBinaryStrings(IP2, subNet));
	}
	
	public static String GetUserIP(boolean returnInBinary, boolean checkIfValidSubnetMask) throws IOException{
		final List<Character> legalNumber = Arrays.asList('.','1','2','3','4','5','6','7','8','9','0');
		final String errorMessage = "Input not a valid IP address! Please try again...";

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		do{
			String tmp = input.readLine();
			
			int numberDepth = 0, addressDepth = 0;
			for(int i = 0; i <= tmp.length(); i++){
				if(i == tmp.length()){
					if(returnInBinary && checkIfValidSubnetMask){
						return CheckByteSubnetMask(IntIPToByteIP(tmp));
					}else if(returnInBinary){
						return IntIPToByteIP(tmp);
					}else if(checkIfValidSubnetMask){
						return ByteIPToIntIP(CheckByteSubnetMask(IntIPToByteIP(tmp)));
					}else{
						return tmp;
					}
				}
				
				if(!legalNumber.contains(tmp.charAt(i))){
					System.out.println(errorMessage);
					break;
				}else{
					if(tmp.charAt(i) == '.'){
						numberDepth = 0;
						addressDepth++;
						if(addressDepth > 3){
							System.out.println(errorMessage);
							break;
						}
					}else{
						numberDepth++;
						if(numberDepth > 3){
							System.out.println(errorMessage);
							break;
						}
					}
				}
			}
		}while(true);
	}

	private static String IntIPToByteIP(String intIP){
		String output = "";
		String tmp = "";
		for(int i = 0; i < intIP.length(); i++){
			if(intIP.charAt(i) != '.'){
				tmp += intIP.charAt(i);
			}else{
				output += ParseIntToBinary(Integer.parseInt(tmp), BYTE_DIGIT_LENGTH)+".";
				tmp = "";
			}
		}
		output += ParseIntToBinary(Integer.parseInt(tmp), BYTE_DIGIT_LENGTH);
		return output;
	}
	private static String ByteIPToIntIP(String byteIP){
		String output = "";
		String tmp = "";
		for(int i = 0; i < byteIP.length(); i++){
			if(byteIP.charAt(i) != '.'){
				tmp += byteIP.charAt(i);
			}else{
				output += RenderBinaryToInt(tmp)+".";
				tmp = "";
			}
		}
		output += RenderBinaryToInt(tmp);
		return output;
	}	
	private static String CheckByteSubnetMask(String checkByteIP){
		boolean hit0 = false;
		for(int i = 0; i < checkByteIP.length(); i++){
			if(checkByteIP.charAt(i) == '.'){
				hit0 = false;
			}else if(checkByteIP.charAt(i) == '0'){
				hit0 = true;
			}else if(checkByteIP.charAt(i) == '1'){
				if(hit0){
					System.out.println("Input not a valid Subnet Mask! Please try again...");
					return null;
				}
			}else{
				System.out.println("Developer Error! CheckByteSubnetMask(String checkByteIP) requires IP's to be converted to binary prior to input! Use IntIPToByteIP(String intIP) to convert the IP to test.");
				return null;
			}
		}
		return checkByteIP;
	}
	
 	public static String AndCompairBinaryStrings(String input1, String input2){
		if(input1.length() != input2.length()){
			System.out.println("This function requires inputs of identical length. Please check inputs, returning null...");
			return null;
		}
		String tmp = "";
		for(int i = 0; i < input1.length(); i++){
			if(input1.charAt(i) == '1' && input2.charAt(i) == '1'){
				tmp += "1";
			}else if(input1.charAt(i) == '.' && input2.charAt(i) == '.'){
				tmp += ".";
			}else{
				tmp += "0";
			}
		}
		return tmp;
	}

	public static int RenderBinaryToInt(String input){
		return RenderBinaryToInt(input, 0, 0);
	}
	private static int RenderBinaryToInt(String input, int depth, int output){
		if(depth >= input.length()){
			return output;
		}

		int floor = (int) Math.pow(2, depth);
		char inp = input.charAt(input.length()-(1+depth));
		if(inp == '1'){
			return RenderBinaryToInt(input, depth+1, output+floor); 
		}else if(inp == '0'){
			return RenderBinaryToInt(input, depth+1, output); 
		}else{
			System.out.println("Invalid Character detected! Please check input value... returning 0");
			return 0;
		}
	}
	
	public static String ParseIntToBinary(int input, int digitLength){
		String tmp = "";
		
		if(input >= Math.pow(2, digitLength)){
			System.out.println("Error! " + input + " out of range for " + digitLength + "-bit Byte!");
			return null;
		}
		
		for(int i = 1; i <= digitLength; i++){
			int floor = (int) Math.pow(2, digitLength-i);
			if(input >= floor){
				tmp += "1";
				input -= floor;
			}else{
				tmp += "0";
			}
		}
		return tmp;
	}
}