package rq222ah_Assign1.Exercise1;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

	@Override
	public void push(int n) {
		if (size < 8)
			values[size++] = n;
	}

	@Override
	public int pop() throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Ooops");
		} else {
			int num = values[size - 1];
			values[size - 1] = 0;
			size--;
			return num;
		}
	}

	@Override
	public int peek() throws IndexOutOfBoundsException {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("Ooops");
		} else
			return values[size - 1];
	}

}
