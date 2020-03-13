package rq222ah_Assign1.Exercise1;

public class ArrayIntList extends AbstractIntCollection implements IntList {

	@Override
	public void add(int n) {
		values[size++] = n;
		// size++;

	}

	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {

		if (index > size)
			throw new IndexOutOfBoundsException("Oops");
		else
			super.size++;

		for (int i = size - 1; i > index; i--) {
			values[i] = values[i - 1];
		}
		values[index] = n;
	}

	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		try {
			for (int i = index; i < size; i++) {
				values[i] = values[i + 1];
			}
			size--;

		} catch (Exception e) {

		}
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		if (index > size)
			throw new IndexOutOfBoundsException("Oops");
		else
			return values[index];
	}

	@Override
	public int indexOf(int n) {
		boolean contains = false;
		int num = 0;

		for (int i = 0; i < size; i++) {
			if (n == values[i]) {
				contains = true;
				num = i;
			}
		}

		if (contains)
			return num;
		else
			return -1;

	}

}
