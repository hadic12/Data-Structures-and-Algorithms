package CodingAssignment7;


public class ListDriver {
	public static void main(String[] args) {
		List empty = new List();
		List one = new List();
		List multiple = new List();
		try {
			one.insert(5, 0);
			multiple.insert(10, 0);
			multiple.insert(20, 0);
			multiple.insert(30, 0);
			System.out.println("Empty:" + empty);
			System.out.println("One:" + one);
			System.out.println("Multiple:" + multiple);
			one.remove(0);
			multiple.remove(1);
			System.out.println("One (upon remove 1):" + one);
			System.out.println("Multiple (upon remove):" + multiple);
			//one.insert(600, 1);// Uncomment to test this, and comment to test rest of the program.
			multiple.insert(400, 2);
			System.out.println("One (on insert at 1):" + one);
			System.out.println("Multiple(on insert at 2):" + multiple);
// test error
			empty.remove(3);
		} catch (LinkedListException e) {
			System.out.println(e.getMessage());
		}
	}
}

