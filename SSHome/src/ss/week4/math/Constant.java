package ss.week4.math;

public class Constant implements Function, Integrandable {
	private double constant;
	
	public Constant(double constant) {
		this.constant = constant;
	}
	public double apply(int x) {
		return constant;
	}

	public Function derivative() {
		return new Constant(0);
	}

	public String toString() {
		return "" + constant;
	}
	public Function integrand() {
		return new LinearProduct(new Constant(constant), new Exponent(1));
	}

}
