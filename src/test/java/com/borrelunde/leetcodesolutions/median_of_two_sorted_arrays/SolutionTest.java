package com.borrelunde.leetcodesolutions.median_of_two_sorted_arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This is the test to the LeetCode problem: 4. Median of Two Sorted Arrays
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.25
 */
@DisplayName("Median of Two Sorted Arrays")
class SolutionTest {

	private final Solution solution = new Solution();

	@Test
	@DisplayName("Example one")
	void exampleOne() {
		int[] nums1 = {1, 3};
		int[] nums2 = {2};

		double expected = 2.00000;
		double actual = solution.findMedianSortedArrays(nums1, nums2);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Example two")
	void exampleTwo() {
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};

		double expected = 2.50000;
		double actual = solution.findMedianSortedArrays(nums1, nums2);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Even combined arrays length")
	void evenCombinedArraysLength() {
		int[] nums1 = {1, 3};
		int[] nums2 = {2, 4};

		double expected = 2.5;
		double actual = solution.findMedianSortedArrays(nums1, nums2);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Odd combined arrays length")
	void oddCombinedArraysLength() {
		int[] nums1 = {1, 3};
		int[] nums2 = {2};

		double expected = 2.0;
		double actual = solution.findMedianSortedArrays(nums1, nums2);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("One empty array")
	void oneEmptyArray() {
		int[] nums1 = {};
		int[] nums2 = {1, 2, 3, 4, 5};

		double expected = 3.0;
		double actual = solution.findMedianSortedArrays(nums1, nums2);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Both arrays empty")
	void bothArraysEmpty() {
		int[] nums1 = {};
		int[] nums2 = {};

		assertThrows(IllegalArgumentException.class,
				() -> solution.findMedianSortedArrays(nums1, nums2));
	}

	@Test
	@DisplayName("Arrays with negative numbers")
	void arraysWithNegativeNumbers() {
		int[] nums1 = {- 5, - 3, - 1};
		int[] nums2 = {- 2, - 1, 4, 6};

		double expected = - 1.0;
		double actual = solution.findMedianSortedArrays(nums1, nums2);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("First array large and second array small")
	void firstArrayLargeAndSecondArraySmall() {
		int[] nums1 = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		int[] nums2 = {1, 2, 3};

		double expected = 8.0;
		double actual = solution.findMedianSortedArrays(nums1, nums2);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("First array small and second array large")
	void firstArraySmallAndSecondArrayLarge() {
		int[] nums1 = {1, 2, 3};
		int[] nums2 = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

		double expected = 8.0;
		double actual = solution.findMedianSortedArrays(nums1, nums2);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Arrays with a single element each")
	void arraysWithASingleElementEach() {
		int[] nums1 = {1};
		int[] nums2 = {2};

		double expected = 1.5;
		double actual = solution.findMedianSortedArrays(nums1, nums2);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Arrays with identical elements")
	void arraysWithIdenticalElements() {
		int[] nums1 = {2, 2, 2};
		int[] nums2 = {2, 2, 2};

		double expected = 2.0;
		double actual = solution.findMedianSortedArrays(nums1, nums2);

		assertEquals(expected, actual);
	}
}