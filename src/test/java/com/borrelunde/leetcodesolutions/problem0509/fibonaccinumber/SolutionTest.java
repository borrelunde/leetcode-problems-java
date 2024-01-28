package com.borrelunde.leetcodesolutions.problem0509.fibonaccinumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the test to the LeetCode problem: 509. Fibonacci Number
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.27
 */
@DisplayName("Fibonacci Number")
class SolutionTest {

	final Solution solution = new Solution();

	@Test
	@DisplayName("Example one")
	void exampleOne() {
		int n = 2;
		int expected = 1;
		int actual = solution.fib(n);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Example two")
	void exampleTwo() {
		int n = 3;
		int expected = 2;
		int actual = solution.fib(n);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Example three")
	void exampleThree() {
		int n = 4;
		int expected = 3;
		int actual = solution.fib(n);
		assertEquals(expected, actual);
	}

	static Stream<Arguments> provideFibonacciNumbersFromZeroToThirty() {
		return Stream.of(
				Arguments.of(0, 0),
				Arguments.of(1, 1),
				Arguments.of(2, 1),
				Arguments.of(3, 2),
				Arguments.of(4, 3),
				Arguments.of(5, 5),
				Arguments.of(6, 8),
				Arguments.of(7, 13),
				Arguments.of(8, 21),
				Arguments.of(9, 34),
				Arguments.of(10, 55),
				Arguments.of(11, 89),
				Arguments.of(12, 144),
				Arguments.of(13, 233),
				Arguments.of(14, 377),
				Arguments.of(15, 610),
				Arguments.of(16, 987),
				Arguments.of(17, 1597),
				Arguments.of(18, 2584),
				Arguments.of(19, 4181),
				Arguments.of(20, 6765),
				Arguments.of(21, 10946),
				Arguments.of(22, 17711),
				Arguments.of(23, 28657),
				Arguments.of(24, 46368),
				Arguments.of(25, 75025),
				Arguments.of(26, 121393),
				Arguments.of(27, 196418),
				Arguments.of(28, 317811),
				Arguments.of(29, 514229),
				Arguments.of(30, 832040)
				// Stop at 30 because the problem description
				// uses that as its upper limit.
		);
	}

	@ParameterizedTest(name = "n {0} is Fibonacci number {1}")
	@DisplayName("Fibonacci numbers from zero to thirty")
	@MethodSource("provideFibonacciNumbersFromZeroToThirty")
	void fibonacciNumbersFromZeroToThirty(int n, int expected) {
		int actual = solution.fib(n);
		assertEquals(expected, actual);
	}
}