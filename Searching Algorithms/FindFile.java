package CodingAssignment6;

import java.util.ArrayList;
import java.io.*;

public class FindFile {
	
	ArrayList<String> path = new ArrayList<>();
	private int count = 0;
	private String name;
	private String directory;
	
	// Default constructor
	public FindFile() {}
	
	// Directory search method which goes to each directory and looks for the target file.
	// It also counts how many times it appear whether in the same or different directory.
	public void directorySearch(String f, String d) throws IllegalArgumentException {// f = file, d = directory.
		File file = new File (d);
		String [] fileList = file.list();
		
		// Exception if the file name includes directory or path
		if (f.contains("\\")) {
			throw new IllegalArgumentException("Please do not include the path or directory in the file name.");
		}
		
		for (int i = 0; i < fileList.length; i++) {	
			File file2 = new File(d + fileList[i]);
			
			if (!file2.isDirectory()) {
				if (f.equals(fileList[i])) {
					path.add(d);
					count++;
				}
			}
			
			else {
				directorySearch(f, d + fileList[i]);
			}
		}
	}
	
	// Getter for ArrayList to store files
	public ArrayList<String> getFiles(){
		return path;
	}
	
	// Getter: Method to count how many files or instances of the same file exist
	public int getCount() {
		return count;
	}
}
