package CodingAssignment7;

public class List {

	private Node top;

	public class Node {
		Object data;
		Node next;
	}

	// Default constructor
	public List() {
		top = null;
	}
	
	public Node getHead() {
		return top;
	}
	// Gets the size of the list
	public int size() {

		int size = 0;
		Node current = top;

		while (current != null) {
			size++;
			current = current.next;
		}

		return size;// return the size
	}

	// Insert method to insert object at some index in the list
	public void insert(Object data, int index) throws LinkedListException {

		Node node = new Node();
		node.data = data;
		node.next = null;
		Node current = top;

		if (index == 0) {
			if (top == null) {
				top = node;
			}

			else {
				node.next = top;
				top = node;
			}

			return;
		}

		if (index > 0) {
			if (top == null) {
				throw new LinkedListException();
			}

			else {
				for (int i = 0; i < index - 1; i++) {
					if (current.next != null) {
						current = current.next;
					}
				}

				if (current == top) {
					top.next = node;
				}

				else {

					try {
						node.next = current.next;
						current.next = node;
					}

					catch (Exception e) {
						throw new LinkedListException();
					}
				}
			}

			return;
		}
	}

	// Remove target index
	public void remove(int index) throws LinkedListException {
		Node current = top;

		if (index > 0) {
			if (top == null) {
				throw new LinkedListException();
			}

			else {
				for (int i = 0; i < index - 1; i++) {

					try {
						current = current.next;
					}

					catch (Exception e) {
						throw new LinkedListException();
					}
				}

				current.next = current.next.next;
			}
		}

		if (index == 0) {

			if (top == null) {

				throw new LinkedListException();
			} else {

				top = top.next;
			}

			return;
		}
	}

	// ToString method
	public String toString() {
		String s = "";
		Node current = top;

		while (current != null) {
			s = s + " " + current.data;
			current = current.next;
		}

		return s;
	}

	//Checks whether the list is empty.
	public boolean isEmpty() {
		if (top == null) {
			return true;
		}

		else {
			return false;
		}
	}

	// Targets specific index
	public int indexOf(Object target) throws LinkedListException {
		Node trav = top;

		for (int i = 0; i < size() - 1; i++) {
			if (trav.data == target) {
				return i;
			}

			else {
				return -1;
			}
		}

		return 1;
	}
	
	//Adds to end
	public void addtoend(Object data) throws LinkedListException {	
		
		Node node = new Node();
		node.data = data;// set the nodes data
		node.next = null;// set next as null
		Node current = top;
		
		for (int i = 0; i < size() - 1; i++)
		{
			try {
				current = current.next;
			}
			catch (Exception e)
			{
				throw new LinkedListException();

			}
		}
		if (current == top)// insert at 2 position
		{
			top.next = node;
		}
		else {
			try {
				current.next = node;
			}
			catch (Exception e)
			{
				throw new LinkedListException();
			}
		}
	}
}