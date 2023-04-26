/*
 * James Bebarski
 * Warrior.java
 * Concept 2
 */

/**
 * The Warrior class, extends the Character abstract class. 
 * Represents a warrior in a game. 
 * @author James Bebarski
 */
public class Warrior extends Character implements MeleeAbility {
	
	private Stamina stamina;

	/**
	 * The Warrior object constructor. 
	 * @param name - the given name of the warrior object.
	 * @param health - the given health of the warrior object.
	 */
	public Warrior(String name, int health) {
		super(name, health, 2);
		this.stamina = new StaminaImpl(100); 
	}
	
	/**
	 * Getter for the Warrior's stamina.
	 * @return the Warrior's stamina.
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
	public void meleeAttack(Character target) {
		System.out.println(this.getName() + " attacks " + target.getName() + " with a sword!");
		stamina.expendStamina(10);
		target.takeDamage(20);
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", Health: " + health + ", Stamina: " + stamina;
	}
}
