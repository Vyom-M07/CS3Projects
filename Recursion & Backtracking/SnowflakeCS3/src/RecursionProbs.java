import java.util.Stack;

public class RecursionProbs {

	public static void main(String[] args) {

		// System.out.println(sumRecipricals(10));
		// System.out.println(productOfEvens(4));
		// System.out.println(conversion(23, 2));
		// System.out.println(matchingDigits(1230, 0));

//		Stack<Integer> s = new Stack<>();
//		
//		s.push(3);
//		s.push(4);
//		s.push(5);
//		
//		doubleUp(s);
//		System.out.println(s.toString());

//		printThis(8);
		printNums2(6);

	}

	static double sumRecipricals(int n) {

		if (n == 1) {
			return n;
		}
		return 1.0 / n + sumRecipricals(n - 1);
	}

	static int productOfEvens(int n) {

		if (n == 1)
			return 2;

		return n * 2 * productOfEvens(n - 1);
	}

	static String conversion(int sum, int base) {

		if (sum / base == 0)
			return Integer.toString(sum % base);

		return conversion(sum / base, base) + Integer.toString(sum % base);
	}

	static int matchingDigits(int a, int b) {
		if (a % 10 == 0 && b % 10 == 0)
			return 1;

		if (a == 0 || b == 0)
			return 0;

		if (a % 10 == b % 10)
			return 1 + matchingDigits(a / 10, b / 10);
		return matchingDigits(a / 10, b / 10);
	}

	static void doubleUp(Stack<Integer> nums) {

		if (nums.isEmpty()) {
			return;
		}

		int temp = nums.pop();

		doubleUp(nums);
		nums.push(temp);
		nums.push(temp);

	}

	static void printThis(int n) {

		if (n == 1) {
			System.out.print("*");
		} else if (n == 2) {
			System.out.print("**");
		} else if (n == 0) {
			System.out.print("");
		} else {

			System.out.print("<");
			printThis(n - 2);
			System.out.print(">");
		}

	}

	static void printNums2(int n) {

		if (n == 1) {
			System.out.print(n + " ");
		} else if (n == 2) {
			System.out.print(Integer.toString(n - 1) + " " + Integer.toString(n - 1) + " ");
		} else if (n == 0) {
			System.out.print("");
		} else {
			if (n % 2 == 0) {
			System.out.print(Integer.toString(n / 2) + " ");
			printNums2(n - 2);
			System.out.print(Integer.toString(n / 2) + " ");
			} else {
				System.out.print(Integer.toString((n / 2) + 1) + " ");
				printNums2(n - 2);
				System.out.print(Integer.toString((n / 2) + 1) + " ");
			}
			
		}

	}

}
