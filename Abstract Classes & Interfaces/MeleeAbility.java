/*
 * James Bebarski
 * MeleeAbility.java
 * Concept 2
 */

/**
 * Interface that requires implementers to utilize a meleeAttack. 
 * @author James Bebarski
 */
public interface MeleeAbility {
	
	/**
	 * Requires a user to utilize some sort of meleeAttack.
	 * @param target - the target of the meleeAttack.
	 */
	void meleeAttack(Character target);

}
