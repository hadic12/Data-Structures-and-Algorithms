package A6;

import java.util.ArrayList;

public class QuickSorter extends Sorter {
	public QuickSorter(ArrayList<String> words) {
		super(words);
	}
	
	//Quick sort with last index
	public void quickSortLex(ArrayList<String> b) {
		int n = b.size();
		ArrayList<Integer> stack = new ArrayList<Integer>();// Temporary ArrayList for storing indexes
		stack.add(0);
		stack.add(n - 1);
		while (!stack.isEmpty()) {
			int high = stack.remove(stack.size() - 1);
			int low = stack.remove(stack.size() - 1);
			int pi = partitionLex(b, low, high);
			if (pi - 1 > low) {
				stack.add(low);
				stack.add(pi - 1);
			}
			if (pi + 1 < high) {
				stack.add(pi + 1);
				stack.add(high);
			}
		}
	}

	//Division method
	public int partitionLex(ArrayList<String> t, int start, int end) {// Returns a pivot for a sub sorted array
		String pivot = t.get(end);// Selecting the last index as pivot
		int i = start - 1;
		long count = getLexComparisons();

		for (int j = start; j < end; j++) {
			count++;

			if (t.get(j).compareTo(pivot) <= 0) {
				i++;
				String temp = t.get(i);
				t.set(i, t.get(j));
				t.set(j, temp);
			}
		}

		setLexComparisons(count);
		String temp2 = t.get(i + 1);
		t.set(i + 1, t.get(end));
		t.set(end, temp2);
		return i + 1;
	}

	//Alternative quicksort
	public void quickSortLength(ArrayList<String> b) {
		int n = b.size();
		ArrayList<Integer> stack = new ArrayList<Integer>();
		stack.add(0);
		stack.add(n - 1);
		while (!stack.isEmpty()) {
			int high = stack.remove(stack.size() - 1);
			int low = stack.remove(stack.size() - 1);
			int pi = partitionLength(b, low, high);
			if (pi - 1 > low) {
				stack.add(low);
				stack.add(pi - 1);
			}
			if (pi + 1 < high) {
				stack.add(pi + 1);
				stack.add(high);
			}
		}
	}

	//Alternative division
	public int partitionLength(ArrayList<String> t, int start, int end) {
		String pivot = t.get(end);
		int i = start - 1;
		long count = getLengthComparisons();

		for (int j = start; j < end; j++) {
			count++;

			if (t.get(j).length() <= pivot.length()) {
				i++;
				String temp = t.get(i);
				t.set(i, t.get(j));
				t.set(j, temp);
			}
		}

		setLengthComparisons(count);
		String temp2 = t.get(i + 1);
		t.set(i, t.get(end));
		t.set(end, temp2);
		return i + 1;
	}

	//@Override
	public ArrayList<String> sortLexicographically() {
		ArrayList<String> a = getUnsortedWords();
		quickSortLex(a);
		setUnsortedWords(a);
		return getUnsortedWords();
	}

	//@Override
	public ArrayList<String> sortByLength() {
		ArrayList<String> a = getUnsortedWords();
		quickSortLength(a);
		setUnsortedWords(a);
		return getUnsortedWords();
	}
}