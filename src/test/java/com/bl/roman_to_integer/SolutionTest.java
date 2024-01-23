package com.bl.roman_to_integer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the test to the LeetCode problem: 13. Roman to Integer
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.23
 */
@DisplayName("Roman to Integer")
class SolutionTest {

	@Test
	@DisplayName("Example one")
	void exampleOne() {
		String s = "III";
		int expected = 3;
		assertEquals(expected, new Solution().romanToInt(s));
	}

	@Test
	@DisplayName("Example two")
	void exampleTwo() {
		String s = "LVIII";
		int expected = 58;
		assertEquals(expected, new Solution().romanToInt(s));
	}

	@Test
	@DisplayName("Example three")
	void exampleThree() {
		String s = "MCMXCIV";
		int expected = 1994;
		assertEquals(expected, new Solution().romanToInt(s));
	}

	@Test
	@DisplayName("Roman IV")
	void romanIv() {
		String s = "IV";
		int expected = 4;
		assertEquals(expected, new Solution().romanToInt(s));
	}

	@Test
	@DisplayName("Roman VII")
	void romanVii() {
		String s = "VII";
		int expected = 7;
		assertEquals(expected, new Solution().romanToInt(s));
	}
}