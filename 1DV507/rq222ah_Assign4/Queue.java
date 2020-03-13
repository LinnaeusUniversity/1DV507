package rq222ah_Assign4;

import java.util.Iterator;

public interface Queue<T> {

	/**
	 * Return the current size of the queue
	 * 
	 * @return An integer representing the size
	 */
	public int size(); // current queue size

	/**
	 * Check if the queue is empty
	 * 
	 * @return true if the queue is empty else returns false
	 */
	public boolean isEmpty(); // true if queue is empty

	/**
	 * Add a new element to the end of the queue
	 * 
	 * @param element A element of an object
	 */
	public void enqueue(T element); // add element at end of queue

	/**
	 * Return and remove the first element in the queue
	 * 
	 * @return returns the first element in the queue
	 */
	public T dequeue(); // return and remove first element.

	/**
	 * Returning the first Element without removing
	 * 
	 * @return the first element from the queue
	 */
	public T first(); // return (without removing) first element

	/**
	 * Returning the last Element without removing
	 * 
	 * @return the last element from the queue
	 */
	public T last(); // return (without removing) last element

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
	public Iterator<T> iterator(); // element iterator

}
