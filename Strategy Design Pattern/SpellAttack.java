/*
 * James Bebarski
 * April 14, 2023
 * SpellAttack.java
 * Concept 8: Design Patterns
 */

import java.util.Random;

/**
 * The SpellAttack class is a concrete implementation of the Attack interface,
 * providing an attack strategy that deals damage to enemies magic resistance points. 
 * @author James Bebarski
 *
 */
public class SpellAttack implements Attack {
	
	private Random random = new Random();
	
	/**
	 * Attacks the given enemy with a spell attack.
	 * Deals damage to magic enemies and prints the result.
	 * It also prints if an attack was successful or not. 
	 * @param enemy - the enemy to be attacked.
	 */
	@Override
	public void attack(Enemy enemy) {
		if (enemy instanceof MagicEnemy) {
			int damage = random.nextInt(10) + 1; // Deal a random amount of magic damage between 1-10
			((MagicEnemy) enemy).receiveMagicDamage(damage);
			System.out.println("Spell attack dealt " + damage + " magic damage!");
		} else {
			System.out.println("Spell attack was ineffective!");
		}
		
	}

}
