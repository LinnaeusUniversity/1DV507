package rq222ah_Assign4.binheap;

public class BinaryIntHeapMain {

	public static void main(String[] args) {

		BinaryIntHeap heap = new BinaryIntHeap();

		System.out.println("Is the heap empty: " + heap.isEmpty());
		int insertElement = 0;
		for (int i = 1; i < 24; i++) {
			insertElement = (int) (Math.random() * 25) + 1;
			heap.insert(insertElement);
		}
		System.out.println("The heap is: " + heap.toString());
		System.out.println("Highest priority element: " + heap.pullHighest());
		System.out.println("The heap is: " + heap.toString());
	}

}
