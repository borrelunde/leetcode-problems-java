package com.bl.add_two_numbers;

/**
 * This is the solution to the Leetcode problem: 2. Add Two Numbers
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.23
 */
class Solution {

	public ListNode addTwoNumbers(ListNode listOneNode, ListNode listTwoNode) {

		// Head of the list to return.
		ListNode head = new ListNode();

		// Node will be used inside the loop to build the list.
		ListNode node = head;

		// Carry is used to keep track of the carry from the last iteration.
		int carry = 0;

		// Continue as long as one of the nodes exist.
		while (listOneNode != null || listTwoNode != null) {

			// The sum is the sum of the carry and the values of the nodes.
			// So we'll add the carry right away.
			int sum = carry;

			// Add to the sum the value of node one if it is present, and
			// prepare the node for the next iteration by going to the next.
			if (listOneNode != null) {
				sum += listOneNode.val;
				listOneNode = listOneNode.next;
			}

			// Do the same for node two.
			if (listTwoNode != null) {
				sum += listTwoNode.val;
				listTwoNode = listTwoNode.next;
			}

			// The nature of the problem lets us be particular evil when it
			// comes to achieving high performance.

			// We know that the sum will never be greater than 18 (9 + 9 = 18)
			// because the problem states that a node holds a single digit.

			// We can then with certainty say that the minimum carry is 0 and
			// the maximum carry is 1. When the sum is greater than 9, the
			// carry must be 1 and the rightmost digit of the sum can be gotten
			// by subtracting 10.
			if (sum > 9) {
				node.val = sum - 10;
				carry = 1;
			} else {
				node.val = sum;
				carry = 0;
			}

			if (listOneNode == null && listTwoNode == null) {
				// None of the list nodes exist anymore, so we know the next
				// iteration is not necessary. What remains is only adding
				// the carry if there is one.
				break;
			}

			// Continue the list with a new node.
			node = node.next = new ListNode();
		}

		// If there is a carry, add it to the list. We know it can only be 1.
		if (carry == 1) {
			node.next = new ListNode(1);
		}

		// Return the head of the list.
		return head;
	}
}
