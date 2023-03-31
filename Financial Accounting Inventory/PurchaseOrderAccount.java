package assignment8;

public class PurchaseOrderAccount extends ObjectList implements Cloneable{

	// Default constructor
	public PurchaseOrderAccount(int n) {
		super(n);
	}
	
	// Cloning constructor
	public PurchaseOrderAccount(ObjectList o) {
		super(o.getElements());
		for (int i = 0; i < o.getElements(); i++) {
			super.add(o.getOrder(i));
		}
	}
	
	// Cloning inheritance method
	public ObjectList clone() {
			return super.clone();
	}
	
	public String toString () {
		return super.toString();
	}
}
