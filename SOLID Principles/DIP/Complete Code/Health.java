/**
 * The Health interface represents the contract for a Health object.
 * It provides methods to get and set health points, take damage, and heal.
 * @author James Bebarski
 */
public interface Health {
	
	/**
	 * Returns healthPoints.
	 * @return healthPoints.
	 */
	int getHealthPoints();
	
	/**
	 * Sets a given amount of healthPoints.
	 * @param healthPoints - the given healthPoints.
	 */
	void setHealthPoints(int healthPoints);
	
	/**
	 * Reduces healthPoints by a given amount.
	 * @param damage - the given damage to health.
	 */
	void takeDamage(int damage);
	
	/**
	 * Increases healthPoints by a given amount.
	 * @param heals - the given heals to health.
	 */
	void takeHeals(int heals);
}
