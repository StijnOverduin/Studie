package ss.week4.math;

public class Product implements Function {

	private Function gx;
	private Function fx;

	public Product(Function gx, Function fx) {
		this.gx = gx;
		this.fx = fx;
	}

	public double apply(int x) {
		return gx.apply(x) * fx.apply(x);

	}

	public Function derivative() {
		return new Sum(new Product(gx.derivative(), fx), new Product(fx.derivative(), gx));

	}

	public String toString() {
		return "(" + gx + ") * (" + fx + ")";
	}

}
