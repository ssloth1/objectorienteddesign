/**
 * HealAction interface, implements the ability to heal others that utilize the Health interface.
 * @author James Bebarski
 */
public interface HealAction {
	/**
	 * Action for a character to heal another character. 
	 * @param target - the character that is being healed. 
	 */
	public void heal(Health target);
}
