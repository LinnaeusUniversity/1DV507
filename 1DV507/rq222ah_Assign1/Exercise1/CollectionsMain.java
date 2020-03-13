package rq222ah_Assign1.Exercise1;

public class CollectionsMain {

	public static void main(String[] args) {
		ArrayIntList list = new ArrayIntList();
		list.add(1);
		list.add(3);
		list.add(4);

		try {

			list.addAt(2, 1);

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Ooops");
		}

		System.out.println(list.toString());
		System.out.println(list.size());
		System.out.println();

		list.remove(1);
		System.out.println(list.toString());
		System.out.println(list.size());
		System.out.println();

		try {

			System.out.println(list.get(1));
			System.out.println();

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Ooops");
		}

		System.out.println("Index of Given no. is " + list.indexOf(3));

		System.out.println();

		ArrayIntStack stack = new ArrayIntStack();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.toString());

		System.out.println();
		try {

			System.out.println(stack.pop());

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Ooops");
		}
		System.out.println();
		try {

			System.out.println(stack.peek());

		} catch (IndexOutOfBoundsException e) {
			System.out.println("Ooops");
		}

	}

}
