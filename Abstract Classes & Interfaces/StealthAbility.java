/*
 * James Bebarski
 * StealthAbility.java
 * Concept 2
 */

/**
 * Interface that requires implementers to utilize a stealthAbility. 
 * @author James Bebarski
 */
public interface StealthAbility {
	
	/**
	 * Requires users to use some sort of stealthAttack.
	 * @param target - the target of the stealthAttack.
	 */
	void stealthAttack(Character target);
}
