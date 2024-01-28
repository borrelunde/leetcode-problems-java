package com.borrelunde.leetcodesolutions.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution to the LeetCode problem: 13. Roman to Integer
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.23
 */
class Solution {

	// A map of roman numeral symbols by value.
	static final Map<Character, Integer> ROMAN_NUMERAL_SYMBOLS_BY_VALUE = new HashMap<>();

	// Initialize the map.
	static {
		ROMAN_NUMERAL_SYMBOLS_BY_VALUE.put('I', 1);
		ROMAN_NUMERAL_SYMBOLS_BY_VALUE.put('V', 5);
		ROMAN_NUMERAL_SYMBOLS_BY_VALUE.put('X', 10);
		ROMAN_NUMERAL_SYMBOLS_BY_VALUE.put('L', 50);
		ROMAN_NUMERAL_SYMBOLS_BY_VALUE.put('C', 100);
		ROMAN_NUMERAL_SYMBOLS_BY_VALUE.put('D', 500);
		ROMAN_NUMERAL_SYMBOLS_BY_VALUE.put('M', 1000);
	}

	public int romanToInt(String romanNumberAsString) {

		// The sum of the roman numeral symbols.
		int sum = 0;

		// Convert the roman numeral string to a character array that we can
		// iterate over.
		final char[] characters = romanNumberAsString.toCharArray();

		// The value of the current roman numeral symbol (used in the loop).
		int currentValue;

		// The value of the previous roman numeral symbol (used in the loop).
		int previousValue = 0;

		// Iterate over the roman numeral symbols in reverse order. That way we
		// can traverse the roman numeral symbols in "ascending" order.
		for (int i = characters.length - 1; i >= 0; i--) {

			// This is the current character we're iterating over.
			final char character = characters[i];

			// Retrieve the value of the roman numeral symbol.
			currentValue = ROMAN_NUMERAL_SYMBOLS_BY_VALUE.get(character);

			// If the previous value is greater than the current value, we need
			// to subtract the current value from the sum. Otherwise, we need to
			// add the current value to the sum.
			if (previousValue > currentValue) {
				sum -= currentValue;
			} else {
				sum += currentValue;
			}

			// Set the previous value to the current value.
			previousValue = currentValue;
		}

		// Return the sum.
		return sum;
	}
}
