package A6;

import java.util.ArrayList;

public abstract class Sorter {
	private ArrayList<String> unsortedWords;
	private long lexComparisons;
	private long lengthComparisons;

	Sorter(ArrayList<String> words) {
		setUnsortedWords(words);
		setLexComparisons(0);
		setLengthComparisons(0);
	}

	public ArrayList<String> getUnsortedWords() {
		return unsortedWords;
	}

	public void setUnsortedWords(ArrayList<String> unsortedWords) {
		// Want to ensure this is a "deep" copy and not a "shallow" copy
		ArrayList<String> newWords = new ArrayList<String>();
		newWords.addAll(unsortedWords);
		this.unsortedWords = newWords;
	}

	public long getLexComparisons() {
		return lexComparisons;
	}

	public void setLexComparisons(long lexComparisons) {
		this.lexComparisons = lexComparisons;
	}

	public long getLengthComparisons() {
		return lengthComparisons;
	}

	public void setLengthComparisons(long lengthComparisons) {
		this.lengthComparisons = lengthComparisons;
	}

	public abstract ArrayList<String> sortLexicographically();

	public abstract ArrayList<String> sortByLength();
}
