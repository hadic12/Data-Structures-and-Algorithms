public class Dairy extends GroceryItem {
    private int refrigerationTemperature;

    //defaukt constructor
    public Dairy() {
        super();
        this.setRefrigerationTemperature(0);
    }

    //parametarized constructr
    public Dairy(String n, int q, double p, int r) {
        super(n, q, p);
        this.setRefrigerationTemperature(r);
    }

    //constructor for initializing from strings from a file
    public Dairy(String inputLine) {
        super();
        String[] a = inputLine.split(" ");
        int q = Integer.parseInt(a[2]);
        double p = Double.parseDouble(a[3]);
        super.setName(a[1]);
        super.setQuantity(q);
        super.setPrice(p);
        this.refrigerationTemperature = Integer.parseInt(a[4]);
    }

    public int getRefrigerationTemperature() {//getter
        return refrigerationTemperature;
    }

    public void setRefrigerationTemperature(int refrigerationTemperature) {//setter
        this.refrigerationTemperature = refrigerationTemperature;
    }

    public String toString() {// overridden toString metod
        String s = (super.toString()+"\t Temperature: "+refrigerationTemperature);
        return s;
    }
}