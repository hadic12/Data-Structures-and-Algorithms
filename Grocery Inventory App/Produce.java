public class Produce extends GroceryItem {
    private boolean isOrganic;

    //Default constructor
    public Produce() {
        super();
        this.isOrganic = false;
    }

    //parametarized constructor
    public Produce(String n, int q, double p, boolean i) {
        super(n, q, p);
        this.isOrganic = i;
    }

    //constructor for initializing from strings from a file
    public Produce(String inputLine) {
        super();
        String[] a = inputLine.split(" ");
        int q = Integer.parseInt(a[2]);
        double p = Double.parseDouble(a[3]);
        super.setName(a[1]);
        super.setQuantity(q);
        super.setPrice(p);
        this.isOrganic = Boolean.parseBoolean(a[4]);
    }

    public boolean isOrganic() {//getter
        return isOrganic;
    }

    public void setOrganic(boolean isOrganic) {//setter
        this.isOrganic = isOrganic;
    }

    public String toString() {// overridden toString metod
        String s = (super.toString()+"\t isOrganic: "+isOrganic);
        return s;
    }
}