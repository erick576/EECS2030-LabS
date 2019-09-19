package eecs2030.lab2;

/*
 * NOTE TO STUDENTS: The four methods you need to complete can 
 * be found at the end of this file.
 */

public class Domino implements Comparable<Domino> {

	/**
	 * The smallest possible value for a side of a domino.
	 */
	public static final int MIN_VALUE = 0;

	/**
	 * The largest possible value for a side of a domino.
	 */
	public static final int MAX_VALUE = 6;

	/**
	 * The two values on the domino.
	 */
	private int val1;
	private int val2;

	public Domino() {
		this(0, 0);
	}

	public Domino(int value1, int value2) {
		if (!isValueOK(value1) || !isValueOK(value2)) {
			throw new IllegalArgumentException();
		}
		this.val1 = value1;
		this.val2 = value2;
	}

	public Domino(Domino other) {
		this(other.val1, other.val2);
	}

	private static boolean isValueOK(int value) {
		return value >= MIN_VALUE && value <= MAX_VALUE;
	}

	@Override
	public int hashCode() {
		return this.getSmallerValue() + 11 * this.getLargerValue();
	}

	@Override
	public String toString() {
		return "[" + this.getSmallerValue() + " : " + this.getLargerValue() + "]";
	}

	/*
	 * You need to implement the four methods below. Both compareTo and equals
	 * should make use of getSmallerValue and getLargerValue.
	 */

	/*
	 * Returns the smaller of the two values of this domino. If both values of this
	 * domino are equal to the same value then that value is returned. Returns: the
	 * smaller of the two values of this domino
	 */
	public int getSmallerValue() {
		if (this.val1 < this.val2) {
			return this.val1;
		} else if (this.val1 > this.val2) {
			return this.val2;
		} else {
			return this.val1;
		}
	}

	/*
	 * Returns the larger of the two values of this domino. If both values of this
	 * domino are equal to the same value then that value is returned. Returns: the
	 * larger of the two values of this domino
	 */
	public int getLargerValue() {
		if (this.val1 < this.val2) {
			return this.val2;
		} else if (this.val1 > this.val2) {
			return this.val1;
		} else {
			return this.val1;
		}
	}

	/*
	 * Compares two dominoes by their values. The smaller values on the two dominoes
	 * are compared first; if the smaller values of both dominoes are equal then the
	 * larger values of the two dominoes are compared. If the two dominoes are equal
	 * then 0 is returned.
	 * 
	 * This domino is less than the other domino if the smaller value of this domino
	 * is less than the smaller value of the other domino, or if the larger value of
	 * this domino is less than the larger value of the other domino and the smaller
	 * values of both dominoes are equal.
	 * 
	 * This domino is greater than the other domino if the smaller value of this
	 * domino is greater than the smaller value of the other domino, or if the
	 * larger value of this domino is greater than the larger value of the other
	 * domino and the smaller values of both dominoes are equal.
	 * 
	 * Specified by: compareTo in interface Comparable<Domino> Parameters: other -
	 * the other domino to compare to this domino Returns: the value 0 if this
	 * domino is equal to other; a value less than 0 if this domino is less than the
	 * other domino; and a value greater than 0 if this domino is greater than the
	 * other domino
	 */
	@Override
	public int compareTo(Domino other) {
		if (this.getSmallerValue() != other.getSmallerValue()) {
			return this.getSmallerValue() - other.getSmallerValue();
		} else if (this.getSmallerValue() == other.getSmallerValue()) {
			if (this.getLargerValue() == other.getLargerValue()) {
				return 0;
			}
		}
		return this.getLargerValue() - other.getLargerValue();
	}

	/*
	 * Compares this domino to the specified object. The result is true if and only
	 * if the argument is a Domino object having the same values as this domino
	 * object. Note that the side on which a value appears is not considered for the
	 * purposes of equals; for instance, eq will be true in the example below:
	 * Domino a = new Domino(1, 4); Domino b = new Domino(4, 1); boolean eq =
	 * a.equals(b);
	 * 
	 * Overrides: equals in class Object Parameters: obj - an object to compare
	 * Returns: true if this domino is equal to the specified object, and false
	 * otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Domino other = (Domino) obj;
		if (this.getSmallerValue() == other.getSmallerValue() && this.getLargerValue() == other.getLargerValue()) {
			return true;
		}
		return false;
	}

}