package assignment8;

public class ObjectList implements Cloneable {//Custom Array List
	private int N;
	private Order[] orderList;
	private int numElements = 0;

	//Default Constructor
	public ObjectList(int n) {
		this.N = n;
		this.orderList = new Order[N];
	}

	// Adding new items
	public void add(Order next) {
		orderList[numElements] = next;
		numElements++;
	}
	
	// Replacing already existing items
	public void replace (Order o, int index) {
		orderList [index] = o;
	}

	public int getElements() {
		return this.numElements;
	}
	
	// Clone method
	public ObjectList clone()  {
		ObjectList a = new ObjectList(N);
			for (int i = 0; i < numElements; i++) {
				//a = (ObjectList)super.clone();
				a.add(this.orderList[i]);
			}
			return a;
	}

	public Order getOrder(int i) {
		return orderList[i];
	}
	
	public String toString () {
		String s = "";
		for (int i = 0; i < numElements; i++) {
			s = s + getOrder(i).toString() + "\n";
		}
		return s;
	}
}
