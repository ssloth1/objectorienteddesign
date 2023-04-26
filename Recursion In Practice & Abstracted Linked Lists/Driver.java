/**
 * Main Driver for testing the GameListADT.
 * @author James Bebarski
 * 
 * Topics Covered:
 * 
 * 1) Recursion in Practice
 * - Any function that can be recursive, IS recursive for this portion of the final.
 * - I felt that combining this section with the Abstracted Linked List section, 
 * - would provide the perfect playground for demonstrating recursion in practice. 
 * -  
 *
 * 3) Abstracted Linked Lists
 * - Much of the code is similar to the Module 4.1 - 4.10 lessons.
 * - In fact, I used the same interfaces provided throughout the examples as a starting point. 
 * - However, I made numerous alterations and quite a few of my own additions. 
 * - I decided to use the Game class for this example, and there are some fields that are used in examples more than other.
 * 
 * 
 * As you will see though, every function that can be recursive is recursive. 
 * I also implemented much more functionality compared to the example given in Module 4.
 */
public class Driver {

	/**
	 * The main method.
	 * @param args - main args
	 */
	public static void main(String[] args) {
		
		
        GameListADTImp haloFranchise = new GameListADTImp();
        
        haloFranchise.addFront(new Game("Halo: Combat Evolved", "Bungie", "First-Person Shooter", 2001, Rating.M, 10.00, true));
        haloFranchise.addFront(new Game("Halo 2", "Bungie", "First-Person Shooter", 2004, Rating.M, 9.99, true));
        haloFranchise.addFront(new Game("Halo 3", "Bungie", "First-Person Shooter", 2007, Rating.M, 19.99, false));
        haloFranchise.addFront(new Game("Halo Wars", "Ensemble Studios", "Real-Time Strategy", 2009, Rating.T, 19.99, false));
        haloFranchise.addFront(new Game("Halo 3: ODST", "Bungie", "First-Person Shooter", 2009, Rating.M, 19.99, false));
        haloFranchise.addFront(new Game("Halo: Reach", "Bungie", "First-Person Shooter", 2010, Rating.M, 29.99, false));
        haloFranchise.addFront(new Game("Halo: Combat Evolved Anniversary", "343 Industries", "First-Person Shooter", 2011, Rating.M, 39.99, true));
        haloFranchise.addFront(new Game("Halo 4", "343 Industries", "First-Person Shooter", 2012, Rating.M, 29.99, false));
        haloFranchise.addFront(new Game("Halo: The Master Chief Collection", "343 Industries", "First-Person Shooter", 2014, Rating.M, 39.99, true));
        haloFranchise.addFront(new Game("Halo 5: Guardians", "343 Industries", "First-Person Shooter", 2015, Rating.T, 19.99, false));
        
        
        // Uncomment the sections you want to see:
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        
        // Task 1:
        // Successfully build and print the Game Franchise of your choice, as Represented by our LinkedList. 
        
        System.out.println(haloFranchise);
        
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Task 2:
        // Implement a method called getList that accepts a given predicate, and returns a list that meets the give predicate condition.
        // Demonstrate that this method works correctly.
        
        /*
        GameListADTImp classics = haloFranchise.getList(g->g.isOlderThan(2008));
        System.out.println(classics);
        */
        
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        
        // Task 3: 
        // Implement a method called discount, this method should allow you to pass a percentage on a game collection list.
        // This percentage based discount will be applied to each game object in the list.
        // In the below code we want to set a discount on all Remasters in the Halo Franchise.
        //Show that the discount method successfully discounted your list using getTotalPrice.
        
        /*
        GameListADTImp saleList = haloFranchise.getList(g->g.isRemaster());
        System.out.println("Cost of Remastered Collection Pre-Discount: $" + saleList.getTotalPrice() + "\n");
        saleList.discount(25.0);
        System.out.println(saleList);
        System.out.println("Cost of Remastered Collection Post-Discount: $" + saleList.getTotalPrice());
        */
        
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        
        //Task 5: 
        // Demonstrate the connect method works correctly.
        // We are just connecting the original list to itself. So the size should be doubled.
        
        /*
        System.out.println("Size before connect: " + haloFranchise.getSize());
        GameListADTImp connected = haloFranchise.connect(haloFranchise);
        System.out.println("Size after connect: " + connected.getSize());
        System.out.println(connected);
        */
		
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        
        // Task 6: 
        // Demonstrate that our addBack, remove, and add operations actually work. 
	
        /*
        GameListADTImp nintendo = new GameListADTImp();
		nintendo.addFront(new Game("Super Mario 64", "Nintendo", "Platformer", 1996, Rating.E, 40.00, false));
		nintendo.addFront(new Game("The Legend of Zelda: Ocarina of Time", "Nintendo", "Action-adventure", 1998, Rating.E, 45.00, true));
		nintendo.addBack(new Game("Pokemon Red Version", "Nintendo", "Role-playing", 1998, Rating.E, 30.00, false));
		nintendo.add(nintendo.getSize() - 1, new Game("Metroid Prime", "Nintendo", "First-person shooter", 2002, Rating.T, 50.00, false));
		System.out.println(nintendo);
		*/
		
		/*
		Steps:
		1) [null]
		2) [Mario64] - > [null]
		3) [Zelda] - > [Mario64] - > [null]
		4) [Zelda] - > [Mario64] - > [Pokemon] -> [null]
		5) [Zelda] - > [Pokemon] - > [null]
		6) [Metroid] - > [Zelda] - > [Pokemon] - > [null] 
		7) [Metroid] - > [Pokemon] - > [null]  
		
		*/

	}

}
