public abstract class GroceryItem implements Comparable, Cloneable {
    private String name;
    private int quantity;
    private double price;

    //default constructor
    public GroceryItem() {
        this.name = "";
        this.quantity = 0;
        this.price = 0;
    }

    //parametarized constructor
    public GroceryItem(String n, int q, double p) {
        name = n;
        quantity = q;
        price = p;
    }

    public String toString() {// overridden toString metod
        String s = "";
        s += String.format("Name: %-20s Quantity: %-10s Price: %-10s",name,quantity,price);
        return s;
    }

    public int compareTo(Object other) {//overridden compareTo method
        if (getClass() != other.getClass()) {
            throw new IllegalArgumentException();
        }

        if (this.equals(other)) {
            return 0;
        }

        else {
            return -1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}