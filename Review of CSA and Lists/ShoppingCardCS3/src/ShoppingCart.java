import java.util.ArrayList;

public class ShoppingCart {

	ArrayList<ItemOrder> list;

	ShoppingCart() {

		list = new ArrayList<>();

	}

	public void add(ItemOrder newOrder) {

		for (int i = 0; i < list.size(); i++) {
			
			if (list.get(i).getItem().equals(newOrder.getItem())) {
				list.remove(i);
				break;
				
			} 
			
//			else {
//				list.add(newOrder);
//				System.out.println(newOrder);
//				break;
//			}
		}
		list.add(newOrder);

	}

	public double getTotal() {

		double total = 0.0;
		
		for (int i = 0; i < list.size(); i++) {
			total += list.get(i).getPrice();
		}
		
		return total;
	}

}
