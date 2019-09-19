package eecs2030.lab2;

import java.util.Objects;

/*
 * NOTE TO STUDENTS: The two methods you need to complete can 
 * be found at the end of this file.
 */

public class Card implements Comparable<Card> {

	/**
	 * The rank of this card.
	 */
	private Rank rank;

	/**
	 * The suit of this card.
	 */
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		if (rank == null || suit == null) {
			throw new NullPointerException();
		}
		this.rank = rank;
		this.suit = suit;
	}

	public Rank rank() {
		return this.rank;
	}

	public Suit suit() {
		return this.suit;
	}

	public Colour color() {
		return this.suit.color();
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.rank, this.suit);
	}

	@Override
	public String toString() {
		return this.rank + " of " + this.suit;
	}

	/*
	 * You need to implement the compareTo and equals methods below.
	 * 
	 * For compareTo, you may compare ranks using the compareTo method found in the
	 * Rank class. You may compare suits using the compareTo method found in the
	 * Suit class.
	 */

	/*
	 *
	 * Compares this card to another card for order. This method imposes the
	 * following order on cards: Cards are first compared by rank. If the rank of
	 * this card is less than the rank of the other card then -1 is returned. If the
	 * rank of this card is greater than the rank of the other card then 1 is
	 * returned. If the ranks of the two cards are equal then the method proceeds to
	 * the next step. The ranks are compared using the compareTo method from the
	 * Rank enum. Cards are compared by suit. If the suit of this card is less than
	 * the suit of the other card then -1 is returned. If the suit of this card is
	 * greater than the suit of the other card then 1 is returned. If the suits of
	 * the two cards are equal then the method returns 0. The suits are compared
	 * using the compareTo method from the Suit enum. Specified by: compareTo in
	 * interface Comparable<Card> Parameters: other - the card to compare against
	 * this card Returns: -1, 0, 1 if this card is less than, equal to, or greater
	 * than the other card
	 */
	@Override
	public int compareTo(Card other) {
		int ans = 0;
		if (this.rank != other.rank) {
			if (this.rank.compareTo(other.rank) > 0) {
				ans = 1;
			} else if (this.rank.compareTo(other.rank) < 0) {
				ans = -1;
			}
		}
		if (this.rank == other.rank) {
			if (this.suit == other.suit) {
				ans = 0;
			} else if (this.suit.compareTo(other.suit) < 0) {
				ans = -1;
			} else {
				ans = 1;
			}
		}
		return ans;
	}

	/*
	 * Compares this card to the specified object for equality. The result is true
	 * if obj is a card having the same rank and the same suit as this card, false
	 * otherwise. Overrides: equals in class Object Returns: true if obj is a card
	 * having the same rank and the same suit as this card, false otherwise
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
		Card other = (Card) obj;
		if (this.suit == other.suit && this.rank == other.rank) {
			return true;
		}
		return false;
	}

}
