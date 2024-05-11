import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Ladder {

	/*
	 * Example:
	 * 
	 * head heal teal tell tall tail
	 */

	public static void main(String[] args) throws FileNotFoundException {

		File f = new File("C:\\Users\\OPBos\\eclipse-workspace\\WordLadderCS3\\dictionary.txt");
		Scanner sc = new Scanner(f);

		File fInput = new File("C:\\Users\\OPBos\\eclipse-workspace\\WordLadderCS3\\input.txt");
		Scanner scInput = new Scanner(fInput);

		Set<String> setDiction = new HashSet<>();

		while (sc.hasNext()) {

			setDiction.add(sc.next().toLowerCase());

		}

		String first = "dears";
		String last = "fears";
		Queue<Stack<String>> queue = new LinkedList<>();
//		while (scInput.hasNext()) {
		boolean loop = true;
		while (loop) {
			first = scInput.next();
			last = scInput.next();
			Stack<String> innerStack = new Stack<>();
			Set<String> visited = new HashSet<>();
			
			innerStack = findPossibleLadder(setDiction, first, visited, innerStack);
			innerStack = findingOfInnerStackLadder(innerStack, visited, last, first, setDiction);
			
			
			queue.offer(innerStack);
		}
//		}
		
		System.out.println(queue.toString());
				

	}

	public static boolean isOneLetterDiff(String first, String last) {
		if (first.length() != last.length()) {
			return false;
		}

		int diffCount = 0;
		for (int i = 0; i < first.length(); i++) {

			if (first.charAt(i) != last.charAt(i)) {
				diffCount++;
			}

			if (diffCount > 1)
				return false;
		}
		return diffCount == 1;

	}
	
	public static Stack<String> findPossibleLadder(Set<String> diction, String first, Set<String> visited, Stack<String> innerQueue) {
		innerQueue.push(first);		
		visited.add(first);
		for (String s : diction) {
			if(isOneLetterDiff(first, s)) {
				innerQueue.push(s);
				visited.add(s);
			}
			
		}
		
		
		return innerQueue;
	}
	
	public static Stack<String> findingOfInnerStackLadder(Stack<String> innerStack, Set<String> visited, String last, String current, Set<String> diction) {
		Stack<String> tempStack = new Stack<>();
		if (current.equals(last)) {
			tempStack.push(current);
		}
		
		else if(visited.contains(last)) {

			tempStack.push(current);
			tempStack.push(last);
		}
		
		Set<String> visitedForLadder = new HashSet<>();
		
		Stack<String> tempStack2;
		while(!innerStack.isEmpty()) {
			
			String temp = innerStack.pop();
			tempStack2 = new Stack<>();
			tempStack2.push(temp);
			visitedForLadder.add(temp);
			tempStack2 = findPossibleLadder(diction, temp, visitedForLadder, tempStack);
			System.out.println(tempStack2.toString());
			
		}
		
		
		
		return tempStack;
	}

}