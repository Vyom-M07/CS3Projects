import java.util.EmptyStackException;


public class MyStack implements StackADT {

	private Square[] stack;
	private int size;

	MyStack() {

		this(2);

	}

	MyStack(int initCap) {
		stack = new Square[initCap];
		size = 0;

	}

	public int size() {

		return size;
	}

	@Override
	public boolean isEmpty() {

		if (size == 0) 
			return true;
		

		return false;

	}

	public Square peek() {

		if (size == 0) {
			throw new EmptyStackException();
		}

		return stack[size - 1];

	}

	@Override
	public Square pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}

		Square removedE = stack[size - 1];
		stack[size - 1] = null;
		size--;
		return removedE;
	}

	@Override
	public void push(Square item) {

		if (size == stack.length) {
			doubleCapacity();
		}

		stack[size] = item;
		size++;

	}

	public void doubleCapacity() {

		Square[] bigStack = new Square[stack.length * 2];
		for (int i = 0; i < size; i++) {
			bigStack[i] = stack[i];
		}

		stack = bigStack;

	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "[]";
		}
		String s = "[";
		for (int i = 0; i < size; i++) {
			s += stack[i] + ", ";
		}
		return s.substring(0, s.length() - 2) + "]";
	}

	@Override
	public void clear() {
		stack = new Square[2];
		size = 0;

	}

}
