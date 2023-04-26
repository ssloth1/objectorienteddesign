/*
 * James Bebarski
 * StaminaImpl.java
 * Concept 2
 */

/**
 * Concrete implementation of the Stamina interface. 
 * @author James Bebarski
 */
public class StaminaImpl implements Stamina {
	
	private int stamina;
	
	/**
	 * Initializes some starting stamina.  
	 * @param stamina - the given amount of stamina.
	 */
	public StaminaImpl(int stamina) {
		this.stamina = stamina;
	}
	
	@Override
	public int getStamina() {
		return stamina;
	}

	@Override
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	@Override
	public void expendStamina(int stamina) {
		this.stamina -= stamina;
	}

	@Override
	public void regenStamina(int stamina) {
		this.stamina += stamina;
	}
	
	@Override
	public String toString() {
		return String.valueOf(stamina);
	}

}
