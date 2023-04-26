/*
 * James Bebarski
 * Inventory.java
 * Concept 2
 */

import java.util.List;

/**
 * An Inventory interface, which lays out behaviors for a inventory implementation.
 * @author James Bebarski
 */
public interface Inventory {
	
	/**
	 * Allows a user to add a new item to their inventory.
	 * @param item - the given item to add.
	 */
	public void addItem(Item item);
	
	/**
	 * Allows a user to remove a item from a inventory.
	 * @param item - the given item to remove.
	 */
	public void removeItem(Item item);
	
	/**
	 * Get's the list of items.
	 * @return the list of items.
	 */
	List<Item> getItems();
	
}
