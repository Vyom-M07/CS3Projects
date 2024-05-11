
public class MyQueue<T> implements QueueADT<T> {

	MyLinkedList<T> queue;
	int size;
	public MyQueue() {
		
		queue = new MyLinkedList<T>();
		size = 0;
		
	}
	
	public MyQueue(@SuppressWarnings("unchecked") T... vals) {
		// "vals" is treated like an array
		size = vals.length;
		queue = new MyLinkedList<T>();
		for (T i : vals) {
			offer(i);
		}
		
	}
	
	
	@Override
	public void offer(T item) {
		
		queue.add(item);
		size++;
		
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		T obj = queue.get(0);
		queue.remove(0);
		size--;
		return obj;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return queue.get(0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public void clear() {
		
		while (!queue.isEmpty())
			queue.remove(0);
		
	}
	
	

}
