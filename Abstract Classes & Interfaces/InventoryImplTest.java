/*
 * James Bebarski
 * InventoryImplTest.java
 * Concept 2
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class InventoryImplTest {

	private InventoryImpl inventory;
	
	@Before 
	public void setUp() {
		inventory = new InventoryImpl(5);
	}
	
	@Test
	public void testAddItem() {
		inventory.addItem(Item.Sword);
		assertEquals(1, inventory.getItems().size());
		assertTrue(inventory.getItems().contains(Item.Sword));
	}
	
	@Test
	public void testAddItemWhenFull() {
		inventory.addItem(Item.Sword);
		inventory.addItem(Item.Dagger);
		inventory.addItem(Item.Lockpick);
		inventory.addItem(Item.Spellbook);
		inventory.addItem(Item.Staff);
		
		inventory.addItem(Item.Hammer);
		assertEquals(5, inventory.getItems().size());
	}
	
	@Test
	public void testRemoveItem() {
		inventory.addItem(Item.Sword);
		inventory.removeItem(Item.Sword);
		assertEquals(0, inventory.getItems().size());
	}
	
	@Test
	public void testToString() {
		inventory.addItem(Item.Sword);
		inventory.addItem(Item.Dagger);
		String expected = "Inventory (2/5):\n1. Sword\n2. Dagger\n";
		assertEquals(expected, inventory.toString());
	}


}
