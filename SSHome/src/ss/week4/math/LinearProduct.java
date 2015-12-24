package ss.week4.math;

public class LinearProduct extends Product implements Integrandable {
	private Constant gx;
	private Function fx;

	public LinearProduct(Constant gx, Function fx) {
		super(gx, fx); 
		this.fx = fx;
		this.gx = gx;
	}

	public Function derivative() {
		return new LinearProduct(gx, fx.derivative());
	}

	public String toString() {
		return "(" + gx + ") * (" + fx + ")";
	}

	public Function integrand() {
		if (fx instanceof Integrandable) {
			Function f = ((Integrandable) fx).integrand();
			if (f != null) {
				return new LinearProduct(gx, f);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
