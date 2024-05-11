import java.util.EmptyStackException;


public class MyStack {

	private Integer[] stack;
	private int size;

	MyStack() {

		size = 0;
		stack = new Integer[7];

	}

	MyStack(int initCap) {
		this.stack = new Integer[initCap];
		this.size = 0;

	}

	public int getSize() {

		return size;
	}

	public boolean isEmpty() {

		if (size == 0) {
			return true;
		}

		return false;

	}

	public Integer peek() {

		if (size == 0) {
			throw new EmptyStackException();
		}

		return stack[size - 1];

	}

	public Integer pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}

		int removedE = stack[size - 1];
		stack[size - 1] = null;
		size--;
		return removedE;
	}

	public void push(Integer item) {

		if (size >= stack.length) {
			doubleCapacity();
		}

		stack[size] = item;
		size++;

	}

	public void doubleCapacity() {

		Integer[] bigStack = new Integer[stack.length * 2];
		for (int i = 0; i < size; i++) {
			bigStack[i] = stack[i];
		}

		stack = bigStack;

	}

	@Override
	public String toString() {
		String s = "";
		for (int i = size; i > 0; i--) {
			s += stack[i-1] + "\n";
		}
		return s;
	}

}
