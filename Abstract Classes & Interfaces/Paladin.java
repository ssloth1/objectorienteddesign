/*
 * James Bebarski
 * Paladin.java
 * Concept 2
 */

/**
 * The Paladin class extends the Warrior. 
 * The Paladin is similar to the Warrior, 
 * but it implements both the MagicAbility and MeleeAbility interfaces.
 * It utilizes the same inventory that Warrior uses.
 * @author James Bebarski
 */
public class Paladin extends Warrior implements MagicAbility, MeleeAbility {
	
	private Stamina stamina;
	private Mana mana;
	
	/**
	 * Constructor for a Paladin object.
	 * @param name - the given name.
	 * @param health - the given health.
	 */
	public Paladin(String name, int health) {
		super(name, health);
		this.stamina = new StaminaImpl(50);
		this.mana = new ManaImpl(50);
	}
	
	/**
	 * Getter for the Paladins's stamina.
	 * @return the Paladins's stamina.
	 */
	public int getStaminaValue() {
		return stamina.getStamina();
	}
	
	/**
	 * Getter for the Paladins's mana.
	 * @return the Paladins's mana.
	 */
	public int getManaValue() {
		return mana.getMana();
	}
	
	/**
	 * Paladin's implementation of attack, 
	 * is unique that it utilizes both meleeAttack and castSpell in a single attack action.
	 */
	@Override
	public void attack(Character target) {
		System.out.println(this.getName() + " performed a basic attack on " + target.getName() + "!");
		stamina.expendStamina(5);
		target.takeDamage(5);
	}
	
	@Override
	public void castSpell(Character target) {
		System.out.println(this.getName() + " infuses attack with holy light at " + target.getName() + "!");
		if (Math.random() < 0.5) {
			System.out.println("The attack has been boosted by the infusion!");
			mana.expendMana(10);
			target.takeDamage(30);
		} else {
			System.out.println("The infusion only provided a moderate boost.");
			mana.expendMana(10);
			target.takeDamage(10);
		}
	}
	
	@Override
	public void meleeAttack(Character target) {
		System.out.println(this.getName() + " attacks " + target.getName() + " with a hammer!");
		stamina.expendStamina(15);
		target.takeDamage(15);
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", Health: " + health + ", Stamina: " + stamina + ", Mana: " + mana;
	}
}
