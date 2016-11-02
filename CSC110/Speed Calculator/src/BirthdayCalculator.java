
import java.util.*;
import java.io.*;
import java.text.*;

public class BirthdayCalculator {
	public static Integer[] thisScriptsBirthday = new Integer[]{10, 3, 2016}, today, userBirthday;
	
	public static enum Months{
		January,
		Febuary,
		March,
		April,
		May,
		June,
		July,
		August,
		September,
		October,
		November,
		December
	}
	
	public static void main(String[] args) throws IOException{
		GetToday();
		BirthdayCalculator bdc = new BirthdayCalculator();
		bdc.Start();
	}
	
	public void Start() throws IOException{
		System.out.println("What is your brithday? Please format as MM/dd/yyyy");
		userBirthday = GetUserDate();

		System.out.println("Today is " + WriteIntArrayDateToString(today));
		System.out.println("Your Birthday is " + WriteIntArrayDateToString(userBirthday));
		
		Integer[] ageDelta = GetAgeDelta(today, userBirthday);
		if(ageDelta[2] >= 0){
			System.out.println("Therefore, you are " + ageDelta[2] + " years " + ageDelta[0] + " months " + ageDelta[1] + " days old");
		}else{
			System.out.println("Therefore, you are... wait a minute! You can't be " + ageDelta[2] + " years old! Let's try that again.");
			Start();
			return;
		}
		
		Integer[] scriptDelta = GetAgeDelta(userBirthday, thisScriptsBirthday);
		if(scriptDelta[2] < 0){
			System.out.println("That makes you " + Math.abs(scriptDelta[2]) + " years " + scriptDelta[0] + " months " + scriptDelta[1] + " days older than me!");
		}else if(scriptDelta[2] > 0){
			System.out.println("That makes me " + scriptDelta[2] + " years " + scriptDelta[0] + " months " + scriptDelta[1] + " days older than you!");
		}else{
			System.out.println("That makes us the same age!");
		}
	}
	
	public Integer[] GetUserDate() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String inputDate = input.readLine();
		
		if(inputDate.charAt(2) != '/' || inputDate.charAt(5) != '/' || inputDate.length() != 10){
			System.out.println("Not a valid date! Please format as MM/dd/yyyy");
			return GetUserDate();
		}
		
		return ReadStringToIntArrayDate(inputDate);
	}
	
	public static void GetToday(){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	    Date dateobj = new Date();
	    String stringDate = df.format(dateobj);
	    today = ReadStringToIntArrayDate(stringDate);
	}
	
	public static Integer[] ReadStringToIntArrayDate(String read){
		Integer[] tmp = null;
		
		if(read.charAt(2) != '/' || read.charAt(5) != '/'){
			System.out.println("Invalid date input! Please fomat date as MM/dd/yyy.");
			return tmp;
		}
		
	    String Ms, Ds, Ys;
	    Ms = "" + read.charAt(0) + read.charAt(1);
	    Ds = "" + read.charAt(3) + read.charAt(4);
	    Ys = "" + read.charAt(6) + read.charAt(7) + read.charAt(8) + read.charAt(9);
	    
	    tmp = new Integer[3];
	    
	    tmp[0] = Integer.parseInt(Ms);
	    tmp[1] = Integer.parseInt(Ds);
	    tmp[2] = Integer.parseInt(Ys);
	    
	    return tmp;
	}

	public static String WriteIntArrayDateToString(Integer[] write){
		//return "" + write[0] + "/" + write[1] + "/" + write[2];
		return "" + Months.values()[write[0]-1] + " " + write[1] + "th, " + write[2];
	}
	
	public static Integer[] GetAgeDelta(Integer[] older, Integer[] younger){
		int i = 0;

		int olderDays = ArrayDateToDayCount(older), youngerDays = ArrayDateToDayCount(younger);
		int daysDifference = olderDays - youngerDays;
		
		if(daysDifference < 0){
			i = -1;
			daysDifference = Math.abs(daysDifference);
		}else{
			i = 1;
		}
		
		Integer[] tmp2 = DayCountToArrayDate(daysDifference);
		Integer[] tmp = new Integer[]{tmp2[0],tmp2[1],tmp2[2],i};
		
		/*tmp1[0] = older[0] - younger[0];
		tmp1[1] = older[1] - younger[1];
		tmp1[2] = older[2] - younger[2];
		
		if(tmp[2] < 0){
			if(tmp[1] > 0){
				tmp[0]++;
			}
			if(tmp[0] > 0){
				tmp[2]++;
			}
			tmp[0] = Math.abs(12 - tmp[0]);
			tmp[1] = Math.abs(new_dim(tmp[0], tmp[2]) - tmp[1]);
		}else{
			if(tmp[0] < 0){
				tmp[2]--;
			}
		}*/
		
		return tmp;
	}
	
	private static Integer[] DayCountToArrayDate(int in){
		Integer[] out = today;
		
		boolean done = false;
		while(!done){
			if(in < new_dim(out[0],out[2])){
				done = true;
				out[1] = in;
				break;
			}
			
			
			if(out[0] == today[0]){
				in -= today[1];
				out[0]--;
			}else{
				in -= new_dim(out[0],out[2]);
				out[0]--;
				if(out[0] < 1){
					out[0] = 12;
					out[2]--;
				}
			}
		}
		
		return out;
	}
	
	private static int ArrayDateToDayCount(Integer[] in){
		int out = in[1];
		for(int y = in[2]; y <= today[2]; y++){
			for(int m = 1; m <= 12; m++){
				if(y == in[2]) m = in[0];
				
				out += new_dim(m,y);
				if(m == 2){
					System.out.println(new_dim(m,y));
				}
				
				if(y == today[2] && m >= today[0]){
					m = 12;
				}
			}
		}
		return out;
	}
	
	public static int IsLeapYear(int y){
		boolean b = ((y%400 == 0) || (y%100 != 0 && y%4 == 0));
		if(b){
			return 1;
		}else{
			return 0;
		}
	}
	
	//This method sourced from Stack Exchange. Edited to work in Java.
	//http://stackoverflow.com/questions/28800127/universal-formula-to-calculate-the-number-of-days-in-month-taking-in-to-account
	public static int new_dim(int mm, int yyyy)
	{
		int feb = 0;
		if(mm == 2){
			feb = 1;
		}
	    return (28 + (mm + (mm/8)) % 2 + 2 % mm + 2 * (1/mm) + (feb * IsLeapYear(yyyy)));
	}
}