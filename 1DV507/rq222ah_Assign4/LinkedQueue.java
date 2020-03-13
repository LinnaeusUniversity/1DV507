package rq222ah_Assign4;

import java.util.Iterator;

public class LinkedQueue<T> implements Queue<T> {
	private int size = 0;
	private Node head = null;
	private Node tail = null;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}

	public void enqueue(T element) {
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

	public T dequeue() throws NullPointerException {
		if (isEmpty()) {
			throw new NullPointerException();
		}

		Node delete = head;
		Node tmp = head.next;
		head = tmp;
		size--;
		return delete.value;
	}

	public T first() {

		return head.value;
	}

	public T last() {

		return tail.value;
	}

	public String toString() {
		Iterator<T> iterator = iterator();
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

	public Iterator<T> iterator() {

		return new listIterator();
	}

	private class listIterator implements Iterator<T> {
		private Node node = head;

		public T next() {
			T val = node.value;
			node = node.next;
			return val;
		}

		public boolean hasNext() {

			return node != null;
		}
	}

	class Node {
		T value;
		Node next = null;

		Node(T element) {
			value = element;
		}
	}
}
