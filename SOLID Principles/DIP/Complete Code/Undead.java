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

    
    /**
     * Provides the ability for an undead to punch a player.
     * @param target - the given player target to be punched.
     */
	@Override
	public void punch(Player target) {
		target.getHealth().takeDamage(5);
	}
	
    /**
     * Provides the ability for an undead to punch a another undead.
     * @param target - the given undead target to be punched.
     */
	@Override
	public void punch(Undead target) {
		target.getHealth().takeDamage(5);
	}
	
	
	// Heal is still okay, because they could have a party member or ally that might benefit from Heal
	@Override
	public void heal(Player target) {
	    if (this.inventory.containsItem(Item.SPELLBOOK)) {
	        System.out.println("Using spellbook on target ... for 10 heals.");
	        target.getHealth().takeHeals(10);
	        return;
	    }
	    if (this.inventory.containsItem(Item.POTION)) {
	        System.out.println("Using potion on target ... for 20 heals.");
	        this.inventory.removeItem(Item.POTION);
	        target.getHealth().takeHeals(20);
	        return;
	    }
	    System.out.println("There are no healing items in " + this.getName() + "'s inventory.");
	}
	
	// This is also ok, because if a Undead want to do damage on another undead, they can use healing items as weapons.
	@Override
	public void heal(Undead target) {
	    if (this.inventory.containsItem(Item.SPELLBOOK)) {
	        System.out.println("Using spellbook on target ... for 10 damage.");
	        target.getHealth().takeHeals(10);
	        return;
	    }
	    if (this.inventory.containsItem(Item.POTION)) {
	        System.out.println("Using potion on target ... for 20 damage.");
	        this.inventory.removeItem(Item.POTION);
	        target.getHealth().takeHeals(20);
	        return;
	    }
	    System.out.println("There are no healing items in " + this.getName() + "'s inventory.");
		
	}
}
