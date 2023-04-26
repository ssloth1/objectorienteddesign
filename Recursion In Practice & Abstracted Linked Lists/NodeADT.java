/**
 * James Bebarski
 * CS5004 Final
 * 1) Recursion in Practice
 * 3) Abstracted Linked Lists
 * NodeADT.java
 */

import java.util.function.Predicate;

/**
 * NodeADT class, represents a Node in a linked list.
 * @author James Bebarski
 */
public class NodeADT implements GameNodeADT {
	
	private Game game; // The game object that is stored in the node.
	private GameNodeADT rest; // Reference to the next node.
	
	/**
	 * Constructs a node that contains a game object and a reference to the next node.
	 * @param game - a game object
	 * @param rest - reference to the rest of the linked list.
	 */
	public NodeADT(Game game, GameNodeADT rest) {
		this.game = game;
		this.rest = rest;
	}
	
	/**
	 * Getter for the game field.
	 * @return the game object stored in a node.
	 */
	public Game getGame() {
		return game;
	}
	
	/**
	 * Getter for the rest of a a linked list.
	 * @return the rest of a linked list.
	 */
	public GameNodeADT getRest() {
		return rest;
	}
	
	/**
	 * Setter for a game object in a linked list.
	 * @param game - a given game object.
	 */
	public void setGame(Game game) {
		this.game = game;
	}
	
	/**
	 * Setter for the rest of the linked list.
	 * @param rest - the rest of a linked list.
	 */
	public void setRest(GameNodeADT rest) {
		this.rest = rest;
	}
	
	@Override
	public int count() {
		return 1 + this.rest.count();
	}
	
	@Override
	public GameNodeADT addFront(Game game) {
		return new NodeADT(game, this);
	}
	
	@Override
	public GameNodeADT addBack(Game game) {
		this.rest = this.rest.addBack(game);
		return this;
	}
	
	@Override
	public GameNodeADT add(int index, Game game) {
		return (index == 0) ? addFront(game) : this.rest.add(index - 1, game);
	}
	
	@Override
	public GameNodeADT remove(Game game) {
	    if (this.game.equals(game)) {
	      return this.rest; 
	    } else {
	      this.rest = this.rest.remove(game);
	      return this; 
	    }
	  }
	
	@Override
	public GameNodeADT connectNode(GameNodeADT other) {
		GameNodeADT newRest = this.rest.connectNode(other);
		return new NodeADT(this.game, newRest);
	}
	
	@Override
	public GameNodeADT getNode(Predicate<Game> predicate) {
		if (predicate.test(this.game)) {
			return new NodeADT(this.game, this.rest.getNode(predicate));
		} else {
			return this.rest.getNode(predicate);
		}
	}
	
	@Override
	public double getNodePrice() {
	    return this.game.getCurrentPrice() + this.rest.getNodePrice();
	}
	
	@Override
	public void discountNode(double percentage) {
		this.game.setDiscountedPrice(percentage);
		this.rest.discountNode(percentage);
	}
	
	@Override
	public String toString() {
		return this.game.toString() + "\n"+ this.rest.toString();
	}
	
}
