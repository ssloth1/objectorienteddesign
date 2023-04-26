/*
 * James Bebarski
 * InventoryImpl.java
 * Concept 2
 */

import java.util.ArrayList;

/**
 * A concrete implementation of the Inventory Interface. 
 * Represents a inventory of a Character in a game.
 * @author James Bebarski
 */
public class InventoryImpl implements Inventory {
	
	private ArrayList<Item> items;
	private int inventorySize;
	
	/**
	 * Constructor for a Inventory Implementation. 
	 * Initializes an empty Array, which can store items.
	 * @param inventorySize - the given size of an inventory.
	 */
	public InventoryImpl(int inventorySize) {
		this.items = new ArrayList<>();
		this.inventorySize = inventorySize;
	}
	
	@Override
	public void addItem(Item item) {
		if (items.size() < inventorySize) {
			items.add(item);
		} else {
			System.out.println("Could not add " + item + ".");
		}
	}

	@Override
	public void removeItem(Item item) {
		items.remove(item);
	}

	@Override
	public ArrayList<Item> getItems() {
		return items;
	}
	
	@Override
	public String toString() {
		String inventory = "Inventory (" + items.size() + "/" + inventorySize + "):\n";
		
		for (int i = 0; i < items.size(); i++) {
			inventory += (i + 1) + ". " + items.get(i).toString() + "\n";
		}
		return inventory;
	}

}
