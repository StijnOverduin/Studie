package ss.week1;

public class DollarsAndCentsCounter {
	private int geld;

	public int dollars() {
		return geld / 100;
	}

	public int cents() {
		return geld % 100;
	}

	public void add(int dollars, int cents) {
		geld = geld + dollars * 100 + cents;
	}

	public void reset() {
		geld = 0;
	}
}
