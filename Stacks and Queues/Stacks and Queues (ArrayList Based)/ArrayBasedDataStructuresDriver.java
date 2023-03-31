/*Incomplete Driver for ArrayList(ObjectList),Stack and Queue*/
// Lesley's version - has some extra ArrayList tests
/* Author: Hadi Chohan
 * Teacher: Professor Kalmin
 * Date: 10/21/2022
 */
public class ArrayBasedDataStructuresDriver {
    public static void main(String[] args) {
        arrayListTests();
        queueTests();
        stackTests();
    }

    private static void arrayListTests() {
        System.out.println("ArrayList Tests");
        // todo: make more tests here
        ArrayList a = new ArrayList();
        System.out.println("Check empty array isEmpty:" + a.isEmpty());
        a.insert('B', 0);
        a.insert('a', 0);
        a.insert('t', 1);
        System.out.println("Check non-empty array isEmpty:" + a.isEmpty());
        System.out.println(a.toString());
        while (a.isEmpty() == false) {
            System.out.println(a.remove(0));
        }
        // Fill over initial capacity and check that it grows
        for (int i = 0; i < 110; i++)
        {
            a.append(new Integer(i));
        }
        System.out.println("Size of array after 110 adds: "+ a.size());
        System.out.println("Value of last element: "+ a.get(a.size()-1));
        System.out.println("Insert past end of list");
        //a.insert('z', 200);
        System.out.println("Insert negative index");
        /*a.insert('z',  -3);
        System.out.println("Remove past end of list");
        a.remove(200); */
        // -----------------------------------------------------------------
        // ADDITIONAL TESTS
        // Check for equality
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        list1.insert("A", 0);
        list1.insert("B", 0);
        list1.insert("C", 0);
        list2.insert("A", 0);
        list2.insert("B", 0);
        list2.insert("C", 0); 
        System.out.println("equality true check: " + list1.equals(list2));
        list2.remove(1);
        list2.insert("D", 0);
        System.out.println("equality false check: " + list1.equals(list2));
        System.out.println("index of, expecting 1: " + list1.getIndexOf("B"));
        System.out.println("index of, expecting -1: " + list1.getIndexOf("J"));
        System.out.println("getAt, expecting A: " + list1.get(2));
        System.out.println("getAt, expecting error: ");
        System.out.println(list1.get(9));
        System.out.println("size, expecting 3: " + list1.size());
        System.out.println("remove return value, expecting A: " + 
        list1.remove(2));
    }
    
    private static void queueTests() {
        System.out.println("\nQueue Tests");
        Queue a = new Queue();
        System.out.println("dequeue empty q");
        a.dequeue();
        a.enqueue('B');
        a.enqueue('a');
        a.enqueue('t');
        System.out.println(a.toString());
        while (a.isEmpty() == false) {
            System.out.println(a.dequeue());
        }
        System.out.println("Fill past initial size");
        for (int i = 0; i < 110; i++)
        {
            a.enqueue(i);
        }
        System.out.println("size: "+ a.size());
    }

    private static void stackTests() {
        System.out.println("\nStack Tests");
        Stack a = new Stack();
        System.out.println("pop empty stack");
        a.pop();
        a.push('B');
        a.push('a');
        a.push('t');
        System.out.println(a.toString());
        while (a.isEmpty() == false) {
            System.out.println(a.pop());
        }
        System.out.println("pop past pushes");
        a.push('A');
        a.pop();
        a.pop();
        System.out.println("Fill past initial size");
        for (int i = 0; i < 110; i++)
        {
            a.push(i);
        }
        System.out.println("pop last");
        System.out.println(a.pop());
    }
}
