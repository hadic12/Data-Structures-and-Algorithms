package CodingAssignment7;

import CodingAssignment7.List.Node;

public class Queue extends List {

	// Adds to the Queue
	public void enqueue(Object object) throws LinkedListException {

		if (super.size() > 0) {
			super.insert(object, super.size() + 1);
		}

		else {
			super.insert(object, super.size());
		}
	}

	// Removes from the Queue
	public void dequeue() throws LinkedListException {
		super.remove(0);
	}

	// Insert method to insert object at some index in the list
	public void insert(Object data, int index) throws LinkedListException {

		Node head = getHead();
		Node node = new Node();
		node.data = data;
		node.next = null;
		Node current = head;

		if (index == 0) {
			if (head == null) {
				head = node;
			}

			else {
				node.next = head;
				head = node;
			}

			return;
		}

		if (index > 0) {
			if (head == null) {
				throw new LinkedListException();
			}

			else {
				for (int i = 0; i < index - 1; i++) {
					if (current.next != null) {
						current = current.next;
					}
				}

				if (current == head) {
					head.next = node;
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
		return "Queue: " + super.toString();
	}
}
