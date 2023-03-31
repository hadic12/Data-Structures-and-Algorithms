package assignment8;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * HW3.java: Simple driver to test Order, Date, and Order classes
 * 
 * @author Rob Nash, borrowed from cfolsen, revised by Lesley Kalmin
 */
public class PurchaseOrderDriver extends ArrayList<Order> {
	/**
	 * main driver function pre: none post: exercises the methods in Order, Money,
	 * and Date (not done)
	 */
	public static void main(String[] args) {
		
		// ArrayList
		ArrayList<Order> order = new ArrayList<>();
		
		// Construct some money
		Money money1 = new Money(10);
		money1.setMoney(30, 50);
		Money money2 = money1.clone();

		// Print Money after cloning
		System.out.println("money1: " + money1);
		System.out.println("money2: " + money2);
		// TODO: do more functional exercises with the money class

		Money m = null;

		System.out.println("null check " + ((m instanceof Money) ? true : false));
		System.out.println("Money objects output:");
		money1.add(12);
		System.out.println("money1: " + money1);
		System.out.println("money2: " + money2);

		// Construct some amount of money
		Money amount1 = new Money(20);
		Money amount2 = amount1.clone();

		// Create Date for Orders
		Date orderDate = new Date(4, 30, 2017);
		Date cloneDate = orderDate.clone();

		// After Cloning
		System.out.println("Date objects output:");
		System.out.println("Date1: " + orderDate);
		System.out.println("Date2: " + cloneDate);
		orderDate.setDay(12);
		System.out.println("Date1: " + orderDate);
		System.out.println("Date2: " + cloneDate);

		// Construct Orders
		Order order1 = new Order(amount2, cloneDate, "SysAdmin", "USB cable");
		Order order2 = order1.clone();
		order2.setOrderDate(orderDate);
		order2.setFulfilled(new Date(5, 30, 2018));
		amount2.setMoney(31, 99);
		cloneDate.setDay(29);
		Order order3 = new Order(amount2, orderDate, "Home Baker", "KitchenAid Mixer");
		Order order5 = order3.clone();
		order3.setFulfilled(new Date(4, 5, 21));

		Order order4 = new Order(amount2, new Date(1, 1, 2021), "Fitness Buff", "Exercise Bike");

		// Add Orders to the ArrayList
		order.add(order1);
		order.add(order2);
		order.add(order3);
		order.add(order4);
		order.add(order5);

		// List iterator
		ListIterator<Order> itr = order.listIterator();

		System.out.println("Order objects output:");

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		// Compare Orders
		System.out.println(order1.compareTo(order2));
		System.out.println(order1.compareTo(order3));
		System.out.println(orderDate.compareTo(cloneDate));

		// PurchaseOrderAccount testing
		PurchaseOrderAccount test = new PurchaseOrderAccount(2);
		test.add(order1);
		test.add(order3);
		PurchaseOrderAccount test2 = new PurchaseOrderAccount(test.clone());

		System.out.println("test = " + test + "test2 = " + test2);

		test2.replace(order4, 0);

		System.out.println("test = " + test + "test2 = " + test2);
	}
}
