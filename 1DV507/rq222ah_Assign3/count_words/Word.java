package rq222ah_Assign3.count_words;

public class Word implements Comparable<Word>{
	
	private String word;
	
	public Word(String str) {
		word= str.toLowerCase(); //set all letters to lower case
	}
	
	public String toString() {
		return word;
	}
	
	/* Override Object methods */
	public int hashCode() {
		
		int hash= word.hashCode(); // to give to hash value from string class
		if(hash<0) {
			hash= Math.abs(hash);
			}
		return hash;
	}

	public boolean equals(Object other) {
		if(other instanceof Word) { //check if it is word-object and then check if its equal
			Word next=(Word) other;
			return word.equals(next.word);
		}
		else
			return false;
	}
	@Override
	
	/* Implement Comparable */   //compares two words lexicographically 
	public int compareTo(Word w) {
		// TODO Auto-generated method stub
		return word.compareTo(w.word);
	}
	
	

}
