package com.borrelunde.leetcodesolutions.add_two_numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is the test to the LeetCode problem: 2. Add Two Numbers
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.23
 */
@DisplayName("Add Two Numbers")
class SolutionTest {

	@Test
	@DisplayName("Example one")
	void exampleOne() {
		ListNode node;

		ListNode l1 = new ListNode(2);
		node = l1.next = new ListNode(4);
		node = node.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		node = l2.next = new ListNode(6);
		node = node.next = new ListNode(4);

		ListNode expected = new ListNode(7);
		node = expected.next = new ListNode(0);
		node = node.next = new ListNode(8);

		assertEquals(expected, new Solution().addTwoNumbers(l1, l2));
	}

	@Test
	@DisplayName("Example two")
	void exampleTwo() {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(0);

		ListNode expected = new ListNode(0);

		assertEquals(expected, new Solution().addTwoNumbers(l1, l2));
	}

	@Test
	@DisplayName("Example three")
	void exampleThree() {
		ListNode node;

		ListNode l1 = new ListNode(9);
		node = l1.next = new ListNode(9);
		node = node.next = new ListNode(9);
		node = node.next = new ListNode(9);
		node = node.next = new ListNode(9);
		node = node.next = new ListNode(9);
		node = node.next = new ListNode(9);

		ListNode l2 = new ListNode(9);
		node = l2.next = new ListNode(9);
		node = node.next = new ListNode(9);
		node = node.next = new ListNode(9);

		ListNode expected = new ListNode(8);
		node = expected.next = new ListNode(9);
		node = node.next = new ListNode(9);
		node = node.next = new ListNode(9);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(1);

		assertEquals(expected, new Solution().addTwoNumbers(l1, l2));
	}

	@Test
	@DisplayName("Wrong one")
	void wrongOne() {
		ListNode node;

		ListNode l1 = new ListNode(9);

		ListNode l2 = new ListNode(1);
		node = l2.next = new ListNode(9);
		node = node.next = new ListNode(9);
		node = node.next = new ListNode(9);
		node = node.next = new ListNode(9);
		node = node.next = new ListNode(9);
		node = node.next = new ListNode(9);
		node = node.next = new ListNode(9);
		node = node.next = new ListNode(9);
		node = node.next = new ListNode(9);

		ListNode expected = new ListNode(0);
		node = expected.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(1);

		assertEquals(expected, new Solution().addTwoNumbers(l1, l2));
	}

	@Test
	@DisplayName("Wrong two")
	void wrongTwo() {
		ListNode node;

		ListNode l1 = new ListNode(1);
		node = l1.next = new ListNode(1);
		node = node.next = new ListNode(1);
		node = node.next = new ListNode(1);
		node = node.next = new ListNode(1);
		node = node.next = new ListNode(1);
		node = node.next = new ListNode(1);
		node = node.next = new ListNode(1);
		node = node.next = new ListNode(1);
		node = node.next = new ListNode(1);
		node = node.next = new ListNode(1);

		ListNode l2 = new ListNode(1);
		node = l2.next = new ListNode(1);
		node = node.next = new ListNode(1);
		node = node.next = new ListNode(1);
		node = node.next = new ListNode(1);
		node = node.next = new ListNode(1);
		node = node.next = new ListNode(1);
		node = node.next = new ListNode(1);
		node = node.next = new ListNode(1);
		node = node.next = new ListNode(1);
		node = node.next = new ListNode(1);

		ListNode expected = new ListNode(2);
		node = expected.next = new ListNode(2);
		node = node.next = new ListNode(2);
		node = node.next = new ListNode(2);
		node = node.next = new ListNode(2);
		node = node.next = new ListNode(2);
		node = node.next = new ListNode(2);
		node = node.next = new ListNode(2);
		node = node.next = new ListNode(2);
		node = node.next = new ListNode(2);
		node = node.next = new ListNode(2);

		assertEquals(expected, new Solution().addTwoNumbers(l1, l2));
	}

	@Test
	@DisplayName("Wrong three")
	void wrongThree() {
		ListNode node;

		ListNode l1 = new ListNode(1);
		node = l1.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(1);

		ListNode l2 = new ListNode(5);
		node = l2.next = new ListNode(6);
		node = node.next = new ListNode(4);

		ListNode expected = new ListNode(6);
		node = expected.next = new ListNode(6);
		node = node.next = new ListNode(4);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(1);

		assertEquals(expected, new Solution().addTwoNumbers(l1, l2));
	}
}
