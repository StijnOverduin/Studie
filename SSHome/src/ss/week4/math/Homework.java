package ss.week4.math;

public class Homework {
	public static void main(String[] args) {
		LinearProduct f1 = new LinearProduct(new Constant(4), new Exponent(4));
		Function f2 = f1.integrand();
		Function f3 = f1.derivative();
		
		System.out.println("f(x) = " + f1 + ", f(8) = " + f1.apply(8));
		System.out.println("f(x) = " + f2 + ", f(8) = " + f2.apply(8));
		System.out.println("f(x) = " + f3 + ", f(8) = " + f2.apply(8));
		
		Sum f4 = new Sum(new Constant(2), new Constant(3));
		Function f5 = f4.derivative();
		Function f6 = f4.integrand();
		
		System.out.println("f(x) = " + f4);
		System.out.println("f(x) = " + f5);
		System.out.println("f(x) = " + f6 + ", f(2) = " + f6.apply(2));
	}

}
