package ss.week3.hotel;

public class PricedSafe extends Safe implements Bill.Item {
	private double price;
	
	public PricedSafe(double price) {
		this.price = price;
	}
	public double getAmount() {
		return price; 
	}
	public String toString() {
		return "This safe costs " + getAmount();
	}

}
