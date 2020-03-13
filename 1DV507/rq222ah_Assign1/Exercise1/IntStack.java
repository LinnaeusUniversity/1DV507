package rq222ah_Assign1.Exercise1;

public interface IntStack extends Iterable<Integer> {
	/* Add integer at top of stack. */
	public void push(int n);

	/* Returns and removes integer at top of stack */
	public int pop() throws IndexOutOfBoundsException;

	/* Returns without removing integer at top of stack */
	public int peek() throws IndexOutOfBoundsException;

	/* Number of integers currently stored. */
	public int size();

	/* Returns true if collection is empty. */
	public boolean isEmpty();

	/* String of type "[ 7 56 -45 68 ... ]" */
	public String toString();

}
