package rq222ah_Assign1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionPointers {
	public static void main(String[] args) {
		System.out.println("Part 1: Apply predicates");
		List<Integer> list = Arrays.asList(45, 3, 24, 16, 1, 1, 3, 8, 7, 6, 10, 12, 17, 22, 30);

		System.out.print("Print all numbers: ");
		Predicate<Integer> all = n -> true;
		selectAndPrint(list, all); //

		System.out.print("\nPrint all odd numbers: ");
		Predicate<Integer> odd = n -> false; // Must be updated
		selectAndPrint(list, odd);

		System.out.print("\nPrint all numbers greater than 10: ");
		Predicate<Integer> aboveTen = n -> false; // Must be updated
		selectAndPrint(list, aboveTen);

		System.out.println("\n\nPart 2: Apply functions");
		List<Double> numbers = Arrays.asList(1.0, 16.0, 25.0, 81.0);
		System.out.println("Original: " + numbers);
		System.out.println("Square root: " + applyFunction(numbers, Math::sqrt));
		System.out.println("Power of two: " + applyFunction(numbers, FunctionPointers::powerOfTwo));
	}

	public static void selectAndPrint(List<Integer> list, Predicate<Integer> predicate) {

		for (int i = 0; i < list.size(); i++) {
			if (predicate.test(i))
				System.out.printf("%d ", i);
		}

	}

	// with the help of java api and google that which methods are available
	private static List<Double> applyFunction(List<Double> numbers, Function<Double, Double> fx) {

		List<Double> list = new ArrayList<Double>(numbers.size());
		for (int i = 0; i < numbers.size(); i++) {
			list.add(fx.apply(numbers.get(i)));
		}

		return list;
	}

	private static Double powerOfTwo(Double d) {
		return Math.pow(d, 2);
	}
}
