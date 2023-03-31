package CodingAssignment7;

public class Stack extends List {

	// Adds to the Stack
	public void push(Object obj) throws LinkedListException {
		super.insert(obj, 0);
	}

	// Removes from the stack
	public void pop() throws LinkedListException {
		super.remove(0);
	}

	// Insert method to insert object at some index in the list
	public void insert(Object data, int index) throws LinkedListException {

		Node top = getHead();
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
		Node top = getHead();
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
		return "" + super.toString();
	}
}
