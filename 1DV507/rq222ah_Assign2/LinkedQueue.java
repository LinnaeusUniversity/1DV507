package rq222ah_Assign2;

import java.util.*;

public class LinkedQueue implements Queue {

	private int size = 0;
	private Node head = null;
	private Node tail = null;

	/**
	 * 
	 * @return the size of the queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Check if the queue is empty
	 * 
	 * @return true if the queue is empty else returns false
	 */

	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Add a new element to the end of the queue
	 * 
	 * @param element A element of an object
	 */

	public void enqueue(Object element) {
		if (head == null) {
			head = new Node(element);
			tail = head;
			size++;
		} else {
			tail.next = new Node(element);
			tail = tail.next;
			size++;
		}
	}

	/*
	 * @throws NullPointerExceptionS
	 * 
	 * @Override
	 */
	// return and remove the first element from the queue
	public Object dequeue() throws NullPointerException {
		if (isEmpty()) {
			throw new NullPointerException();
		}

		/*
		 * Node tmp = head; Node delete = head.next; head = delete; size--; return
		 * tmp.value;
		 */

		Node delete = head;
		Node proceed = head.next;
		head = proceed;
		size--;
		return delete.value;

	}

	/**
	 * Returning the first Element without removing
	 * 
	 * @return the first element from the queue
	 */
	public Object first() {
		return head.value;
	}

	/**
	 * Returning the last Element without removing
	 * 
	 * @return the last element from the queue
	 */
	public Object last() {
		return tail.value;
	}

	/**
	 * Creates a string representing the queue
	 * 
	 * @return a string with queue-content
	 */
	public String toString() {
		Iterator<Object> iterator = iterator();
		StringBuilder str = new StringBuilder();
		str.append("[");
		while (iterator.hasNext()) {
			str.append(iterator.next());
			if (iterator.hasNext() != false) {
				str.append(",");
			}

		}
		str.append("]");
		return str.toString();
	}

	/**
	 * An iterator for the element
	 * 
	 * @return a new Iterator
	 */

	public Iterator<Object> iterator() {
		return new listIterator();
	}

	private class listIterator implements Iterator<Object> {
		private Node node = head;

		public Object next() {
			Object val = node.value;
			node = node.next;
			return val;
		}

		public boolean hasNext() {
			return node != null;
		}
	}

	/**
	 * This a class 'Node' which is of private type
	 * 
	 * @author Rashed Qazizada
	 */

	private class Node {
		Object value = 0;
		Node next = null;

		Node(Object element) {
			this.value = element;
		}
	}

}
