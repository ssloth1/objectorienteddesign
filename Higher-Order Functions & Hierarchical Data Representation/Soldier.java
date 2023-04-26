/*
 * James Bebarski
 * Soldier.java
 * Concept 4 + 5
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a Soldier object, extends GenericMember.
 * A soldier has Associates as their subordinates.
 * @author James Bebarski
 */
public class Soldier extends GenericMember{
	
	/** The list of Associate subordinates.*/
	private List<Associate> subordinates;
	
	/**
	 * The constructor for a Soldier object.
	 * @param name - the given name for the Soldier.
	 * @param neighborhood - the givne neighborhood for the soldier.
	 */
	public Soldier(String name, Neighborhood neighborhood) {
		super(name, 50000, neighborhood);
		setSubordinates(new LinkedList<>());
	}
	
	/**
	 * Get's a list of Associate subordinates. 
	 * @return a list of Associate subordinates.
	 */
	public List<Associate> getSubordinates() {
		return subordinates;
	}
	
	/**
	 * Set's the list of Associate subordinates.
	 * @param subordinates a list of Associate subordinates.
	 */
	public void setSubordinates(List<Associate> subordinates) {
		this.subordinates = subordinates;
	}

	@Override
	public Member addSubordinate(String boss, Member subordinate) {
		if (!(subordinate instanceof Associate)) {
			System.out.println(boss + "can only be assigned a associate.");
		}
		if (this.name.equals(boss)) {
			this.subordinates.add((Associate) subordinate);
		}
		for (int i = 0; i < this.subordinates.size(); i++) {
		      this.subordinates.set(i,(Associate) this.subordinates.get(i).addSubordinate(boss, subordinate));
		}
		return this;
	}

	@Override
	public void printMembers() {
		System.out.println(this);	
	}

	@Override
	public String toString() {
		return "SOLDIER - " + "Name: " + name + ", Monthly Cut: " + income + ", Neighborhood: " + neighborhood;
	}

}

