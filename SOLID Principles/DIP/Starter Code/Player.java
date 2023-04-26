
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
    
    @Override
    public String toString() {
    	return getName().toString() + "\n" + health.toString() + "\n" + inventory.toString();
    }

	@Override
	public void punch(Health target) {
		target.takeDamage(5);
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


	@Override
	public void heal(Health target) {
	    if (this.inventory.containsItem(Item.SPELLBOOK)) {
	        System.out.println("Using spellbook on target ... for 10 heals.");
	        target.takeHeals(10);
	        return;
	    }
	    if (this.inventory.containsItem(Item.POTION)) {
	        System.out.println("Using potion on target ... for 20 heals.");
	        this.inventory.removeItem(Item.POTION);
	        target.takeHeals(20);
	        return;
	    }
	    System.out.println("There are no healing items in " + this.getName() + "'s inventory.");
	}

}
