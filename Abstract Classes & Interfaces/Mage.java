/*
 * James Bebarski
 * Mage.java
 * Concept 2
 */

/**
 * Represents a Mage type of Character. Like a character they have a name and health. 
 * Mage's also have mana which is depleted each time a spell is cast. 
 * @author James Bebarski
 */
public class Mage extends Character implements MagicAbility {
	
	private Mana mana;

	/**
	 * A constructor for a Mage object.
	 * @param name - the given name 
	 * @param health - the given health
	 */
	public Mage(String name, int health) {
		super(name, health, 4);
		this.mana = new ManaImpl(100);
	}
	
	/**
	 * Getter for the Mages's mana.
	 * @return the Mage's mana.
	 */
	public int getManaValue() {
		return mana.getMana();
	}
		
	@Override 
	public void attack(Character target) {
		System.out.println(this.getName() + " performed a basic attack on " + target.getName() + "!");
		mana.expendMana(5);
		target.takeDamage(5);
	}
	
	@Override
	public void castSpell(Character target) {
		System.out.println(this.getName() + " casts a mana attack at " + target.getName() + "!");
		mana.expendMana(10);
		target.takeDamage(20);
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", Health: " + health + ", Mana: " + mana ;
	}
	
}
