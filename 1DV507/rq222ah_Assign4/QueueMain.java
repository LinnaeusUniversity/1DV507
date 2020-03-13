package rq222ah_Assign4;

public class QueueMain {

	public static void main(String[] args) {

		try {
			LinkedQueue<Integer> queue = new LinkedQueue<Integer>();

			System.out.println("The Queue is: " + queue.toString());
			System.out.println("Is empty: " + queue.isEmpty());
			for (int i = 1; i <= 40; i++) {
				queue.enqueue(i);
			}

			System.out.println("The queue is: " + queue.toString());
			System.out.println("Get first value: " + queue.first());
			System.out.println("Get last value: " + queue.last());
			System.out.println("Size of the queue: " + queue.size());
			System.out.println("Remove first element and return it: " + queue.dequeue());
			System.out.println("Size of queue: " + queue.size());
			System.out.println("Is the queue empty: " + queue.isEmpty());
			System.out.println("Get first value: " + queue.first());
			System.out.println("Get last value: " + queue.last());
			System.out.println("Print the queue: " + queue.toString());

		}

		catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
	}
}
