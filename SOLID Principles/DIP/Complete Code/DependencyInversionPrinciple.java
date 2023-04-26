/**
 * Driver for demonstrating good use of open closed principal.
 * @author James Bebarski
 */
public class DependencyInversionPrinciple {
	/**
	 * The main method.
	 * @param args - main args
	 */
	public static void main(String[] args) {
		

		
		//Dependency Inversion Code:
		
		Player jon = new Player("Jon", 100);
		Player don = new Player("Don", 100);
		Undead rob = new Undead("Rob Zombie", 100);
		
		jon.pickupItem(Item.SPELLBOOK);
		don.pickupItem(Item.POTION);
		
		// Rob Zombie beats up Jon.
		rob.punch(jon);
		rob.punch(jon);
		rob.punch(jon);
		rob.punch(jon);
		rob.punch(jon);
		rob.punch(jon);
		rob.punch(jon);
		rob.punch(jon);
		rob.punch(jon);
		
		// Rob Zombie bats up Don. 
		rob.punch(don);
		rob.punch(don);
		rob.punch(don);
		rob.punch(don);
		
		// Our Players aren't feeling too good.
		System.out.println(jon);
		System.out.println(don);
		
		// Don uses on of his potions on don, and tries to use one on himself.
		don.heal(jon);
		don.selfHeal();
		
		// Jon heals up Don and then replenishes himself using his spellbook.
		// Spellbooks have unlimted uses.
		// Potions are single use.
		jon.heal(don);
		jon.heal(don);
		jon.selfHeal();
		jon.selfHeal();
		
		// Our Players should feel better.
		System.out.println(jon);
	    System.out.println(don);
	    
	    // Jon uses his healing spell from the spellbook to drain the zombies health.
	    // Healing spells actually damage the health of a Undead. 
	    
	    jon.heal(rob);
	    jon.heal(rob);
	    jon.heal(rob);
	    jon.heal(rob);
	    jon.heal(rob);
	    
	    // Rob doesn't feel too good.
	    System.out.println(rob);
	
	}

}
