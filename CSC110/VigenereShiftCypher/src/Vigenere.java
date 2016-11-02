import java.io.IOException;
import patpackages.input.*;

public class Vigenere {
	public static void main(String[] args) throws IOException {
		System.out.println(EncodeCypherText(
				ConsoleUI.promptForInput("please input your key", false),
				ConsoleUI.promptForInput("please input your message", false)));	
	}
	
	public static String EncodeCypherText(String key, String plainText){
		String str = "";
		for(int i = 0; i < plainText.replaceAll("\\s","").length(); i++){
			str += (char)(((Character.toLowerCase(key.replaceAll("\\s","").charAt(i%key.replaceAll("\\s","").length())) + Character.toLowerCase(plainText.replaceAll("\\s","").charAt(i)) - 2*'a') % 26) + 'a');
		}
		return str;
	}
}
