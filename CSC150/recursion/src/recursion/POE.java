package recursion;

public class POE {

	public static void main(String[] args) {
		long fac = 63;
		System.out.println(loopFactorial(fac));
		System.out.println(resursiveFactorial(fac));
		System.out.println("");
		
		long fib = 4;
		System.out.println(loopFibonachi(1,1,fib));
		System.out.println(recursiveFibonachi(1,1,fib));
		System.out.println("");

		System.out.println(count);
	}

	public static long loopFibonachi(long a1, long a2, long iterations){
		for(int i = 1; i < iterations; i++){
			long a1c = a1;
			a1 = a2;
			a2 = a2 + a1c;
		}
		return a1;
	}
	public static long recursiveFibonachi(long iterations){
		return recursiveFibonachi(1, 1, iterations, 1);
	}
	public static long recursiveFibonachi(long a1, long a2, long iterations){
		return recursiveFibonachi(a1, a2, iterations, 1);
	}
	static int count = 0;
	public static long recursiveFibonachi(long a1, long a2, long iterations, long currentIteration){
		count ++;
		if(currentIteration < iterations){
			return recursiveFibonachi(a2, a1+a2, iterations, ++currentIteration);
		}
		return a1;
	}
	
	public static long loopFactorial(long a){
		long b = 1;
		while(a>1){
			b *= a;
			a--;
		}
		return b;
	}
	public static long resursiveFactorial(long a){
		if(a > 1){
			return a * resursiveFactorial(a-1);
		}else{
			return a;
		}
	}

}
