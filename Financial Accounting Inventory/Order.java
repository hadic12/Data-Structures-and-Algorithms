package assignment8;

import java.io.Serializable;

public class Order implements Comparable<Order>, Cloneable, Serializable {
	private static final long serialVersionUID = 254323467L;
	private Money amount;
	private Date orderDate, sendDate = null;
	private String customer;
	private String item;

	public Order(Money amount, Date orderDate, String customer, String item) {
		this.amount = amount;
		this.orderDate = orderDate;
		this.customer = customer;
		this.item = item;
	}

	public Order(Order toCopy) {
		// Copy from other object into this.
		amount = toCopy.amount;
		orderDate = toCopy.orderDate;
		sendDate = toCopy.sendDate;
		customer = toCopy.customer;
		item = toCopy.item;
	}

	public boolean isFulfilled() {
		return sendDate != null;
	}

	public boolean setFulfilled(Date sendDate) {
		// First check date is after order date.
		if (sendDate.isAfter(orderDate)) {
			this.sendDate = sendDate;
			return true;
		} else {
			return false;
		}
	}

	public boolean setOrderDate(Date nextDate) {
		// If order is already sent do not change.
		if (isFulfilled())
			return false;

		this.orderDate = nextDate;
		return true;
	}

	public boolean setSentDate(Date nextDate) {
		// If order is already sent dont change.
		if (isFulfilled())
			return false;

		this.sendDate = nextDate;
		return true;
	}

	public boolean setAmount(Money amount) {
		// If order is already sent dont change.
		if (isFulfilled())
			return false;

		this.amount = amount;
		return true;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Money getAmount() {
		return amount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public String getCustomer() {
		return customer;
	}

	public String getItem() {
		return item;
	}

	// toString method of money and date class
	public String toString() {
		return "Item: " + item + " customer: " + customer + "  amount: " + amount.toString() + "  Ordered Date: "
				+ orderDate.toString();
	}

	// Equals method
	public boolean equals(Object o) {
		// first make sure object is of order class
		if (o instanceof Order) {
			Order other = (Order) o;

			// now use string, date, money class equals method to compare
			if (customer.equals(other.getCustomer()) && item.equals(other.getItem()) && amount.equals(other.getAmount())
					&& orderDate.equals(other.getOrderDate()))
				return true;

			return false;
		}

		return false;
	}

	@Override
	// Comparing method
	public int compareTo(Order o) {
		if (getClass() != o.getClass())
			throw new IllegalArgumentException();
		return this.getAmount().compareTo(o.getAmount());
	}

	// Cloning method
	public Order clone() {
		Order b;
		try {
			b = (Order) super.clone();
			return b;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}