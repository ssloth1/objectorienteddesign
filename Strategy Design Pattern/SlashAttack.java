/*
 * James Bebarski
 * April 14, 2023
 * SlashAttack.java
 * Concept 8: Design Patterns
 */

import java.util.Random;

/** 
 * The SlashAttack class is a concrete implementation of the Attack interface
 * it provides an attack strategy for the enemies that are vulnerable to slash type attacks.
 * This attack is used when magic protection or armor protection is depleted.
 * @author James Bebarski
 */
public class SlashAttack implements Attack {
    
	private Random random = new Random();
    
	/**
	 * Attacks the given enemy with a slash attack.
	 * Deals damage to enemies who are vulnerable, 
	 * it also prints if an attack was successful or not.
	 * @param enemy - the enemy to be attacked.
	 */
    @Override
    public void attack(Enemy enemy) {
        if (enemy.isVulnerable()) {
            int damage = random.nextInt(10) + 1; // Deal a random amount of health damage between 1-10
            enemy.receiveHealthDamage(damage);
            System.out.println("Slash attack dealt " + damage + " flesh damage!");
        } else {
            System.out.println("Slash attack was ineffective!");
        }
    }
}
