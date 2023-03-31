package CodingAssignment6;

public class BinarySearch extends SearchAlgorithm {
	// Variables
	private int index1;
	private int index2;
	private int foundWord = -1;
	private int left = 0;
	private int right;
	private int mid;
	private int index = -1;
	private int flag = 0;
	private int temp;

	// Iterative search method
	public int iterativeSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		// Variables to set default values 
		index1 = 0;
		index2 = words.length;
		// reset
		resetCount();
		int left = 0, right = words.length;
		index = -1;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			incrementCount();

			// Check if x is present at mid
			// System.out.println(words[mid]+wordToFind);
			if (words[mid].equals(wordToFind)) {
				index = mid;
			}
			// If x greater, ignore left half
			if (words[mid].compareTo(wordToFind) < 0) {
				left = mid + 1;
			}
			// If x is smaller, ignore right half
			else {
				right = mid - 1;
			}
		}

		// If we reach here, then element was not present
		if (getCount() < 1) {
			throw new ItemNotFoundException("Word Not Found");
		} else {

			return index;
		}
	}

	// Recursive method
	public int recursiveSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		
		if (flag == 0) {
    		resetCount();
    		flag = 1; 
    		index = -1;
    		left = 0;
    		right = words.length;
    		temp = 0;
    	}
		
    	mid = (left + right) / 2;
    	
    	//Incrementing if found
    	if (temp == 0) {
    		incrementCount();
    	}
    	
    	// Exception for item not found
    	if (right < left) {
    		if (getCount() < 1) {
				throw new ItemNotFoundException("Word Not Found");
			} else {
	
				return index;
			}
		}
    	
    	// Searching algorithm
    	if (words[mid].equals(wordToFind)) {
    		index = mid;
    		temp++;
		}
    	
    	if (words[mid].compareTo(wordToFind) < 0) {
    		left = mid + 1;
			return recursiveSearch(words, wordToFind);
		}
    	else {
    		right = mid - 1;
    		return recursiveSearch(words, wordToFind);
		}
	}
}
