package CodingAssignment6;

/**
 * Linear and Binary Search Homework 5 Driver
 * CSS 143
 * updated 2/5/2021
 * 
 * Note that nothing in this class needs to be changed except for your 
FILE_AND_PATH variable
 * You may temporarily uncomment the linear recursive call to see what happens
 * 
 * Implement the Binary Search using both the iterative and recursive techniques 
covered
 * in class
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinSearchDriver {
	public final static String FILE_AND_PATH = "C:\\Users\\hadic\\eclipse-workspace\\Misc\\src\\CodingAssignment6\\longwords.txt";
	/*
	 * TODO: Be sure to change the FILE_AND_PATH to point to your local copy of
	 * longwords.txt or a FileNotFoundException will result
	 */
//Note how we deal with Java's Catch-or-Declare rule here by declaring the exceptions we might throw

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(FILE_AND_PATH));
		ArrayList<String> theWords = new ArrayList<String>();
//read in words
		while (input.hasNext()) {
			theWords.add(input.next());
		}
//make a standard array from an ArrayList
		String[] wordsToSearch = new String[theWords.size()];
		theWords.toArray(wordsToSearch);
//start with the linear searches
		System.out.println("\n+++ Linear Search +++++");
		tryLinearSearch(wordsToSearch, "DISCIPLINES");
		tryLinearSearch(wordsToSearch, "TRANSURANIUM");
		tryLinearSearch(wordsToSearch, "HEURISTICALLY");
		tryLinearSearch(wordsToSearch, "FOO");
//and compare these results to the binary searches
		System.out.println("\n+++ Binary Search +++++");
		tryBinarySearch(wordsToSearch, "DISCIPLINES");
		tryBinarySearch(wordsToSearch, "TRANSURANIUM");
		tryBinarySearch(wordsToSearch, "HEURISTICALLY");
		tryBinarySearch(wordsToSearch, "FOO");
	}

	/**
	 * Method tryBinarySearch precondition: wordsToSearch is a nonempty array of
	 * Strings, and target is a non-null string to search for in our collection of
	 * strings postcondition: Uses a BinarySearch object (which implements this
	 * style of search) to try to find the target string
	 */
	private static void tryBinarySearch(String[] wordsToSearch, String target) {
//TODO: Build a LinearSearch class that inherits from SearchAlgorithm, and put it in the same directory as this class to successfully compile
		SearchAlgorithm binSearch = new BinarySearch();
		try {
			System.out.print("  " + target + " found at index: " + binSearch.iterativeSearch(wordsToSearch, target));
			System.out.println(" taking " + binSearch.getCount() + "comparisons.");
			System.out.print("  " + target + " found at index: " + binSearch.recursiveSearch(wordsToSearch, target));
			System.out.println(" taking " + binSearch.getCount() + "comparisons.");
		} catch (ItemNotFoundException e) {
			System.out.println("  " + target + ":" + e.getMessage());
		}
	}

	/**
	 * Method tryLinearSearch precondition: wordsToSearch is a nonempty array of
	 * Strings, and target is a non-null string to search for in our collection of
	 * strings postcondition: Uses a LinearSearch object to try to find the target
	 * string
	 */
	private static void tryLinearSearch(String[] wordsToSearch, String target) {
//TODO: Build a LinearSearch class that inherits from SearchAlgorithm, and put it in the same directory as this class to successfully compile
		SearchAlgorithm linSearch = new LinearSearch();
		try {
			System.out.print(target + " found at index: " + linSearch.iterativeSearch(wordsToSearch, target));
			System.out.println(" taking " + linSearch.getCount() + "comparisons.");
// This may be problematic, but try it once to see what happens
//			System.out.print( target + " found at index: " + linSearch.recursiveSearch(wordsToSearch,target));
// 			System.out.println( " taking " + linSearch.getCount() + "comparisons.");
		} catch (ItemNotFoundException e) {
			System.out.println(target + ":" + e.getMessage());
		}
	}
}
