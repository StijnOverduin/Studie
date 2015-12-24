package ss.week3.hotel;

public class Item implements Bill.Item {

	private double amount;
	private String text;

	public Item(String text, double amount) {
		this.amount = amount;
		this.text = text;
	}

	public double getAmount() {
		return amount;
	}

	public String toString() {
		return text;
	}

}
