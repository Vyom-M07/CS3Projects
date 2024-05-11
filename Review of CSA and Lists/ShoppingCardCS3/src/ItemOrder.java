
public class ItemOrder {

	private Item item;
	private int qty;
	
	ItemOrder(Item item, int qty) {
		this.item = item;
		this.qty = qty;
		
		
	}
	
	public double getPrice() {
		
		return item.priceFor(qty);
		
	}
	
	public Item getItem() {
		
		return item;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
//		if (obj == this) {
//			return true;
//		} 
//		
//		if(obj.getClass() != this.getClass() || obj.getClass() == null) {
//			
//			return false;
//		}
		
		ItemOrder item = (ItemOrder) obj;
		
		return this.getItem().equals(item.getItem());
		
	}
	
}
