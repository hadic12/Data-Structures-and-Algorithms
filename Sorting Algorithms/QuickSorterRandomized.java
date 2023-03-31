package A6;

import java.util.ArrayList;
import java.util.Random;

public class QuickSorterRandomized extends Sorter {
	public QuickSorterRandomized(ArrayList<String> words) {
		super(words);
	}
	
	// Quiksort method
	public void randomQuickSortLex(ArrayList<String> b) {
		int n = b.size();
		ArrayList<Integer> stack = new ArrayList<Integer>();
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

	// Division method for Quicksort
	public int partitionLex(ArrayList<String> t, int start, int end) {
		Random r = new Random();
		int pivotIndex = r.nextInt(end - start + 1) + start;
		String pivot = t.get(pivotIndex);
		int i = start - 1;
		long count = getLexComparisons();
		
		String tru = t.get(pivotIndex);
		t.set(pivotIndex, t.get(end));
		t.set(end, tru);

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
	
	// Alternative quicksort method
	public void randomQuickSortLength(ArrayList<String> b) {
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
	
	// Alternative division
	public int partitionLength(ArrayList<String> t, int start, int end) {
		Random r = new Random();
		int pivotIndex = r.nextInt(end - start + 1) + start;
		String pivot = t.get(pivotIndex);
		int i = start - 1;
		long count = getLengthComparisons();
		
		String tru = t.get(pivotIndex);
		t.set(pivotIndex, t.get(end));
		t.set(end, tru);
		
		for (int j = start; j < end; j++) {
			count++;

			if (t.get(j).length() < pivot.length() || ((t.get(j).length() == pivot.length()) && t.get(j).compareTo(pivot) < 0)) {
				i++;
				String temp = t.get(i);
				t.set(i, t.get(j));
				t.set(j, temp);
			}
		}

		setLengthComparisons(count);
		String temp2 = t.get(i + 1);
		t.set(i + 1, t.get(end));
		t.set(end, temp2);
		return i + 1;
	}

	//@Override
	public ArrayList<String> sortLexicographically() {
		ArrayList<String> a = getUnsortedWords();
		randomQuickSortLex(a);
		setUnsortedWords(a);
		return getUnsortedWords();
	}

	//@Override
	public ArrayList<String> sortByLength() {
		ArrayList<String> a = getUnsortedWords();
		randomQuickSortLength(a);
		setUnsortedWords(a);
		return getUnsortedWords();
	}
}
