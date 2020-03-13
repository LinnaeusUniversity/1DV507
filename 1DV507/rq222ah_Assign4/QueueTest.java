package rq222ah_Assign4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {

	public void testSize() {
		// Create an empty queue and check it
		LinkedQueue<Integer> queue1 = new LinkedQueue<Integer>();
		assertEquals(true, queue1.isEmpty());

		// Create a filled queue and test its Size
		LinkedQueue<Integer> queue2 = build(50);
		assertEquals(false, queue2.isEmpty());
		assertEquals(50, queue2.size());

		// Extreme test
		LinkedQueue<Integer> queue3 = build(8000000);
		assertEquals(8000000, queue3.size());

	}

	private LinkedQueue<Integer> build(int s) {
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		for (int i = 0; i < s; i++) {
			queue.enqueue(i);
		}
		return queue;

	}
}
