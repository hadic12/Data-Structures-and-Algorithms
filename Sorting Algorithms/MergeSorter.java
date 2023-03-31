package A6;

import java.util.ArrayList;

public class MergeSorter extends Sorter {
	public MergeSorter(ArrayList<String> words) {
		super(words);
	}

	//@Override
	public ArrayList<String> sortLexicographically() {
		ArrayList<String> a = getUnsortedWords();
		int n = a.size();
		ArrayList<String> temp = new ArrayList<>(n);// temporary Array List that holds the original Array List
		
		for(int i = 0; i < n; i++) {
			temp.add(null);
		}
		
		int stepSize = 1;
		
		while (stepSize < n) {// While the array is empty or must be empty for the loop to begin.
			int left = 0;
			
			while ((left + stepSize) < n) {
				int mid = (left + stepSize) - 1;
				int right = Math.min(n - 1, left + 2 * stepSize - 1);
				mergeLex(a, temp, left, mid, right);
				left += 2 * stepSize;
			}
			
			stepSize *= 2;
		}
		
		setUnsortedWords(a);
		return getUnsortedWords();
	}
	
	public void mergeLex(ArrayList<String> list, ArrayList<String> t, int left, int mid, int right) {
		int i = left;// index for smaller values
		int j = mid + 1;// index for larger values
		int k = left;// Starting index, used to iterate over temp
		long count = getLexComparisons();
		
		while (i <= mid && j <= right) {
			count++;
			if (list.get(i).compareTo(list.get(j)) <= 0) {
				t.set(k++, list.get(i++));
			}
			
			else {
				t.set(k++, list.get(j++));
			}
		}
		
		setLexComparisons(count);
		
		while (i <= mid) {// Copying remaining elements from left to mid
			t.set(k++, list.get(i++));
		}
		
		while (j <= right) {// Copying remaining elements from mid + 1 to right
			t.set(k++, list.get(j++));
		}
		
		for (int m = left; m <= right; m++) {// Updating list
			list.set(m, t.get(m));
		}
	}
	
	public void mergeLength(ArrayList<String> list, ArrayList<String> t, int left, int mid, int right) {
		int i = left;// index for smaller values
		int j = mid + 1;// index for larger values
		int k = left;// Starting index, used to iterate over temp
		long count = getLengthComparisons();
		
		while (i <= mid && j <= right) {
			count++;
			if (list.get(i).length() <= list.get(j).length()) {
				t.set(k++, list.get(i++));
			}
			
			else {
				t.set(k++, list.get(j++));
			}
		}
		
		setLengthComparisons(count);
		
		while (i <= mid) {// Copying remaining elements from left to mid
			t.set(k++, list.get(i++));
		}
		
		while (j <= right) {// Copying remaining elements from mid + 1 to right
			t.set(k++, list.get(j++));
		}
		
		for (int m = left; m <= right; m++) {// Updating List
			list.set(m, t.get(m));
		}
	}
	
	//@Override
    public ArrayList<String> sortByLength() {
        
		ArrayList<String> a = getUnsortedWords();
		int n = a.size();
		ArrayList<String> temp = new ArrayList<>(n);
		
		for(int i = 0; i < n; i++) {// Added null to empty spaces
			temp.add(null);
		}
		
		int stepSize = 1;
		
		while (stepSize < n) {// Sorting algorithm
			int left = 0;
			
			while ((left + stepSize) < n) {
				int mid = (left + stepSize) - 1;
				int right = Math.min(n - 1, left + 2 * stepSize - 1);
				mergeLength(a, temp, left, mid, right);
				left += 2 * stepSize;
			}
			
			stepSize *= 2;
		}

		setUnsortedWords(a);
		return getUnsortedWords();
    }
}
