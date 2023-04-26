/**
 * PunchAction interface, implements the ability to punch others that utilize the Health interface.
 * @author James Bebarski
 */
public interface PunchAction {
	
	/**
	 * Action to punch a Player..
	 * @param target - The given player target.
	 */
	public void punch(Player target);
	
	
	/**
	 * Provides the ability to punch an undead target.
	 * @param target - the given undead target.
	 */
	public void punch(Undead target);
}
