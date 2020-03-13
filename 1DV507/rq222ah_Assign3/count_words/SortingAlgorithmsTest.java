package rq222ah_Assign3.count_words;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import rq222ah_Assign3.SortingAlgorithms;

class SortingAlgorithmsTest {

	@Test
	void intSortTest() {
		int [] unSorted = {100,55,32,56,-500};
		int [] sorted = {-500,32,55,56,100};
		int [] newSorted = SortingAlgorithms.insertionSort(unSorted);
		int [] newMerged = SortingAlgorithms.mergeSort(unSorted);
		
		int [] negative = { -20,-80,-100,-1,0};
		int [] sortedN = {-100,-80,-20,-1,0};
		int [] newSorted1 = SortingAlgorithms.insertionSort(negative);
		int [] newMerged1 = SortingAlgorithms.mergeSort(negative);
		
		
		//Testing for both algorithms and its working :-)
		assertArrayEquals(newSorted,sorted);
		assertArrayEquals(newMerged,sorted);
		
		assertArrayEquals(newSorted1,sortedN);
		assertArrayEquals(newMerged,sortedN);
	}
	@Test
	void stringSortTest() {
		Comparator<String> compare =  (m1, m2) -> m2.compareTo(m1);
		
		String [] unSorted = {"Carol", "bob", "Alice"};
		String [] sorted = {"Alice","bob","Carol"};
		String [] newSorted = SortingAlgorithms.insertionSort(unSorted, compare);
		assertArrayEquals(newSorted,sorted);
		
		String [] unSorted1 = {"f","e","d","a","b","c"};
		String [] sorted1 = {"a","b","c","d","e","f"};
		String [] newSorted1 = SortingAlgorithms.insertionSort(unSorted1, compare);
		assertArrayEquals(newSorted1,sorted1);
		
	}

}