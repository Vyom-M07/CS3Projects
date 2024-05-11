
public class Item {

	private String name;
	private double price;
	private int bulkQty;
	private double bulkPrice;

	Item(String name, double price) {

		this(name, price, 1, price);
		// 1 and 1 are here temporarily, change later
		

	}

	Item(String name, double price, int bulkQty, double bulkPrice) {

		if (price < 0 || bulkPrice < 0 || bulkQty < 0) {

			throw new IllegalArgumentException("error");

		}

		this.name = name;
		this.price = price;
		this.bulkQty = bulkQty;
		this.bulkPrice = bulkPrice;

	}

	public double priceFor(int quantity) {

		if (quantity < 0) {
			throw new IllegalArgumentException("error");
		}

		if (quantity >= bulkQty && bulkQty > 0) {
			System.out.println("bulk price");
			return quantity * bulkPrice;

		} else {
			return quantity * price;
		}
	}

	@Override
	public boolean equals(Object obj) {

//		if (obj == this) {
//			return true;
//		} 
//		if ( obj.getClass() != this.getClass() || getClass() == null) {
//			return false;
//		}
		
		Item item = (Item) obj;
		
		return this.getName().equals(item.getName());
		
	}

	public String toString() {

		if (bulkPrice != price) {

			return "Name: " + getName() + ", Price: $" + getPrice() + ", or buy " + getBulkQty() + " or more for "
					+ getBulkPrice() + " each";

		} else {
			return "Name: " + getName() + ", Price: $" + getPrice();
		}

	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getBulkQty() {
		return bulkQty;
	}

	public void setBulkQty(int bulkQty) {
		this.bulkQty = bulkQty;
	}

	public double getBulkPrice() {
		return bulkPrice;
	}

	public void setBulkPrice(double bulkPrice) {
		this.bulkPrice = bulkPrice;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
