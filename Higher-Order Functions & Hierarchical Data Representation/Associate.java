/*
 * James Bebarski
 * Associate.java
 * Concept 4 + 5
 */

/**
 * Represents an Associate in a syndicate.
 * An Associate cannot have any children.
 * @author James Bebarski
 */
public class Associate extends GenericMember{
	
	/**
	 * Constructor for an Associate object.
	 * @param name - the given name for an Associate object.
	 * @param neighborhood - the given Neighborhood for an associate object.
	 */
	public Associate(String name, Neighborhood neighborhood) {
		super(name, 5000, neighborhood);
	}

	@Override
	public Member addSubordinate(String boss, Member subordinate) {
		if (this.name.equals(boss)) {
			Soldier newSoldier = new Soldier(this.name, this.neighborhood);
			newSoldier.addSubordinate(boss, subordinate);
			return newSoldier;
		}
		return this;
	}

	@Override
	public void printMembers() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "ASSOCIATE - " + "Name: " + name + ", Monthly Cut: " + income + ", Neighborhood: " + neighborhood;
	}

}
