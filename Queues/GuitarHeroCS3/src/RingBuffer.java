public class RingBuffer {
	private double[] data; // items in the buffer
	private int first; // index for the next dequeue or peek
	private int last; // index for the next enqueue
	private int size; // number of items in the buffer
	private int capacity;

	/** create an empty buffer, with given max capacity */
	public RingBuffer(int capacity) {
		this.capacity = capacity;
		data = new double[capacity];
		size = 0;
		first = 0;
		last = -1;

	}

	/** return number of items currently in the buffer */
	public int size() {
		// YOUR CODE HERE

		return size; // REPLACE
	}

	/** is the buffer empty (size equals zero)? */
	public boolean isEmpty() {

		return size == 0;
	}

	/** is the buffer full (size equals array capacity)? */
	public boolean isFull() {
		return size == capacity;
	}

	/** add item x to the end */
	public void enqueue(double x) {
		// YOUR CODE HERE
		if (isFull()) 
			throw new ArrayIndexOutOfBoundsException("Full Array");
		last = (last + 1) % capacity; // Wrap around or next pointer location
		data[last] = x;
		size++;

	}

	/** delete and return item from the front */
	public double dequeue() {
		// YOUR CODE HERE
		if (isEmpty()) 
			throw new ArrayIndexOutOfBoundsException("Cannot remove from empty");
			
		
		double r = data[first];
		first = (first + 1) % capacity; // Wrap around or xnext pointer location
		size--;
		return r;
	}

	/** return (but do not delete) item from the front */
	public double peek() {
		// YOUR CODE HERE
		if (isEmpty()) 
			throw new ArrayIndexOutOfBoundsException("Empty Buffer");
		
		return data[first]; // REPLACE
	}

	/** a simple test of the constructor and methods in RingBuffer */
	public static void main(String[] args) {
		int N = 100;
		RingBuffer buffer = new RingBuffer(N);
		for (int i = 1; i <= N; i++) {
			buffer.enqueue(i);
		}
		double t = buffer.dequeue();
		buffer.enqueue(t);
		System.out.println("Size after wrap-around is " + buffer.size());
		while (buffer.size() >= 2) {
			double x = buffer.dequeue();
			double y = buffer.dequeue();
			buffer.enqueue(x + y);
		}
		System.out.println(buffer.peek());

		/*
		 * Your program should produce the following output:
		 *
		 * Size after wrap-around is 100 
		 * 5050.0
		 */
	}
}
