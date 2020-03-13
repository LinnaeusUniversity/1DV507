package rq222ah_Assign4.time;

import java.util.Comparator;
import java.util.Random;

public class Exercise_3 {

	public static void main(String[] args) {

		// We use integer array to store elements
		int[] list = new int[1000];
		System.out.println("Sorted integers: " + CalInt(list));

		Comparator<String> n = new Comparator<String>() {
			@Override
			public int compare(String a1, String a2) {
				return a1.compareTo(a2);
			}
		};

		// We use a String array to store elements
		String[] list2 = new String[1000];
		System.out.println("Sorted strings: " + CalString(list2, n));
	}

	public static int CalInt(int[] arr) {
		int counter = 0;
		boolean lessThanOneSecond = true;
		Random r = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(100000);
		}

		long time = System.nanoTime();
		while (lessThanOneSecond) {
			InsertionSort(arr);
			counter++;

			if (System.nanoTime() - time <= 1000000000) {
				lessThanOneSecond = true;
			} else {
				lessThanOneSecond = false;
			}

			for (int j = 0; j < arr.length; j++) {
				arr[j] = r.nextInt(100000);
			}
		}
		return counter * 1000;
	}

	public static int CalString(String[] arr, Comparator<String> c) {
		int counter = 0;
		boolean lessThanOneSecond = true;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = getRandomString();
		}

		long time = System.nanoTime();
		while (lessThanOneSecond) {
			InsertionSort(arr, c);
			counter++;

			if (System.nanoTime() - time <= 1000000000) {
				lessThanOneSecond = true;
			} else {
				lessThanOneSecond = false;
			}

			for (int j = 0; j < arr.length; j++) {
				arr[j] = getRandomString();
			}
		}
		return counter * 1000;
	}

	public static String getRandomString() {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder str = new StringBuilder();
		Random r = new Random();
		while (str.length() < 11) {
			int index = r.nextInt(chars.length());
			str.append(chars.charAt(index));
		}
		return str.toString();
	}

	public static int[] InsertionSort(int[] in) {
		int[] newList = new int[in.length];
		System.arraycopy(in, 0, newList, 0, in.length);

		for (int i = 1; i < newList.length; i++) {
			int temp = newList[i];
			int pos = i;

			while (pos > 0 && newList[pos - 1] > temp) {
				newList[pos] = newList[pos - 1];
				pos = pos - 1;
			}
			newList[pos] = temp;
		}
		return newList;
	}

	public static String[] InsertionSort(String[] in, Comparator<String> n) {
		String[] newList = new String[in.length];
		System.arraycopy(in, 0, newList, 0, in.length);

		for (int i = 1; i < newList.length; i++) {
			String temp = newList[i];
			int pos = i;

			while (pos > 0 && n.compare(newList[pos - 1], temp) > 0) {
				newList[pos] = newList[pos - 1];
				pos = pos - 1;
			}

			newList[pos] = temp;
		}
		return newList;
	}

}
