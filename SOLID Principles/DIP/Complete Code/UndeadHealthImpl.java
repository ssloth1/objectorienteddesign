/**
 * Represents an UndeadHealthImplementation. Undead start with healthPoints. 
 * They take reduced damage on attack, but healing actually reduces their health by the given heals!
 * Think about this in terms of using healing magic on an Undead enemy in a CRPG (Think Baldur's Gate or Divinity). 
 * @author James Bebarski
 *
 */
public class UndeadHealthImpl implements Health {
	
	private int healthPoints;
	
	/**
	 * Constructor for the UndeadHealthImpl. 
	 * @param healthPoints - given healthPoints.
	 */
	public UndeadHealthImpl(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	
	@Override
	public int getHealthPoints() {
		return healthPoints;
	}

	@Override
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	@Override
	public void takeDamage(int damage) {
		this.healthPoints -= Math.round(damage * 0.9f); // Undead take a reduced amount of damage.
	}

	@Override
	public void takeHeals(int heals) {
		this.healthPoints -= heals; // Healing actually really hurts the undead!
	}
	
	@Override
	public String toString() {
		return "Health: " + healthPoints;
	}


}
