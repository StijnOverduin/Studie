package ss.week3.test;

import static org.junit.Assert.*;

import ss.week3.hotel.Bill;
import ss.week3.hotel.Item;

import org.junit.Before;
import org.junit.Test;

public class BillTest {
	private Item cola;
	private Item kamer;
	private Item safe;
	private Bill bill;

	@Before
	public void setUp() {
		bill = new Bill(System.out);
		cola = new Item("cola", 1.50);
		kamer = new Item("kamer 101", 50);
		safe = new Item("safe", 20.00);

	}

	@Test
	public void test() {
		bill.newItem(cola);
		assertEquals(1.50, bill.getSum(), 0.0001);
		bill.newItem(kamer);
		assertEquals(51.50, bill.getSum(), 0.0001);
		bill.newItem(safe);
		assertEquals(71.50, bill.getSum(), 0.001);

	}

	@Test
	public void billEmptyTest() {
		assertEquals(0, bill.getSum(), 0.00001);
	}

}
