package rq222ah_Assign4.binheap;

public interface BinaryHeap<T> {
	public void insert(T t); // Add n to heap

	public T pullHighest(); // Return and remove element with highest priority

	public int size(); // Current heap size

	public boolean isEmpty(); // True if heap is empty

}
