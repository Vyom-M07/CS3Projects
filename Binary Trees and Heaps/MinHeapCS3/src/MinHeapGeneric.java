
public class MinHeapGeneric<T extends Comparable<T>> {

	private T[] heap;
	static final int DEFAULT_CAPACITY = 8;
	int size;

	@SuppressWarnings("unchecked")
	public MinHeapGeneric() {

		this.heap = (T[]) new Comparable[DEFAULT_CAPACITY];
		this.size = 0;

	}

	@SuppressWarnings("unchecked")
	MinHeapGeneric(int initialCapacity) {

		this.size = 0;
		this.heap = (T[]) new Comparable[initialCapacity];

	}

	MinHeapGeneric(T... nums) {

		this.size = nums.length;
		buildHeap(nums);

	}

	@SuppressWarnings("unchecked")
	private void buildHeap(T[] nums) {

		this.heap = (T[]) nums;

		// compare the last two at a time to the parent: (in Heap visualization) 30 and
		// 31, 28 and 29, 26 and 27
		// the min between them gets swapped with the parent
		// after all leaf nodes are checked go and check first pair of parent notes with
		// its parent note
		// check the element just swapped with the leaf notes of the parent node.

		for (int i = getParentIndex(size); i >= 1; i--) {
			siftDown(i);
		}

	}

	public int getSize() {

		return size;

	}

	public boolean isEmpty() {

		return size == 0;

	}

	public T peekMinimum() {

		return heap[1];

	}

	public int getLeftChildIndex(int parentIndex) {

		return parentIndex * 2;

	}

	public int getRightChildIndex(int parentIndex) {

		return parentIndex * 2 + 1;

	}

	public int getParentIndex(int childIndex) {

		return childIndex / 2;

	}
	
	@SuppressWarnings("unchecked")
	private void doubleCapacity() {
		
		T[] temp = (T[]) new Comparable[heap.length * 2];
		
		// i = 1 because the first element in heap array is at index 1 not 0 SO DON"T CHANGE IT VYOM ITS NOT AN ERROR
		for (int i = 1; i < heap.length; i++) {
			temp[i] = heap[i];
		}
		heap = temp;
	}
	
	public void insert(T value) {
		
		if (size == heap.length-1) {
			doubleCapacity();
		}
		size++;
		heap[size] = value;
		if (size != 1) 
			bubbleUp(size);
	}
	
	private void bubbleUp(int index) {

		if (getParentIndex(index) != 0) {
			// heap[index] < heap[getParentIndex(index)]
			if (heap[index].compareTo(heap[getParentIndex(index)]) < 0) {
		//		System.out.println("Im inside");
				T temp = heap[index];
				heap[index] = heap[getParentIndex(index)];
				heap[getParentIndex(index)] = temp;
				bubbleUp(getParentIndex(index));
			}
		}
	}
	
	public T popMinimum() {
		
		T minValue = heap[1];
		heap[1] = heap[size];
		size--;
		siftDown(1);
		
		// index 1 because the first element is stored at index 1 not 0
		return minValue;
		
	}

	private void siftDown(int index) {
		if (getRightChildIndex(index) >= size) {
			return;
		}
		
//		if(heap[getLeftChildIndex(index)] == null) {
//			heap[getLeftChildIndex(index)] = heap[index];
//		} else if (heap[getRightChildIndex(index)] == null) {
//			heap[getRightChildIndex(index)] = heap[index];
//		}
//	
		
	
//		System.out.println(size);
//		System.out.println(Arrays.toString(heap));
		
//		System.out.println(heap[getRightChildIndex(index)]);
		T minBetween;
		if (heap[getLeftChildIndex(index)].compareTo(heap[getRightChildIndex(index)]) < 0) {
			minBetween = heap[getLeftChildIndex(index)];
		} else {
			minBetween = heap[getRightChildIndex(index)];
		}
		// int minBetween = Math.min(heap[getLeftChildIndex(index)], heap[getRightChildIndex(index)]);
		if (minBetween == heap[getLeftChildIndex(index)]) {
			heap[getLeftChildIndex(index)] = heap[index];
			heap[index] = minBetween;
			siftDown(getLeftChildIndex(index));
		} else {
			heap[getRightChildIndex(index)] = heap[index];
			heap[index] = minBetween;
			siftDown(getRightChildIndex(index));
		}

	}
	
	@Override
	public String toString() {
		
		String output = "";
		
		for (int i = 1; i <= getSize(); i++) {
			
			output += heap[i] + ", ";	
		}
		
		return output.substring(0, output.lastIndexOf(","));
		
	}

	public void display() {
		int nBlanks = 32, itemsPerRow = 1, column = 0, j = 1;
		String dots = "...............................";
		System.out.println(dots + dots);
		while (j <= this.getSize()) {
			if (column == 0)
				for (int k = 0; k < nBlanks; k++)
					System.out.print(' ');
			System.out.print((heap[j] == null) ? "" : heap[j]);
			if (++column == itemsPerRow) {
				nBlanks /= 2;
				itemsPerRow *= 2;
				column = 0;
				System.out.println();
			} else
				for (int k = 0; k < nBlanks * 2 - 2; k++)
					System.out.print(' ');
			j++;
		}
		System.out.println("\n" + dots + dots);
	}

}
