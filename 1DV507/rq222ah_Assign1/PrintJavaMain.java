package rq222ah_Assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class PrintJavaMain {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			printAllJavaFiles("C:\\eclipse\\Java_courses\\1DV507\\src");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static int depth = 1, count = 0, folders = 0;

	public static void printAllJavaFiles(String directory) throws IOException {
		File file = new File(directory);
		if (file.exists()) {
			System.out.println("Reading java files from directory: " + file);
			visitSub(file);
		} else
			System.err.println("Can't find directory: " + file);
	}

	private static void visitSub(File file) throws IOException {

		if (file.isDirectory()) {
			printDir(file);
			depth++;
			File[] subs = file.listFiles();
			for (File f : subs) {
				if (lookForJava(f) == true) {

					printOnlyJava(f);
				}
				visitSub(f);
			}
			depth--;
		}

	}

	/* Print java files */
	private static void printOnlyJava(File f) throws IOException {
		StringBuffer java = new StringBuffer();
		for (int i = 0; i < folders; i++)
			java.append(" ");
		System.out.println((++count) + " " + java.toString() + f.getName() + " {Size: " + countLines(f) + "}");
	}

	private static void printDir(File file) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < depth; i++)
			buf.append(" ");
		System.out.println((++count) + buf.toString() + file.getName());
	}

	/* Check if file is .java file */
	private static boolean lookForJava(File f) {
		String name = f.getName();
		char ch = '.';
		int dot = name.lastIndexOf(ch);
		if (dot != -1 && dot != 0) {
			String java = name.substring(dot);
			return java.equals(".java");
		}
		return false;
	}

	/* Count the lines */
	private static int countLines(File f) throws IOException {
		int line = 0;
		FileReader reader = new FileReader(f);
		LineNumberReader lineCounter = new LineNumberReader(reader);
		while (lineCounter.readLine() != null) {
			line++;
		}
		lineCounter.close();
		return line;
	}
}
