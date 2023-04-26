/*
 * James Bebarski
 * April 14, 2023
 * ArmoredEnemy.java
 * Concept 8: Design Patterns
 */

/**
 * The ArmoredEnemy class is a subclass of Enemy, 
 * representing an enemy with armor protection.
 * @author James Bebarski
 */
public class ArmoredEnemy extends Enemy {
	
    private int armorProtection;
    
    /**
     * Constructs a new ArmoredEnemy with a given name, health, and armor.
     * @param name - the name of the armored enemy.
     * @param health - the initial health of armored enemy.
     * @param armorProtection - the initial armor protection of the armored enemies.
     */
	public ArmoredEnemy(String name, int health, int armorProtection) {
        super(name, health);
        this.armorProtection = armorProtection;
    }
	
	/**
	 * Getter method for ArmorProtection.
	 * @return the armor protection.
	 */
	public int getArmorProtection() {
		return armorProtection;
	}
	
	/**
	 * Setter method for ArmorProtection.
	 * @param armorProtection - the given ArmorProtection.
	 */
	public void setArmorProtection(int armorProtection) {
		this.armorProtection = armorProtection;
	}
	
	/**
	 * Calculates the given damage to armor. 
	 * @param damage - the given damage.
	 */
	public void receiveArmorDamage(int damage) {
		armorProtection -= damage;
		if (armorProtection <= 0) {
			this.setArmorProtection(0);
		}
	}
	
	/**
	 * Returns true if the opponents armorProtection is at or below 0. 
	 * If so this means the ArmoredEnemy is vulnerable to health damage. 
	 * @return true if they are vulnerable, false otherwise.
	 */
	@Override
	public boolean isVulnerable() {
		return armorProtection <= 0;
	}
	
	/**
	 * Prints out information regarding the ArmorEnemy's current name, health, and armor protection.
	 */
	@Override
	public void printStatus() {
		System.out.println(this.getName() + " has " 
	                     + this.getHealth() + " health, and " 
				         + this.getArmorProtection() + " armor protection.");
	}
	
	/**
	 * toString representation of the ArmoredEnemy. 
	 */
	@Override
	public String toString() {
		return "Name: " + name + ", Health: " + health + ", Armor Protection: " + armorProtection;
	}
}
