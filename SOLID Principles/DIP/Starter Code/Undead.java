/**
 * Represents an Undead Non-Playable Character.
 * A Undead object has a fullName, uses the NPC inventory. 
 * @author James Bebarski
 */
public class Undead extends NPC implements HealAction, PunchAction {
	
	private Health health;
	
	/**
	 * Constructs an Undead NPC, it accepts a fullName as a String, using the Name constructor from character.
	 * Uses the the inventory of an NPC, and utilizes the UndeadHealthImpl.
	 * @param fullName - the fullName of a Undead character
	 * @param healthPoints - the healthPoints of an Undead character.
	 */
	public Undead(String fullName, int healthPoints) {
		super(fullName);
		this.health = new UndeadHealthImpl(healthPoints);
	}
	
    /**
     * Getter method for a Undead Health
     * @return a Undead's Health.
     */
    public Health getHealth() {
        return health;
    }
    
    /**
     * Sets a Undead's health. 
     * @param health - a given Health object.
     */
    public void setHealth(Health health) {
        this.health = health;
    }
	
    @Override
    public String toString() {
    	return getName().toString() + "\n" + health.toString() + "\n" + getInventory().toString();
    }

    
    // Now we can use the HealAction Interface and PunchAction interface, instead of CharacterAction. 
    // CharacterAction with all the initial methods lumped together forced us to use healSelf(), which was useless and harmful to an Undead. 
    // We now have way more flexibility both now and in the future, especially if we decide to create new subclasses or subclasses of Character in the future.
    
	@Override
	public void punch(Health target) {
		target.takeDamage(5);
	}
	
	
	// Heal is still okay, because they could have a party member or ally that might benefit from Heal
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
