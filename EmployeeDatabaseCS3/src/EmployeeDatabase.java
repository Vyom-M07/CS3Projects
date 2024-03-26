import java.util.Arrays;

public class EmployeeDatabase {

	private int Capacity = 11;
	private Employee[] arr;
	private int size;

	public EmployeeDatabase() {

		arr = new Employee[Capacity];
		this.size = 0;

	}

	public EmployeeDatabase(int initCapacity) {

		arr = new Employee[initCapacity];
		this.size = 0;

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

		if (arr[key.hashCode(key.getID())] == null) {
			arr[key.hashCode(key.getID())] = key;
			return true;
		}
//		System.out.println("stuck");

		int counter = 0;
		for (int i = key.hashCode(key.getID()) + 1; i < arr.length; i++) {
//			System.out.println("Im stuck");
			if (arr[i] == null) {
				arr[i] = key;
				return true;
			}

			if (i == arr.length - 1) {
				i = 0;
			}

			if (counter == arr.length - 1) {
				break;
			}
			counter++;
//			System.out.println(counter);
		}
		return false;
	}

	public boolean contains(Employee key) {

		if (arr[key.hashCode(key.getID())] != null) {
			if (arr[key.hashCode(key.getID())].equals(key)) {
				return true;
			}
		}

		int counter = 0;
		for (int i = key.hashCode(key.getID()) + 1; i < arr.length; i++) {

			if (arr[i] != null) {
				if (arr[i].equals(key)) {
					return true;
				}
			}

			if (i == arr.length - 1) {
				i = 0;
			}
			if (counter == arr.length - 1) {
				break;
			}
			counter++;

		}
		return false;
	}

	public int size() {

		return size;

	}

	public String toString() {

		return Arrays.toString(arr);

	}

	public boolean remove(Employee employee) {
		
		if (!contains(employee))
			return false;

		if (arr[employee.hashCode(employee.getID())] != null) {
			if (arr[employee.hashCode(employee.getID())].equals(employee)) {
				
				arr[employee.hashCode(employee.getID())] = null;
				
				int counter = employee.hashCode(employee.getID());
				while (arr[counter+1] != null) {
					
					Employee e = arr[counter+1];
					arr[counter+1] = null;
					arr[e.hashCode(e.getID())] = e;
					
					
				}

			}

		}

		return true;
	}

}