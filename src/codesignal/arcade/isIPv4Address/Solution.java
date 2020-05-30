package codesignal.arcade.isIPv4Address;

public class Solution {
	boolean isIPv4Address(String inputString) {
		int dotTimes = inputString.length() - inputString.replace(".", "").length();
		if (dotTimes != 3)
			return false;

		String[] parts = inputString.split("\\.");
		if (parts.length < 4)
			return false;

		for (String part : parts) {
			try {
				int num = Integer.parseInt(part);
				if (num < 0 || num > 255)
					return false;
			} catch (Exception e) {
				return false;
			}
		}

		return true;
	}
}
