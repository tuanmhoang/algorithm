package codesignal.arcade.reverseparentheses;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class Solution {

	String reverseInParentheses(String inputString) {
		Stack<String> stack = new Stack<>();
		String[] strChars = inputString.split("");
		StringBuilder result = new StringBuilder();
		for (String string : strChars) {
			if (stack.isEmpty() && !(string.equals("(") || string.equals(")"))) {
				result.append(string);
			} else {
				if (string.equals(")")) {
					StringBuilder reversedTmpString = new StringBuilder();
					String tempString = stack.pop();
					while (!tempString.equals("(")) {
						reversedTmpString.append(tempString);
						tempString = stack.pop();
					}

					if (stack.isEmpty()) {
						result.append(reversedTmpString);
					} else {
						String[] splitReversedTmpString = reversedTmpString.toString().split("");
						for (String string2 : splitReversedTmpString) {
							stack.push(string2);
						}
					}
				} else {
					stack.push(string);
				}
			}
		}
		return result.toString();
	}

	@Test
	public void test1() throws Exception {
		String inputString = "(bar)";
		String expected = "rab";
		assertEquals(expected, reverseInParentheses(inputString));
	}

	@Test
	public void test2() throws Exception {
		String inputString = "foo(bar)baz";
		String expected = "foorabbaz";
		assertEquals(expected, reverseInParentheses(inputString));
	}

	@Test
	public void test3() throws Exception {
		String inputString = "foo(bar)baz(blim)";
		String expected = "foorabbazmilb";
		assertEquals(expected, reverseInParentheses(inputString));
	}

	@Test
	public void test4() throws Exception {
		String inputString = "foo(bar(baz))blim";
		String expected = "foobazrabblim";
		assertEquals(expected, reverseInParentheses(inputString));
	}

	@Test
	public void test5() throws Exception {
		String inputString = "";
		String expected = "";
		assertEquals(expected, reverseInParentheses(inputString));
	}

	@Test
	public void test6() throws Exception {
		String inputString = "()";
		String expected = "";
		assertEquals(expected, reverseInParentheses(inputString));
	}

	@Test
	public void test7() throws Exception {
		String inputString = "(abc)d(efg)";
		String expected = "cbadgfe";
		assertEquals(expected, reverseInParentheses(inputString));
	}

}
