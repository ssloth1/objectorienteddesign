


/** An enum to represent an item */
public enum Item {
	
	/** Represent a Sword. */
	SWORD("Sword"),
	
	/** Represents a Bow. */
	BOW("Bow"),
	
	/** Represents a Spellbook */
	SPELLBOOK("Spellbook"),
	
	/** Represents a Potion. */
	POTION("Potion");
	
	private final String itemName; 
	
	/**
	 * Constructs an Item with string representation.
	 * @param itemName - the string representation of the Item enum.
	 */
	Item(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return itemName;
	}
}
