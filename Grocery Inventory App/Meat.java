public class Meat extends GroceryItem{
    private boolean isGround;

    //default constructor
    public Meat() {
        super();
        this.isGround = false;
    }

    //parametarized constructor
    public Meat(String n, int q, double p, boolean i) {
        super(n, q, p);
        this.isGround = i;
    }

    //constructor for initializing from strings from a file
    public Meat(String inputLine) {
        super();
        String[] a = inputLine.split(" ");
        int q = Integer.parseInt(a[2]);
        double p = Double.parseDouble(a[3]);
        super.setName(a[1]);
        super.setQuantity(q);
        super.setPrice(p);
        this.isGround = Boolean.parseBoolean(a[4]);
    }

    public boolean getGround() {
        return isGround;
    }

    public void setGround(boolean isOrganic) {
        this.isGround = isOrganic;
    }

    public String toString() {// overridden toString metod
        String s = (super.toString()+"\t isGround: "+isGround);
        return s;
    }
}