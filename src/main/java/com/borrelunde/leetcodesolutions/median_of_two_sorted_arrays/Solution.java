package com.borrelunde.leetcodesolutions.median_of_two_sorted_arrays;

/**
 * This is the solution to the LeetCode problem: 4. Median of Two Sorted Arrays
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.25
 */
@SuppressWarnings("ManualMinMaxCalculation")
public class Solution {

	// This solution is made with readability in mind. It is not the most
	// efficient solution, but it should be understandable. And that's what
	// matters more for me.
	//
	// There are many ways to optimise for performance and memory usage. For
	// example by using bitwise operations for division, inlining methods and
	// constants, using the original arrays instead of copying them, and
	// reducing the number of helper variables and methods, etc.

	private static final int HYPOTHETICAL_NEGATIVE_INFINITY = 0x80000000;  // Integer minimum value.
	private static final int HYPOTHETICAL_POSITIVE_INFINITY = 0x7fffffff;  // Integer maximum value.

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		// Determine the smallest and largest array.
		final int[] leftArray = getSmallestArrayOf(nums1, nums2);
		final int[] rightArray = getLargestArrayOf(nums1, nums2);

		// Calculate the sizes of the arrays and their combined length. This
		// will be used in the partitioning of the arrays.
		final int leftArraySize = leftArray.length;
		final int rightArraySize = rightArray.length;
		final int combinedArraysLength = leftArraySize + rightArraySize;

		// According to the problem description, the arrays should never be
		// empty. If they are, then we throw an exception.
		if (leftArraySize == 0 && rightArraySize == 0) {
			throw new IllegalArgumentException("The arrays are empty.");
		}

		// Low and high for the binary search.
		int low = 0;
		int high = leftArraySize;

		// Binary search.
		while (low <= high) {

			// In simple steps, this is what goes on:
			//
			// 1. Calculate the partition indices for the arrays.
			//
			// 2. Get the left and right values of the partitions.
			//
			// 3. Check if the left side of the partition is less than or equal
			//    to the right side of the partition.
			//
			// 4. If the left side is less than or equal to the right side,
			//    then we have found the median.
			//
			// 5. If the left side is greater than the right side, then we need
			//    to move the partition to the left.
			//
			// 6. If the left side is less than the right side, then we need to
			//    move the partition to the right.

			// Calculate the partition indices for the arrays.
			final int leftArrayPartitionIndex = (low + high) / 2;
			final int rightArrayPartitionIndex = (combinedArraysLength + 1) / 2 - leftArrayPartitionIndex;

			// Get values at partition indices.
			final int leftArrayLeftValue = getLeftValueOfPartition(leftArray, leftArrayPartitionIndex);
			final int leftArrayRightValue = getRightValueOfPartition(leftArray, leftArrayPartitionIndex);

			final int rightArrayLeftValue = getLeftValueOfPartition(rightArray, rightArrayPartitionIndex);
			final int rightArrayRightValue = getRightValueOfPartition(rightArray, rightArrayPartitionIndex);

			// The left side is OK if the left value is less than or equal to
			// the right value. Equally, the right side is OK if the right
			// value is less than or equal to the left value.
			final boolean leftSideIsOk = leftArrayLeftValue <= rightArrayRightValue;
			final boolean rightSideIsOk = rightArrayLeftValue <= leftArrayRightValue;

			// If both sides are OK, then we can calculate the median.
			if (leftSideIsOk && rightSideIsOk) {

				// Get the maximum of the left values and the minimum of the
				// right values. The maximum and minimum are the closest values
				// to the middle.
				final int leftValue = getMaximumOf(leftArrayLeftValue, rightArrayLeftValue);
				final int rightValue = getMinimumOf(leftArrayRightValue, rightArrayRightValue);

				final double median;
				if (isEven(combinedArraysLength)) {
					// When the combined length is even, we need to calculate
					// the average of the two middle values.
					median = (leftValue + rightValue) / 2.0;
				} else {
					// It is easier when the combined length is odd. Then the
					// median is the middle (left) value.
					median = leftValue;
				}

				return median;
			}

			// Move the partition to the left if the left side is not OK.
			else if (! leftSideIsOk) {
				high = leftArrayPartitionIndex - 1;
			}

			// Vice versa for the right side.
			else {
				low = leftArrayPartitionIndex + 1;
			}
		}

		// Given the constraints of the problem, we should never reach this
		// point. If we reach here regardless, then something is wrong.
		throw new UnsupportedOperationException("Something went wrong.");
	}

	private static int getLeftValueOfPartition(final int[] array, final int index) {
		if (index <= 0) {
			// There is no left value at this index, so we return the smallest
			// possible value. We can then be sure that the value to its right
			// is greater or equal to it.
			return HYPOTHETICAL_NEGATIVE_INFINITY;
		}
		return array[index - 1];
	}

	private static int getRightValueOfPartition(final int[] array, final int index) {
		if (index >= array.length) {
			// The same goes for the right side, just the other way around.
			return HYPOTHETICAL_POSITIVE_INFINITY;
		}
		return array[index];
	}

	private static int[] getSmallestArrayOf(int[] a, int[] b) {
		return a.length <= b.length ? a : b;
	}

	private static int[] getLargestArrayOf(int[] a, int[] b) {
		return a.length <= b.length ? b : a;
	}

	private static boolean isEven(final int number) {
		return number % 2 == 0;
	}

	private static int getMaximumOf(final int a, final int b) {
		return a >= b ? a : b;
	}

	private static int getMinimumOf(final int a, final int b) {
		return a >= b ? b : a;
	}
}
