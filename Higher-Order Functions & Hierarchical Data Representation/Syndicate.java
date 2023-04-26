/*
 * James Bebarski
 * Syndicate.java
 * Concept 4 + 5
 */

import java.util.List;
import java.util.function.Predicate;

/**
 * The syndicate interface represents a "legitimate business" syndicate organization. 
 * It provides methods to manage the hierarchy and get's information about the organization.
 * @author James Bebarski
 */
public interface Syndicate {
	
	/**
	 * Adds a member to the organization under a specified boss. 
	 * @param member - the new member to be added tot he organization.
	 * @param bossName - the name of the boss the new member will report to.
	 */
	void addMember(Member member, String bossName);
	
	/**
	 * Returns the total number of members in the organization.
	 * @return the size of the organization.
	 */
	int getSize();
	
	
	/**
	 * Returns the total number of members in the syndicate that satisfy the given predicate.
	 * @param predicate - the given predicate.
	 * @return The total number of members that meet the given predicate conditions.
	 */
	public int getSize(Predicate<Member> predicate);
		
	/**
	 * Returns the total number of members in the organization from a specific neighborhood.
	 * @param neighborhood - the neighborhood to filter members by.
	 * @return the count of members from the specified neighborhood.
	 */
	int getSizeByNeighborhood(Neighborhood neighborhood);
	
	/**
	 * Returns a list of names of all the members in the organization. 
	 * @return a list of member names.
	 */
	List<String> allMembers();
	
	/**
	 * Returns the monthly financial obligations of the syndicate.
	 * @return the monthly financial obligations of the syndicate.
	 */
	int getTotalFinancialObligations();
	
	/**
	 * Returns the number of members with a monthly cut above the specified value.
	 * @param cut - the monthly value to compare against.
	 * @return the count of members with a cut above the specified value.
	 */
	int cutAbove(int cut);
	

	/**
	 * Counts the number of members in the syndicate with a monthly cut above the given amount
	 * and in some specified neighborhood of operation.
	 * @param cut - the minimum monthly cut value to filter member by.
	 * @param neighborhood - the neighborhood to filter members by.
	 * @return the number of members with a monthly cut above the specified value and in a specific neighborhood.
	 */
	int countMembersByCutAndNeighborhood(int cut, Neighborhood neighborhood);
	
	/**
	 * Returns a list of members in the syndicate that meet a specified condition.
	 * @param condition - the given condition.
	 * @return a list of members in the syndicate that meet a certain condition.
	 */
	List<Member> getMembersByCondition(Predicate<Member> condition);
	
	/**
	 * Prints the members of the organization, using indentations to help denote the hierarchy.
	 */
	public void printMembers();
	
}
