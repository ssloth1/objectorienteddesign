/**
 * HealAction interface, implements the ability to heal others that utilize the Health interface.
 * @author James Bebarski
 */
public interface HealAction {
	/**
	 * Action for a implementer of HealAction to heal a Player. 
	 * @param target - the Player that is being healed. 
	 */
	public void heal(Player target);
	
	/**
	 * Action for a implementer of HealAction to heal a Undead. 
	 * Keep in mind this is intended to harm an Undead, as heal does damage to them.
	 * @param target - the given Undead target.
	 */
	public void heal(Undead target);
}
