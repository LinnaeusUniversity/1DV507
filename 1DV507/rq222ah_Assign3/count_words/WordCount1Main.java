package rq222ah_Assign3.count_words;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount1Main {

	public static void main(String[] args) throws FileNotFoundException {
		HashSet<Word> hs = new HashSet<Word>(); //Setting up set for Hash and Tree
		TreeSet<Word> ts = new TreeSet<Word>(); 
		
		try {
			File file = new File("C:/Users/MY PC/Desktop/words.txt");//Open the file we created in IdentyfyWords
			Scanner scan = new Scanner(file);
			
			while(scan.hasNext()) {
				String str = scan.next(); //Scan word by word and create an object for each and add to the sets
				Word word = new Word(str);
				hs.add(word); 
				ts.add(word);
				}
			
			scan.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Printing the size, 349, pretty close to 350
		System.out.println("HashSet size: " + hs.size()); 
		System.out.println("TreeSet size: " + ts.size());
		System.out.println(hs);
		System.out.println(ts);
		
		/*Iterator<Word> iterator;
		iterator = ts.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}*/
		
		
			
		

	}

}
