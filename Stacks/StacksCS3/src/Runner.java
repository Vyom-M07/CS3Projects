import java.util.Stack;

public class Runner {

	public static void main(String[] args) {

//		Stack<Integer> stack = new Stack<Integer>();
//		stack.push(3);
//		stack.push(4);
//		stack.push(2);
//		stack.push(-2);
//		stack.push(1);
		
		int[] s = new int[] {3, 1, 2, -3, 1, -5, 0};
		Stack<Integer> stack = makeStack(s);
		
		StackProbs p = new StackProbs();
//		System.out.println(stack);
//		System.out.println(p.doubleUp(stack));	
		
//		System.out.println(p.posAndNeg(stack));
//		System.out.println(p.shiftByN(stack, 2));
		
//		System.out.println(p.reverseVowels("hello how are you"));
//		System.out.println(p.bracketBalance("([()[]()])()"));
		
		
		
		
		
	}
	
	public static Stack<Integer> makeStack(int[] nums) {
		
		Stack<Integer> stack = new Stack<Integer>();
		for (int num : nums)  {
			stack.push(num);
		}
		
		return stack; 
		
	}
}
