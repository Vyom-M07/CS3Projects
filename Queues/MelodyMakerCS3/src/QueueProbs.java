import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueProbs {

	public QueueProbs() {

	}

	public Queue<Integer> evenFirst(Queue<Integer> nums) {

		int size = nums.size();
		Queue<Integer> qT = new LinkedList<>();

		for (int i = 0; i < size; i++) {
			int temp = nums.poll();
			if (temp % 2 == 0) {

				// qT has all even numbers
				qT.offer(temp);

			} else if (temp % 2 != 0) {
				// nums has all odd numbers
				nums.offer(temp);
			}

		}

		size = nums.size();
		for (int i = 0; i < size; i++) {

			qT.offer(nums.poll());

		}

		return qT;

	}

	boolean numPalindrome(Queue<Integer> nums) {
		Queue<Integer> t = new LinkedList<>();
		Queue<Integer> t2 = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();

		int halfSize = nums.size() / 2;

		for (int i = 0; i < halfSize; i++) {
			t.offer(nums.poll());
		}

		while (!nums.isEmpty()) {
			stack.push(nums.poll());
		}
		while (!stack.isEmpty()) {
			t2.offer(stack.pop());
		}
		System.out.println(t);
		System.out.println(t2);

		int tSize = t.size();
		for (int i = 0; i < tSize; i++) {
			if (t.poll() != t2.poll())
				return false;
		}

		return true;
	}

	public Stack<Integer> sieveOfEratosthenes(int n) {

		Queue<Integer> t = new LinkedList<>();
		Stack<Integer> sPrime = new Stack<>();

		// If 'n' is less than or equal to 2,
		// return 2 b/c any number before 2 isn't prime or composite
		// and 2 is the the first prime number so we can just return 2 for 'n = 2'
		if (n <= 2) {
			sPrime.push(2);
			return sPrime;
		}

		for (int i = 2; i <= n; i++) {
			t.offer(i);
		}
		
		while(!t.isEmpty()) {
			int temp = sPrime.push(t.poll());
			
			int size = t.size();
			for (int i = 0; i < size; i++) {
				
				int testNum = t.poll();
				if (testNum % temp != 0) {
					t.offer(testNum);
				}
				
			}
			
			
		}

	

		return sPrime;

	}

}
