/*
 * James Bebarski
 * ManaImplTest.java
 * Concept 2
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ManaImplTest {

	private Mana mana;
	
	@Before
	public void setUp() {
		mana = new ManaImpl(100);
	}
	
	@Test 
	public void testGetMana() {
		assertEquals(100, mana.getMana());
	}
	
	@Test 
	public void testSetMana() {
		mana.setMana(150);
		assertEquals(150, mana.getMana());
	}
	
	@Test 
	public void testExpendMana() {
		mana.expendMana(30);
		assertEquals(70, mana.getMana());
	}
	
	@Test 
	public void testRegenMana() {
		mana.regenMana(40);
		assertEquals(140, mana.getMana());
	}
	
	@Test
	public void testToString() {
		assertEquals("100", mana.toString());
	}
}
