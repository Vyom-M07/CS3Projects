import java.util.ArrayList;

public class Catalog {

	ArrayList<Item> list;
	private String name;
	
	Catalog(String name) {
	
		this.list = new ArrayList<Item>();
		this.name = name;
		
	}
	
	public void add(Item item) {
		
		list.add(item);
		
	}
	
	public int size() {
		
		return list.size();
		
	}
	
	public Item get(int index) {
		
		return list.get(index);
	}
	
	public String getName() {
		
		return name;
	}
	
	
	
}
