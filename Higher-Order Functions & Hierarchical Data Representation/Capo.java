/*
 * James Bebarski
 * Capo.java
 * Concept 4 + 5
 */
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a Capo object. 
 * A Capo can have Soldier objects as it's subordinates.
 * @author James Bebarski
 */
public class Capo extends GenericMember {
	
	/** Can have a list of soldiers as it's subordinates. */
	private List<Soldier> subordinates;
	
	/**
	 * Constructor for a Capo object.
	 * @param name - the given name for an Capo object.
	 * @param neighborhood - the given Neighborhood for an Capo object.
	 */
	public Capo(String name, Neighborhood neighborhood) {
		super(name, 100000, neighborhood);;
		setSubordinates(new LinkedList<>());
	}
	
	/**
	 * Getter method to get it's list of Soldier subordinates.
	 * @return the list of subordinates.
	 */
	public List<Soldier> getSubordinates() {
		return subordinates;
	}

	/**
	 * Setter to set the subordinates for a Capo object.
	 * @param subordinates - the list of soldier subordinates.
	 */
	public void setSubordinates(List<Soldier> subordinates) {
		this.subordinates = subordinates;
	}
	
	@Override
	public Member addSubordinate(String boss, Member subordinate) {
		if (!(subordinate instanceof Soldier)) {
			System.out.println(boss + "can only be assigned a associate.");
		}
		if (this.name.equals(boss)) {
			this.subordinates.add((Soldier) subordinate);
		}
		for (int i = 0; i < this.subordinates.size(); i++) {
		      this.subordinates.set(i,(Soldier) this.subordinates.get(i).addSubordinate(boss, subordinate));
		}
		return this;
	}

	@Override
	public void printMembers() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "CAPO - " + "Name: " + name + ", Monthly Cut: " + income + ", Neighborhood: " + neighborhood;
	}

}
