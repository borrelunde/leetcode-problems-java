package com.borrelunde.leetcodesolutions.string_to_integer_atoi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the test to the LeetCode problem: 8. String to Integer (atoi)
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.25
 */
@DisplayName("String to Integer (atoi)")
class SolutionTest {

	@Test
	@DisplayName("Example one")
	void exampleOne() {
		String s = "42";
		int expected = 42;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Example two")
	void exampleTwo() {
		String s = "   -42";
		int expected = - 42;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Example three")
	void exampleThree() {
		String s = "4193 with words";
		int expected = 4193;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Leading whitespace should be ignored")
	void leadingWhitespaceShouldBeIgnored() {
		String s = "   555";
		int expected = 555;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Positive zero should be zero")
	void positiveZeroShouldBeZero() {
		String s = "0";
		int expected = 0;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Negative zero should be zero")
	void negativeZeroShouldBeZero() {
		String s = "-0";
		int expected = 0;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Positive sign should be ignored")
	void positiveSignShouldBeIgnored() {
		String s = "+30";
		int expected = 30;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Two plus signs should fail")
	void twoPlusSignsShouldFail() {
		String s = "++1";
		int expected = 0;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Two minus signs should fail")
	void twoMinusSignsShouldFail() {
		String s = "--1";
		int expected = 0;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Only text should be zero")
	void onlyTextShouldBeZero() {
		String s = "Hello world";
		int expected = 0;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Text and then a number should be zero")
	void textAndThenANumberShouldBeZero() {
		String s = "Hello world 123";
		int expected = 0;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Integer maximum should be integer maximum")
	void integerMaximumShouldBeIntegerMaximum() {
		String s = "2147483647";
		int expected = Integer.MAX_VALUE;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Integer minimum should be integer minimum")
	void integerMinimumShouldBeIntegerMinimum() {
		String s = "-2147483648";
		int expected = Integer.MIN_VALUE;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Greater than integer maximum should be clamped")
	void greaterThanIntegerMaximumShouldBeClamped() {
		String s = "2147483648"; // Only one more.
		int expected = Integer.MAX_VALUE;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Less than integer minimum should be clamped")
	void lessThanIntegerMinimumShouldBeClamped() {
		String s = "-2147483649";  // Only one less.
		int expected = Integer.MIN_VALUE;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Positive number beyond 10 digits should be clamped")
	void positiveNumberBeyondTenDigitsShouldBeClamped() {
		String s = "999999999999";
		int expected = Integer.MAX_VALUE;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Negative number beyond 10 digits should be clamped")
	void negativeNumberBeyondTenDigitsShouldBeClamped() {
		String s = "-999999999999";
		int expected = Integer.MIN_VALUE;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Empty string should be zero")
	void emptyStringShouldBeZero() {
		String s = "";
		int expected = 0;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("200 characters of text should be zero")
	void TwoHundredCharactersOfTextShouldBeZero() {
		String s = "Lorem ipsum dolor sit amet, consectetur adipiscing " +
				"elit. Aenean malesuada lorem quis justo iaculis, molestie " +
				"tristique massa suscipit. Phasellus maximus congue mi " +
				"vel vulputate. Etiam maximus egestas.";

		int expected = 0;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Positive two hundred digits should be integer maximum")
	void positiveTwoHundredDigitsShouldBeIntegerMaximum() {
		String s = "1234567890" +  // 10
				"1234567890" +     // 20
				"1234567890" +     // 30
				"1234567890" +     // 40
				"1234567890" +     // 50
				"1234567890" +     // 60
				"1234567890" +     // 70
				"1234567890" +     // 80
				"1234567890" +     // 90
				"1234567890" +     // 100
				"1234567890" +     // 110
				"1234567890" +     // 120
				"1234567890" +     // 130
				"1234567890" +     // 140
				"1234567890" +     // 150
				"1234567890" +     // 160
				"1234567890" +     // 170
				"1234567890" +     // 180
				"1234567890" +     // 190
				"1234567890";      // 200

		int expected = Integer.MAX_VALUE;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Negative two hundred digits should be integer minimum")
	void positiveTwoHundredDigitsShouldBeIntegerMinimum() {
		String s = "-1234567890" + // 10
				"1234567890" +     // 20
				"1234567890" +     // 30
				"1234567890" +     // 40
				"1234567890" +     // 50
				"1234567890" +     // 60
				"1234567890" +     // 70
				"1234567890" +     // 80
				"1234567890" +     // 90
				"1234567890" +     // 100
				"1234567890" +     // 110
				"1234567890" +     // 120
				"1234567890" +     // 130
				"1234567890" +     // 140
				"1234567890" +     // 150
				"1234567890" +     // 160
				"1234567890" +     // 170
				"1234567890" +     // 180
				"1234567890" +     // 190
				"1234567890";      // 200

		int expected = Integer.MIN_VALUE;
		int actual = new Solution().myAtoi(s);

		assertEquals(expected, actual);
	}
}