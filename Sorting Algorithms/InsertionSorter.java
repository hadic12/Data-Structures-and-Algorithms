package A6;

import java.util.ArrayList;

public class InsertionSorter extends Sorter {
	public InsertionSorter(ArrayList<String> words) {
		super(words);
	}

	//@Override
	public ArrayList<String> sortLexicographically() {
		ArrayList<String> a = getUnsortedWords();
		long count = 0;
		
		for (int i = 1; i < a.size(); i++) {// Outer loop to iterate through the array
			String temp = a.get(i);// Current variable/temporary variable storage
			int j = i - 1;

			while (j >= 0 && temp.compareTo(a.get(j)) < 0) {// Inner loop to run the sort algorithm
				count++;
				a.set(j + 1, a.get(j));
				j--;
			}

			a.set(j + 1, temp);// Placing temp at its right position
		}
		
		setLexComparisons(count);
		setUnsortedWords(a);
		return getUnsortedWords();
	}

	//@Override
	public ArrayList<String> sortByLength() {// Same algorithm as above but runs on a different attribute
		ArrayList<String> a = getUnsortedWords();
		long count = 0;

		for (int i = 1; i < a.size(); i++) {
			String temp = a.get(i);
			int j = i - 1;

			while (j >= 0 && temp.length() < a.get(j).length()) {
				count++;
				a.set(j + 1, a.get(j));
				j--;
			}

			a.set(j + 1, temp);
		}

		setLengthComparisons(count);
		setUnsortedWords(a);
		return getUnsortedWords();
	}
}
