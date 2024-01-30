package com.borrelunde.leetcodesolutions.problem0034.findfirstandlastpositionofelementinsortedarray;

/**
 * This is the solution to the LeetCode problem: 34. Find First and Last
 * Position of Element in Sorted Array
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.30
 */
public class Solution {

	public int[] searchRange(int[] nums, int target) {
		final int leftIndex = binarySearch(nums, target, true);
		final int rightIndex = binarySearch(nums, target, false);
		return new int[]{leftIndex, rightIndex};
	}

	private static int binarySearch(int[] nums, int target, boolean first) {

		int low = 0;
		int high = nums.length;

		while (low < high) {

			// Bitwise right shift (>> 1) divides by two to get the middle.
			final int searchIndex = low + ((high - low) >> 1);
			final int searchValue = nums[searchIndex];

			// If the search value is equal to the target, we should check if
			// its index meets the criteria of either the leftmost instance of
			// the target or the rightmost instance of the target. Otherwise,
			// narrow the search in the direction required.
			if (searchValue == target) {

				// This is a check to find either the leftmost instance of the
				// target or the rightmost instance of the target.
				if (first) {
					// If there is no index to the left, simply return the
					// search index.
					if (searchIndex == 0) {
						return searchIndex;
					}

					// Otherwise, check if the left value is less than the
					// target. If it is, we know the search index is the
					// leftmost instance of target.
					final int leftValue = nums[searchIndex - 1];
					if (leftValue < target) {
						return searchIndex;
					}

					// However, if left is not, narrow the search to the left.
					high = searchIndex;
				} else {
					// If there is no index to the right, simply return the
					// search index. As above, but in the other direction.
					if (searchIndex >= nums.length - 1) {
						return searchIndex;
					}

					// Otherwise, check if the right value is less than the
					// target. If it is, we know the search index is the
					// rightmost instance of target.
					final int rightValue = nums[searchIndex + 1];
					if (rightValue > target) {
						return searchIndex;
					}

					// However, if right is not, narrow the search to the right.
					low = searchIndex + 1;
				}
			} else if (searchValue > target) {
				high = searchIndex;
			} else {
				low = searchIndex + 1;
			}
		}

		// Return invalid because the target was not found.
		return - 1;
	}
}