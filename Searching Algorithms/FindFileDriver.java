package CodingAssignment6;

/*
 * Driver for finding files in given directory tree
 */
public class FindFileDriver {
	public final static String DIR_NAME = "C:\\temp";

	public static void main(String[] args) {
// Finds 2
		doSearch("file5.txt", DIR_NAME);
// File does not exist
		doSearch("nosuchfile", DIR_NAME);
// Finds 3
		doSearch("file3.txt", DIR_NAME);
// Finds File with Path
		doSearch("C:\\temp\\file5.txt", DIR_NAME);
	}

	/*
	 * Search for target file starting with directory path
	 */
	private static void doSearch(String target, String dirName) {
		FindFile finder = new FindFile();
		System.out.println(" \nTarget: " + target);
		try {
			finder.directorySearch(target, dirName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(finder.getFiles());
			System.exit(0);
		}
		if (finder.getCount() == 0)
			System.out.println(target + " not found");
		else {
			System.out.println("Count = " + finder.getCount());
			System.out.println("files found at " + finder.getFiles());
		}
	}
}