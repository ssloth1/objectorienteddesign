/**
 * James Bebarski
 * CS5004 Final
 * 1) Recursion in Practice
 * 3) Abstracted Linked Lists
 * GameListADT.java
 */

import java.util.function.Predicate;

/** 
 * Interface that defines methods that a GameListADT should implement.
 * @author James Bebarski
 */
public interface GameListADT {
	  
	/**
	   * Add a game to the front of this list
	   * @param game - the game to be added to the front of this list
	   */
	  void addFront(Game game);

	  /**
	   * Add a game to the back of this list 
	   * @param game - the game to be added to the back of this list
	   */
	  void addBack(Game game);

	  /**
	   * Add a game to this list so that it occupies the provided index.
	   * @param index - the index to be occupied by this game, beginning at 0
	   * @param game the game to be added to the list
	   */
	  void add(int index, Game game);

	  /**
	   * Return the number of game currently in this list
	   * @return the size of the list
	   */
	  int getSize();

	  /**
	   * Remove the first instance of this game from this list
	   * @param game - the game to be removed
	   */
	  void remove(Game game);
	  
	  /**
	   * Connects the given GameListImp to the end of this list.
	   * @param other - the list to be connected to the end of this list
	   * @return the head of the resulting list.
	   */
	  GameListADTImp connect(GameListADTImp other);
	  
	  /**
	   * Returns a new list of game objects that match a given predicate condition.
	   * @param predicate - the given predicate condition.
	   * @return a new list of nodes with game objects that meet the predicate conditions.
	   */
	  GameListADTImp getList(Predicate<Game> predicate);
	  
	  /**
	   * Get the total price of all games in the list.
	   * @return the total price of all games.
	   */
	  double getTotalPrice();
	  
	  /**
	   * Apply a discount to all games in the list by the given percentage.
	   * @param percentage - the discount percentage to apply.
	   */
	  void discount(double percentage);
	  
	  /**
	   * Returns a new list of game objects that are remastered.
	   * @return a new list of nodes with game objects that are remastered.
	   */
	  GameListADTImp getRemasters();
	     
}
