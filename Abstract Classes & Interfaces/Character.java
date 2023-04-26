/*
 * James Bebarski
 * Character.java
 * Concept 2
 */

/**
 * Represents an abstract Character in a video game. 
 * A character has a name and health. 
 * @author James Bebarski
 */
public abstract class Character {
	protected String name;
	protected int health;
	protected Inventory inventory;
	
	/**
	 * Constructor for a Character object.
	 * @param name - the given name of the character as a String.
	 * @param health - the given health of the character as a integer.
	 * @param inventorySize - the given inventory, with some specified inventory size.
	 */
	public Character(String name, int health, int inventorySize) {
		this.name = name;
		this.health = health;
		this.inventory = new InventoryImpl(inventorySize);
	}
	
	/**
	 * The abstract method for a basic attack that all Character subtypes must implement. 
	 * @param target - the Character object to attack. 
	 */
	public abstract void attack(Character target);
	
	/**
	 * Getter method for a character's name.
	 * @return the character name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name for a character object.
	 * @param name - the given name for a character.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter method for a character's health. 
	 * @return the character health.
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Sets the health for a character object.
	 * @param health - the given health.
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 * Provides a more concise way for Character 
	 * children to add an item to their inventory.
	 * @param item - the given item for a Character to add to Inventory.
	 */
	public void pickupItem(Item item) {
		inventory.addItem(item);
	}
	
	/**
	 * Provides a more abstract way for Character
	 * children to add an item to their inventory.
	 * @param item - the given item for a Character to remove from Inventory.
	 */
	public void dropItem(Item item) {
		inventory.removeItem(item);
	}
	
	
	/**
	 * Method that lays out the logic for how every character object will receive incoming damage. 
	 * @param damage - the given damage. 
	 */
	public void takeDamage(int damage) {
		this.health -= damage;
		if (health <= 0) {
			System.out.println(name + " has been defeated!");
		} else {
			System.out.println(name + " took " + damage + " damage! Remaining health: " + health);
		}
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", Health: " + health;
	}
}