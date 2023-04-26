/*
 * James Bebarski
 * PaladinTest.java
 * Concept 2
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaladinTest {
	
	private Paladin paladin;
	
	// Notice how I was able to use Character here,
	// Since I only need to get health from the dummy,
	// this will work just fine because all characters have health.
	private Character dummy;
	
	
	/**
	 * We still instantiate dummy as a Mage,
	 * but since dummy is of the Character type we can only use Character methods.
	 * for more flexibility we can could just make the dummy variable a mage if we wanted.
	 * I just wanted to use this as an example of Liskov Subsitution.
	 */
	@Before
	public void setUp() {
		paladin = new Paladin("Jim", 100);
		dummy = new Mage("Dummy", 100);
	}
	
	@Test 
	public void testPaladinConstructor() {
		assertEquals("Jim", paladin.getName());
		assertEquals(100, paladin.getHealth());
		assertEquals(50, paladin.getManaValue());
		assertEquals(50, paladin.getStaminaValue());
	}
	
	@Test 
	public void testPaladinAttack() {
		paladin.attack(dummy);
		assertEquals(95, dummy.getHealth());
		assertEquals(45, paladin.getStaminaValue());
	}
	
	@Test
	public void testPaladinCastSpell() {
		paladin.castSpell(dummy);
		// castSpell has a 50/50 chance of doing either 10 damage or 30.
		boolean damage = dummy.getHealth() == 70 || dummy.getHealth() == 90;
		assertEquals(true, damage);
		// Spell costs 10 mana
		assertEquals(40, paladin.getManaValue());
	}
	
    @Test
    public void testPaladinMeleeAttack() {
        paladin.meleeAttack(dummy);
        assertEquals(85, dummy.getHealth());
        // Melee attack costs 15 stamina.
        assertEquals(35, paladin.getStaminaValue());
    }
	
	

}
