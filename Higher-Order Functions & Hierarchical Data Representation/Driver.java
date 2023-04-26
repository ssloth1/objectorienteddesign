/*
 * James Bebarski
 * Driver.java
 * Concept 4 + 5
 */

import java.util.List;

/**
 * Driver for demonstrating our Syndicate hierarchy and associated methods.
 * @author James Bebarski
 */
public class Driver {
	
	/**
	 * The main method for the Driver class. 
	 * @param args - the main arguments
	 */
	public static void main(String[] args) {
		
		// Create the Syndicate object, using Vito Corleone as our godfather.
		SyndicateImpl syndicate = new SyndicateImpl("Vito Corleone", Neighborhood.Manhattan);
		
		// Create capos
		Capo capo1 = new Capo("Peter Clemenza", Neighborhood.Brooklyn);
		Capo capo2 = new Capo("Salvatore Tessio", Neighborhood.Manhattan);
		Capo capo3 = new Capo("Frank Pentangeli", Neighborhood.Bronx);

		// Create soldiers
		Soldier soldier1 = new Soldier("Luca Brasi", Neighborhood.Brooklyn);
		Soldier soldier2 = new Soldier("Rocco Lampone", Neighborhood.Brooklyn);
		Soldier soldier3 = new Soldier("Al Neri", Neighborhood.Brooklyn);
		Soldier soldier4 = new Soldier("Tony Rosato", Neighborhood.Bronx);
		Soldier soldier5 = new Soldier("Joey Zasa", Neighborhood.Bronx);
		Soldier soldier6 = new Soldier("Moe Greene", Neighborhood.Manhattan);
		Soldier soldier7 = new Soldier("Willie Cicci", Neighborhood.Manhattan);
		Soldier soldier8 = new Soldier("Eddie Paradise", Neighborhood.Vegas);
		Soldier soldier9 = new Soldier("Nick Geraci", Neighborhood.Vegas);

		// Create associates
		Associate associate1 = new Associate("Bobby Corcoran", Neighborhood.Manhattan);
		Associate associate2 = new Associate("Johnny Fontane", Neighborhood.Brooklyn);
		Associate associate3 = new Associate("Aldo Trapani", Neighborhood.Bronx);
		Associate associate4 = new Associate("Federico 'Fredo' Corleone", Neighborhood.Manhattan);
		Associate associate5 = new Associate("Salvatore 'Sally' Tessio", Neighborhood.Bronx);
		Associate associate6 = new Associate("Carlo Rizzi", Neighborhood.Bronx);
		Associate associate7 = new Associate("Michael Corleone", Neighborhood.Manhattan);
		Associate associate8 = new Associate("Tom Hagen", Neighborhood.Manhattan);
		Associate associate9 = new Associate("Rocco Lampone Jr.", Neighborhood.Manhattan);
		Associate associate10 = new Associate("Don Altobello", Neighborhood.Vegas);
		Associate associate11 = new Associate("Anthony Stracci", Neighborhood.Vegas);
		Associate associate12 = new Associate("Lenny Montana", Neighborhood.Brooklyn);
		Associate associate13 = new Associate("Frankie Pentangeli", Neighborhood.Bronx);
		Associate associate14 = new Associate("Joey Zasa Jr.", Neighborhood.Bronx);
		Associate associate15 = new Associate("Billy Corcoran", Neighborhood.Brooklyn);
		Associate associate16 = new Associate("Vincent Mancini", Neighborhood.Manhattan);
		
		
		// Add our capos to the syndicate, with the godfather (root) as their parent (boss).
		syndicate.addMember(capo1, "Vito Corleone");
		syndicate.addMember(capo2, "Vito Corleone");
		syndicate.addMember(capo3, "Vito Corleone");
		
		// Add our soldiers to the syndicate, with various capos as their parents (bosses).
		syndicate.addMember(soldier1, "Peter Clemenza");
		syndicate.addMember(soldier2, "Peter Clemenza");
		syndicate.addMember(soldier3, "Peter Clemenza");
		syndicate.addMember(soldier4, "Salvatore Tessio");
		syndicate.addMember(soldier5, "Salvatore Tessio");
		syndicate.addMember(soldier6, "Salvatore Tessio");
		syndicate.addMember(soldier7, "Frank Pentangeli");
		syndicate.addMember(soldier8, "Frank Pentangeli");
		syndicate.addMember(soldier9, "Frank Pentangeli");
		
		// Add our associates to the syndicate, with various soldiers as their parents (bosses).
		syndicate.addMember(associate1, "Luca Brasi");
		syndicate.addMember(associate2, "Luca Brasi");
		syndicate.addMember(associate3, "Luca Brasi");
		syndicate.addMember(associate4, "Rocco Lampone");
		syndicate.addMember(associate5, "Rocco Lampone");
		syndicate.addMember(associate6, "Al Neri");
		syndicate.addMember(associate7, "Tony Rosato");
		syndicate.addMember(associate8, "Tony Rosato");
		syndicate.addMember(associate9, "Joey Zasa");
		syndicate.addMember(associate10, "Joey Zasa");
		syndicate.addMember(associate11, "Moe Greene");
		syndicate.addMember(associate12, "Moe Greene");
		syndicate.addMember(associate13, "Willie Cicci");
		syndicate.addMember(associate14, "Willie Cicci");
		syndicate.addMember(associate15, "Eddie Paradise");
		syndicate.addMember(associate16, "Nick Geraci");
		
		//System.out.println(syndicate.allMembers());
		syndicate.printMembers();
		
		System.out.println("\n");
		
		// Demonstrate getSize:
		System.out.println("Syndicate Size: " + syndicate.getSize());
		
		// Demonstrate getSizeByNeighborhood:
		System.out.println("Number of Members in Vegas: " + syndicate.getSizeByNeighborhood(Neighborhood.Vegas));
		System.out.println("Number of Members in Manhatten: " + syndicate.getSizeByNeighborhood(Neighborhood.Manhattan));
		
		// Demonstrates syndicates monthly financial obligations
		System.out.println("Monthly payouts: $" + syndicate.getTotalFinancialObligations());
		
		// Demonstrates cutAbove()
		System.out.println("Members with cut above $49,999 a month: " + syndicate.cutAbove(49999));
		
		// Demonstrates a method that uses Map/Filter/Reduce
		System.out.println("Members with cut above $49,999 a month and in Manhattan: " + syndicate.countMembersByCutAndNeighborhood(49999, Neighborhood.Manhattan));
		
		// Demonstrate getMembersByCondition - members who are Soldier's and based in Manhattan:
		List<Member> searchByPredicate = syndicate.getMembersByCondition(member -> member.getClass() == Soldier.class && member.getNeighborhood() == Neighborhood.Manhattan);
		System.out.println("List of Soldiers In Manhatten:" + searchByPredicate);
		
		// Demonstrate getMembersByCondition - members with whose name's contain "Corleone": 
		List<Member> corleoneFamily = syndicate.getMembersByCondition(member -> member.getName().contains("Corleone"));
		System.out.println("Corleone Family Members in Syndicate: " + corleoneFamily);
		
		// Demonstrate getSize - with given condition:
		System.out.println("Number of Member with the name Corleone: " + syndicate.getSize(member -> member.getName().contains("Corleone")));
	}
}
