package com.borrelunde.leetcodesolutions.problem0008.stringtointegeratoi;

/**
 * This is the solution to the LeetCode problem: 8. String to Integer (atoi)
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.25
 */
public class Solution {

	static final char WHITESPACE = ' ';

	static final char PLUS = '+';
	static final char MINUS = '-';

	static final int MINIMUM_VALUE = 0x80000000;  // -2^31
	static final int MAXIMUM_VALUE = 0x7fffffff;  //  2^31 - 1

	public int myAtoi(String s) {

		// If the string is empty, return zero.
		if (s.isEmpty()) {
			return 0;
		}

		// Convert the string to a character array that we'll iterate over.
		final char[] characters = s.toCharArray();

		// Used to keep track of whether the number is negative or not.
		boolean negative = false;

		// This is the index used to iterate over the character array. It is
		// declared outside the loop so that it can be used in both loops.
		int i = 0;

		// First, ignore leading whitespace and account for explicit sign
		// symbol.
		for (; i < characters.length; i++) {
			char character = characters[i];

			// Ignore leading whitespace.
			if (character == WHITESPACE) {
				continue;
			}

			// Account for explicit sign symbol.
			else if (character == PLUS) {
				// The number is positive by default, so we don't need to do
				// set the negative flag to false.

				// Increment the index to skip the sign symbol.
				i++;
			} else if (character == MINUS) {
				negative = true;

				// Same as above.
				i++;
			}

			// If the character is not whitespace nor a sign symbol, we will
			// delegate the rest of the work to the next loop. It is responsible
			// for parsing the number.
			break;
		}

		// We're parsing an integer, but we're using a long to avoid overflow
		// and underflow.
		long number = 0;

		// Parse the number.
		for (; i < characters.length; i++) {
			final char character = characters[i];

			// If the character is not a digit, we will break out of the loop.
			if (! characterIsDigit(character)) {
				break;
			}

			// Convert the character to a digit.
			final int digit = digitFromCharacter(character);

			// First, multiply the number by ten to make room for the new digit.
			// Then, add the digit to the number, taking into account whether
			// the number is negative or not.
			number = number * 10 + (negative ? - digit : digit);

			// Clamp the number if it is greater than the maximum value.
			if (number <= MINIMUM_VALUE) {
				return MINIMUM_VALUE;
			}

			// Clamp the number if it is less than the minimum value.
			else if (number >= MAXIMUM_VALUE) {
				return MAXIMUM_VALUE;
			}
		}

		// Return the number as an integer.
		return (int) number;
	}

	static int digitFromCharacter(final char character) {
		// Assumes the digit character is in the ASCII table.
		return character - '0';
	}

	static boolean characterIsDigit(final char character) {
		// Assumes the character is in the ASCII table.
		return character >= '0' && character <= '9';
	}
}
