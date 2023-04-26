/**
 * Health class represents a health object. It has healthPoints. 
 * We set methods for taking in a value that reduces the healthpoints by a given amount, and increases health.
 * @author James Bebarski
 *
 */
public class HealthImpl implements Health {

	private int healthPoints;
	
	/**
	 * Constructor for a health object. 
	 * @param healthPoints - the given health points.
	 */
	public HealthImpl(int healthPoints) {
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
		this.healthPoints -= damage;
	}
	

	@Override
	public void takeHeals(int heals) {
		this.healthPoints += heals;
	}
	
	@Override
	public String toString() {
		return "Health: " + healthPoints;
	}

}
