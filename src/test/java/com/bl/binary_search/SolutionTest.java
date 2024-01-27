package com.bl.binary_search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This is the test to the LeetCode problem: 704. Binary Search
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.27
 */
@DisplayName("Binary Search")
class SolutionTest {

	private final Solution solution = new Solution();

	@Test
	@DisplayName("Example one")
	void exampleOne() {
		int[] nums = {- 1, 0, 3, 5, 9, 12};
		int target = 9;

		int expected = 4;
		int actual = solution.search(nums, target);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Example two")
	void exampleTwo() {
		int[] nums = {- 1, 0, 3, 5, 9, 12};
		int target = 2;

		int expected = - 1;
		int actual = solution.search(nums, target);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Empty array should return -1")
	void emptyArrayShouldReturn1() {
		int[] nums = {};
		int target = 9;  // Doesn't matter what the target is.

		int expected = - 1;
		int actual = solution.search(nums, target);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Target is a negative number")
	void targetIsANegativeNumber() {
		int[] nums = {- 1, 0, 3, 5, 9, 12};
		int target = - 1;

		int expected = 0;
		int actual = solution.search(nums, target);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Target is larger than the largest number in the array")
	void targetIsLargerThanTheLargestNumberInTheArray() {
		int[] nums = {- 1, 0, 3, 5, 9, 12};
		int target = 13;

		int expected = - 1;
		int actual = solution.search(nums, target);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Target is smaller than the smallest number in the array")
	void targetIsSmallerThanTheSmallestNumberInTheArray() {
		int[] nums = {- 1, 0, 3, 5, 9, 12};
		int target = - 2;

		int expected = - 1;
		int actual = solution.search(nums, target);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("All elements in the array are the same")
	void allElementsInTheArrayAreTheSame() {
		int[] nums = {1, 1, 1, 1, 1, 1};
		int target = 1;

		int actual = solution.search(nums, target);

		// The actual index is not important, as long as it's a valid index.
		assertTrue(actual >= 0 && nums[actual] == target);
	}
}