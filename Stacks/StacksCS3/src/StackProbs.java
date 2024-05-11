import java.util.Stack;

public class StackProbs {

	public Stack<Integer> doubleUp(Stack<Integer> nums) {

		Stack<Integer> stack = new Stack<Integer>();

		while (!nums.isEmpty()) {

			int temp = nums.pop();
			stack.push(temp);
			stack.push(temp);
		}

		while (!stack.isEmpty()) {

			nums.push(stack.pop());
			nums.push(stack.pop());
		}

		return nums;

	}

	public Stack<Integer> posAndNeg(Stack<Integer> nums) {
		// Peek() returns the top pancake
		Stack<Integer> pos = new Stack<>();
		Stack<Integer> neg = new Stack<>();

		while (!nums.isEmpty()) {

			int temp = nums.pop();

			if (temp >= 0) {
				pos.push(temp);
			} else {

				neg.push(temp);
			}
		}
		while (!neg.isEmpty()) {

			nums.add(neg.pop());

		}

		while (!pos.isEmpty()) {
			nums.add(pos.pop());
		}

		return nums;

	}

	public Stack<Integer> shiftByN(Stack<Integer> nums, int n) {

		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		while (nums.size() > n) {

			stack1.push(nums.pop());
		}

		while (!nums.isEmpty()) {
			stack2.push(nums.pop());
		}

		while (!stack1.isEmpty()) {

			nums.push(stack1.pop());

		}

		while (!stack2.isEmpty()) {
			nums.push(stack2.pop());
		}

		return nums;

	}

	public String reverseVowels(String str) {
		// hello how are you
		Stack<Character> stack = new Stack<Character>();
		String v = "";

		char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u' };

		for (int i = 0; i < str.length(); i++) {

			for (int j = 0; j < vowels.length; j++) {

				if (str.charAt(i) == vowels[j]) {

					stack.push(str.charAt(i));
					break;
				}

			}
		}

		for (int i = 0; i < str.length(); i++) {

			Character c = str.charAt(i);
			if (c.equals(vowels[0]) || c.equals(vowels[1]) || c.equals(vowels[2]) || c.equals(vowels[3])
					|| c.equals(vowels[4])) {
				v += stack.pop();

			} else {
				v += c;
			}

		}

		return v;

	}

	public boolean bracketBalance(String s) {
		boolean equal = false;
		char pOpen = '(';
		char pClose = ')';
		char bOpen = '[';
		char bClose = ']';
		Stack<Character> openP = new Stack<Character>();
		Stack<Character> closeP = new Stack<Character>();
		Stack<Character> openB = new Stack<Character>();
		Stack<Character> closeB = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == pOpen) {
				openP.push(s.charAt(i));
			} else if (s.charAt(i) == pClose) {
				closeP.push(s.charAt(i));
			} else if (s.charAt(i) == bOpen) {
				openB.push(s.charAt(i));
			} else {
				closeB.push(s.charAt(i));
			}
		}
		if (openP.size() == closeP.size() && openB.size() == closeB.size()) {
			equal = true;
		}
		return equal;
	}

}
