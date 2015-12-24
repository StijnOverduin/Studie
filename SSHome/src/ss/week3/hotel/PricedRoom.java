package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item {
	private double amount;
	
	public PricedRoom(int no, double rprice, double sprice) {
		this(no, rprice, new PricedSafe(sprice));
	}
	public PricedRoom(int no, double rprice, Safe safe) {
		super(no, safe);
		amount = rprice;
	}
	public double getAmount() {
		return amount;
	}
	public String toString() {
		return "This room costs " + getAmount() + " /night";
	}
}
