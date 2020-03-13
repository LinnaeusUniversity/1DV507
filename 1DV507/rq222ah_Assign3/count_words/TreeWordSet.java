package rq222ah_Assign3.count_words;

import java.util.Iterator;

public class TreeWordSet implements WordSet {
	private BST root = null;
	private int sz, count = 0;
	private Word[] arrWord = new Word[8];

	@Override
	public Iterator iterator() {

		return new TreeIterator();
	}

	@Override
	public void add(Word word) {
		if (root == null) {
			root = new BST(word);
		} else {
			root.addW(word);
			sz++;
		}

	}

	@Override
	public boolean contains(Word word) {

		return root.contains(word);
	}

	@Override
	public int size() {

		return sz;
	}

	public class BST {
		Word word;
		BST left;
		BST right;

		public BST(Word w) {
			this.word = w;
		}

		public void addW(Word w) {
			if (w.compareTo(word) < 0) { // add to left branch
				if (left == null)
					left = new BST(w);
				else
					left.addW(w); // Recursive call
			} else if (w.compareTo(word) > 0) { // add to right branch
				if (right == null)
					right = new BST(w);
				else
					right.addW(w); // Recursive call
			}

		}

		public boolean contains(Word w) {
			if (w.equals(this.word)) {
				return true;
			}
			if (w.compareTo(word) < 0) {
				if (left == null) {
					return false;
				} else
					return left.contains(w);
			} else {
				if (right == null) {
					return false;
				} else
					return right.contains(w);
			}
		}

		private void resize() {
			Word[] temp = new Word[arrWord.length * 2];
			for (int i = 0; i < arrWord.length; i++) {
				temp[i] = arrWord[i];
			}
			arrWord = temp;
		}

		public Word[] toArray() // using principle of print() from lecture slide to send Words to array
		{
			if (left != null) {
				left.toArray();
			}
			if (count == arrWord.length) {
				resize();
			}
			arrWord[count] = word;
			count++;
			if (right != null) {
				right.toArray();
			}
			return arrWord;
		}
	}

	private class TreeIterator implements Iterator<Word> {
		private int count = 0;

		public TreeIterator() {
			root.toArray();
		}

		@Override
		public boolean hasNext() {
			if (root == null) {
				return false;
			} else if (arrWord[count] == null) {
				return false;
			} else
				return count < arrWord.length;
		}

		@Override
		public Word next() {
			return arrWord[count++];
		}
	}
}
