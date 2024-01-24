package com.bl.palindrome_number;

/**
 * This is the solution to the LeetCode problem: 9. Palindrome Number
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.24
 */
public class Solution {

	public boolean isPalindrome(int x) {

		// Any negative number reads with the minus sign first. Since it cannot
		// appear in the rest of the number, we can with certainty say that a
		// palindrome number is never negative.
		if (x < 0) {
			return false;
		}

		// Any positive number containing only one digit is always a palindrome.
		if (x < 9) {
			return true;
		}

		// Apart from the negative number check, below is the "actual" solution
		// to the problem. The positive number check above is not necessary,
		// but it is a small optimisation that makes the solution faster if the
		// number is a single digit.

		// The maximum number of digits is 10 because:
		//   the minimum value is -2^31     = -2,147,483,648
		//   the maximum value is  2^31 - 1 =  2,147,483,647

		// This is the array to hold the digits of the number, the order is
		// irrelevant since a palindrome is same in both directions.
		int[] digits = new int[10];

		// This is the index of the rightmost digit in the array.
		int rightmostDigitIndex = 0;

		// Example of how the digits array is populated:
		// x = 12345
		//
		// index | array
		//     0 | [5]
		//     1 | [5,4]
		//     2 | [5,4,3]
		//     3 | [5,4,3,2]
		//     4 | [5,4,3,2,1]
		//     5 | done
		//
		// We can see that the index of the rightmost digit is the same as the
		// number of digits in the number. We'll use this to index the array
		// in the for loop in reverse later.

		// Populate the digits array with the digits of the number. As seen in
		// the example above.
		while (x > 0) {

			// Get the rightmost digit of the number and store it in the array.
			digits[rightmostDigitIndex++] = x % 10;

			// Remove the rightmost digit from the number.
			x /= 10;
		}

		// This is the index of the leftmost digit in the array.
		int leftmostDigitIndex = 0;

		// Compare the digits in the array from both ends towards the middle. If
		// the digits are not equal, the number is not a palindrome.
		for (rightmostDigitIndex -= 1; rightmostDigitIndex >= 0; rightmostDigitIndex--) {
			if (digits[rightmostDigitIndex] != digits[leftmostDigitIndex++]) {
				return false;
			}
		}

		// If we get here, the number is a palindrome.
		return true;
	}
}
