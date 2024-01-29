package com.borrelunde.leetcodesolutions.problem0744.findsmallestlettergreaterthantarget;

/**
 * This is the solution to the LeetCode problem: 744. Find Smallest Letter
 * Greater Than Target
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.29
 */
public class Solution {

	public char nextGreatestLetter(char[] letters, char target) {

		int lowIndex = 0;
		int highIndex = letters.length - 1;

		// Binary search.
		while (lowIndex <= highIndex) {

			final int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
			final char middleCharacter = letters[middleIndex];

			if (middleCharacter > target) {
				highIndex = middleIndex - 1;
			} else {
				lowIndex = middleIndex + 1;
			}
		}

		// After the search, the low index is the index of the smallest
		// greatest character. The only chance it isn't is if the index
		// surpasses the array and is out of bounds.

		// In that case, return the first character in letters.
		if (lowIndex >= letters.length) {
			return letters[0];
		}

		// Otherwise, return the character at its position.
		return letters[lowIndex];
	}
}
