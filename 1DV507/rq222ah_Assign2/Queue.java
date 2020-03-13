package rq222ah_Assign2;

import java.util.Iterator;

public interface Queue {
	/**
	 * Return the current size of the queue
	 * 
	 * @return An integer representing the size
	 */
	public int size();

	/**
	 * Check if the queue is empty
	 * 
	 * @return true if the queue is empty else returns false
	 */
	public boolean isEmpty();

	/**
	 * Add a new element to the end of the queue
	 * 
	 * @param element A element of an object
	 */
	public void enqueue(Object element);

	/**
	 * Return and remove the first element in the queue
	 * 
	 * @return returns the first element in the queue
	 */
	public Object dequeue();

	/**
	 * Returning the first Element without removing
	 * 
	 * @return the first element from the queue
	 */
	public Object first();

	/**
	 * Returning the last Element without removing
	 * 
	 * @return the last element from the queue
	 */
	public Object last();

	/**
	 * Creates a string representing the queue
	 * 
	 * @return a string with queue-content
	 */
	public String toString(); // return a string representation of the queue content

	/**
	 * An iterator for the element
	 * 
	 * @return a new Iterator
	 */
	public Iterator<Object> iterator(); // element iterator
}
