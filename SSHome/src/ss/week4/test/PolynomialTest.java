package ss.week4.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ss.week4.math.Polynomial;
import ss.week4.math.Sum;

public class PolynomialTest {
	private static final double DELTA = 1e-15;
	private double[] values = {3, 2, 1};
	private Polynomial polynomial;

	@Before
	public void setUp() {
		polynomial = new Polynomial(values);
	}

	@Test
	public void testApply() {
		assertEquals(6.0, polynomial.apply(1), DELTA);
		assertEquals(3, polynomial.apply(0), DELTA);
		assertEquals(11, polynomial.apply(2), DELTA);
	}
	
	@Test
	public void testDerivative() {
		assertTrue(polynomial.derivative() instanceof Sum);
		assertEquals(polynomial.derivative().apply(0), 2, DELTA);
	
		
	}
	@Test
	public void testIntegrand() {
		assertTrue(polynomial.integrand() instanceof Sum);
		assertEquals(polynomial.integrand().apply(0), 0.0, DELTA);
	}

}
