package CodingAssignment7;

public class StackQueueDriver {

	public static void main(String[] args) throws LinkedListException {
		
		List emptylist = new List();
		List onelist = new List();
		List multiplelist = new List();

		// Tests for Stack and Queue Classes
		try {
			onelist.insert(5, 0);
			multiplelist.insert(10, 0);
			multiplelist.insert(20, 0);
			multiplelist.insert(30, 0);

			System.out.println("--------List---------");
			
			System.out.println("Empty:" + emptylist);
			System.out.println("One:" + onelist);
			System.out.println("Multiple:" + multiplelist);

			onelist.remove(0);
			multiplelist.remove(1);
			System.out.println("One (upon remove 1):" + onelist);
			System.out.println("Multiple (upon remove):" + multiplelist);

			onelist.insert(600, 1);
			multiplelist.insert(400, 2);
			System.out.println("One (on insert at 1):" + onelist);
			System.out.println("Multiple(on insert at 2):" + multiplelist);

			// test error
			emptylist.remove(3);
		} catch (LinkedListException e) {
			System.out.println(e.getMessage());
		}


		
		Stack emptystack = new Stack();
		Stack onestack = new Stack();
		Stack multiplestack = new Stack();

		try {
			onestack.push(5);
			multiplestack.push(10);
			multiplestack.push(20);
			multiplestack.push(30);
			
			System.out.println("--------Stack---------");

			System.out.println("Empty:" + emptystack);
			System.out.println("One:" + onestack);
			System.out.println("Multiple:" + multiplestack);

			onestack.pop();
			multiplestack.pop();
			System.out.println("One (upon pop):" + onestack);
			System.out.println("Multiple (upon pop):" + multiplestack);

			onestack.push(600);
			multiplestack.push(400);
			System.out.println("One (on push):" + onestack);
			System.out.println("Multiple(on push):" + multiplestack);

			// test error
			emptystack.pop();
		} catch (LinkedListException e) {
			System.out.println(e.getMessage());
		}


		Queue emptyqueue = new Queue();
		Queue onequeue = new Queue();
		Queue multiplequeue = new Queue();

		try {
			onequeue.enqueue(5);
			multiplequeue.enqueue(10);
			multiplequeue.enqueue(20);
			multiplequeue.enqueue(30);
			
			System.out.println("--------Queue---------");

			System.out.println("Empty:" + emptyqueue);
			System.out.println("One:" + onequeue);
			System.out.println("Multiple:" + multiplequeue);

			onequeue.dequeue();
			multiplequeue.dequeue();
			System.out.println("One (upon dequeue):" + onequeue);
			System.out.println("Multiple (upon dequeue):" + multiplequeue);

			onequeue.enqueue(600);
			multiplequeue.enqueue(400);
			System.out.println("One (on enqueue):" + onequeue);
			System.out.println("Multiple(on enqueue):" + multiplequeue);

			// test error
			emptyqueue.dequeue();
		} catch (LinkedListException e) {
			System.out.println(e.getMessage());
		}

	}		
}
