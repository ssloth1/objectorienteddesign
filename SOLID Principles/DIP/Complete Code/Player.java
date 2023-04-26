
/**
 * The Player class represents a Player object, 
 * think of this as the character that a person controls.
 * @author James Bebarski
 *
 */
public class Player extends Character implements HealAction, HealSelfAction, PunchAction {
	
	private Health health;
	private Inventory inventory;
	
	/**
	 * Constructs a Player object with a given name, and healthPoints.
	 * We also initialize an empty Inventory.
	 * @param fullName - the given name.
	 * @param healthPoints - the given healthPoints.
	 */
	public Player(String fullName, int healthPoints) {
		super(fullName);
		this.health = new HealthImpl(healthPoints);
		this.inventory = new InventoryImpl();
	}
	
    /**
     * Getter method for a character Health
     * @return a character's Health.
     */
    public Health getHealth() {
        return health;
    }
    
    /**
     * Sets a character's health. 
     * @param health - a given Health object.
     */
    public void setHealth(Health health) {
        this.health = health;
    }
    
    /**
     * Getter method for a character's inventory. 
     * @return a character's inventory.
     */
    public Inventory getInventory() {
        return inventory;
    }
    
    /**
     * Sets a character's inventory.
     * @param inventory -  a given inventory.
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
    /**
     * Allows a player to pickUp a given item and add it to their inventory.
     * @param item - the given item.
     */
    public void pickupItem(Item item) {
    	this.inventory.addItem(item);
    }
    
    /**
     * Allows a player to drop and item from their inventory.
     * @param item - the item to drop.
     */
    public void dropItem(Item item) {
    	if (this.inventory.containsItem(item)) {
    		this.inventory.removeItem(item);
    	} else {
    		System.out.println("You cannot drop an item you don't have!");
    	}
    }
    
    @Override
    public String toString() {
    	return getName().toString() + "\n" + health.toString() + "\n" + inventory.toString();
    }


	@Override
	public void selfHeal() {
	    if (this.inventory.containsItem(Item.SPELLBOOK)) {
	        System.out.println("Using spellbook... for 10 heals.");
	        this.health.takeHeals(10);
	        return;
	    }
	    if (this.inventory.containsItem(Item.POTION)) {
	        System.out.println("Using potion... for 20 heals.");
	        this.inventory.removeItem(Item.POTION);
	        this.health.takeHeals(20);
	        return;
	    }
	    System.out.println("There are no healing items in " + this.getName() + "'s inventory.");
	}


    /**
     * Heals another player using a healing item from the inventory.
     * @param target The target player to be healed.
     */
	@Override
    public void heal(Player target) {
	    if (this.inventory.containsItem(Item.SPELLBOOK)) {
	        System.out.println("Using spellbook... for 10 heals.");
	        target.health.takeHeals(10);
	        return;
	    }
	    if (this.inventory.containsItem(Item.POTION)) {
	        System.out.println("Using potion... for 20 heals.");
	        this.inventory.removeItem(Item.POTION);
	        target.health.takeHeals(20);
	        return;
	    }
	    System.out.println("There are no healing items in " + this.name + "'s inventory.");
    }
    
    /**
     * Uses a heal ability as an attack on an undead character.
     * @param target The target undead to be healed.
     */
	@Override
    public void heal(Undead target) {
	    if (this.inventory.containsItem(Item.SPELLBOOK)) {
	        System.out.println("Using spellbook... for 10 heals.");
	        target.getHealth().takeHeals(10);
	        return;
	    }
	    if (this.inventory.containsItem(Item.POTION)) {
	        System.out.println("Using potion... for 20 heals.");
	        this.inventory.removeItem(Item.POTION);
	        target.getHealth().takeHeals(20);
	        return;
	    }
	    System.out.println("There are no healing items in " + this.name + "'s inventory.");
    }
	
	// Punch a player target. 
	@Override
	public void punch(Player target) {
		target.getHealth().takeDamage(5);
	}
	
	//Punch an undead target.
	@Override
	public void punch(Undead target) {
		target.getHealth().takeDamage(5);
	}

}
