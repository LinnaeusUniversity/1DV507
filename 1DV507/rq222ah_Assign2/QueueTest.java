package rq222ah_Assign2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {
	LinkedQueue qu = new LinkedQueue();
	static public int preTest = 0;

	@BeforeEach
	void setUp() throws Exception {

		preTest++;
		System.out.println("Test " + preTest);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test

	public void sizeTest() {
		qu.enqueue(11);
		qu.enqueue(12);
		qu.enqueue(1991);
		assertEquals(3, qu.size());
		qu.dequeue();
		assertEquals(2, qu.size());
	}

	@Test

	public void isEmptyTest() {
		assertTrue(qu.isEmpty());
		qu.enqueue(11);
		qu.enqueue(12);
		assertFalse(qu.isEmpty());
	}

	@Test
	public void enqueueTest() {
		qu.enqueue(1);
		qu.enqueue(2);
		qu.enqueue(3);
		assertEquals(3, qu.size());
		assertTrue(!qu.isEmpty());

	}

	@Test
	public void dequeueTest() {
		qu.enqueue(1);
		qu.enqueue(2);
		qu.enqueue(3);

		qu.dequeue();

		assertEquals(2, qu.size());

	}

	@Test
	public void firstTest() {
		qu.enqueue(1);
		qu.enqueue(2);

		assertEquals(1, qu.first());

		qu.dequeue();

		assertThrows(IndexOutOfBoundsException.class, () -> qu.first());

	}

	@Test
	public void lastTest() {
		qu.enqueue(1);
		qu.enqueue(2);
		qu.enqueue(3);

		// assertEquals(3,qu.last());
		assertThrows(IndexOutOfBoundsException.class, () -> qu.last());

	}

	@Test
	public void toStringTest() {

		assertTrue(qu.isEmpty());

		assertEquals(null, qu.toString());
	}

	@Test
	public void IteratorTest() {
		qu.enqueue(5);
		qu.enqueue(10);
		qu.enqueue(15);
		Iterator<Object> obj = qu.iterator();
		assertTrue(obj.hasNext());
	}
}
