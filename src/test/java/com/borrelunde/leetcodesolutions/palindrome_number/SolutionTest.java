package com.borrelunde.leetcodesolutions.palindrome_number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the test to the LeetCode problem: 9. Palindrome Number
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.24
 */
@DisplayName("Palindrome Number")
class SolutionTest {

	@Test
	@DisplayName("Example one")
	void exampleOne() {
		int x = 121;
		boolean expected = true;
		boolean actual = new Solution().isPalindrome(x);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Example two")
	void exampleTwo() {
		int x = - 121;
		boolean expected = false;
		boolean actual = new Solution().isPalindrome(x);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Example three")
	void exampleThree() {
		int x = 10;
		boolean expected = false;
		boolean actual = new Solution().isPalindrome(x);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Integer minimum value is not a palindrome")
	void integerMinimumValueIsNotAPalindrome() {
		int x = Integer.MIN_VALUE;
		boolean expected = false;
		boolean actual = new Solution().isPalindrome(x);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Integer maximum value is not a palindrome")
	void integerMaximumValueIsNotAPalindrome() {
		int x = Integer.MAX_VALUE;
		boolean expected = false;
		boolean actual = new Solution().isPalindrome(x);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Zero is a palindrome number")
	void zeroIsAPalindromeNumber() {
		int x = 0;
		boolean expected = true;
		boolean actual = new Solution().isPalindrome(x);

		assertEquals(expected, actual);
	}

	@ParameterizedTest(name = "{0} is a palindrome ")
	@DisplayName("Selected numbers are palindromes")
	@ValueSource(ints = {1, 11, 121, 1_221, 12_321, 123_321,
			1_234_321, 12_344_321, 123_454_321, 1_234_554_321})
	void selectedNumbersArePalindromes(int x) {
		boolean expected = true;
		boolean actual = new Solution().isPalindrome(x);

		assertEquals(expected, actual);
	}

	@ParameterizedTest(name = "{0} is not a palindrome")
	@DisplayName("Selected numbers are not palindromes")
	@ValueSource(ints = {12, 123, 1_234, 12_345, 123_456, 1_234_567,
			12_345_678, 123_456_789, 1_234_567_890})
	void selectedNumbersAreNotPalindromes(int x) {
		boolean expected = false;
		boolean actual = new Solution().isPalindrome(x);

		assertEquals(expected, actual);
	}
}