package com.borrelunde.leetcodesolutions.integer_to_roman;

/**
 * This is the solution to the LeetCode problem: 12. Integer to Roman
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.27
 */
public class Solution {

	// This class stores the Roman numeral and its corresponding integer value.
	// (First I used a map, but the solution became really clumsy.)
	private static class RomanNumeral {

		private final int value;
		private final String numeral;

		public RomanNumeral(final int number, final String symbol) {
			this.value = number;
			this.numeral = symbol;
		}

		// No getters are needed because it's a private inner class.
	}

	// The Roman numerals are sorted in descending order because we want to
	// start with the largest and subtract our way down.
	private static final RomanNumeral[] ROMAN_NUMERALS = {
			new RomanNumeral(1000, "M"),
			new RomanNumeral(900, "CM"),
			new RomanNumeral(500, "D"),
			new RomanNumeral(400, "CD"),
			new RomanNumeral(100, "C"),
			new RomanNumeral(90, "XC"),
			new RomanNumeral(50, "L"),
			new RomanNumeral(40, "XL"),
			new RomanNumeral(10, "X"),
			new RomanNumeral(9, "IX"),
			new RomanNumeral(5, "V"),
			new RomanNumeral(4, "IV"),
			new RomanNumeral(1, "I")
	};

	public String intToRoman(int num) {

		// It is faster to use a string builder than a string.
		final StringBuilder builder = new StringBuilder();

		// Go through every Roman numeral and subtract our way down, while
		// appending the Roman numeral to the string builder.
		for (final RomanNumeral romanNumeral : ROMAN_NUMERALS) {
			while (num >= romanNumeral.value) {
				num -= romanNumeral.value;
				builder.append(romanNumeral.numeral);
			}
		}
		return builder.toString();
	}
}
