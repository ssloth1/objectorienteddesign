/*
 * James Bebarski
 * SyndicateImplTest.java
 * Concept 4 + 5
 */

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Test file for SyndicateImpl
 * @author James Bebarski
 */
public class SyndicateImplTest {
	
	private Syndicate syndicate;
	
	@Before
	public void setUp() {
		syndicate = new SyndicateImpl("Vito Corleone", Neighborhood.Manhattan);
	}
	
	@Test
	public void testAddMember() {
		// The godfather is the root node. 
		assertEquals(1, syndicate.getSize());
		
	    syndicate.addMember(new Capo("Peter Clemenza", Neighborhood.Brooklyn), "Vito Corleone");
	    syndicate.addMember(new Soldier("Luca Brasi", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Soldier("Rocco Lampone", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Soldier("Al Neri", Neighborhood.Brooklyn), "Peter Clemenza");

	    // Tests adding members to hierarchy.
	    syndicate.addMember(new Associate("Bobby Corcoran", Neighborhood.Manhattan), "Luca Brasi");
	    assertEquals(6, syndicate.getSize());

	    syndicate.addMember(new Associate("Aldo Trapani", Neighborhood.Bronx), "Luca Brasi");
	    assertEquals(7, syndicate.getSize());

	    syndicate.addMember(new Associate("Salvatore 'Sally' Tessio", Neighborhood.Bronx), "Luca Brasi");
	    assertEquals(8, syndicate.getSize());
	}
	
	@Test
	public void testGetSize() {
		// One member (The godfather)
	    assertEquals(1, syndicate.getSize());

	    // Add a capo (size 2)
	    syndicate.addMember(new Capo("Peter Clemenza", Neighborhood.Brooklyn), "Vito Corleone");
	    assertEquals(2, syndicate.getSize());

	    // Add soldiers (size 4)
	    syndicate.addMember(new Soldier("Luca Brasi", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Soldier("Rocco Lampone", Neighborhood.Brooklyn), "Peter Clemenza");
	    assertEquals(4, syndicate.getSize());
	    
	    // Add associate (size 5)
	    syndicate.addMember(new Associate("Bobby Corcoran", Neighborhood.Manhattan), "Luca Brasi");
	    assertEquals(5, syndicate.getSize());
	}
	
	@Test
	public void testGetSizeByNeighborhood() {
	    syndicate.addMember(new Capo("Peter Clemenza", Neighborhood.Brooklyn), "Vito Corleone");
	    syndicate.addMember(new Soldier("Luca Brasi", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Soldier("Rocco Lampone", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Soldier("Al Neri", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Associate("Bobby Corcoran", Neighborhood.Manhattan), "Vito Corleone");
	    
	    // Get's number of members in Brooklyn
	    assertEquals(4, syndicate.getSizeByNeighborhood(Neighborhood.Brooklyn));
	    // Gets number of members in Manhattan
	    assertEquals(2, syndicate.getSizeByNeighborhood(Neighborhood.Manhattan));
	}
	
	@Test
	public void testGetTotalFinancialObligations() {
	    syndicate.addMember(new Capo("Peter Clemenza", Neighborhood.Brooklyn), "Vito Corleone");
	    syndicate.addMember(new Soldier("Luca Brasi", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Soldier("Rocco Lampone", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Soldier("Al Neri", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Associate("Bobby Corcoran", Neighborhood.Manhattan), "Vito Corleone");
	    // Get's the total financial obligations to syndicate members.
	    assertEquals(1255000, syndicate.getTotalFinancialObligations());
	}
	
	@Test
	public void testCutAbove() {
	    syndicate.addMember(new Capo("Peter Clemenza", Neighborhood.Brooklyn), "Vito Corleone");
	    syndicate.addMember(new Soldier("Luca Brasi", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Soldier("Rocco Lampone", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Soldier("Al Neri", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Associate("Bobby Corcoran", Neighborhood.Manhattan), "Vito Corleone");
	    // Number of members who make above $50,000
	    assertEquals(2, syndicate.cutAbove(50000));
	    // Number of members who make above $0
	    assertEquals(6, syndicate.cutAbove(0));
	    // Number of members who make above -$10,000
	    assertEquals(6, syndicate.cutAbove(-10000));
	}
	
	@Test
	public void testCountMembersByCutAndNeighborhood() {
	    syndicate.addMember(new Capo("Peter Clemenza", Neighborhood.Brooklyn), "Vito Corleone");
	    syndicate.addMember(new Soldier("Luca Brasi", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Associate("Johnny Fontane", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Soldier("Rocco Lampone", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Soldier("Al Neri", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Associate("Federico 'Fredo' Corleone", Neighborhood.Manhattan), "Vito Corleone");
	    syndicate.addMember(new Associate("Bobby Corcoran", Neighborhood.Manhattan), "Luca Brasi");
	    
	    //Gets the number of members who make above $5000 and lives in Brooklyn.
	    assertEquals(4, syndicate.countMembersByCutAndNeighborhood(5000, Neighborhood.Brooklyn));
	    //Gets the number of members who make above $5000 and lives in Manhattan.
	    assertEquals(1, syndicate.countMembersByCutAndNeighborhood(5000, Neighborhood.Manhattan));
	    // Gets the number of members who make above $0 and lives in Bronx.
	    assertEquals(0, syndicate.countMembersByCutAndNeighborhood(0, Neighborhood.Bronx));
	}
	
	@Test
	public void testGetMembersByCondition() {
	    // Add members with different cuts and neighborhoods
	    syndicate.addMember(new Capo("Peter Clemenza", Neighborhood.Brooklyn), "Vito Corleone");
	    syndicate.addMember(new Soldier("Luca Brasi", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Associate("Johnny Fontane", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Soldier("Rocco Lampone", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Soldier("Al Neri", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Associate("Federico 'Fredo' Corleone", Neighborhood.Manhattan), "Vito Corleone");
	    syndicate.addMember(new Associate("Bobby Corcoran", Neighborhood.Manhattan), "Luca Brasi");

	    // Returns the size of members who's income are above 0.
	    List<Member> members = syndicate.getMembersByCondition(member -> member.getIncome() > 0);
	    assertEquals(8, members.size());
	    
	    // Returns the size of members whose income is above 10000.
	    members = syndicate.getMembersByCondition(member -> member.getIncome() > 10000);
	    assertEquals(5, members.size());
	    
	    // Returns the size of members who reside in Brooklyn.
	    members = syndicate.getMembersByCondition(member -> member.getNeighborhood() == Neighborhood.Brooklyn);
	    assertEquals(5, members.size());
	    
	    // Returns the size of members who reside in Bronx.
	    members = syndicate.getMembersByCondition(member -> member.getNeighborhood() == Neighborhood.Bronx);
	    assertEquals(0, members.size());
	}
	
	@Test
	public void testGetSizeByPredicate() {
	    
	    syndicate.addMember(new Capo("Peter Clemenza", Neighborhood.Brooklyn), "Vito Corleone");
	    syndicate.addMember(new Soldier("Luca Brasi", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Soldier("Rocco Lampone", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Associate("Johnny Fontane", Neighborhood.Brooklyn), "Peter Clemenza");
	    syndicate.addMember(new Associate("Federico 'Fredo' Corleone", Neighborhood.Manhattan), "Vito Corleone");

	    // Test with a predicate that matches all members
	    assertEquals(6, syndicate.getSize(m -> true));

	    // Test with a predicate that matches only associates
	    assertEquals(2, syndicate.getSize(m -> m instanceof Associate));

	    // Test with a predicate that matches only soldiers
	    assertEquals(2, syndicate.getSize(m -> m instanceof Soldier));

	    // Test with a predicate that matches only capos
	    assertEquals(1, syndicate.getSize(m -> m instanceof Capo));
	}

	

}
