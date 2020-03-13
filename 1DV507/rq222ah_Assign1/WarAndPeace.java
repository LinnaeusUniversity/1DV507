package rq222ah_Assign1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WarAndPeace {

	public static void main(String[] args) {
		String txt = readtxt("C:\\eclipse\\Java_courses\\1DV507\\WarAndPeace.txt"); // My  method
		String[] words = txt.split(" "); // Simple split, will be cleared up later on
		// later on
		System.out.println("Initial word count: " + words.length); // We found 577,091

		Stream<String> stream = Arrays.stream(words);
		long wordCount = stream.map(w -> w.toLowerCase().replaceAll("\\s+", "")).filter(w -> w.length() > 0).distinct()
				.count();
		System.out.println("No.of unique words used in the txt: " + wordCount);
	}

	public static String readtxt(String filename) {
		try {
			return Files.readAllLines(Paths.get(filename), Charset.forName("ISO-8859-1")).stream()
					.collect(Collectors.joining(" "));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
