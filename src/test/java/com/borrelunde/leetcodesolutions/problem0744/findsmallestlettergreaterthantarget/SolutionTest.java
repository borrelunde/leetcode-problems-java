package com.borrelunde.leetcodesolutions.problem0744.findsmallestlettergreaterthantarget;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the test to the LeetCode problem: 744. Find Smallest Letter Greater
 * Than Target
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.29
 */
@DisplayName("Find Smallest Letter Greater Than Target")
class SolutionTest {

	private final Solution solution = new Solution();

	@Test
	@DisplayName("Example one")
	void exampleOne() {
		char[] letters = {'c', 'f', 'j'};
		char target = 'a';

		char expected = 'c';
		char actual = solution.nextGreatestLetter(letters, target);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Example two")
	void exampleTwo() {
		char[] letters = {'c', 'f', 'j'};
		char target = 'c';

		char expected = 'f';
		char actual = solution.nextGreatestLetter(letters, target);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Example three")
	void exampleThree() {
		char[] letters = {'x', 'x', 'y', 'y'};
		char target = 'z';

		char expected = 'x';
		char actual = solution.nextGreatestLetter(letters, target);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Should return first letter when target is last element in array")
	void shouldReturnFirstLetterWhenTargetIsLastElementInArray() {
		char[] letters = {'a', 'b', 'c', 'd', 'f', 'g'};
		char target = 'g';

		char expected = 'a';
		char actual = solution.nextGreatestLetter(letters, target);

		assertEquals(expected, actual);
	}

	static Stream<Arguments> provideLettersWithTargetInMiddleButNotPresent() {
		return Stream.of(
				Arguments.of(new char[]{'b', 'd'}, 'c', 'd'),
				Arguments.of(new char[]{'a', 'b', 'd', 'e'}, 'c', 'd'),
				Arguments.of(new char[]{'m', 'n', 'p', 'q'}, 'o', 'p'),
				Arguments.of(new char[]{'n', 'n', 'p', 'p'}, 'o', 'p'),
				Arguments.of(new char[]{'a', 'b', 'x', 'y'}, 'c', 'x'),
				Arguments.of(new char[]{'c', 'f', 'j'}, 'd', 'f')
		);
	}

	@ParameterizedTest(name = "In {0} with target {1} should return {2}")
	@DisplayName("Should return smallest greater character when target is not in array")
	@MethodSource("provideLettersWithTargetInMiddleButNotPresent")
	void shouldReturnSmallestGreaterCharacterWhenTargetIsNotInArray(char[] letters, char target, char expected) {
		char actual = solution.nextGreatestLetter(letters, target);

		assertEquals(expected, actual);
	}
}