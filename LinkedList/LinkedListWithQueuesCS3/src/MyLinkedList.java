public class MyLinkedList<T> {

	ListNode head;
	ListNode tail;
	private int size;

	MyLinkedList() {
		head = null;
		tail = null;
		size = 0;

	}

	MyLinkedList(T val) {
		ListNode node = new ListNode(val);
		head = node;
		tail = head;
		size++;

	}
	
	public MyLinkedList(@SuppressWarnings("unchecked") T... vals) {
		
		for (T i : vals) {
			add(i);
		}
		
	}


	/*
	 * 
	 * while (temp != null) --> after while loop, temp IS the null node of the List
	 * (last node with information's next node) while (temp.next != null) --> after
	 * while loop, temp is the last element in the LinkedList
	 * 
	 */

	void add(T newVal) {

		if (head == null) {
			head = new ListNode(newVal);
			tail = head;
		} else {
//			ListNode temp = head;
//			while (temp.next != null) {
//				temp = temp.next;
//			}
//			temp.next = new ListNode(newVal);

			tail.next = new ListNode(newVal);
			tail = tail.next;

		}

		size++;

	}

	boolean contains(T target) {

		ListNode temp = this.head;

		while (temp != null) {

			if (temp.val == target)
				return true;

			temp = temp.next;
		}
		return false;
	}

	T get(int index) {
		int count = 0;

		if (index > size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		ListNode temp = this.head;
		while (temp != null) {

			if (count == index) {
				break;
			}
			count++;
			temp = temp.next;
		}
		return temp.val;

	}

	int indexOf(T target) {
		int index = 0;
		ListNode temp = this.head;

		while (temp != null) {

			if (temp.val == target) {
				return index;
			}
			temp = temp.next;
			index++;
		}
		return -1;
	}

	void set(T newVal, int index) {

		if (index > size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}

		ListNode current = head;
		int counter = 0;
		while (counter != index) {
			counter++;
			current = current.next;
		}

		current.val = newVal;

	}

	int size() {

		return size;

	}

	boolean isEmpty() {
		return size() == 0;
	}

	T remove(int index) {

		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			ListNode copy = head;
			head = head.next;
			size--;
			return copy.val;
		} else if (index == size) {
			// FINISH
			int counter = 0;
			ListNode pred = head;
			while (counter != index -1) {
				pred = pred.next;
			}
			ListNode toDel = pred.next;
			pred.next = null;
			tail = pred;
			return toDel.val;
			
		} else {

			int counter = 0;
			ListNode pred = head;
			while (counter != index - 1) {
				counter++;
				pred = pred.next;
			}
			ListNode toDel = pred.next;
			pred.next = pred.next.next;

			size--;
			return toDel.val;
		}

	}

	void add(T newVal, int index) {

		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("not working");
		}

		if (index == size) {
			// adding the element to the back of the LinkedList
			add(newVal);
			size--;
		} else if (index == 0) {
			// adding it to the beginning of the list
			ListNode newHead = new ListNode(newVal);
			newHead.next = head;
			head = newHead;
			

		} else {
			// adding element in between two elements
			ListNode pred = head;
			int counter = 0;
			while (counter != index - 1) {
				counter++;
				pred = pred.next;
			}
			// after while loop, temp is the node at 'index-1'
			ListNode newNode = new ListNode(newVal);
			newNode.next = pred.next;
			pred.next = newNode;

		}
		size++;
	}

	@Override
	public String toString() {
		if (head == null) {
			return "[]";
		}
		String s = "[";

		ListNode temp = head;

		while (temp != null) {
			s += temp.val + ", ";
			temp = temp.next;
		}

		return s.substring(0, s.length() - 2) + "]";
	}

	private class ListNode {
		T val;
		ListNode next;

		public ListNode(T val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "" + this.val;
		}

	}
}
