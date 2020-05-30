package codesignal.arcade.palindromeRearranging;

public class Solution {
	boolean palindromeRearranging(String inputString) {
		int[] alphabet = new int[26];
		for (int i : alphabet) {
			alphabet[i] = 0;
		}
		char[] array = inputString.toCharArray();
		for (char c : array) {
			alphabet[(int) c - 97]++;
		}
		int count = 0;
		for (int i : alphabet) {
			if (i % 2 == 1) {
				count++;
				if (count == 2) {
					return false;
				}
			}
		}
		return true;
	}
}
