package rq222ah_Assign3.count_words;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class HashWordSet implements WordSet {
	private final int INITIAL_SIZE = 8;
	private int size;
	private Node[] buckets = new Node[INITIAL_SIZE];

	@Override
	public void add(Word word) {
		if (contains(word)) {
			return;
		}
		int pos = getBucketNumber(word);
		Node node = new Node(word);
		node.next = buckets[pos];
		buckets[pos] = node;
		size++;

		if (size == buckets.length) {
			// System.out.println("rehash");
			rehash();
		}

	}

	public void rehash() { // ref: lecture slide 17
		Node[] temp = buckets; // Copy of old buckets
		buckets = new Node[2 * temp.length]; // New empty buckets
		size = 0;
		for (Node n : temp) { // Insert old values into new buckets
			if (n == null)
				continue; // Empty bucket
			while (n != null) {
				add(n.value); // Add elements again
				n = n.next;

			}
		}

	}

	@Override
	public boolean contains(Word word) { // lecture slides num.17
		int pos = getBucketNumber(word);
		Node node = buckets[pos];
		while (node != null) { // Search list for element
			if (node.value.equals(word))
				return true; // Found!
			else
				node = node.next;
		}
		return false; // Not found
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		Word word;
		Iterator<Word> it = iterator();
		while (it.hasNext()) {
			word = it.next();
			str.append(word.toString());
			if (it.hasNext()) {
				str.append(",");
			}
		}
		return str.toString();

	}

	private int getBucketNumber(Word str) { // ref : lecture slide no 16
		int hc = str.hashCode();
		if (hc < 0)
			hc = -hc;
		return hc % buckets.length;
	}

	class WeHash implements Iterator<Word> 
	{
		private int count;
		private Node node; 
		
		public WeHash()
		{
			count = 0;
			node = null;
		}
		
		@Override
		public boolean hasNext() 
		{  			
			if (node != null && node.next != null) //if the node Node and next node both are not empty
			{
				return true; 
			}
			
			for (int i = count; i < buckets.length; i++)
			{
				if (buckets[i] != null) //if element in buckets in position i is null then return false otherwise
				{
					return true; 
				}
			}
				return false;
		}
			
		
		@Override
		 public Word next() 
		{	
			if (!hasNext()) 
			{
				node = node.next;
			} 
			if (count == buckets.length) //throwing an exception if count is equal to length of buckets
			{
				throw new NoSuchElementException();
			}
			else 
			{
				do 
				{
					node = buckets[count++]; 
				} 
				while (node == null); //while the node is null move forward
			}
			return node.value; //return the value

		}
	}

	class Node {
		Word value;
		Node next = null;

		Node(Word data) {
			this.value = data;
			next = null;
		}
	}

	@Override
	public Iterator iterator() {
		
		return new WeHash();
	}
}
