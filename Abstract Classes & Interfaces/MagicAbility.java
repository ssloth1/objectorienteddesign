/*
 * James Bebarski
 * MageAbility.java
 * Concept 2
 */

/**
 * Interface that requires implementers to utilize castSpell. 
 * @author James Bebarski
 */
public interface MagicAbility {
	
	/**
	 * Requires a user to utilize some sort of spellAttack.
	 * @param target - the target of the spellAttack.
	 */
	void castSpell(Character target);
}
