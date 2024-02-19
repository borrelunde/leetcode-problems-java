package com.borrelunde.leetcodesolutions.problem0278.firstbadversion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the test to the LeetCode problem: 278. First Bad Version
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.02.18
 */
@DisplayName("First bad version")
class SolutionTest {

	private final Solution solution = new Solution();

	@Test
	@DisplayName("Example one")
	void exampleOne() {
		int n = 5;
		int bad = 4;

		solution.setBadVersion(bad);

		int expected = bad;
		int actual = solution.firstBadVersion(n);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("First version is bad")
	void firstVersionIsBad() {
		int n = 1;
		int bad = 1;

		solution.setBadVersion(bad);

		int expected = bad;
		int actual = solution.firstBadVersion(n);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Last version is bad")
	void lastVersionIsBad() {
		int n = Integer.MAX_VALUE;
		int bad = Integer.MAX_VALUE;

		solution.setBadVersion(bad);

		int expected = bad;
		int actual = solution.firstBadVersion(n);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Bad version is in the middle of many")
	void badVersionIsInTheMiddleOfMany() {
		int n = 1_000_000;
		int bad = 500_000;

		solution.setBadVersion(bad);

		int expected = bad;
		int actual = solution.firstBadVersion(n);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Bad version is minimum and n is maximum")
	void badVersionIsMinimumAndNIsMaximum() {
		int n = Integer.MAX_VALUE;
		int bad = 1;

		solution.setBadVersion(bad);

		int expected = bad;
		int actual = solution.firstBadVersion(n);

		assertEquals(expected, actual);
	}
}