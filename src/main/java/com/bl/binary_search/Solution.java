package com.bl.binary_search;

/**
 * This is the solution to the LeetCode problem: 704. Binary Search
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.27
 */
public class Solution {

	public int search(int[] nums, int target) {

		int low = 0;
		int high = nums.length - 1;

		// The loop will continue until the target is found or the low and high
		// indices have crossed each other. In which the target was not found.
		while (low <= high) {

			// The reason why we don't use (low + high) / 2 is because it can
			// cause an integer overflow. For example:
			//   low  = 2 000 000 000
			//   high = 2 000 000 000
			//   low + high = 4 000 000 000    which is larger than the maximum
			//                                 integer value: 2 147 483 647
			final int middleIndex = low + (high - low) / 2;
			final int middleValue = nums[middleIndex];

			if (middleValue == target) {
				// The target was found, return its index.
				return middleIndex;
			} else if (middleValue > target) {
				// The target must be in the left half (lower half) of the array.
				high = middleIndex - 1;
			} else {
				// The target must be in the right half (upper half) of the array.
				low = middleIndex + 1;
			}
		}

		// -1 represents that the target was not found.
		return - 1;
	}
}
