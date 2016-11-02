import java.io.*;

public class MadLib {
	public static void main(String[] args) throws IOException{
		BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("What is your name?");
		String name = input.readLine();

		System.out.println(name + ", What is your age?");
		String age = input.readLine();
		System.out.println(age);

		System.out.println("What city do you live in?");
		String city = input.readLine();
		System.out.println(city);
		

		System.out.println("The lib is mad as follows:");
		System.out.println("");
		System.out.println("Little did " + name + " know that moving to the high rise appartments down town would take them farther than they had ever expected. \n"
				+ "After the " + age + " years of standing in Timbuktu, the appartments fell, their immence hight throwing its penthouse well out of the locals veiw. \n"
				+ name + " lives in " + city + "now.");
	}
}
