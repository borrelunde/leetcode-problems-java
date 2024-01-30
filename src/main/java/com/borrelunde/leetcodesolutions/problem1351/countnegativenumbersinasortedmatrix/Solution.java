package com.borrelunde.leetcodesolutions.problem1351.countnegativenumbersinasortedmatrix;

/**
 * This is the solution to the LeetCode problem: 1351. Count Negative Numbers in
 * a Sorted Matrix
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.30
 */
public class Solution {

	public int countNegatives(int[][] grid) {

		// This is the sum of negative numbers that will be returned.
		int sum = 0;

		// Perform a binary search in every row to find the number of negative
		// numbers in each. That number is added to the sum.
		for (final int[] row : grid) {

			int low = 0;
			int high = row.length;

			while (low < high) {

				// Bitwise right shift (>> 1) divides by two to get the middle.
				final int searchIndex = low + ((high - low) >> 1);

				// The target is (-1), the first possible negative number.
				if (row[searchIndex] > - 1) {
					low = searchIndex + 1;
				} else {
					high = searchIndex;
				}
			}

			// Low represents the index of the first negative number in the row.
			// Given we know all elements after it are negative, we can use it
			// to calculate the number of negative numbers instead of actually
			// counting them.
			sum += row.length - low;
		}

		// Return the sum of negative numbers.
		return sum;
	}
}
