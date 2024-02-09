package com.borrelunde.leetcodesolutions.problem0436.findrightinterval;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution to the LeetCode problem: 436. Find Right Interval
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.02.09
 */
public class Solution {

	private static final int INVALID_INDEX = - 1;

	public int[] findRightInterval(int[][] intervals) {

		// Map to store the start value and index of each interval.
		Map<Integer, Integer> intervalStartValueByIndex = new HashMap<>();
		for (int i = 0; i < intervals.length; i++) {
			intervalStartValueByIndex.put(intervals[i][0], i);
		}

		// Sort the intervals so that a binary search can be used on it.
		sort(intervals);

		// The array to store the right interval indices.
		int[] result = new int[intervals.length];

		// Find the right interval for each interval.
		for (int[] interval : intervals) {
			int intervalIndex = intervalStartValueByIndex.get(interval[0]);
			int rightIntervalIndex = binarySearch(intervals, interval[1]);
			result[intervalIndex] = rightIntervalIndex == INVALID_INDEX
					? INVALID_INDEX
					: intervalStartValueByIndex.get(intervals[rightIntervalIndex][0]);
		}

		// Return the right interval indices array.
		return result;
	}

	private static int binarySearch(int[][] intervals, int target) {

		int low = 0;
		int high = intervals.length - 1;

		while (low <= high) {
			// Calculate the middle index of the array. Bitwise shift to the
			// right is the same as dividing by 2, but faster.
			int middle = low + ((high - low) >> 1);

			if (intervals[middle][0] >= target) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}

		// After the loop, low is the smallest index of the interval whose start
		// value is greater than or equal to the target. However, we need to
		// check if it is within the bounds of the array. If it is not, then
		// the target was not found.

		return low < intervals.length ? low : INVALID_INDEX;
	}

	private static void sort(int[][] matrix) {

		// A temporary matrix is used in the sorting algorithm to store sorted
		// elements before it is copied to the original matrix.
		int[][] tempMatrix = new int[matrix.length][2];

		// Start the recursive merge-sorting process.
		mergeSort(matrix, tempMatrix, 0, matrix.length - 1);
	}

	private static void mergeSort(int[][] matrix, int[][] tempMatrix, int low, int high) {

		// If the matrix has 0 or 1 elements, it's already sorted.
		if (low >= high) {
			return;  // Break out of recursion.
		}

		// Calculate the middle index of the array. Bitwise shift to the right
		// is the same as dividing by 2, but faster.
		int middle = low + ((high - low) >> 1);
		mergeSort(matrix, tempMatrix, low, middle);  // Sort the left half.
		mergeSort(matrix, tempMatrix, middle + 1, high);  // Sort the right half.
		merge(matrix, tempMatrix, low, middle, high);  // Merge the two sorted halves.
	}

	private static void merge(int[][] matrix, int[][] tempMatrix, int low, int middle, int high) {

		// Indices for left and right halves, and the temporary helper matrix.
		int left = low;
		int right = middle + 1;
		int temp = 0;

		// Merge left and right halves into the temporary matrix.
		while (left <= middle && right <= high) {
			if (matrix[left][0] <= matrix[right][0]) {
				tempMatrix[temp++] = matrix[left++];
			} else {
				tempMatrix[temp++] = matrix[right++];
			}
		}

		// If there are remaining elements in the left half, copy them into the
		// temporary matrix.
		while (left <= middle) {
			tempMatrix[temp++] = matrix[left++];
		}

		// The same goes for the right half.
		while (right <= high) {
			tempMatrix[temp++] = matrix[right++];
		}

		// Finally, copy the sorted elements from the temporary matrix to the
		// original matrix.
		for (int i = 0; i < temp; i++) {
			matrix[low + i] = tempMatrix[i];
		}
	}
}
