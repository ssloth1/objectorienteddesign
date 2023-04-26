import java.util.List;
import java.util.function.Predicate;

/**
 * The Inventory interface represents the contract for a Inventory object.
 * It provides methods to get add items, remove items, 
 * count items, count by a type of item, and check if a type of item exists in inventory.
 * @author James Bebarski
 */
public interface Inventory {
	
	/**
	 * Gets the list of items in the inventory. 
	 * @return the list of items in the inventory.
	 */
	public List<Item> getInventory();
	
	/**
	 * Sets the list of items in the inventory.
	 * @param items - the items in to set int he inventory.
	 */
	void setInventory(List<Item> items);
	
	/**
	 * Adds a new item to the inventory array.
	 * @param item - the given item add.
	 */
	public void addItem(Item item);
	
	/**
	 * Removes a new item from the inventory array,
	 * @param item - the given item to remove
	 */
	public void removeItem(Item item);
	
	/**
	 * Returns the size of an array of items.
	 * @return the size of an array of items.
	 */
	public int countItems();
	
	/**
	 * Returns the size of an array of items, given a ceratin predicate.
	 * @param predicate - the given predicate/condition to filter our count by.
	 * @return the size of the array.
	 */
	public int countByItem(Predicate<Item> predicate);
	
	/**
	 * Returns true if the given item is in the inventory, false otherwise.
	 * @param item - the given item.
	 * @return true if the given item is in the array, false otherwise.
	 */
	public boolean containsItem(Item item);
}
