import java.util.Arrays;

public class PhoneBook implements IMap {

	private Entry[] arr;
	private int size = 0; // keeps track of how many databuckets filled not how many total elements in hash map
	private int capacity;
	
	PhoneBook(int capacity) {
		
		arr = new Entry[capacity];
		this.capacity = capacity;
		
	}
	
	@Override
	public PhoneNumber put(Person person, PhoneNumber phone) {
		
		if ((double) size / capacity >= .75) {
			
			rehash();
			
		}
		
		if(arr[person.hashCode() % capacity] == null) {
			
			size++;
			arr[person.hashCode() % capacity] = new Entry(person, phone);
			
		} else {
			
			Entry e = arr[person.hashCode() % capacity];
			while(e != null) {
				
				
				if (e.getKey().equals(person)) {
	//				System.out.println("Should be in here");
					Entry temp = new Entry(e.getKey(), e.getValue());
					e.setValue(phone);
					
			//		System.out.println(Arrays.toString(arr));
					return temp.getValue();
					
				}
				e = e.getNext();
			}
			e = arr[person.hashCode() % capacity];
			Entry before = new Entry(person, phone);
			before.setNext(e);
			arr[person.hashCode() % capacity] = before;
		}
		
		
	//	System.out.println(Arrays.toString(arr));
		return null;
	}

	private void rehash() {
	
		
		
		Entry[] arr2 = new Entry[capacity*2];
		
		System.arraycopy(arr, 0, arr2, 0, capacity);
		
		arr = arr2;
		
		
	}

	@Override
	public PhoneNumber get(Person person) {
		// basically all i need to do here is find which index of array and then go thru each node until i find the phone number for the person.
		// can also check if the first node in the linked list is already the person to save time complexity
		Entry e = arr[person.hashCode() % capacity]; // e - head of linked list
		
		if (e.getKey().equals(person)) {
			return e.getValue();
		}
		
		if( e != null) {
			
			if(e.getNext() != null) {
				Entry temp = e;
				while(temp != null) {
					
					temp = temp.getNext();
					
					if(temp.getKey().equals(person)) {
						return temp.getValue();
					}
					
				}
				
				
			}
			
			
		}
		
		return null;
	}

	@Override 
	public int size() {
		
		return size;
	}

	@Override 
	public PhoneNumber remove(Person person) {

	
		Entry e = arr[person.hashCode() % capacity]; // head of linked list --> current
		Entry previous = null; // make previous's next deleted element's next instead of the deleted element itself ('skipping over the node)
		
		while (e != null) {
			
			if(e.getKey().equals(person)) {
				if (previous == null) {
					// head of linked list
					arr[person.hashCode() % capacity] = e.getNext();
					
				} else {
					
					previous.setNext(e.getNext()); // the skipping over part
				}
				size--;
				return e.getValue();
			}
			
			previous = e;
			e = e.getNext();
		}
		
		
		return null;
	}
	
	@Override
	public String toString() {
		
		return Arrays.toString(arr);
		
	}

	
	
}
