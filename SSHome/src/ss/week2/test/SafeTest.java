package ss.week2.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ss.week2.hotel.Safe;

public class SafeTest {

	private Safe safe;

	@Before
	public void setUp() {
		safe = new Safe();
	}

	@Test
	public void testActivateWrongPassword() {
		safe.activate("hello");
		assertFalse(safe.isActive());
	}
	@Test
	public void testActivateCorrectPassword() {
		safe.activate("password");
		assertTrue(safe.isActive());
	}
	@Test
	public void testOpenCorrectPassword() {
		safe.activate("password");
		safe.open("password");
		assertTrue(safe.isOpen());
		
	}
	@Test
	public void testOpenWrongPassword() {
		safe.open("hello");
		assertFalse(safe.isOpen());
		
	}
	@Test
	public void testActiveWhenActiveCorrectPassword() {
		safe.activate("password");
		assertTrue(safe.isActive());
		safe.activate("password");	
		assertTrue(safe.isActive());
	}
	@Test
	public void testActiveWhenActiveWrongPassword() {
		safe.activate("password");
		assertTrue(safe.isActive());
		safe.activate("hello");
		assertFalse(safe.isActive());
	}
	@Test
	public void testDeactivate() {
		safe.deactivate();
		assertFalse(safe.isActive());
	}
	@Test
	public void testClose() {
		safe.close();
		assertFalse(safe.isOpen());
	}

}
