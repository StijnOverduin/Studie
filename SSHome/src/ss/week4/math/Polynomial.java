package ss.week4.math;

public class Polynomial implements Function, Integrandable {
	private LinearProduct[] values;

	public Polynomial(double[] values) {
		this.values = new LinearProduct[values.length];
		for (int i = 0; i < values.length; i++) {
			Constant c = new Constant(values[i]);
			Exponent e = new Exponent(i);
			this.values[i] = new LinearProduct(c, e);
		}
	}

	public double apply(int x) {
		double ans = 0;
		for (int i = 0; i < values.length; i++) {
			ans += values[i].apply(x);
			System.out.println(ans);
		}
		return ans;

	}
	public static void main(String[] args) {
		double[] values = {3,2,1};
		Polynomial p = new Polynomial(values);
		System.out.println(p.derivative());
		
	}

	public Function derivative() {
		Function f = null;
		for (int i = 0; i < values.length; i++) {
			Function a = values[i].derivative();
			if (f == null) {
				f = new Sum(new Constant(0), a);
			} else {
				f = new Sum(f, a);
			}
		}
		return f;
	}

	public String toString() {
		String ans = "";
		for (int i = 0; i < values.length; i++) {
			ans = ans + values[i] + " + ";
		}
		return ans;
	}
	public Function integrand() {
		Function f = null;
		for (int i = 0; i < values.length; i++) {
			Function a = values[i].integrand();
			if (f == null) {
				f = new Sum(new Constant(0), a);
			} else {
				f = new Sum(f,a);
			}
		}
		return f;
	}

}
