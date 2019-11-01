import java.util.ArrayList;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 * See under doc/index.html for the API of methods.
 * This lab requires definitions of recursive helper methods. 
 * You may review the recording of parts of Lecture 14 (October 28): 
 * 		https://youtu.be/J2CB3QHinQU 
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in an arithmetic sequence, with
	 * initial term 'start' and common difference 'diff'. You can assume that n is
	 * non-negative (larger than or equal to 0). e.g., arithmeticArray(2, 3, 5)
	 * returns an array {2, 5, 8, 11, 14}.
	 * 
	 * @param start the first term in an arithmetic sequence
	 * @param diff  the common difference between terms in an arithmetic sequence
	 * @param n     the first n numbers in an arithmetic sequence
	 * @return an array representing the first n numbers in the specified arithmetic
	 *         sequence
	 * 
	 *         <b>You are forbidden to use the arithmeticList method below to solve
	 *         this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] arithmeticArray(int start, int diff, int n) {
		/*
		 * Your Task: Make use of the recursive method arithmeticArrayHelper.
		 */
		RecursiveMethods rm = new RecursiveMethods();
		if (n == 0) {
			return new int[0];
		}
		int[] seq = new int[n];
		seq[0] = start;
		rm.arithmeticArrayHelper(1, diff, seq);
		return seq;
	}

	/**
	 * This is a recursive helper method expected to be used by arithmeticArray.
	 * 
	 * @param i    position in `seq` to be assigned to
	 * @param diff common difference of the arithmetics sequence
	 * @param seq  a partially filled arithmetic sequence
	 * 
	 *             Each recursive call to this helper method stores at index `i` of
	 *             the resulting arithmetic sequence `seq`, which is assumed to have
	 *             been partially filled at indices 0, 1, ..., i - 1.
	 */
	void arithmeticArrayHelper(int i, int diff, int[] seq) {
		/*
		 * Your Task
		 */
		if (i < seq.length && seq.length != 0) {
			seq[i] = seq[i - 1] + diff;
			arithmeticArrayHelper(i + 1, diff, seq);
		}
	}

	/**
	 * Return a list storing the first n numbers in an arithmetic sequence, with
	 * initial term 'start' and common difference 'diff'. You can assume that n is
	 * non-negative (larger than or equal to 0). e.g., arithmeticList(2, 3, 5)
	 * returns a list {2, 5, 8, 11, 14}.
	 * 
	 * @param start the first term in an arithmetic sequence
	 * @param diff  the common difference between terms in an arithmetic sequence
	 * @param n     the first n numbers in an arithmetic sequence
	 * @return a list representing the first n numbers in the specified arithmetic
	 *         sequence
	 * 
	 *         <b>You are forbidden to use the arithmeticArray method above to solve
	 *         this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> arithmeticList(int start, int diff, int n) {
		/*
		 * Your Task: Make use of the recursive method arithmeticListHelper.
		 */
		RecursiveMethods rm = new RecursiveMethods();
		if (n == 0) {
			return new ArrayList<Integer>(0);
		}
		List<Integer> seq = new ArrayList<>();
		seq.add(0, start);
		rm.arithmeticListHelper(1, diff, seq, n);
		return seq;
	}

	/**
	 * This is a recursive helper method expected to be used by arithmeticList.
	 * 
	 * @param i    position in `seq` to be assigned to
	 * @param diff common difference of the arithmetics sequence
	 * @param seq  a partially filled arithmetic sequence
	 * @param n    size of the arithmetic sequence to be built eventually
	 * 
	 *             Each recursive call to this helper method stores at index `i` of
	 *             the resulting arithmetic sequence `seq`, which is assumed to have
	 *             been partially filled at indices 0, 1, ..., i - 1.
	 */
	void arithmeticListHelper(int i, int diff, List<Integer> seq, int n) {
		/*
		 * Your Task
		 */
		if (i < n && seq.size() != 0) {
			seq.add(i, diff + seq.get(i - 1));
			arithmeticListHelper(i + 1, diff, seq, n);
		}
	}

	/**
	 * Return whether or not an array represents the first n numbers of an
	 * arithmetic sequence. An arithmetic sequence has a common difference between
	 * every two adjacent terms. The array may or may not be empty. e.g.,
	 * isArithmeticArray({1, 3, 5, 8, 10}) returns false and isArithmeticArray({1,
	 * 3, 5, 7, 9}) returns true (because the common difference is 2).
	 * 
	 * @param a an array
	 * @return true if input array a represents an arithmetic sequence; false
	 *         otherwise.
	 * 
	 *         <b>You are forbidden to use the isArithmeticList method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isArithmeticArray(int[] a) {
		/*
		 * Your Task: Make use of the recursive method isArithmeticArrayHelper.
		 */
		return isArithmeticArrayHelper(1, 0, a);
	}

	/**
	 * This is a recursive helper method expected to be used by isArithmeticArray.
	 * 
	 * @param i    position in `seq`, starting from which the remaining sub-sequence
	 *             is an arithmetic sequence
	 * @param diff common difference of the arithmetics sequence
	 * @param a    an array which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `a` with indices i - 1, i, i + 1,
	 *         ..., a.length - 1 is an arithmetic sequence
	 * 
	 *         Each recursive call to this helper method considers if elements of
	 *         `a` at indices `i - 1` and `i` make two valid adjacent elements in
	 *         the arithmetic sequence, i.e., their difference is equal to the
	 *         common difference `diff`. Also, it considers if the remaining
	 *         sub-sequence (indices i + 1, i + 2, ..., a.length - 1) is an
	 *         arithmetic sequence with common difference `diff`.
	 */
	boolean isArithmeticArrayHelper(int i, int diff, int[] a) {
		/*
		 * Your Task
		 */
		if (a.length == 0 || a.length == 1 || a.length == 2) {
			return true;
		}
		int diff1 = a[1] - a[0];
		if (i < a.length && (a[i] - diff1 == a[i - 1])) {
			return true && isArithmeticArrayHelper(i + 1, diff1, a);
		} else if (i == a.length) {
			return true;
		}
		return false;
	}

	/**
	 * Return whether or not a list represents the first n numbers of an arithmetic
	 * sequence. An arithmetic sequence has a common difference between every two
	 * adjacent terms. The list may or may not be empty. e.g., isArithmeticList({1,
	 * 3, 5, 8, 10}) returns false and isArithmeticList({1, 3, 5, 7, 9}) returns
	 * true (because the common difference is 2).
	 * 
	 * @param l a list
	 * @return true if input list l represents an arithmetic sequence; false
	 *         otherwise.
	 * 
	 *         <b>You are forbidden to use the isArithmeticArray method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isArithmeticList(List<Integer> l) {
		/*
		 * Your Task: Make use of the recursive method isArithmeticListHelper.
		 */

		return isArithmeticListHelper(1, 0, l);
	}

	/**
	 * This is a recursive helper method expected to be used by isArithmeticList.
	 * 
	 * @param i    position in `seq`, starting from which the remaining sub-sequence
	 *             is an arithmetic sequence
	 * @param diff common difference of the arithmetics sequence
	 * @param l    a list which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `l` with indices i - 1, i, i + 1,
	 *         ..., l.size() - 1 is an arithmetic sequence
	 * 
	 *         Each recursive call to this helper method considers if elements of
	 *         `l` at indices `i - 1` and `i` make two valid adjacent elements in
	 *         the arithmetic sequence, i.e., their difference is equal to the
	 *         common difference `diff`. Also, it considers if the remaining
	 *         sub-sequence (indices i + 1, i + 2, ..., l.size() - 1) is an
	 *         arithmetic sequence with common difference `diff`.
	 */
	boolean isArithmeticListHelper(int i, int diff, List<Integer> l) {
		/*
		 * Your Task
		 */
		if (l.size() == 0 || l.size() == 1 || l.size() == 2) {
			return true;
		}
		int diff1 = l.get(1) - l.get(0);
		if (i < l.size() && (l.get(i) - diff1 == l.get(i - 1))) {
			return true && isArithmeticListHelper(i + 1, diff, l);
		} else if (i == l.size()) {
			return true;
		}
		return false;
	}

	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1,
	 * consisting of all elements of array a and integer i.
	 * 
	 * @param a an array that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of
	 *         array a and integer i. e.g., insertIntoSortedArray({1, 2, 4, 5}, 3)
	 *         returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 *         <b>You are forbidden to use the insertIntoSortedList method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		return insertIntoSortedArrayHelper(a, i, 0);
	}

	// Helper Method #1
	public int[] insertIntoSortedArrayHelper(int[] a, int i, int k) {
		if (a.length == 0) {
			int[] d = new int[1];
			d[0] = i;
			return d;
		}
		if (a.length == 1) {
			if (i < a[0]) {
				int[] d = new int[2];
				d[1] = a[0];
				d[0] = i;
				return d;
			}
			int[] d = new int[2];
			d[0] = a[0];
			d[1] = i;
			return d;
		}
		if (k == 0) {
			if (i <= a[0]) {
				int[] h = new int[a.length + 1];
				return arrayFiller(a, h, i, 0, 0, 0);
			}
		}

		if (k < a.length - 1 && i <= a[k + 1] && i >= a[k]) {
			int[] h = new int[a.length + 1];
			return arrayFiller(a, h, i, k + 1, 0, 0);
		}
		if (k == a.length - 2) {
			if (i >= a[a.length - 1]) {
				int[] h = new int[a.length + 1];
				return arrayFiller(a, h, i, a.length, 0, 0);
			}
		}
		return insertIntoSortedArrayHelper(a, i, k + 1);
	}

	// Helper Method #2
	public int[] arrayFiller(int[] a, int[] h, int i, int k, int g, int f) {
		if (g < h.length) {
			if (g == k) {
				h[g] = i;
				return arrayFiller(a, h, i, k, g + 1, f);
			}
			h[g] = a[f];
			return arrayFiller(a, h, i, k, g + 1, f + 1);
		}
		return h;

	}

	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1,
	 * consisting of all elements of the input list and integer i.
	 * 
	 * @param list a list that is sorted in a non-descending order
	 * @param i    an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of
	 *         the input list and integer i. e.g., insertIntoSortedList({1, 2, 4,
	 *         5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 *         <b>You are forbidden to use the insertIntoSortedArray method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		return insertIntoSortedListHelper(list, i, 0);
	}

	public List<Integer> insertIntoSortedListHelper(List<Integer> a, int i, int k) {
		if (a.size() == 0) {
			a.add(i);
			return a;
		}
		if (a.size() == 1) {
			if (i < a.get(0)) {
				a.add(0, i);
				return a;
			}
			a.add(1, i);
			return a;
		}
		if (k == 0) {
			if (i <= a.get(0)) {
				a.add(0, i);
				return a;
			}
		}

		if (k < a.size() - 1 && i <= a.get(k + 1) && i >= a.get(k)) {
			a.add(k + 1, i);
			return a;
		}
		if (k == a.size() - 2) {
			if (i >= a.get(a.size() - 1)) {
				a.add(a.size(), i);
				return a;
			}
		}
		return insertIntoSortedListHelper(a, i, k + 1);
	}

	/**
	 * Given two sorted arrays left and right, where left is sorted in a
	 * non-descending order and right is sorted in a ***non-ascending*** order,
	 * return an array (of size left.length + right.length) sorted in a
	 * non-descending order, consisting of all elements of arrays left and right.
	 * 
	 * @param left  an array sorted in a non-descending order
	 * @param right an array sorted in a non-ascending order
	 * @return a sorted array of size left.length + right.length, consisting of all
	 *         elements of arrays left and right. e.g., mergeSortedArraysV2({1, 3,
	 *         5, 7}, {8, 6, 4, 2}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         <b>You are forbidden to use the mergeSortedListsV2 method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */

		if (left.length == 0 && right.length == 0) {
			return new int[0];
		}
		int[] arr = new int[right.length];
		int[] sortedRight = reverse(right, arr, right.length - 1, 0);
		int[] sorted = new int[left.length + right.length];
		return merge(sorted, left, sortedRight, 0, 0, 0);
	}

	public int[] reverse(int[] array, int[] arr, int i, int s) {
		if (array.length == 0) {
			return new int[0];
		}
		if (array.length == 1) {
			return array;
		}
		if (i >= 0) {
			arr[s] = array[i];
			return reverse(array, arr, i - 1, s + 1);
		}
		return arr;
	}

	public int[] merge(int[] sorted, int[] sortedLeft, int[] sortedRight, int lcounter, int rcounter, int mcounter) {
		if (sortedLeft.length == 0 && sortedRight.length == 0) {
			return new int[0];
		}
		if (sortedLeft.length == 0 && sortedRight.length != 0) {
			return sortedRight;
		}
		if (sortedLeft.length != 0 && sortedRight.length == 0) {
			return sortedLeft;
		}
		if (rcounter == sortedRight.length) {
			if (lcounter != sortedLeft.length) {
				sorted[mcounter] = sortedLeft[lcounter];
				lcounter++;
				mcounter++;
				merge(sorted, sortedLeft, sortedRight, lcounter, rcounter, mcounter);
			}
		}
		if (lcounter == sortedLeft.length) {
			if (rcounter != sortedRight.length) {
				sorted[mcounter] = sortedRight[rcounter];
				rcounter++;
				mcounter++;
				merge(sorted, sortedLeft, sortedRight, lcounter, rcounter, mcounter);
			}
		}

		if (lcounter != sortedLeft.length && rcounter != sortedRight.length
				&& sortedLeft[lcounter] <= sortedRight[rcounter]) {
			sorted[mcounter] = sortedLeft[lcounter];
			lcounter++;
			mcounter++;
			merge(sorted, sortedLeft, sortedRight, lcounter, rcounter, mcounter);
		} else if (lcounter != sortedLeft.length && rcounter != sortedRight.length
				&& sortedLeft[lcounter] > sortedRight[rcounter]) {
			sorted[mcounter] = sortedRight[rcounter];
			rcounter++;
			mcounter++;
			merge(sorted, sortedLeft, sortedRight, lcounter, rcounter, mcounter);
		}
		return sorted;
	}

	/**
	 * Given two sorted lists left and right, where left is sorted in a
	 * non-descending order and right is sorted in a ***non-ascending*** order,
	 * return a list (of size left.length + right.length) sorted in a non-descending
	 * order, consisting of all elements of lists left and right.
	 * 
	 * @param left  a list sorted in a non-descending order
	 * @param right a list sorted in a non-ascending order
	 * @return a sorted list of size left.size() + right.size(), consisting of all
	 *         elements of lists left and right. e.g., mergeSortedListsV2({1, 3, 5,
	 *         7}, {8, 6, 4, 2}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         <b>You are forbidden to use the mergeSortedArraysV2 method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		if (left.size() == 0 && right.size() == 0) {
			return new ArrayList<>(0);
		}
		List<Integer> rightrev = new ArrayList<>(right.size());
		List<Integer> sortedRight = reverse(right, rightrev, right.size() - 1, 0);
		List<Integer> sorted = new ArrayList<>(right.size() + left.size());
		return merge(sorted, left, sortedRight, 0, 0, 0);
	}

	public List<Integer> reverse(List<Integer> array, List<Integer> arr, int i, int s) {
		if (array.size() == 0) {
			return new ArrayList<Integer>(0);
		}
		if (array.size() == 1) {
			return array;
		}
		if (i >= 0) {
			arr.add(s, array.get(i));
			return reverse(array, arr, i - 1, s + 1);
		}
		return arr;
	}

	public List<Integer> merge(List<Integer> sorted, List<Integer> sortedLeft, List<Integer> sortedRight, int lcounter,
			int rcounter, int mcounter) {
		if (sortedLeft.size() == 0 && sortedRight.size() == 0) {
			return new ArrayList<Integer>(0);
		}
		if (sortedLeft.size() == 0 && sortedRight.size() != 0) {
			return sortedRight;
		}
		if (sortedLeft.size() != 0 && sortedRight.size() == 0) {
			return sortedLeft;
		}
		if (rcounter == sortedRight.size()) {
			if (lcounter != sortedLeft.size()) {
				sorted.add(mcounter, sortedLeft.get(lcounter));
				lcounter++;
				mcounter++;
				merge(sorted, sortedLeft, sortedRight, lcounter, rcounter, mcounter);
			}
		}
		if (lcounter == sortedLeft.size()) {
			if (rcounter != sortedRight.size()) {
				sorted.add(mcounter, sortedRight.get(rcounter));
				rcounter++;
				mcounter++;
				merge(sorted, sortedLeft, sortedRight, lcounter, rcounter, mcounter);
			}
		}

		if (lcounter != sortedLeft.size() && rcounter != sortedRight.size()
				&& sortedLeft.get(lcounter) <= sortedRight.get(rcounter)) {
			sorted.add(mcounter, sortedLeft.get(lcounter));
			lcounter++;
			mcounter++;
			merge(sorted, sortedLeft, sortedRight, lcounter, rcounter, mcounter);
		} else if (lcounter != sortedLeft.size() && rcounter != sortedRight.size()
				&& sortedLeft.get(lcounter) > sortedRight.get(rcounter)) {
			sorted.add(mcounter, sortedRight.get(rcounter));
			rcounter++;
			mcounter++;
			merge(sorted, sortedLeft, sortedRight, lcounter, rcounter, mcounter);
		}

		return sorted;
	}

}
