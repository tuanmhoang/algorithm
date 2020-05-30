package codesignal.arcade.aresimilar;

public class Solution {
	boolean areSimilar(int[] a, int[] b) {
		int count = 0;
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			// count = a[i] == b[i] ? count : count +1;
			if (a[i] != b[i]) {
				count++;
				if (count == 3) {
					return false;
				}
				if (count == 2) {
					if (a[temp] != b[i] || a[i] != b[temp]) {
						return false;
					}
				}
				temp = i;
			}
		}
		return true;
	}
}
