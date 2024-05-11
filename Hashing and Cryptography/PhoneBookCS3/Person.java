
public class Person {

	private String name;
	
	public Person(String name) {

		this.name = name;
		
	}



	@Override
	public int hashCode() {
		
		
		return name.hashCode();
		
	}


	@Override
	public String toString() {
		
		return name;
	}



	public boolean equals(Person o) {
	
		
		return name.equals(o.name);
		
	}
	
}
