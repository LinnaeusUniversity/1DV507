package rq222ah_Assign4.time;

public class Concatination {

	public static void main(String[] args) {

		String shortConcat = "";
		String longConcat = "";
		long numOfShortConcat = 0;
		long numOfLongConcat = 0;

		StringBuilder shortAppend = new StringBuilder();
		StringBuilder longAppend = new StringBuilder();
		long numOfShortAppend = 0;
		long numOfLongAppend = 0;

		// Short concat
		long time = System.nanoTime();
		while (System.nanoTime() - time <= 1000000000) {
			shortConcat = shortConcat + "n";
			numOfShortConcat++;
		}

		// Long concat
		time = System.nanoTime();
		while (System.nanoTime() - time <= 1000000000) {
			longConcat = longConcat
					+ "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn";
			numOfLongConcat++;
		}

		// Short append
		time = System.nanoTime();
		while (System.nanoTime() - time <= 1000000000) {
			shortAppend.append("n").toString();
			numOfShortAppend++;
		}

		// Long append
		time = System.nanoTime();
		while (System.nanoTime() - time <= 1000000000) {
			longAppend.append("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn")
					.toString();
			numOfLongAppend++;
		}

		System.out.println("Short concat: " + shortConcat.length());
		System.out.println("Number of short concatenations: " + numOfShortConcat + "\n");

		System.out.println("Long concat: " + longConcat.length());
		System.out.println("Number of long concatenations: " + numOfLongConcat + "\n");

		System.out.println("Short append: " + shortAppend.length());
		System.out.println("Number of short appends: " + numOfShortAppend + "\n");

		System.out.println("Long append: " + longAppend.length());
		System.out.println("Number of long appends: " + numOfLongAppend);
	}
}
