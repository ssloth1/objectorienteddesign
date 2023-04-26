/**
 * PunchAction interface, implements the ability to punch others that utilize the Health interface.
 * @author James Bebarski
 */
public interface PunchAction {
	/**
	 * Action to punch another character.
	 * @param target - The target that uses the Health interface.
	 */
	public void punch(Health target);
}
