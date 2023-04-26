/*
 * James Bebarski
 * April 14, 2023
 * Simulation.java
 * Concept 8: Design Patterns
 */

import java.util.Scanner;

/**
 * The driver class for the Strategy Pattern Demonstration.
 * @author James Bebarski
 */
public class Simulation {
	
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Player player = new Player("Jim the Great");
		
		System.out.println("Welcome to my Strategy Pattern Example!");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Tips:");
		System.out.println("Slash depletes health.\n" + "Smash depletes armor protection.\n" + "Spell depletes magic protection.\n");
		System.out.println("You'll need to deplete enemy armor or magic protection before attempting flesh damage." );
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Choose your opponent type:\n" + 
						   "1: Armored Enemy\n" + 
				           "2: Magic Enemy\n"); 
		
		int opponentType = scanner.nextInt();
		
		Enemy enemy;
		
		if (opponentType == 1) {
			enemy = new ArmoredEnemy("Armored Enemy", 20, 15);
		} else {
			enemy = new MagicEnemy("Magic Enemy", 20, 15);
		}
		
		System.out.println("You are now facing\n" + enemy.toString());
		
		while (!enemy.isKnockedOut()) {
			System.out.println("Choose your attack: \n" + "1) Slash\n" + "2) Smash\n" + "3) Spell\n");
			int attackChoice = scanner.nextInt();
			Attack attack;
			
			if (attackChoice == 1) {
				attack = new SlashAttack();
				player.executeAttack(attack, enemy);
			} else if (attackChoice == 2) {
				attack = new SmashAttack();
				player.executeAttack(attack, enemy);
			} else if (attackChoice == 3) {
				attack = new SpellAttack();
				player.executeAttack(attack, enemy);
			} else  {
				System.out.println("Invalid attack choice. Exiting.");
				scanner.close();
				System.exit(1);
			}
			
			enemy.printStatus();
		}
		scanner.close();
	}
}
