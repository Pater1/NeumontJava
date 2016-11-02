
public class NRand {

	private static final int N = 15;
	private static int[] randArray;
	
	public static void main(String[] args){
		randArray = new int[N];
		
		FillArray(0,N);
		
		for(int i = N-1; i >= 0; i--){
			System.out.println("" + randArray[i] + " at " + i);
		}
	}
	
	private static void FillArray(int depth, int exit){
		if(depth >= exit){
			return;
		}else{
			randArray[depth] = (int) (Math.random() * (0-50) + 50);
			FillArray(depth+1,N);
		}
	}
}
