package ss.week3.hotel;

import java.io.PrintStream;
import ss.week3.Format;

public class Bill {
	private double sum;
	private PrintStream ps;

	public interface Item {

		public double getAmount();

		public String toString();
	}

	public Bill(PrintStream prs) {
		this.ps = prs;
	}

	public void close() {
		ps.println(getSum());
	}

	public double getSum() {
		return sum;
	}

	public void newItem(Bill.Item item) {
		sum += item.getAmount();
		this.printLine(item.toString(), item.getAmount());
	}
	public void printLine(String text, double amount) {
		ps.println(Format.printLine(text, amount));
	}
}
