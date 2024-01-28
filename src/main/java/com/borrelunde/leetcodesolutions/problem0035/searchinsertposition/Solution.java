package com.borrelunde.leetcodesolutions.problem0035.searchinsertposition;

/**
 * This is the solution to the LeetCode problem: 35. Search Insert Position
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.28
 */
public class Solution {

	public int searchInsert(int[] nums, int target) {

		int low = 0;
		int high = nums.length - 1;

		int middleIndex = 0;
		int middleValue = 0;

		// Binary search. This is documented more in the solution to the
		// LeetCode problem 704. Binary Search.
		while (low <= high) {

			middleIndex = low + (high - low) / 2;
			middleValue = nums[middleIndex];

			if (middleValue == target) {
				return middleIndex;
			} else if (middleValue > target) {
				high = middleIndex - 1;
			} else {
				low = middleIndex + 1;
			}
		}

		// If we get here, the binary search didn't find the target. So, let's
		// insert it. If the target is less than the value at the middle index,
		// we simply replace that. Otherwise, after it.
		return target < middleValue
				? middleIndex  // Take the place of the existing element.
				: middleIndex + 1;
	}
}
