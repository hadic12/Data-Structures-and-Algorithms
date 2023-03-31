package A6;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SortDriver {
    public static boolean isSorted(ArrayList<String> words) {
        ArrayList<String> sortedWords = new ArrayList<String>();
        sortedWords.addAll(words);
        Collections.sort(sortedWords);
        boolean sorted = true;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i) != sortedWords.get(i)) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }
    
    public static boolean isSortedLength(ArrayList<String> words) {
        Comparator<String> byLength = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length())
                    return -1;
                else if (s1.length() > s2.length())
                    return 1;
                else
                    return s1.compareTo(s2);
            }
        };
        ArrayList<String> sortedWords = new ArrayList<String>();
        sortedWords.addAll(words);
        Collections.sort(sortedWords, byLength);
        boolean sorted = true;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i) != sortedWords.get(i)) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }
    static void testSorter(Sorter studentSorter) {
        System.out.println("Attempting lexicographical sort...");
        long startTime = System.currentTimeMillis();
        ArrayList<String> sortedWords1 = studentSorter.sortLexicographically();
        long endTime = System.currentTimeMillis();
        System.out.println("Checking if list is sorted: "
                + isSorted(sortedWords1));
        System.out.println("Sort took (comparisons): "
                + studentSorter.getLexComparisons());
        System.out.println("Sort took (milliseconds): " + (endTime - startTime)
                + "\n");
        System.out.println("Attempting by-length sort...");
        startTime = System.currentTimeMillis();
        
        ArrayList<String> sortedWords2 = studentSorter.sortByLength();
        endTime = System.currentTimeMillis();
        System.out.println("Checking if list is sorted: "
                + isSortedLength(sortedWords2));
        System.out.println("Sort took (comparisons): "
                + studentSorter.getLengthComparisons());
        System.out.println("Sort took (milliseconds): " + (endTime - startTime)
                + "\n");
    }
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        Scanner s = null;
        try {
            s = new Scanner(new File("C:\\Users\\hadic\\eclipse-workspace\\Class143B\\src\\A6\\unsortedwords.txt"));
        } catch (IOException e) {
            System.out.println("Couldn't read the file!");
            System.exit(1);
        }
        while (s.hasNext()) {
            words.add(s.next());
        }
        System.out.println("Successfully read " + words.size()
                + " words, proceeding to sort...\n");
        Sorter insertionSorter = new InsertionSorter(words);
        Sorter mergeSorter = new MergeSorter(words);
        Sorter quickSorter = new QuickSorter(words);
        Sorter randomQuickSorter = new QuickSorterRandomized(words);
        //Sorter bstSorter = new BinarySearchTreeSorter(words);
        System.out.println("INSERTION");
        testSorter(insertionSorter);
        System.out.println("MERGE");
        testSorter(mergeSorter);
        System.out.println("QUICK");
        testSorter(quickSorter);
        System.out.println("QUICK (RANDOMIZED)");
        testSorter(randomQuickSorter);
        //System.out.println("BST");
        //testSorter(bstSorter);
    }
}
