package com.borrelunde.leetcodesolutions.problem0035.searchinsertposition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the test to the LeetCode problem: 35. Search Insert Position
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.28
 */
@DisplayName("Search Insert Position")
class SolutionTest {

	private final Solution solution = new Solution();

	@Test
	@DisplayName("Example one")
	void exampleOne() {
		int[] nums = {1, 3, 5, 6};
		int target = 5;

		int expected = 2;
		int actual = solution.searchInsert(nums, target);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Example two")
	void exampleTwo() {
		int[] nums = {1, 3, 5, 6};
		int target = 2;

		int expected = 1;
		int actual = solution.searchInsert(nums, target);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Example three")
	void exampleThree() {
		int[] nums = {1, 3, 5, 6};
		int target = 7;

		int expected = 4;
		int actual = solution.searchInsert(nums, target);

		assertEquals(expected, actual);
	}

	@Nested
	@DisplayName("Given array with one element")
	class GivenArrayWithOneElement {

		final int[] nums = {1};

		@Test
		@DisplayName("Should return index 0 when target is less than the element")
		void shouldReturnIndex0WhenTargetIsLessThanTheElement() {
			int expected = 0;
			int actual = solution.searchInsert(nums, Integer.MIN_VALUE);

			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Should return its index when target is equal to the element")
		void shouldReturnItsIndexWhenTargetIsEqualToTheElement() {
			int expected = 0;
			int actual = solution.searchInsert(nums, 1);

			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Should return index 1 when target is greater than the element")
		void shouldReturnIndex1WhenTargetIsGreaterThanTheElement() {
			int expected = 1;
			int actual = solution.searchInsert(nums, Integer.MAX_VALUE);

			assertEquals(expected, actual);
		}
	}

	@Nested
	@DisplayName("Given array with two elements")
	class GivenArrayWithTwoElements {

		final int[] nums = {1, 3};

		@Test
		@DisplayName("Should return index 0 when target is less than the first element")
		void shouldReturnIndex0WhenTargetIsLessThanTheFirstElement() {
			int expected = 0;
			int actual = solution.searchInsert(nums, Integer.MIN_VALUE);

			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Should return index 0 when target is equal to the first element")
		void shouldReturnIndex0WhenTargetIsEqualToTheFirstElement() {
			int expected = 0;
			int actual = solution.searchInsert(nums, 1);

			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Should return index 1 when target is greater than the first element and less than the second element")
		void shouldReturnIndex1WhenTargetIsGreaterThanTheFirstElementAndLessThanTheSecondElement() {
			int expected = 1;
			int actual = solution.searchInsert(nums, 2);

			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Should return index 1 when target is equal to the second element")
		void shouldReturnIndex1WhenTargetIsEqualToTheSecondElement() {
			int expected = 1;
			int actual = solution.searchInsert(nums, 3);

			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Should return index 2 when target is greater than the second element")
		void shouldReturnIndex2WhenTargetIsGreaterThanTheSecondElement() {
			int expected = 2;
			int actual = solution.searchInsert(nums, Integer.MAX_VALUE);

			assertEquals(expected, actual);
		}
	}

	@Nested
	@DisplayName("Given array with only the same element")
	class GivenArrayWithOnlyTheSameElement {

		final int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1};

		@Test
		@DisplayName("Should return index 0 when target is less than the element")
		void shouldReturnIndex0WhenTargetIsLessThanTheElement() {
			int expected = 0;
			int actual = solution.searchInsert(nums, Integer.MIN_VALUE);

			assertEquals(expected, actual);
		}

		@Test
		@DisplayName("Should return index 9 when target is greater than the element")
		void shouldReturnIndex9WhenTargetIsGreaterThanTheElement() {
			int expected = 9;
			int actual = solution.searchInsert(nums, Integer.MAX_VALUE);

			assertEquals(expected, actual);
		}
	}
}