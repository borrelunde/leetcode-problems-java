package com.borrelunde.leetcodesolutions.problem0509.fibonaccinumber;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution to the LeetCode problem: 509. Fibonacci Number
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.27
 */
public class Solution {

	// The cache of Fibonacci numbers.
	private static final List<Integer> FIBONACCI_NUMBERS_CACHE = new ArrayList<>();

	// Initialize the cache with the two first Fibonacci numbers.
	static {
		FIBONACCI_NUMBERS_CACHE.add(0);
		FIBONACCI_NUMBERS_CACHE.add(1);
	}

	public int fib(int n) {

		final int fibonacciNumber;
		final int lastCachedFibonacciNumberIndex = FIBONACCI_NUMBERS_CACHE.size() - 1;

		// Check if the Fibonacci number is already cached.
		if (n <= lastCachedFibonacciNumberIndex) {

			// Retrieve the Fibonacci number from the cache.
			fibonacciNumber = FIBONACCI_NUMBERS_CACHE.get(n);

			// Return the Fibonacci number.
			return fibonacciNumber;
		}

		// If the Fibonacci number is not in the cache, let's start from where
		// we left off and put it there.

		// Retrieve the two last Fibonacci numbers from the cache.
		final int a = FIBONACCI_NUMBERS_CACHE.get(lastCachedFibonacciNumberIndex - 1);
		final int b = FIBONACCI_NUMBERS_CACHE.get(lastCachedFibonacciNumberIndex);

		// Calculate the Fibonacci number.
		fibonacciNumber = a + b;

		// Add the Fibonacci number to the cache.
		FIBONACCI_NUMBERS_CACHE.add(fibonacciNumber);

		// Check if we have reached the Fibonacci number we are looking for.
		if (n - 1 == lastCachedFibonacciNumberIndex) {
			return fibonacciNumber;
		}

		// If not, let's continue recursively until we reach it.
		return fib(n);
	}
}
