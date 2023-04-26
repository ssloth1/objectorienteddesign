/*
 * James Bebarski
 * April 14, 2023
 * Attack.java
 * Concept 8: Design Patterns
 */

/**
 * The Attack interface represents the different strategies for attacking enemies. 
 * Concrete implementations define the actual attack method and strategy.
 * @author James Bebarski
 */
public interface Attack {
	
	/**
	 * Attacks the given enemy with a specific type of strategy/move type. 
	 * @param enemy - the enemy to be attacked.
	 */
	void attack(Enemy enemy);
	
}
