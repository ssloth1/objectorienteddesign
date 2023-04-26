/*
 * James Bebarski
 * April 14, 2023
 * SmashAttack.java
 * Concept 8: Design Patterns
 */

import java.util.Random;

/**
 * The SmashAttack class is a concrete implementation of the Attack interface,
 * providing an attack strategy that deals damage to enemies armor resistance points. 
 * @author James Bebarski
 */
public class SmashAttack implements Attack {
    
	private Random random = new Random();
    
	/** 
	 * Attacks the given enemy with a smash attack. 
	 * Deals damage to armored enemies and print the result. 
	 * It also prints if an attack was successful or not.
	 * @param enemy - The enemy to be attacked.
	 */
    @Override
    public void attack(Enemy enemy) {
        if (enemy instanceof ArmoredEnemy) {
            int damage = random.nextInt(10) + 1; // Deal a random amount of armor damage between 1-10
            ((ArmoredEnemy) enemy).receiveArmorDamage(damage);
            System.out.println("Smash attack dealt " + damage + " armor damage!");
        } else {
            System.out.println("Smash attack was ineffective!");
        }
    }
}
