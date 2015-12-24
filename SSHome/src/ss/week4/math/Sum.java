package ss.week4.math;

public class Sum implements Function, Integrandable {
	private Function gx;
	private Function fx;

	public Sum(Function gx, Function fx) {
		this.gx = gx;
		this.fx = fx;
	}

	public double apply(int x) {
		return gx.apply(x) + fx.apply(x);
	}

	public Function derivative() {
		return new Sum(gx.derivative(), fx.derivative());
	}

	public String toString() {
		return "g(x) = " + gx + "f(x) = " + fx;
	}
	public static void main(String[] args){
		Sum sum = new Sum(new LinearProduct(new Constant(2), new Exponent(2)), new Constant(3));
		System.out.println(sum.apply(0));
	}

	public Function integrand() {
		if (gx instanceof Integrandable && fx instanceof Integrandable) {
			Function g = ((Integrandable)gx).integrand();
			Function f = ((Integrandable)fx).integrand();
			if(g != null && f != null) {
				return new Sum(g, f);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

}
