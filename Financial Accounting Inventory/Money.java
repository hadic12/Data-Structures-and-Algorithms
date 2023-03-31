package assignment8;

import java.io.Serializable;

public class Money implements Comparable<Money>, Cloneable, Serializable {
	private static final long serialVersionUID = 574321235L;
	private int dollars;
	private int cents;

	public Money() {
		dollars = 0;
		cents = 0;
	}

	public Money(int doll) {
		dollars = doll;
		cents = 0;
	}

	public Money(int doll, int cent) {
		dollars = doll;
		this.cents = cent;

		// if cents are more than 100, add to dollars and convert cent to less than 100
		dollars += cents / 100;
		cents = cents % 100;
	}

	public Money(Money other) {
		dollars = other.dollars;
		cents = other.cents;
	}

	public void setMoney(int d, int c) {
		dollars = d;
		cents = c;

		// if cents are more than 100, add to dollars and convert cent to less than 100
		dollars += cents / 100;
		cents = cents % 100;
	}

	public int getDollars() {
		return dollars;
	}

	public int getCents() {
		return cents;
	}

	public double getMoney() {
		return dollars + cents / 100.0;
	}

	public void add(int dollars) {
		this.dollars += dollars;
	}

	public void add(int dollars, int cents) {
		this.dollars += dollars;
		this.cents += cents;

		// If cents are more than 100, adds to dollars and converts cents to less than
		// 100.
		dollars += cents / 100;
		cents = cents % 100;
	}

	public void add(Money other) {
		dollars += other.dollars;
		cents += other.cents;

		// If cents are more than 100, adds to dollars and converts cents to less than
		// 100.
		dollars += cents / 100;
		cents = cents % 100;
	}

	// Equals method
	public boolean equals(Object o) {

		// Check instance of object, it should be of money class type.
		if (o instanceof Money) {
			Money other = (Money) o;

			// Check if dollar and cents are same.
			if (dollars == other.getDollars() && cents == other.getCents())
				return true;

			return false;
		}

		return false;
	}

	public String toString() {
		return "$" + dollars + "." + cents;
	}

	// Comparing method
	public int compareTo(Money o) {
		if (getClass() != o.getClass()) {
			throw new IllegalArgumentException();
		}
		return Double.compare(o.getMoney(), getMoney());
	}

	// Cloning method
	public Money clone() {
		Money m;
		try {
			m = (Money) super.clone();
			return m;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}