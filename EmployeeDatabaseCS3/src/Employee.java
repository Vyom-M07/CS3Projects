
public class Employee extends EmployeeDatabase {
	
	private String name;
	private int id;
	private int Capacity;
	
	public Employee(String name, int id) {
		
		this.name = name;
		this.id = id;
		
		Capacity = super.getCapacity();
		
		
	}
	
	public boolean equals(Employee o) {
		
		return id == o.id;
		
	}
	
	public int hashCode(int id) {
		
		return id % Capacity;
		
	}
	
	@Override
	public String toString() {
		
		return "name " + name + " id: " + id;
		
	}

}
