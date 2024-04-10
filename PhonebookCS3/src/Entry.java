
public class Entry {
	
	private Entry next;
	private Person key;
	private	PhoneNumber value;
	
	public Entry(Person key, PhoneNumber value) {
		
		this.key = key;
		this.value = value;
		
		
	}
	
	@Override
	public String toString() {
		
		return "[name: " + key + ", number: " + value + "]";
		
	}

	public Entry getNext() {
		return next;
	}

	public void setNext(Entry next) {
		this.next = next;
	}

	public Person getKey() {
		return key;
	}

	public void setKey(Person key) {
		this.key = key;
	}

	public PhoneNumber getValue() {
		return value;
	}

	public void setValue(PhoneNumber value) {
		this.value = value;
	}
	
	
	

}
