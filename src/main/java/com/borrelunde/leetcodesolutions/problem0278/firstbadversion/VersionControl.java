package com.borrelunde.leetcodesolutions.problem0278.firstbadversion;

/**
 * This is the parent class that holds the isBadVersion API for the problem. It
 * is needed for the unit tests.
 *
 * @author Børre A. Opedal Lunde
 * @since 2024.02.18
 */
public class VersionControl {

	private int badVersion;

	public void setBadVersion(final int bad) {
		this.badVersion = bad;
	}

	public boolean isBadVersion(int version) {
		return version >= badVersion;
	}
}
