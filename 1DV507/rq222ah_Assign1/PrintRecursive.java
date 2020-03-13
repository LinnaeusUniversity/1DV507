package rq222ah_Assign1;

public class PrintRecursive {

	public static void main(String[] args) {
		String str = "Hello Everyone!";
		reverseOrder(str, 14);
		System.out.println();
		regularPrint(str, 0);
	}

	public static void reverseOrder(String str, int n) {

		if (!(n < 0)) {
			System.out.println(str.charAt(n));
			reverseOrder(str, n - 1);
		} else
			System.out.println();

	}

	public static void regularPrint(String str, int n) {

		if (!(n == str.length())) {
			System.out.print(str.charAt(n));
			regularPrint(str, n + 1);
		} else
			System.out.println();

	}
}
