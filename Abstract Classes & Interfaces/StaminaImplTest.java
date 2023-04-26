/*
 * James Bebarski
 * StaminaImplTest.java
 * Concept 2
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StaminaImplTest {
	
	private Stamina stamina;
	
	@Before
	public void setUp() {
		stamina = new StaminaImpl(100);
	}
	
	@Test
	public void testGetStamina() {
		assertEquals(100, stamina.getStamina());
	}
	
	@Test
	public void testSetStamina() {
		stamina.setStamina(250);
		assertEquals(250, stamina.getStamina());
	}
	
	@Test
	public void testExpendStamina() {
		stamina.expendStamina(50);
		assertEquals(50, stamina.getStamina());
	}
	
	@Test
	public void testRegenStamina() {
		stamina.regenStamina(50);
		assertEquals(150, stamina.getStamina());
	}
	
	@Test
	public void testToString() {
		assertEquals("100", stamina.toString());
	}

}
