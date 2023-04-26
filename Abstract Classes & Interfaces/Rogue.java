/*
 * James Bebarski
 * Rogue.java
 * Concept 2
 */

/**
 * The Rogue class, extends the Character abstract class. 
 * Represents a rogue in a Game. 
 * Utilizes the StealthAbility interface.
 * @author James Bebarski
 *
 */
public class Rogue extends Character implements StealthAbility {
	
	private Stamina stamina;

	/**
	 * Constructor for a rogue object.
	 * @param name - the given name.
	 * @param health - the given health. 
	 */
	public Rogue(String name, int health) {
		super(name, health, 8);
		this.stamina = new StaminaImpl(100);
	}
	
	/**
	 * Getter for the Rogue's stamina.
	 * @return the rogue's stamina.
	 */
	public int getStaminaValue() {
		return stamina.getStamina();
	}
	
	@Override
	public void attack(Character target) {
		System.out.println(this.getName() + " performed a basic attack on " + target.getName() + "!");
		stamina.expendStamina(5);
		target.takeDamage(5);
	}
	
	@Override
	public void stealthAttack(Character target) {
		System.out.println(this.getName() + " performs a stealth attack on " + target.getName() + "!");
		int damage = 5;
		// 20% chance to do 10x damage
		if (Math.random() < 0.2)  {
			damage *= 10; 
			System.out.println("Critical hit!");
			stamina.expendStamina(5);
			target.takeDamage(damage);
		} else {
			stamina.expendStamina(5);
			target.takeDamage(damage);
		}
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", Health: " + health + ", Stamina: " + stamina;
	}
}
