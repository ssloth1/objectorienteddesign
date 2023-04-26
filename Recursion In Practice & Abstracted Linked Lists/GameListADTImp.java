/**
 * James Bebarski
 * CS5004 Final
 * 1) Recursion in Practice
 * 3) Abstracted Linked Lists
 * GameListADTImp.java
 */

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.function.Predicate;

/** 
 * Class that implements the GameListADT interface.
 * @author James Bebarski
 */
public class GameListADTImp implements GameListADT {
	
	private GameNodeADT head; 
	
	/**
	 * Initializes a Game List as an EmptyNode, new nodes with data are added later.
	 */
	public GameListADTImp() {
		head = new EmptyNodeADT();
	}
	
	/**
	 * Returns the head of the GameListADT. Essentially this returns the list.
	 * @return the head of the GameListADT.
	 */
	public GameNodeADT getHead() {
		return head;
	}
	
	@Override
	public int getSize() {
		return head.count();
	}
	
	@Override
	public void addFront(Game g) {
		head = head.addFront(g);
	}

	@Override
	public void addBack(Game g) {
		head = head.addBack(g);
	}

	@Override
	public void add(int index, Game g) {
	    head = head.add(index, g);
	}
	
	@Override
	public void remove(Game g) {
		head = head.remove(g);
	}
	
	@Override
	public GameListADTImp connect(GameListADTImp other) {
		GameListADTImp mergedList = new GameListADTImp();
		mergedList.head = this.head.connectNode(other.head);
		return mergedList;
	}
	
	@Override
	public double getTotalPrice() {
	    double totalPrice = head.getNodePrice();
	    DecimalFormat price = new DecimalFormat("#.##");
	    price.setRoundingMode(RoundingMode.HALF_EVEN);
	    return Double.parseDouble(price.format(totalPrice));
	}
	
	@Override
	public GameListADTImp getRemasters() {
		GameListADTImp newList = new GameListADTImp();
		newList.head = this.head.getNode(g->(g.isRemaster()));
		return newList;
	}
	@Override
	public GameListADTImp getList(Predicate<Game> predicate) {
		GameListADTImp newList = new GameListADTImp();
		newList.head = this.head.getNode(predicate);
		return newList;
	}
	
	@Override
	public void discount(double percentage) {
		head.discountNode(percentage);
		
	}
	
	@Override
	public String toString() {
		return head.toString();
	}

}
