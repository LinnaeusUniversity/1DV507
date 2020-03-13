package rq222ah_Assign3.count_words;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class IdentyfyWordsMain {
	
   	public static void main(String[] args) {
   		String test="";
   		test= readFile(args[0]);
		printFile(test);
		
		//String word="";
		//System.out.println("Does it exit? "+ file.exists());
   	}
		public static String readFile(String path) {
			String word="";
		try {
			
				File file= new File(path);
				Scanner sc=new Scanner(file);
				while(sc.hasNext()) {
					String text=sc.next()+" ";
					//char[] ch=text.toCharArray();
					for(int i=0;i<text.length();i++) {
						char ch=text.charAt(i);
						if(Character.isLetter(ch) || Character.isWhitespace(ch)) {
							word+=ch;
						}
					}
				}
				sc.close();
				
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		return word;
	}
   	
   	
   	public static void printFile(String outptString) {		
		try { 
			File outFile = new File("C:/Users/MY PC/Desktop/words.txt"); //Create a new File
			PrintWriter printer = new PrintWriter(outFile); //new PrintWriter
			printer.print(outptString); //print the text to the file
			System.out.print("File printed!");
			printer.close ();
			} catch (IOException e) {
		e.printStackTrace ();
		}
}	

}
