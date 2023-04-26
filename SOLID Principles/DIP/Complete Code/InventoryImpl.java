


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * The InventoryImpl class, represents an InventoryImpl object. An InventoryImpl object has a list of items.
 * @author James Bebarski
 */
public class InventoryImpl implements Inventory {
	
	private List<Item> items;
	
	/**
	 * InventoryImpl Constructor. 
	 * Created with an empty array for storing items.
	 */
	public InventoryImpl() {
		this.items = new ArrayList<>();
	}
	
	@Override
	public List<Item> getInventory() {
		return items;
	}

	@Override
	public void setInventory(List<Item> items) {
		this.items = items;
	}
	
	@Override
	public void addItem(Item item) {
		items.add(item);
	}
	
	@Override
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	@Override
	public int countItems() {
		return items.size();
	}
	
	@Override
	public int countByItem(Predicate<Item> predicate) {
		return (int) items.stream().filter(predicate).count();
	}
	
	@Override
	public boolean containsItem(Item item) {
		return items.contains(item);
	}
	
	@Override
	public String toString() {
		String result = "Inventory:\n";
		for (Item item : items) {
			result += "- " + item.toString() + "\n";
		}
		return result;
	}


}
