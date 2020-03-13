package rq222ah_Assign2;

public class QueueMain {

	public static void main(String[] args) {

		try {
			LinkedQueue que = new LinkedQueue();

			System.out.println("The queue elements are: " + que.toString());
			System.out.println("Is queue empty: " + que.isEmpty());
			for (int i = 0; i < 50; i++) {
				que.enqueue(i);
			}

			System.out.println("Get first value: " + que.first());
			System.out.println("Get last value: " + que.last());
			System.out.println("Size of queue: " + que.size());
			System.out.println("Remove first element and return it: " + que.dequeue());
			System.out.println("Size of queue: " + que.size());
			System.out.println("Remove first element and return it: " + que.dequeue());
			System.out.println("Is empty: " + que.isEmpty());
			System.out.println("Get first value: " + que.first());
			System.out.println("Get last value: " + que.last());
			System.out.println("Print the queue: " + que.toString());
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}
}
