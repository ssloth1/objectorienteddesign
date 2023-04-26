/*
 * James Bebarski
 * April 14, 2023
 * Player.java
 * Concept 8: Design Patterns
 */

/**
 * The Player class represents a player in the game/sim.
 * It holds a name and can execute different attack strategies. 
 * @author James Bebarski
 */
public class Player {
	
	Attack attack;
	
	private String name;
	
	/**
	 * Constructs a new Player with the given name.
	 * @param name - the name of the player.
	 */
	public Player(String name) {
		this.name = name;
	}
	
	
	/**
	 * Executes the given attack strategy on the specified enemy.
	 * @param strategy - the attack strategy to be executed.
	 * @param enemy - the enemy to be attacked.
	 */
	public void executeAttack(Attack strategy, Enemy enemy) {
		strategy.attack(enemy);
	}
	
	/**
	 * Returns a string representation of the player. 
	 * @return the player's name. 
	 */
	@Override
	public String toString() {
		return name;
	}
}
