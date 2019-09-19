package eecs2030.lab2;

public class Nickel implements Comparable<Nickel> {

	private int year;

	/**
	 * The monetary value of a nickel in cents.
	 */
	public final int CENTS = 5;

	/**
	 * Initializes this nickel to have the specified issue year.
	 * 
	 * @param year the year this coin was issued in @pre. year must be greater than
	 *             or equal to 1858
	 * @throws IllegalArgumentException if year is less than 1858
	 */
	public Nickel(int year) {
		if (year < 1858) {
			throw new IllegalArgumentException();
		} else {
			this.year = year;
		}
	}

	/**
	 * Returns the issue year of this coin.
	 * 
	 * @return the issue year of this coin
	 */
	public int issueYear() {
		return this.year;
	}

	/**
	 * Compares this nickel to the specified object for equality. The result is true
	 * if obj is a nickel. The issue year is not considered when comparing two
	 * nickels for equality.
	 * 
	 * @Override equals in class Object
	 * @return true if obj is a nickel
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() == obj.getClass()) {
			return true;
		}
		return false;
	}

	/**
	 * Returns a hash code for this nickel. Specifically, this method returns the
	 * issue year of this nickel.
	 * 
	 * @Override hashCode in class Object
	 * @return the issue year of this nickel
	 */
	@Override
	public int hashCode() {
		return this.year;
	}

	/**
	 * Compares this nickel to another nickel by their issue year. The result is a
	 * negative integer if this nickel has an earlier issue year than the other
	 * nickel, a positive integer if this nickel has a later issue year than the the
	 * other nickel, and zero otherwise. Specifically, this method returns the
	 * difference of the issue year of this nickel and the issue year of the other
	 * nickel.
	 * 
	 * @return the difference of the issue year of this nickel and the issue year of
	 *         the other nickel
	 */
	@Override
	public int compareTo(Nickel other) {
		return this.year - other.year;
	}

}