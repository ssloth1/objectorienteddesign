/*
 * James Bebarski
 * Godfather.java
 * Concept 4 + 5
 */

import java.util.LinkedList;
import java.util.List;

/**
 * A class that represents a Godfather object, which is the head of a Syndicate.
 * Can have Capo's as their subordinates.
 * @author James Bebarski
 */
public class Godfather extends GenericMember {
	
	/** A list of Capo subordinates.*/
	private List<Capo> subordinates;
	
	/**
	 * Constructs a Godfather with the specified name, and neighborhood.
	 * @param name - the given name of the Godfather. 
	 * @param neighborhood - the given neighborhood of the Godfather.
	 */
	public Godfather(String name, Neighborhood neighborhood) {
		super(name, 1000000, neighborhood);
		setSubordinates(new LinkedList<>());
	}
	
	/**
	 * Get's a list of Capo subordinates.
	 * @return a list of capo subordinates. 
	 */
	public List<Capo> getSubordinates() {
		return subordinates;
	}
	
	/**
	 * Set's a list of Capo subordinates.
	 * @param subordinates - the given list of Capo subordinates.
	 */
	public void setSubordinates(List<Capo> subordinates) {
		this.subordinates = subordinates;
	}
	
	@Override
	public Member addSubordinate(String boss, Member subordinate) {
		if (!(subordinate instanceof Capo)) {
			System.out.println(boss + "can only be assigned a associate.");
		}
		if (this.name.equals(boss)) {
			this.subordinates.add((Capo) subordinate);
		}
		for (int i = 0; i < this.subordinates.size(); i++) {
		      this.subordinates.set(i,(Capo) this.subordinates.get(i).addSubordinate(boss, subordinate));
		}
		return this;
	}

	@Override
	public void printMembers() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "GODFATHER - " + "Name: " + name + ", Monthly Cut: " + income + ", Neighborhood: " + neighborhood;
	}

}
