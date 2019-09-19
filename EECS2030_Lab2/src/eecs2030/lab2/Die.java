package eecs2030.lab2;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/*
 * NOTE TO STUDENTS: 
 * The constructor that you need to complete can be found on line 47.
 * 
 * The two methods you need to complete can be found at the end of this file.
 */

public class Die implements Comparable<Die> {

	/**
	 * A random number generator to simulate rolling the die. DO NOT CHANGE THE
	 * DECLARATION OF rng. THE UNIT TESTS RELY ON BEGIN ABLE TO ACCESS THE RANDOM
	 * NUMBER GENERATOR.
	 */
	Random rng = new Random();

	/**
	 * The array of face values.
	 */
	private int[] faces;

	/**
	 * The current value of the die.
	 */
	private int value;

	/**
	 * The number of faces on a die.
	 */
	public static int NUMBER_OF_FACES = 6;

	/*
	 * You need to implement the no-argument constructor below, and the methods
	 * compareTo and equals found at the end of the class.
	 */

	public Die() {
		faces = new int[6];
		for (int i = 0; i < 6; i++) {
			faces[i] = i + 1;
		}
		this.value = faces[0];
	}

	private static boolean isInAscendingOrder(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public Die(int[] faces) {
		if (faces.length != 6) {
			throw new IllegalArgumentException();
		}
		if (!Die.isInAscendingOrder(faces)) {
			throw new IllegalArgumentException();
		}
		this.faces = Arrays.copyOf(faces, NUMBER_OF_FACES);
		this.value = this.faces[0];
	}

	public void setValueToFace(int face) {
		if (face < 0 || face >= NUMBER_OF_FACES) {
			throw new IllegalArgumentException();
		}
		this.value = this.faces[face];
	}

	public int value() {
		return this.value;
	}

	public int roll() {
		int idx = rng.nextInt(Die.NUMBER_OF_FACES);
		this.value = this.faces[idx];
		return this.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.value, this.faces);
	}

	/*
	 * You need to implement the compareTo and equals methods below.
	 * 
	 */

	/*
	 * Compares this die to another die by their current values. The result is a
	 * negative integer if this die has a smaller current value than the other die,
	 * a positive integer if this die has a greater current value than the the other
	 * nickel, and zero otherwise. Specified by: compareTo in interface
	 * Comparable<Die> Returns: a negative integer, 0, or a positive integer if the
	 * current value of this die is less than, equal to, or greater than,
	 * respectively, the current value of the other die
	 */
	@Override
	public int compareTo(Die other) {
		return this.value - other.value;
	}

	/*
	 * Compares this die to the specified object for equality. The result is true if
	 * obj is a die with a current value equal to the current value of this die and
	 * both dice have identical faces, false otherwise. Overrides: equals in class
	 * Object Returns: true if obj is a die with a current value equal to the
	 * current value of this die and both dice have identical faces, false
	 * otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		// The method Arrays.equals may be useful for helping
		// to implement this method.
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Die other = (Die) obj;
		return Arrays.equals(this.faces, other.faces) && this.value == other.value;
	}

}
