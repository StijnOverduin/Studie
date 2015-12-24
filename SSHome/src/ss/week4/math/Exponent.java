package ss.week4.math;

public class Exponent implements Function, Integrandable {
	private int n;

	public Exponent(int n) {
		this.n = n;

	}

	public double apply(int x) {
		return Math.pow(x, n);
	
	}
	public static void main(String[] args) {
		Exponent n = new Exponent(0);
		System.out.println(n.apply(0));
	}

	public Function derivative() {
		return new LinearProduct(new Constant(n), new Exponent(n - 1));
	}

	public String toString() {
		return "x^" + n;
	}
	
	public Function integrand() {
		return new Product(new Constant(1 / (n + 1)), new Exponent(n + 1));
	}

}
