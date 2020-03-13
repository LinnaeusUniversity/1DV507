package rq222ah_Assign3;

import java.util.Comparator;

public class SortingAlgorithms {
	public static int[] insertionSort(int[] in) {
		for (int i = 0; i < in.length; i++) {
			for (int w = i; w > 0; w--) {
				if (in[w] < in[w - 1]) {
					int EX = in[w - 1];
					in[w - 1] = in[w];
					in[w] = EX;
				}
			}
		}
		return in;
	}

	public static int[] mergeSort(int[] in) // VG Exercise
	{
		double CLoop = Math.log((double) in.length) / Math.log((double) 2);
		int Loop = 0;
		if (CLoop > (int) CLoop) {
			Loop = (int) CLoop + 1;
		} else {
			Loop = (int) CLoop;
		}
		System.out.println(Loop);

		arrayMerge(in);
		return in;
	}

	private static int[] arrayMerge(int[] devided) {
		if (devided.length == 1) {
			return devided;
		}

		int Seprate = 0;
		if (devided.length % 2 == 0) {
			Seprate = devided.length / 2;
		}
		if (devided.length % 2 == 1) {
			Seprate = devided.length / 2 + 1;
		}

		int[] Merge1 = new int[Seprate];
		int[] Merge2 = new int[devided.length - Seprate];

		for (int i = 0; i < Merge1.length; i++) {
			Merge1[i] = devided[i];
		}

		for (int w = 0; w < Merge2.length; w++) {
			Merge2[w] = devided[w + Merge1.length];
		}
		return Merge2;
	}

	public static String[] insertionSort(String[] in, Comparator<String> c) {
		for (int i = 0; i < in.length; i++) {
			for (int w = i; w > 0; w--) {
				if (c.compare(in[w], in[w - 1]) < 0) {
					String EX = in[w - 1];
					in[w - 1] = in[w];
					in[w] = EX;
				}
			}
		}
		return in;
	}

	public String[] mergeSort(String[] in, Comparator<String> c) // VG Exercise
	{
		return in;
	}
}