package com.borrelunde.leetcodesolutions.problem1351.countnegativenumbersinasortedmatrix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the test to the LeetCode problem: 1351. Count Negative Numbers in a
 * Sorted Matrix
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.30
 */
@DisplayName("Count Negative Numbers in a Sorted Matrix")
class SolutionTest {

	private final Solution solution = new Solution();

	@Test
	@DisplayName("Example one")
	void exampleOne() {
		int[][] grid = {
				{4, 3, 2, - 1},
				{3, 2, 1, - 1},
				{1, 1, - 1, - 2},
				{- 1, - 1, - 2, - 3}
		};

		int expected = 8;
		int actual = solution.countNegatives(grid);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Example two")
	void exampleTwo() {
		int[][] grid = {
				{3, 2},
				{1, 0}
		};

		int expected = 0;
		int actual = solution.countNegatives(grid);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Should return zero when grid is empty")
	void shouldReturnZeroWhenGridIsEmpty() {
		int[][] grid = {{}};

		int expected = 0;
		int actual = solution.countNegatives(grid);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Should return zero when grid is one positive element")
	void shouldReturnZeroWhenGridIsOnePositiveElement() {
		int[][] grid = {
				{1}
		};

		int expected = 0;
		int actual = solution.countNegatives(grid);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Should return one when grid is one negative element")
	void shouldReturnOneWhenGridIsOneNegativeElement() {
		int[][] grid = {
				{- 1}
		};

		int expected = 1;
		int actual = solution.countNegatives(grid);

		assertEquals(expected, actual);
	}

	static Stream<Arguments> provideGrids() {
		return Stream.of(
				Arguments.of(new int[][]{
						{0, 0},
						{0, 0}
				}, 0),
				Arguments.of(new int[][]{
						{2, 1},
						{2, 1}
				}, 0),
				Arguments.of(new int[][]{
						{- 1, - 1},
						{- 1, - 1}
				}, 4),
				Arguments.of(new int[][]{
						{- 1, - 2},
						{- 1, - 2}
				}, 4),
				Arguments.of(new int[][]{
						{5, 4, 3, 2, 1},
						{4, 3, 2, 1, 0},
						{3, 2, 1, 0, - 1},
						{2, 1, 0, - 1, - 2},
						{1, 0, - 1, - 2, - 3},
				}, 6)
		);
	}

	@ParameterizedTest(name = "{1} negative numbers in {0}")
	@DisplayName("Count negative numbers in various sorted matrices")
	@MethodSource("provideGrids")
	void countNegativeNumbersInVariousSortedMatrices(int[][] grid, int expected) {
		int actual = solution.countNegatives(grid);

		assertEquals(expected, actual);
	}
}