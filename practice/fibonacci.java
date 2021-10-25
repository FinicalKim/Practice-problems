package practice;

public class fibonacci {
	
	public static void main(String[] args) {
		System.out.println(fib(8));
	}
	public static int fib(int n) {
		if (n == 1) {	// base case
			return 0;
		}
		if (n == 2) {	// base case
			return 1;
		}
		int fib = fib(n - 1) + fib(n - 2);	// return the sum of n-1 and n-2
		return fib;
	}
}
