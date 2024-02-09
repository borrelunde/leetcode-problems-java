package com.borrelunde.leetcodesolutions.problem0436.findrightinterval;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * This is the test to the LeetCode problem: 463. Find Right Interval
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.02.09
 */
@DisplayName("Find Right Interval")
class SolutionTest {

	private final Solution solution = new Solution();

	@Test
	@DisplayName("Example one")
	void exampleOne() {
		int[][] intervals = new int[][]{
				{1, 2}
		};

		int[] expected = new int[]{- 1};
		int[] actual = solution.findRightInterval(intervals);

		assertArrayEquals(expected, actual);
	}

	@Test
	@DisplayName("Example two")
	void exampleTwo() {
		int[][] intervals = new int[][]{
				{3, 4},
				{2, 3},
				{1, 2}
		};

		int[] expected = new int[]{- 1, 0, 1};
		int[] actual = solution.findRightInterval(intervals);

		assertArrayEquals(expected, actual);
	}

	@Test
	@DisplayName("Example three")
	void exampleThree() {
		int[][] intervals = new int[][]{
				{1, 4},
				{2, 3},
				{3, 4}
		};

		int[] expected = new int[]{- 1, 2, - 1};
		int[] actual = solution.findRightInterval(intervals);

		assertArrayEquals(expected, actual);
	}

	@Test
	@DisplayName("Empty matrix")
	void emptyMatrix() {
		int[][] intervals = new int[][]{
				// Empty.
		};

		int[] expected = new int[]{};
		int[] actual = solution.findRightInterval(intervals);

		assertArrayEquals(expected, actual);
	}

	@Test
	@DisplayName("Large interval that encompasses others")
	void largeIntervalEncompassesOthers() {
		int[][] intervals = {
				{1, 100},
				{2, 3},
				{4, 5},
				{6, 7}
		};
		int[] expected = {- 1, 2, 3, - 1};
		int[] actual = solution.findRightInterval(intervals);
		assertArrayEquals(expected, actual);
	}

	@Test
	@DisplayName("Non-overlapping, consecutive intervals")
	void nonOverlappingConsecutiveIntervals() {
		int[][] intervals = {
				{1, 2},
				{2, 3},
				{3, 4}
		};
		int[] expected = {1, 2, - 1};
		int[] actual = solution.findRightInterval(intervals);
		assertArrayEquals(expected, actual);
	}

	@Test
	@DisplayName("Reverse ordered intervals")
	void reverseOrderedIntervals() {
		int[][] intervals = {
				{3, 4},
				{2, 3},
				{1, 2}
		};
		int[] expected = {- 1, 0, 1};
		int[] actual = solution.findRightInterval(intervals);
		assertArrayEquals(expected, actual);
	}

	@Test
	@DisplayName("Intervals with large numbers")
	void intervalsWithLargeNumbers() {
		int[][] intervals = {
				{1000000, 2000000},
				{2000000, 3000000},
				{3000000, 4000000}
		};
		int[] expected = {1, 2, - 1};
		int[] actual = solution.findRightInterval(intervals);
		assertArrayEquals(expected, actual);
	}
}