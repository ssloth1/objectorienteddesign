/*
 * James Bebarski
 * Stamina.java
 * Concept 2
 */

/**
 * The Stamina interface, describes behaviors related to implementers of the Stamina users.
 * @author James Bebarski
 */
public interface Stamina {
	
	/**
	 * Get's the stamina of the user.
	 * @return the stamina of the user.
	 */
	public int getStamina();
	
	/**
	 * Set's the stamina of the user.
	 * @param stamina - the given stamina. 
	 */
	public void setStamina(int stamina);
	
	/**
	 * Helps us define how much stamina a user utilizes from an attack.
	 * @param stamina - the given stamina.
	 */
	public void expendStamina(int stamina);
	
	/**
	 * Helps us define how much stamina a user can regenerate when called.
	 * @param stamina - the given stamina.
	 */
	public void regenStamina(int stamina);
	
}
