package rq222ah_Assign1;

public class Pascal {

	public static void main(String[] args) {

		pascalRow(15);

	}

	public static int[] pascalRow(int n) {

		int[] pTriangle1 = new int[n + 1];

		if (n == 32) {
			System.err.println(" Not possible for 32!! ");
			return pTriangle1;
		}

		if (n == 0) {
			pTriangle1[0] = 1;
			for (int i = 0; i < pTriangle1.length; i++) {
				System.out.print(pTriangle1[i] + " ");
			}
			return pTriangle1;
		}

		if (n == 1) {
			pTriangle1[0] = 1;
			pTriangle1[1] = 1;
			for (int i = 0; i < pTriangle1.length; i++) {
				System.out.print(pTriangle1[i] + " ");
			}
			return pTriangle1;
		}
		if (n == 2) {
			pTriangle1[0] = 1;
			pTriangle1[1] = 2;
			pTriangle1[2] = 1;
			for (int i = 0; i < pTriangle1.length; i++) {
				System.out.print(pTriangle1[i] + " ");
			}

			return pTriangle1;

		} else

			for (int i = 1; i < pTriangle1.length - 1; i++) {
				pTriangle1[0] = pTriangle1[n] = 1;
				pTriangle1[i] = factorial(n) / (factorial(n - i) * factorial(i));

				// System.out.print(pTriangle1[i] + " ");

			}

		for (int j = 0; j < pTriangle1.length; j++) {
			System.out.print(pTriangle1[j] + " ");
		}

		return pTriangle1;

	}

	// i used recursion for factorial
	public static int factorial(int n) {
		if (n == 1)
			return 1;
		else
			return n * factorial(n - 1);
	}

}
