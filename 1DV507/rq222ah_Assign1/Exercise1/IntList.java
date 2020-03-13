package rq222ah_Assign1.Exercise1;

/* A simple interface describing an integer list. 
 */

public interface IntList extends Iterable<Integer> {
	/* Add integer n to the end of the list. */
	public void add(int n);

	/*
	 * Inserts integer n at position index. Shifts the element currently at that
	 * position (if any) and any subsequent elements to the right.
	 */
	public void addAt(int n, int index) throws IndexOutOfBoundsException;

	/* Remove integer at position index. */
	public void remove(int index) throws IndexOutOfBoundsException;

	/* Get integer at position index. */
	public int get(int index) throws IndexOutOfBoundsException;

	/* Number of integers currently stored. */
	public int size();

	/* Returns true if collection is empty. */
	public boolean isEmpty();

	/* Find position of integer n, otherwise return -1 */
	public int indexOf(int n);

	/* String of type "[ 7 56 -45 68 ... ]" */
	public String toString();
}
