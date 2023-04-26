import org.junit.Test;
import static org.junit.Assert.*;

/** Class contains unit tests for the Game class.*/
public class GameTest {
	/** Test game objects.*/
	Game game1 = new Game("Super Mario Bros.", "Nintendo", "Platformer", 1985, Rating.E, 29.99, false);
	Game game2 = new Game("The Legend of Zelda: Breath of the Wild", "Nintendo", "Action-Adventure", 2017, Rating.E10, 59.99, false);
	Game game3 = new Game("Minecraft", "Mojang", "Sandbox", 2011, Rating.E10, 25.00, false);
	
	/**
	 * Tests the remaster method of the Game class by verifying that the new Game object
	 * has the expected properties after being remastered.
	 */
	@Test
	public void testRemaster() {
		Game remasteredGame = game1.remaster("Nintendo", 2021, 69.99);
		
		assertEquals("Super Mario Bros.", remasteredGame.getTitle());
		assertEquals("Nintendo", remasteredGame.getDeveloper());
		assertEquals("Platformer", remasteredGame.getGenre());
		assertEquals(2021, remasteredGame.getReleaseYear());
		assertEquals(Rating.E, remasteredGame.getRating());
		assertEquals(69.99, remasteredGame.getCurrentPrice(), 0.01);
		assertTrue(remasteredGame.isRemaster());
	}
	
	/**
	 * Tests the getDiscountedPrice method of the Game class by verifying that the method returns the expected discount price.
	 */
	@Test
	public void testGetDiscountedPrice() {
		assertEquals(29.99, game1.getDiscountedPrice(0), 0.01);
		assertEquals(44.99, game2.getDiscountedPrice(25.0), 0.01);
		assertEquals(18.75, game3.getDiscountedPrice(25.0), 0.01);
	}
	
	/**
	 * Tests the setDiscountedPrice method of the Game class by verifying 
	 * that the current price of the game object is set to the expected discounted price.
	 */
	@Test
	public void testSetDiscountedPrice() {
		game1.setDiscountedPrice(10.0);
		assertEquals(26.99, game1.getCurrentPrice(), 0.01);
		
		game2.setDiscountedPrice(50.0);
		assertEquals(30.00, game2.getCurrentPrice(), 0.01);
		
		game3.setDiscountedPrice(75.0);
		assertEquals(6.25, game3.getCurrentPrice(), 0.01);
	}
	
	/**
	 * Tests the ageDifference method of the Game class by verifying 
	 * that the returned age difference between two games is the same as the expected.
	 */
	@Test
	public void testAgeDifference() {
		assertEquals(26, game1.ageDifference(game3));
		assertEquals(6, game2.ageDifference(game3));
		assertEquals(32, game2.ageDifference(game1));
	}
	
	/**
	 * Tests the isOlderThan method of the Game class by verifying
	 * that a given game object is or is not older than a given year.
	 */
	@Test
	public void testIsOlderThan() {
		assertTrue(game3.isOlderThan(2022));
		assertFalse(game2.isOlderThan(2015));
		assertTrue(game1.isOlderThan(1986));
	}
	
	/**
	 * Tests the cheaperThan method of the Game class by verifying 
	 * that a game object is or is not cheaper than a given game.
	 */
	@Test
	public void testCheaperThan() {
		assertTrue(game1.cheaperThan(game2));
		assertFalse(game1.cheaperThan(game3));
		assertFalse(game2.cheaperThan(game3));
	}
	
	/**
	 * Tests the containsDev method of the Game class by verifying 
	 * that a game object contains a given string.
	 */
	@Test
	public void testContainsDev() {
		assertTrue(game1.containsDev("Ninten"));
		assertTrue(game2.containsDev("intend"));
		assertTrue(game3.containsDev("Mojang"));
	}
	
}
