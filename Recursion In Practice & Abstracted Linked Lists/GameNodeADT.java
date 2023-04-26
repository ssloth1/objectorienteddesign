/**
 * James Bebarski
 * CS5004 Final
 * 1) Recursion in Practice
 * 3) Abstracted Linked Lists
 * GameListADTNode.java
 */

import java.util.function.Predicate;

/**
 * This interface represents all the operations for a node in a list of games. 
 * @author James Bebarski
 */
public interface GameNodeADT {
	
	/**
	 * Return the number of games in this list.
	 * @return the size of the list.
	 */
	int count();
	
	/**
	 * Adds a given game object to the front of this list and return a modified list.
	 * @param game - the game to be added to the list. 
	 * @return the head of the new list.
	 */
	GameNodeADT addFront(Game game);
	
	/**
	 * Add the given game to the back of the list, and return the modified list.
	 * @param game - the game to be added
	 * @return the head of the new list.
	 */
	GameNodeADT addBack(Game game);
	
	/**
	 * Adds a given game at the given index in the list
	 * if the given node is 0, it adds the game object to the front of the list.
	 * @param index - the position that will by occupied by this game, starting at 0.
	 * @param game - the game to be added.
	 * @return the head of the resulting list
	 * @throws IllegalArgumentException if an invalid index is passed.
	 */
	GameNodeADT add(int index, Game game);
	
	/**
	 * Remove the first instance of the given game object from the list.
	 * @param game - the game object to be removed.
	 * @return the head of the resulting list after the game is removed.
	 */
	GameNodeADT remove(Game game);
	
    /**
     * Connects the given GameListADTNode to the end of this list.
     * @param other - the list to be connected to the end of this list
     * @return the head of the resulting list
     */
	GameNodeADT connectNode(GameNodeADT other);
	
    /**
     * Gets a new node containing game objects that match the given predicate.
     * @param predicate - the condition to filter
     * @return a new node containing a game object that match the given predicate
     */
	GameNodeADT getNode(Predicate<Game> predicate);

    /**
	 * Calculate the total price of all the games in the list.
	 * @return the total price of all games.
	 */
	double getNodePrice();
	
	/**
	 * Applies a discount to a given game object in a list.
	 * @param percentage - the discount percentage to apply.
	 */
	void discountNode(double percentage);

}
