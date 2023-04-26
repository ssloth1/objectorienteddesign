/**
 * Driver for demonstrating good use of open closed principal.
 * @author James Bebarski
 */
public class InterfaceSegregation {
	/**
	 * The main method.
	 * @param args - main args
	 */
	public static void main(String[] args) {
		
		// Driver Code from Single Responsibility Example:
		/*
		Player player = new Player("Jim", 100);
		
		player.getInventory().addItem(Item.SWORD);
		player.getInventory().addItem(Item.POTION);
		player.getInventory().addItem(Item.BOW);
		player.getInventory().addItem(Item.POTION);
		player.getInventory().addItem(Item.SPELLBOOK);
		
		
		System.out.println(player);
		player.getName().setTitle(Title.COUNT);
		player.getInventory().removeItem(Item.BOW);
		
		System.out.println("I got a cool new title:");
		System.out.println(player);
		
		System.out.println("# of items in inventory: " + player.getInventory().countItems());
		System.out.println("# of potions in inventory: " + player.getInventory().countByItem(item -> item == Item.POTION));
		
		player.getHealth().takeDamage(75);
		player.getHealth().takeHeals(50);
		
		System.out.print("Took some damage and heals: \n");
		System.out.println(player);
		*/
		
		// Code from Open/Closed Principle and Liskov Substitution Principle
		/*
		Undead vampire = new Undead("Dracula", 100);
		vampire.getInventory().addItem(Item.SPELLBOOK);
		vampire.getInventory().addItem(Item.POTION);
		vampire.getName().setTitle(Title.COUNT);
		System.out.println(vampire);
		*/
		
		//Interface Segregation Example Code:
		
		Player jon = new Player("Jon", 100);
		Player don = new Player("Don", 100);
		Undead rob = new Undead("Rob Zombie", 100);
		
		jon.getInventory().addItem(Item.SPELLBOOK);
		don.getInventory().addItem(Item.POTION);
		
		// Rob Zombie beats up Jon.
		rob.punch(jon.getHealth());
		rob.punch(jon.getHealth());
		rob.punch(jon.getHealth());
		rob.punch(jon.getHealth());
		rob.punch(jon.getHealth());
		rob.punch(jon.getHealth());
		rob.punch(jon.getHealth());
		rob.punch(jon.getHealth());
		rob.punch(jon.getHealth());
		
		// Rob Zombie bats up Don. 
		rob.punch(don.getHealth());
		rob.punch(don.getHealth());
		rob.punch(don.getHealth());
		rob.punch(don.getHealth());
		
		// Our Players aren't feeling too good.
		System.out.println(jon);
		System.out.println(don);
		
		// Don uses on of his potions on don, and tries to use one on himself.
		don.heal(jon.getHealth());
		don.selfHeal();
		
		// Jon heals up Don and then replenishes himself using his spellbook.
		// Spellbooks have unlimted uses.
		// Potions are single use.
		jon.heal(don.getHealth());
		jon.heal(don.getHealth());
		jon.selfHeal();
		jon.selfHeal();
		
		// Our Players should feel better.
		System.out.println(jon);
	    System.out.println(don);
	    
	    // Jon uses his healing spell from the spellbook to drain the zombies health.
	    // Healing spells actuall damage the health of a Undead. 
	    
	    jon.heal(rob.getHealth());
	    jon.heal(rob.getHealth());
	    jon.heal(rob.getHealth());
	    jon.heal(rob.getHealth());
	    jon.heal(rob.getHealth());
	    
	    // Rob doesn't feel too good.
	    System.out.println(rob);
	
	}

}
