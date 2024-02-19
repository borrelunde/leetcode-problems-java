package com.borrelunde.leetcodesolutions.problem0278.firstbadversion;

/**
 * This is the solution to the LeetCode problem: 278. First Bad Version
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.02.18
 */
public class Solution extends VersionControl {

	public int firstBadVersion(int n) {

		// Low and high boundaries for the binary search.
		int low = 1;  // Versions start from 1, not 0.
		int high = n;

		// Binary search to find the first bad version.
		while (low <= high) {

			// Calculate middle and avoid integer overflow. Bitwise right shift
			// (>> 1) is used instead of dividing by 2.
			final int middle = low + ((high - low) >> 1);

			// Narrow the search based on the version check.
			if (isBadVersion(middle)) {
				// Adjust the search to the left half (exclude this version).
				high = middle - 1;
			} else {
				// Adjust the search to the right half (exclude this version).
				low = middle + 1;
			}
		}

		// At the end of the loop, low is the first bad version.
		return low;
	}
}
