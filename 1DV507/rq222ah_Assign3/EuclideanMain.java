package rq222ah_Assign3;

import java.util.*;

public class EuclideanMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Finding GCD:" + "\n");
		System.out.print("M:");
		int M = sc.nextInt();
		System.out.print("N: ");
		int N = sc.nextInt();

		System.out.println("GCD" + "(" + M + "," + N + ") " + "= " + gcd(N, M));
		sc.close();
	}

	/**
	 * Calculate GCD of two integers using recursion
	 * 
	 * @param a integer
	 * @param b integer
	 * @return gcd using recursion
	 */
	public static int gcd(int a, int b) {

		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

}
