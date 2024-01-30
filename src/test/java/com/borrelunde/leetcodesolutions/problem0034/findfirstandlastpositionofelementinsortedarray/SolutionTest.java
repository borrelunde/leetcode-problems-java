package com.borrelunde.leetcodesolutions.problem0034.findfirstandlastpositionofelementinsortedarray;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * This is the test to the LeetCode problem: 34. Find First and Last Position of
 * Element in Sorted Array
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.30
 */
@DisplayName("Find First and Last Position of Element in Sorted Array")
class SolutionTest {

	private final Solution solution = new Solution();

	private static final int MINIMUM = - 1_000_000_000;
	private static final int MAXIMUM = 1_000_000_000;

	@Test
	@DisplayName("Example one")
	void exampleOne() {
		int[] nums = {5, 7, 7, 8, 8, 10};
		int target = 8;

		int[] expected = new int[]{3, 4};
		int[] actual = solution.searchRange(nums, target);

		assertArrayEquals(expected, actual);
	}

	@Test
	@DisplayName("Example two")
	void exampleTwo() {
		int[] nums = {5, 7, 7, 8, 8, 10};
		int target = 6;

		int[] expected = new int[]{- 1, - 1};
		int[] actual = solution.searchRange(nums, target);

		assertArrayEquals(expected, actual);
	}

	@Test
	@DisplayName("Should return invalid when array is empty")
	void shouldReturnInvalidWhenArrayIsEmpty() {
		int[] nums = {};
		int target = 0;

		int[] expected = new int[]{- 1, - 1};
		int[] actual = solution.searchRange(nums, target);

		assertArrayEquals(expected, actual);
	}

	@Test
	@DisplayName("Should return the same element when the array contains the target only once")
	void shouldReturnTheSameElementWhenTheArrayContainsTheTargetOnlyOnce() {
		int[] nums = {- 2, - 1, 0, 1, 2};
		int target = 0;

		int[] expected = new int[]{2, 2};
		int[] actual = solution.searchRange(nums, target);

		assertArrayEquals(expected, actual);
	}

	@Nested
	@DisplayName("When the array contains only the same number")
	class WhenTheArrayContainsOnlyTheSameNumber {

		final int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

		@Test
		@DisplayName("Should return invalid when target is greater than that number")
		void shouldReturnInvalidWhenTargetIsGreaterThanThatNumber() {
			int target = 2;

			int[] expected = {- 1, - 1};
			int[] actual = solution.searchRange(nums, target);

			assertArrayEquals(expected, actual);
		}

		@Test
		@DisplayName("Should return invalid when target is less than that number")
		void shouldReturnInvalidWhenTargetIsLessThanThatNumber() {
			int target = 0;

			int[] expected = {- 1, - 1};
			int[] actual = solution.searchRange(nums, target);

			assertArrayEquals(expected, actual);
		}

		@Test
		@DisplayName("Should return first and last element position when target is that number")
		void shouldReturnFirstAndLastElementPositionWhenTargetIsThatNumber() {
			int target = 1;

			int[] expected = {0, 9};
			int[] actual = solution.searchRange(nums, target);

			assertArrayEquals(expected, actual);
		}
	}

	@Nested
	@DisplayName("When the array contains the minimum number")
	class WhenTheArrayContainsTheMinimumNumber {

		final int[] nums = {MINIMUM, MINIMUM, - 1, 0, 1, 2};

		@Test
		@DisplayName("Should return first and last element when target is that number")
		void shouldReturnFirstAndLastElementWhenTargetIsThatNumber() {
			int[] expected = {0, 1};
			int[] actual = solution.searchRange(nums, MINIMUM);

			assertArrayEquals(expected, actual);
		}

		@Test
		@DisplayName("Should return first and last element when target is another number")
		void shouldReturnFirstAndLastElementWhenTargetIsAnotherNumber() {
			int target = 0;

			int[] expected = {3, 3};
			int[] actual = solution.searchRange(nums, target);

			assertArrayEquals(expected, actual);
		}
	}

	@Nested
	@DisplayName("When the array contains the maximum number")
	class WhenTheArrayContainsTheMaximumNumber {

		final int[] nums = {- 1, 0, 1, 2, MAXIMUM, MAXIMUM};


		@Test
		@DisplayName("Should return first and last element when target is that number")
		void shouldReturnFirstAndLastElementWhenTargetIsThatNumber() {
			int[] expected = {4, 5};
			int[] actual = solution.searchRange(nums, MAXIMUM);

			assertArrayEquals(expected, actual);
		}

		@Test
		@DisplayName("Should return first and last element when target is another number")
		void shouldReturnFirstAndLastElementWhenTargetIsAnotherNumber() {
			int target = 0;

			int[] expected = {1, 1};
			int[] actual = solution.searchRange(nums, target);

			assertArrayEquals(expected, actual);
		}
	}
}