
public class Overflow {
	public static void main(String[] args){
		Long max = (long) 1;
		while (max>0){
			max += 100000000;
			System.out.println(max);
		}
	}
}
