/*
 * James Bebarski
 * April 14, 2023
 * MagicEnemy.java
 * Concept 8: Design Patterns
 */

/**
 * The MagicEnemy class is a subclass of Enemy, 
 * representing an enemy with magic protection.
 * @author James Bebarski
 */
public class MagicEnemy extends Enemy {
	
	private int magicProtection;
	
	/**
	 * Constructs a new MagicEnemy with a given name, health, and magic protection.
	 * @param name - the name of the magic type enemy.
	 * @param health - the health of the magic type enemy.
	 * @param magicProtection - the initial magic protection of the magic enemies.
	 */
	public MagicEnemy(String name, int health, int magicProtection) {
		super(name, health);
		this.magicProtection = magicProtection;
	}
	
	/**
	 * Getter method for magicProtection.
	 * @return the magicProtection.
	 */
	public int getMagicProtection() {
		return magicProtection;
	}
	
	/**
	 * Setter method for magicProtection.
	 * @param magicProtection - the given magicProtection
	 */
	public void setMagicProtection(int magicProtection) {
		this.magicProtection = magicProtection;
	}
	
	/**
	 * If the opponent has lost their magic protection, they are vulnerable to taking damage to their health. 
	 * @return true if they are considered vulnerable, false otherwise.
	 */
	@Override
	public boolean isVulnerable() {
		return magicProtection <= 0;
	}
	
	/**
	 * Prints out information regarding the MagicEnemy's current name, health, and magic protection.
	 */
	@Override
	public void printStatus() {
		System.out.println(this.getName() + " has " 
	                     + this.getHealth() + " health, and " 
				         + this.getMagicProtection() + " magic protection.");
	}
	
	/**
	 * Calculates the amount of magic damage that has been done to the MagicEnemy.
	 * @param damage - the given damage.
	 */
	public void receiveMagicDamage(int damage) {
		magicProtection -= damage;
		if (magicProtection <= 0) {
			this.setMagicProtection(0);
		}
	}
	
	/**
	 * toString representation of the MagicEnemy object.
	 * @return the toString representation.
	 */
	@Override
	public String toString() {
		return "Name: " + name + ", Health: " + health + ", Magic Protection: " + magicProtection;
	}
}
