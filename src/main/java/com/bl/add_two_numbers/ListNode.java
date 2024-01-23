package com.bl.add_two_numbers;

/**
 * Definition for singly-linked list.
 * <p>
 * Made from the problem description.
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.01.23
 */
public class ListNode {

	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	// This is needed for the test to work. It is not part of the problem.
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ListNode node) {
			if (node.val == this.val) {
				if (node.next == null && this.next == null) {
					return true;
				} else if (node.next != null && this.next != null) {
					return node.next.equals(this.next);
				}
			}
		}
		return false;
	}

	// This is also not part of the problem.
	@Override
	public String toString() {
		return "ListNode{" +
				"val=" + val +
				", next=" + next +
				'}';
	}
}
