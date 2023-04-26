/*
 * James Bebarski
 * Driver.java
 * Concept 2
 */

/**
 * Driver to demonstrate our Abstract Class and Interface Exercise.
 * @author James Bebarski
 */
public class Driver {
	
	/**
	 * The main method for our Abstract Class and Interface Exercise.
	 * @param args - the main args
	 */
	public static void main(String[] args) {
		
		/**
		 * 1. Character
		 * I have provided the Character abstract class for you. 
		 * Notice that there is a single abstract method for an attack.
		 * This should be a generic attack that each subclass should implement at a minimum.
		 * We will create more specialized attacks later on!
		 * 
		 * 2. Children Classes
		 * Implement the Warrior, Mage, Rogue, and Paladin classes. 
		 * 
		 * 3. Ability Interfaces
		 * Create the MagicAbility, MeleeAbility, and StealthAbility interfaces. 
		 * Think about who should implement what.
		 * These will require our behaviors for special moves that might use mana, stamina, or some fun combination.
		 * Hint: a class like Paladin might have a magicAttack and a meleeAttack!  
		 * 
		 * 4. Mana + ManaImpl and Stamina + StaminaImpl
		 * Create the Mana and Stamina interfaces. 
		 * Then create concrete implementations of these interfaces. 
		 * We will use composition in the Character subclasses for those that need stamina or mana.
		 * There should be methods to: 
		 * - getMana and getStamina 
		 * - setMana and setStamina
		 * - expendMana and expendStamina
		 * - regenMana and regenStamina
		 * 
		 * 5. Inventory
		 * Go further down below for instructions.
		 * 
		 * Feel free to observe the present driver, and the provided Paladin and PaladinTest file
		 * to get an idea as to how all these components of our design should fit together. 
		 * 
		 * You should run the provided StaminaImpl and ManaImpl tests when you think you've wrapped up. 
		 * Feel free to use these tests as a guide for the functionality you'll need to implement. 
		 */
		
		Warrior warriorGuy = new Warrior("Steve", 100);
		Mage mageGuy = new Mage("Ronaldo", 100);
		Rogue rogueGuy = new Rogue("Harry", 100);
		Paladin paladinGuy = new Paladin("Pete", 100);
		
		// Task 2: Demonstrate our character subclass implementations.
		// And their attack and specialized attack actions.
		
		// All attack() methods do the same damage.
		// but depending on the Character sub-class, they expend either stamina or mana.
		
		// 1. warriorGuy casts a melee attack on paladinGuy,
		// expending 10 stamina, but does 20 damage.
		// 2. warriorGuy uses a basic attack on paladinGuy.
		// this does 5 damage and expends 5 stamina.
		System.out.println(warriorGuy);
		warriorGuy.meleeAttack(paladinGuy);
		warriorGuy.attack(paladinGuy);
		System.out.println("\n");
		
		// 1. mageGuy casts a spell on warriorGuy,
		// expending 10 mana, but does 20 damage.
		// 2. mageGuy uses a basic attack on warriorGuy.
		// this does 5 damage and expends 5 mana.
		mageGuy.castSpell(warriorGuy);
		mageGuy.attack(warriorGuy);
		System.out.println("\n");
		
		// 1. rogueGuy uses a stealth attack on mageGuy,
		// a stealth attack consumes stamina and does 5 base damage, 
		// but has a 20% chance to do 10x damage (50 damage).
		// 2. rogueGuy uses a basic attack on mageGuy, 
		// this does 5 damage and expends 5 stamina.
		rogueGuy.stealthAttack(mageGuy);
		rogueGuy.attack(mageGuy);
		System.out.println("\n");
		
		
		// 1. paladinGuy casts a melee attack on rogueGuy,
		// expending 15 stamina, but does 15 damage.
		// 2. paladinGuy uses a spell attack on rogueGuy,
		// a spell attack for paladin consumes 10 mana, 
		// but has a 50/50 chance to do either 10 damage or 30 damage.
		// 3. paladinGuy uses a basic attack on rogueGuy,
		// this does 5 damage and expends 5 stamina.
		System.out.println(paladinGuy);
		paladinGuy.meleeAttack(rogueGuy);
		paladinGuy.castSpell(rogueGuy);
		paladinGuy.attack(rogueGuy);
		System.out.println("\n");
		
		// Task 3: 
		// For the final task, we will want to create a inventory interface. 
		// Inventory should include behaviors for:
		// - addItem
		// - removeItem
		// - and geItems (retrieves the inventory).
		// I want you to create a concrete Inventory Implementation.
		// The constructor should initialize an empty array for storing items. 
		// However, we want to be able to set the maximum size of the array. 
		// Character should be modified to include this new component of our design. 
		// We want all Characters subclasses to have some inventory, but the size will be up to us.
		// Example: A rogue might need a lot of tools, so let's give them a bigger inventory.
		// I have provided a Item enum file, with some items. 
		// My last stipulation is that paladin inherits the same inventory as warrior.
		// I want you to create a new concrete method in Character that abstracts 
		// the action of picking up and dropping an item from one's inventory.
		
		// Run the code so that it works as described. 
		
		// This is good:
		paladinGuy.inventory.addItem(Item.Armor);
		paladinGuy.inventory.removeItem(Item.Armor);
		
		// But this is better:
		// Since Paladin extends Warrior, it utilizes the Warriors inventory.
		paladinGuy.pickupItem(Item.Armor);
		paladinGuy.pickupItem(Item.Sword);
		System.out.println(paladinGuy.inventory);
		
		// Attempt to add item past the inventory capacity.
		paladinGuy.pickupItem(Item.Potion);
		
		// Make space to in inventory. 
		paladinGuy.dropItem(Item.Sword);
		System.out.println(paladinGuy.inventory);
		
		// Add new item.
		paladinGuy.pickupItem(Item.Potion);
		System.out.println(paladinGuy.inventory);
		
		
	}

}
