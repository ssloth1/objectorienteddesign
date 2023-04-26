/*
 * James Bebarski
 * Item.java
 * Concept 2
 */

/**
 * Enum for representing different types of items commonly found in games.
 * Primarily used to demonstrate the an inventory interface implementation.
 * @author James Bebarski
 */
public enum Item {
	
	/** Represents a sword item.*/
	Sword("Sword"),
	
	/** Represents a dagger item.*/
	Dagger("Dagger"),
	
	/** Represents a lockpick item.*/
	Lockpick("Lockpick"),
	
	/** Represents a spellbook item.*/
	Spellbook("Spellbook"),
	
	/** Represents a staff item.*/
	Staff("Staff"),
	
	/** Represents a hammer item.*/
	Hammer("Hammer"),
	
	/** Represents a potion item.*/
	Potion("Potion"),
	
	/** Represents a armor item.*/
	Armor("Armor");
	
	private String itemName;
	
	/**
	 * Initializes the string representation of a specific item.
	 * @param itemName - the given item name.
	 */
	Item(String itemName) {
		this.itemName = itemName;
	}
	
	@Override
	public String toString() {
		return itemName;
	}
}
