package rq222ah_Assign4.binheap;

public class BinaryIntHeap implements BinaryHeap<Integer> {

	private static final int default_size = 10;
	private Integer heap[];
	private int size;

	public BinaryIntHeap() {
		heap = new Integer[default_size]; // never using the first 0th element of the array
		size = 0;
	}

	@Override
	public void insert(Integer n) {
		if (size == heap.length - 1) {
			resize();
		}

		int pos = size++;

		while (pos > 1 && n.compareTo(heap[pos / 2]) > 0) {
			heap[pos] = heap[pos / 2];
			pos = pos / 2;
		}
		heap[pos] = n;

	}

	public Integer pullHighest() {
		int result = heap[1];
		heap[1] = heap[size];
		heap[size] = null;
		size--;

		return result;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return heap.length == 1;
	}

	public String toString() {
		String str = "";
		for (int i = 1; i < size; i++) {
			str += heap[i] + " ";
		}
		return str;
	}

	private void resize() {
		Integer[] tmp = new Integer[2 * heap.length];
		System.arraycopy(heap, 1, tmp, 1, heap.length - 1);
		heap = tmp;
	}

}
