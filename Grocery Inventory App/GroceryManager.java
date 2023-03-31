import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GroceryManager {
    private ArrayList<GroceryItem> inventory = new ArrayList<>();
    private HashSet<String> reOrderList = new HashSet<>();

    public void loadInventory(String fileName) {//reading inventory from file
        Scanner input = null;

        try {
            input = new Scanner(new FileInputStream(fileName));
            String line = input.nextLine();//reading first line of the file
            String[] a = line.split(" ");
            int numDairy = Integer.parseInt(a[0]);//taking out number of types of items (Dairy,produce and meat)
            int numProduce = Integer.parseInt(a[1]);
            int numMeat = Integer.parseInt(a[2]);
            int count = 0;
            while (input.hasNext()) {//creating objects and initializing them and updating inventory
                line = input.nextLine();
                if (count < numDairy) {
                    inventory.add(new Dairy(line));
                    count++;
                }

                else if (count < numDairy + numProduce) {
                    inventory.add(new Produce(line));
                    count++;
                }

                else {
                    inventory.add(new Meat(line));
                    count++;
                }
            }
        }

        catch (Exception e) {
            System.out.println("File not found.");
        }
    }

    public void processOrder(GroceryOrder<GroceryItem> a) throws GroceryException {//processing individual orders
        String name;
        int quantity;
        double price;

        for (Object item : a) {
            GroceryItem temp = (GroceryItem) item;
            name = temp.getName();
            quantity = temp.getQuantity();
            price = temp.getPrice();
            GroceryItem n = findItemByName(name);//finding items information in inventory by searching using name

            if (n != null) {// if item found in inventory
                if ((n.getQuantity() - quantity) <= 0) {//if after processing order quantity get equal or less than 0
                    quantity = quantity - n.getQuantity();

                    for (GroceryItem gt : inventory) {// for going through each item in inventory
                        if (gt.getName().equals(name)) {
                            gt.setQuantity(0);//updating quantity of item in inventory
                        }
                    }
                    // adding out of sock items in to reOderList
                    reOrderList.add(name);
                    // exception for item out of stock
                    throw new GroceryException("out of "+name);
                }

                else {
                    quantity = n.getQuantity() - quantity;// calculating remaining quantity after processing order

                    for (GroceryItem itr : inventory) {// for going through each item in inventory
                        if (itr.getName().equals(name)) {
                            itr.setQuantity(quantity);//updating quantity of item in inventory
                        }
                    }
                }
            }

            else {
                //exception for item not found in inventory
                throw new GroceryException(name + " not found.");
            }
        }
    }

    public GroceryItem findItemByName(String s) {// searching by name in inventory
        for (GroceryItem items : inventory) {
            if (items.getName().equals(s)) {
                return items;
            }
        }

        return null;// if item not found return null
    }

    public void sortInventoryByName() {// sorting inventory using bubble sort
        int length = inventory.size();
        Object temp = null;

        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (inventory.get(j - 1).getName().compareTo(inventory.get(j).getName())>0) {
                    temp = inventory.get(j - 1);			//temp = c , j-1 = a , j = b
                    inventory.set(j - 1, inventory.get(j));
                    inventory.set(j, (GroceryItem) temp);
                }
            }
        }
    }

    public void sortInventoryByPrice() {// sorting inventory using insertion sort 
        int length = inventory.size();

        for (int i = 1; i < length; i++) {
            Object temp = inventory.get(i);
            int j = i - 1;

            while (j > 0 && inventory.get(j).getPrice() > ((GroceryItem) temp).getPrice()) {
                inventory.set(j + 1, inventory.get(j));
                j--;
            }

            inventory.set(j + 1, (GroceryItem) temp);
        }
    }

    public void displayRestockingList() {//displaying hashset of reOrderList
        for (String item : reOrderList) {
            System.out.println(item);
        }
    }

    public void displayInventory() {// displaying inventory
        for (GroceryItem item : inventory) {
            System.out.println(item);
        }
    }
}