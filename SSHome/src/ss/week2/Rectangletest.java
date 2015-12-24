package ss.week2;

import org.junit.Before;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Rectangletest {
	private Rectangle r;
	
	@Before
	public void setUp() {
		r = new Rectangle(2, 3);
	}
	
	@Test
	public void testInitial() {
		assertEquals(2, r.length());
		assertEquals(3, r.width());
		assertEquals(6, r.area());
		assertEquals(10, r.perimeter());

	}
}
