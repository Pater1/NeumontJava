import java.io.*;
import java.text.*;

public class Calc {

	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("add, subtract, multiply, divide, tempf2c, tempc2f, exp, sqrt, sin, cos, or random");
		System.out.println("Please type in your function.");
		String function = input.readLine();

		System.out.println("Input the primary value.");
		double A = Double.parseDouble(input.readLine());
		double C = 0, $ = 0;
		
		
		if(function.equals("add")){
			System.out.println("Input the secondary value.");
			C = Add(A,Double.parseDouble(input.readLine()));
			$ = .01;
		}else if(function.equals("subtract")){
			System.out.println("Input the secondary value.");
			C = Subtract(A, Double.parseDouble(input.readLine()));
			$ = .01;
		}else if(function.equals("multiply")){
			System.out.println("Input the secondary value.");
			C = Multiply(A, Double.parseDouble(input.readLine()));
			$ = .01;
		}else if(function.equals("divide")){
			System.out.println("Input the secondary value.");
			C = Divide(A, Double.parseDouble(input.readLine()));
			$ = .01;
		}else if(function.equals("tempf2c")){
			C = Tempf2c(A);
			$ = .25;
		}else if(function.equals("tempc2f")){
			C = Tempc2f(A);
			$ = .25;
		}else if(function.equals("exp")){
			System.out.println("Input the secondary value.");
			C = Pow(A, Double.parseDouble(input.readLine()));
			$ = .04;
		}else if(function.equals("sqrt")){
			C = Sqrt(A);
			$ = .04;
		}else if(function.equals("sin")){
			C = Sin(A);
			$ = .25;
		}else if(function.equals("cos")){
			C = Cos(A);
			$ = .25;
		}else if(function.equals("random")){
			System.out.println("Input the secondary value.");
			C = Rand(A, Double.parseDouble(input.readLine()));
			$ = .04;
		}

		DecimalFormat df = new DecimalFormat("###.##");
		System.out.println("Result: " + df.format(C));
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		System.out.println("Your charge is: " + fmt.format($));
	}
	public static double Add(double A, double B){
		return A+B;
	}
	public static double Subtract(double A, double B){
		return A-B;
	}
	public static double Multiply(double A, double B){
		return A*B;
	}
	public static double Divide(double A, double B){
		return A*B;
	}
	public static double Pow(double A, double B){
		return Math.pow(A, B);
	}
	public static double Rand(double A, double B){
		return (Math.random() * (B-A) + A);
	}
	public static double Sqrt(double A){
		return Math.pow(A, 1/2);
	}
	public static double Tempf2c(double A){
		return ((5.0/9.0) * (A - 32.0));
	}
	public static double Tempc2f(double A){
		return ((9.0/5.0) * A + 32.0);
	}
	public static double Sin(double A){
		return Math.sin(A);
	}
	public static double Cos(double A){
		return Math.cos(A);
	}
}