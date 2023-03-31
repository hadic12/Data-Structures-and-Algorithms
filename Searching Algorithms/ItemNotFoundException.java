package CodingAssignment6;

// Custom Exception
public class ItemNotFoundException extends RuntimeException {

	// Default Constructor
	public ItemNotFoundException (){
		super(" Word not found. ");
	}
	// Alternate Constructor
	public ItemNotFoundException (String msg) {
		super (msg);
	}
}
