import java.lang.reflect.Array;
import java.util.Arrays;

public class MyHashTable<K, V> {

	private Object[] arr;
	private int size = 0;
	private int capacity = 11;

	private class Node {

		K key;
		V value;
		Node next;

		Node(K key, V value) {

			this.key = key;
			this.value = value;

		}

		@Override
		public String toString() {

			return "[name: " + key + ", number: " + value + "]";

		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getNext() {
			return this.next;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

	}

	public MyHashTable() {

		arr = new Object[11];

	}
	
	@SuppressWarnings("unchecked")
	private Node get(int i) {
		
		return (Node) arr[i];
		
	}
	
	

	@SuppressWarnings("unchecked")
	public V put(K key, V value) {
		
		int index = Math.abs(key.hashCode()  % capacity);
		if ((double) size / capacity >= .75) {
			
			rehash();
			
		}
//		System.out.println(index);
		if(arr[index] == null) {
			
			size++;
			arr[index] = new Node(key, value);
			
		} else {
			
			Node e = (Node) arr[index];
			while(e != null) {
				
//				System.out.println(key);
//				System.out.println(e.getKey());
//				System.out.println(e.getKey().toString().equals(key.toString()));
				// if it already exists
				if (e.getKey().toString().equals(key.toString())) {

	//				System.out.println("Should be in here");
					Node temp = new Node(e.getKey(), e.getValue());
					e.setValue(value);
					
			//		System.out.println(Arrays.toString(arr));
					return temp.getValue();
					
				}
				e = e.getNext();
			}
			e = (Node) arr[index];
			Node before = new Node(key, value);
			before.setNext(e);
			arr[index] = before;
		}
		
		
	//	System.out.println(Arrays.toString(arr));
		return null;
	}

	private void rehash() {

		Object[] arr2 = new Object[capacity * 2];

		System.arraycopy(arr, 0, arr2, 0, capacity);

		arr = arr2;

	}

	@SuppressWarnings("unchecked")
	public V get(K key) {
		
		int index = Math.abs(key.hashCode()  % capacity);
		Node n = (Node) arr[index]; // n - head of linked list
		
		if (n == null)
			return null;

		if (n.getKey().toString().equals(key.toString())) {
			return n.getValue();
		}

		if (n != null) {

			if (n.getNext() != null) {
				Node temp = n;
				while (temp != null) {

					temp = temp.getNext();

					if (temp.getKey().toString().equals(key.toString())) {
						return temp.getValue();
					}

				}

			}
		}
		return null;
	}
	
	public int size() {
		return size;
	}
	
	@SuppressWarnings("unchecked")
	public V remove(K key) {
		int index = Math.abs(key.hashCode()  % capacity);
		
		Node n = (Node) arr[index]; // head of linked list --> current
		Node previous = null; // make previous's next deleted element's next instead of the deleted element itself ('skipping over the node)
		
		while (n != null) {
			
			if(n.getKey().toString().equals(key.toString())) {
				if (previous == null) {
					// head of linked list
					arr[index] = n.getNext();
					
				} else {
					
					previous.setNext(n.getNext()); // the skipping over part
				}
				size--;
				return n.getValue();
			}
			
			previous = n;
			n = n.getNext();
		}
		
		
		return null;
	}
	
	@Override
	public String toString() {
		
		return Arrays.toString(arr);
		
	}
	
}
