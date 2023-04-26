
/**
 * Represents a Non-Playable character in a game. 
 * @author James Bebarski
 */
public class NPC extends Character {
	
	protected Inventory inventory;
	
	/**
	 * Constructor for an NPC object. An NPC has a name and an inventory.
	 * @param fullName - the given fullName.
	 */
	public NPC(String fullName) {
		super(fullName);
		this.inventory = new InventoryImpl();
	}
	
    /**
     * Getter method for a NPC's inventory. 
     * @return a NPC's inventory.
     */
    public Inventory getInventory() {
        return inventory;
    }
    
    /**
     * Sets a NPC's inventory.
     * @param inventory -  a given inventory.
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
    
    @Override
    public String toString() {
    	return getName().toString() + "\n" + getInventory().toString();
    }
    
}
