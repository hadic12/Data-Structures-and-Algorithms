package CodingAssignment6;

public class LinearSearch extends SearchAlgorithm {
	private int index1;
	private int index2;
	private int flag = 0;
	private int foundWord = -1;

	// Iterative search method
	public int iterativeSearch(String[] words, String wordToFind) throws ItemNotFoundException {

		int index = -1;
		resetCount();

		for (int i = 0; i < words.length; i++) {
			
			if (flag == 0)
			incrementCount();
			
			if (words[i].equals(wordToFind)) {
				flag = 1;
				index = i;
			}
		}
		if (getCount() > 0) {
			return index;
		} else {
			throw new ItemNotFoundException();
		}
	}

	// Recursive search method
	public int recursiveSearch(String[] words, String wordToFind) throws ItemNotFoundException {
		if (flag == 0) {
			index1 = 0;
			index2 = words.length - 1;
			flag++;
		}
		
		// If out of bounds or item not found
		if (index1 > index2) {
			if (getCount() == 0){
				throw new ItemNotFoundException();
			}
			
			else {
				return foundWord;
			}
		}
		
		// Searching algorithm
		else if (words[index1].equals(wordToFind)) {
			incrementCount();
			foundWord = index1;
		}

		else {
			index1 += 1;
			return recursiveSearch(words, wordToFind);
		}
		return foundWord;
	}
}
