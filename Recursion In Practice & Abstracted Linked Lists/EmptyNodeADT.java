/**
 * James Bebarski
 * CS5004 Final
 * 1) Recursion in Practice
 * 3) Abstracted Linked Lists
 * EmployerNodeADT.java
 */


import java.util.function.Predicate;

/**
 * EmptyNodeADT class, represents a Empty Node in a linked list.
 * @author James Bebarski
 */
public class EmptyNodeADT implements GameNodeADT {

	@Override
	public int count() {
		return 0;
	}
	
	@Override
	public GameNodeADT addFront(Game game) { 
		return new NodeADT(game, this); }
	
	@Override
	public GameNodeADT addBack(Game game) {
		return addFront(game);
	}
	
	@Override
	public GameNodeADT add(int index, Game game) {
		if (index == 0) {
			return addFront(game);
		}
		throw new IllegalArgumentException("Invalid index provided.");
	}

	@Override
	public GameNodeADT remove(Game game) {
		return this;
	}
	
	
	@Override
	public double getNodePrice() {
	    return 0;
	}
	
	@Override
	public GameNodeADT getNode(Predicate<Game> predicate) {
	    return this;
	}
	
	@Override
	public GameNodeADT connectNode(GameNodeADT other) {
		return other;
	}
	
	@Override 
	public void discountNode(double percentage) {}
	
	@Override
	public String toString() {
		return "";
	}

}
