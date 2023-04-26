/*
 * James Bebarski
 * April 14, 2023
 * Enemy.java
 * Design Patterns
 */

/**
 * The abstract Enemy class represents a abstract enemy in the game/sim.
 * It holds name, health, and defines methods that are common among all enemies. 
 * Additionally it contains abstract methods that it's children must implement. 
 * @author James Bebarski
 */
public abstract class Enemy {
	
	protected String name;
	protected int health;
	
	/** 
	 * Constructs a new Enemy with a given name and health
	 * @param name - the name of the enemy.
	 * @param health - the health of the enemy.
	 */
	public Enemy(String name, int health) {
		this.name = name;
		this.health = health;
	}
	
	/**
	 * Determines when an enemy is vulnerable to damage to their health. 
	 * Essentially it checks if their special resistance's have depleted to 0. 
	 * @return true if an enemy is vulnerable to health damage, or false if they are not.
	 */
	public abstract boolean isVulnerable();
	
	/**
	 * Prints the current status of an enemy,
	 * like total health points, resistance points (armor or magic), and their name. 
	 */
	public abstract void printStatus();
	
	/**
	 * Getter method for an enemy name. 
	 * @return - the name of the enemy.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Getter method for an enemy's health.
	 * @return - the health of an enemy.
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * Setter method for an enemy name.
	 * @param name - the name of the enemy.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Setter health for an enemy health.
	 * @param health - the health of the enemy.
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 * Checks if an opponents health is at or below zero. 
	 * This also prints if the opponent has been knocked out.
	 * @return true if the enemy health is at or below zero, false otherwise. 
	 */
	public boolean isKnockedOut() {
		if (health <= 0) {
			System.out.println(this.name + " has been knocked out.");
			return true;
		}
		return false;
	}
	
	/**
	 * Calculates the damage done to an enemy's health after being attacked.
	 * @param damage - the damage done to an enemy.
	 */
	public void receiveHealthDamage(int damage) {
		health -= damage;
		if (health <= 0) {
			this.setHealth(0);
		}
	}
	
	/**
	 * Basic toString method for the enemy object.
	 * @return the string representation of an enemy.
	 */
	@Override
	public String toString() {
		return "Name: " + name + "Health: " + health;
	}
	
}
