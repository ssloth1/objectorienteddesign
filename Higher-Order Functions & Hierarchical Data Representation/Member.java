/*
 * James Bebarski
 * Member.java
 * Concept 4 + 5
 */

import java.util.List;
import java.util.function.Predicate;

/**
 * The Member interface represents a member of the syndicate organization.
 * It provides behavior's to manage the hierarchy and get's information about members.
 * @author James Bebarski
 */
public interface Member {
	
	/**
	 * Returns the name of the member.
	 * @return the name of the member.
	 */
	String getName();
	
	/**
	 * Returns the monthly cut the member takes from the organization's profits.
	 * @return the monthly cut the member takes from the organzations's profits.
	 */
	int getIncome();
	
	/**
	 * Returns the neighborhood where the member is located. 
	 * @return the neighborhood where the member is located.
	 */
	Neighborhood getNeighborhood();
	
	/**
	 * Adds a subordinate member to this member's hierarchy. 
	 * @param boss - the name of member that will become the boss of the new subordinate.
	 * @param subordinate - the new subordinate member to be added to the hierarchy. 
	 * @return the number that was added to hierarchy. 
	 */
	Member addSubordinate(String boss, Member subordinate);
	
	/**
	 * Returns the total number of members in the member's hierarchy.
	 * @return the total number of members in the member's hierarchy. 
	 */
	int count(); 
	
	/**
	 * Returns the total number of members in the member's hierarchy that satisfy the given predicate.
	 * @param condition - the given predicate. 
	 * @return the total number of members that meet the given predicate conditions.
	 */
	int count(Predicate<Member> condition);
	
	/**
	 * Returns a list of all the members in the member's hierarchy. 
	 * @return a list of all the members in the member's hierarchy.
	 */
	List<Member> toList();
	
	/**
	 * Returns a list of all the members in the member's hierarchy the satisfy the given predicate.
	 * @param predicate - the given predicate.
	 * @return a list of all the members that meet the given predicate condtions.
	 */
	List<Member> toList(Predicate<Member> predicate);
	
	/**
	 * Prints the members of the member's hierarchy, using indentations to help denote our hierarchy.
	 */
	void printMembers();
}
