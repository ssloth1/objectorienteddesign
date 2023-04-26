/*
 * James Bebarski
 * Mana.java
 * Concept 2
 */

/**
 * The Mana interface, describes behaviors related to implementers of the Mana users.
 * @author James Bebarski
 */
public interface Mana {
	
	/**
	 * Get's the mana of the user.
	 * @return the mana of the user.
	 */
	public int getMana();
	
	/**
	 * Set's the mana of the user.
	 * @param mana - the given mana. 
	 */
	public void setMana(int mana);
	
	/**
	 * Helps us define how much mana a user utilizes from an action.
	 * @param mana - the given mana to expend.
	 */
	public void expendMana(int mana);
	
	/**
	 * Helps us define how much mana a user can regenerate.
	 * @param mana - the given mana to regen.
	 */
	public void regenMana(int mana);
}
