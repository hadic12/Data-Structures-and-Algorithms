package CodingAssignment7;

public class LinkedListException extends RuntimeException {
	
	// Default Constructor
	public LinkedListException (){
		super(" Illegal Action ");
	}
	// Alternate Constructor
	public LinkedListException (String msg) {
		super (msg);
	}
}
