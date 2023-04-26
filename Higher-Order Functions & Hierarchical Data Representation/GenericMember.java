/*
 * James Bebarski
 * GenericMember.java
 * Concept 4 + 5
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Represents a generic member in a hierarchy.
 * This abstract class implements the Member interface 
 * and provides basic functionality and data storage for organization members.
 * @author James Bebarski
 */
public abstract class GenericMember implements Member {
	/** The given name of a Generic Member. */
	protected String name;
	/** The monthly income. */
	protected int income;
	/** The given neighborhood enum */
	protected Neighborhood neighborhood;
	
	/**
	 * Creates a new GenericMember with the given name, monthly income, and neighborhood.
	 * @param name - The name of the member.
	 * @param income - The percentage of the member's revenue share.
	 * @param neighborhood - The neighborhood the member is associated with. 
	 */
	public GenericMember(String name, int income, Neighborhood neighborhood) {
		this.name = name;
		this.income = income;
		this.neighborhood = neighborhood;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getIncome() {
		return this.income;
	}
	
	@Override
	public Neighborhood getNeighborhood() {
		return this.neighborhood;
	}
	
	@Override
	public int count() {
		return 1;
	}
	
	@Override
	public int count(Predicate<Member> condition) {
		if (condition.test(this)) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public List<Member> toList() {
		List<Member> result = new ArrayList<Member>();
		result.add(this);
		return result;
	}
	
	@Override
	public List<Member> toList(Predicate<Member> predicate) {
		List<Member> result = new ArrayList<Member>();
		if (predicate.test(this))result.add(this);
		return result;
	}
	
	@Override 
	public String toString() {
		return "Name: " + name + ", Monthly Cut: " + income + ", Neighborhood: " + neighborhood;
	}

}
