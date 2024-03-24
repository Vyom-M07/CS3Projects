
public class EmployeeDatabase {

	private int Capacity = 11;
	private Employee[] arr;
	private int size;
	
	public EmployeeDatabase() {
		
		arr = new Employee[Capacity];
		
	}
	
	public EmployeeDatabase(int initCapacity) {
		
		arr = new Employee[initCapacity];
	
	}
	
	
	public int getCapacity() {
		
		return Capacity;
		
	}
	
	public boolean add(Employee key) {
		
		if (size == Capacity) {
			System.out.println("The table is full, cannot add");
			return false;
		}
		
		if (contains(key)) {
			System.out.println("Cannot add element; already in the set");
			return false;
		}
		
		size++;
		
		int id = key.hashCode(); // last digit
		
		while (true) {
			
			if (arr[id] == null) {
				arr[id] = key;
			} else {
				
				id++;
				if (id == Capacity)
				{
					id = 0;
					break; // idk if this acc goes here
				}
				
			}
			
			
		}
		
		
		
		return false;
			
	}
	
	public boolean contains(Employee key) {
		
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[i].equals(key) && arr[i] != null)
				return true;
			
		}
		
		return false;
		
	}
	
	public int size() {
		
		return size;
		
	}

	
	
}
