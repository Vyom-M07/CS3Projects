import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

public class WordLadder {
	File dictionary = new File("dictionary.txt");
	Scanner input;
	String end;
	String start;
	Queue<Stack> qOfStacks;
	ArrayList<String> arr;
	Set<String> set;

	public WordLadder() {
	}

	public Set<String> saveDict() throws FileNotFoundException {
		input = new Scanner(new File("dictionary.txt"));
		Set<String> hash = new HashSet<>();
		while (input.hasNextLine()) {
			String str = input.nextLine().toLowerCase();
			if (str.length() == start.length()) {
				hash.add(str);
			}
		}

		return hash;

	}

	public WordLadder(String start, String end) throws FileNotFoundException {
		qOfStacks = new LinkedList<>();
		input = new Scanner(new File("dictionary.txt"));
		this.start = start;
		this.end = end;
		set = saveDict();
		arr = new ArrayList<>();
		if (!set.contains(start)) {
			System.out.println("No ladder found between " + start + " and " + end);
		} else {
			set.remove(start);
			if (start.equals(end)) {
				Stack<String> stack7 = new Stack<>();
				stack7.push(start);
				stack7.push(end);
				System.out.println("Found! >>>" + stack7);
			} else {
				run();
			}
		}
	}

	public void oneDifferent(Stack<String> s) {
		// checks
		String word = s.peek();
		String save = "" + word;
		int num = 0;
		for (int i = 1; i <= word.length(); i++) {
			word = save;
			// sorts through alphabet
			for (char j = 'a'; j <= 'z'; j++) {
				word = word.substring(0, num) + j + save.substring(i);
				// change/replace
				if (set.contains(word)) {
					Stack<String> stack1 = copyStack(s);
					stack1.push(word);
					set.remove(word);
					qOfStacks.offer(stack1);
				}
			}
			// add
			num++;
		}
	}

	public void run() throws FileNotFoundException {
		Stack<String> stack1 = new Stack<>();
		stack1.push(start);
		qOfStacks.offer(stack1);
		while (!qOfStacks.isEmpty()) {
			stack1 = qOfStacks.poll();
			oneDifferent(stack1);

			if (stack1.peek().equals(end)) {
				System.out.println("Found! >>>" + stack1);

				break;
			}
		}
		if (qOfStacks.isEmpty()) {
			System.out.println("No word ladder between " + start + " and " + end + "!");
		}
	}

	public Stack<String> copyStack(Stack<String> s) {// should keep values
		Stack<String> stack1 = new Stack<>();
		Stack<String> stack2 = new Stack<>();
		while (!s.isEmpty()) {
			stack2.push(s.pop());
		}
		// copies stack
		while (!stack2.isEmpty()) {
			String str = stack2.pop();
			stack1.push(str);
			s.push(str);
		}
		return stack1;
	}

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("input.txt");
		Scanner sc = new Scanner(f);
		
		while (sc.hasNext()) {
			String first = sc.next();
			String last = sc.next();
			WordLadder l = new WordLadder(first, last);
		}
		

	}

}