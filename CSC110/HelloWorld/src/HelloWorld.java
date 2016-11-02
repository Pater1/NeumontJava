import java.io.*;

public class HelloWorld {

	public static void main(String[] args) throws IOException{
		System.out.println("Hello World, again...");
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(input.readLine());
	}

}
