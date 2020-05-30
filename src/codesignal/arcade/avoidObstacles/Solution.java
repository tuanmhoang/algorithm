package codesignal.arcade.avoidObstacles;

import java.util.Arrays;

public class Solution {
	int avoidObstacles(int[] inputArray) {
		Arrays.sort(inputArray);
		for (int jump = 1; jump <= 40; jump++) {
			int position = jump;
			for (int i = 0; i < inputArray.length; ) {
				while (position < 40) {
					if (position == inputArray[i]) {
						break;
					}

					if (position > inputArray[i]) {
						if (i == inputArray.length - 1) {
							return jump;
						}
						i++;
						continue;
					}
					position = position + jump;
				}
				if (position == 40
						|| position > inputArray[inputArray.length - 1]) {
					return jump;
				} else {
					break;
				}
			}
		}
		return 0;
}

}
