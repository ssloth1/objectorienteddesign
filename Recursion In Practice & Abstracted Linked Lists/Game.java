/**
 * James Bebarski
 * CS5004 Final
 * 1) Recursion in Practice
 * 3) Abstracted Linked Lists
 * Game.java
 */

/**
 * A game class that represents a game object.
 * @author James Bebarski
 */
public class Game {
	private String title;
	private String developer;
	private String genre;
	private int releaseYear;
	private Rating rating;
	private double currentPrice;
	private boolean isRemaster;
	
	/**
	 * A constructor for a game class that has a title, developer, genre, releaseYear, rating, currentPrice, isRemaster. 
	 * This contructs a game object.
	 * @param title - the title of the game.
	 * @param developer - the developer of the game.
	 * @param genre - the genre of the game.
	 * @param releaseYear - the release year of the game.
	 * @param rating - the rating of the game.
	 * @param currentPrice - the current price of the game.
	 * @param isRemaster - returns true if game is a remaster, else false.
	 */
	public Game(String title, String developer, String genre, int releaseYear, Rating rating, double currentPrice, boolean isRemaster) {
	
		this.title = title;
		this.developer = developer;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.rating = rating;
		this.currentPrice = currentPrice;
		this.isRemaster = isRemaster;
	}

	/**
	 * Get the game object's title.
	 * @return the game object's title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the game object's title.
	 * @param title - the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the game object's developer.
	 * @return the game object's developer
	 */
	public String getDeveloper() {
		return developer;
	}

	/**
	 * Sets the game objects developer.
	 * @param developer - the developer to set
	 */
	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	/**
	 * Gets the game object's genre.
	 * @return the game object's genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Sets the game object's genre.
	 * @param genre - the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Get's the game object's release year.
	 * @return the game object's releaseYear
	 */
	public int getReleaseYear() {
		return releaseYear;
	}

	/**
	 * Set's the game object's release year.
	 * @param releaseYear - the releaseYear to set
	 */
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	/**
	 * Get's the game object's rating.
	 * @return the game object's rating
	 */
	public Rating getRating() {
		return rating;
	}

	/**
	 * Set's the game object's rating.
	 * @param rating - the rating to set
	 */
	public void setRating(Rating rating) {
		this.rating = rating;
	}

	/**
	 * Get's the object's currentPrice.
	 * @return the currentPrice
	 */
	public double getCurrentPrice() {
		return currentPrice;
	}

	/**
	 * Set's the object's currentPrice.
	 * @param currentPrice - the currentPrice to set
	 */
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	/**
	 * Returns if the game object is a remaster or not.
	 * @return True of the game object is a isRemaster
	 */
	public boolean isRemaster() {
		return isRemaster;
	}

	/**
	 * Set's the objects remaster status.
	 * @param isRemaster the isRemaster to set
	 */
	public void setRemaster(boolean isRemaster) {
		this.isRemaster = isRemaster;
	}
	
	/**
	 * Creates a remastered version of the game with updated information and sets the isRemaster flag to true.
	 * @param newDeveloper - the developer in charge of the remaster
	 * @param newReleaseYear - the new release year
	 * @param newCurrentPrice - the new current price
	 * @return the remastered Game object
	 */
	public Game remaster(String newDeveloper, int newReleaseYear, double newCurrentPrice) {
		return new Game(this.title, newDeveloper, this.genre, newReleaseYear, this.rating, newCurrentPrice, true);
		
	}
	
	/**
	 * Returns the value of current price reduced by a specified percentage
	 * and rounds the result to the nearest 100th decimal place.
	 * @param percentage - the discount percentage to apply to the current price.
	 * @return the discounted price.
	 */
	public double getDiscountedPrice(double percentage) {
		double discountAmount = this.currentPrice * (percentage / 100.0);
		currentPrice -= discountAmount;
		return currentPrice = Math.round(this.currentPrice * 100.0)/100.0;
	}
	
	/**
	 * Sets the current price of the game to a discounted price by a specified percentage.
	 * @param percentage - the discount percentage to apply to the current price.
	 */
	public void setDiscountedPrice(double percentage) {
	    double newPrice = getDiscountedPrice(percentage);
	    setCurrentPrice(newPrice);
	}
	
	/**
	 * Calculates the age difference between this game and another game in years. 
	 * @param otherGame - the other game to calculate the age difference with.
	 * @return the absolute value of the age difference in years.
	 */
	public int ageDifference(Game otherGame) {
		return Math.abs(this.releaseYear - otherGame.releaseYear);
	}
	
	/**
	 * Compares this game's release year against a given release year.
	 * Returns True if this game is younger than the given year, or False otherwise.
	 * @param year - the given year
	 * @return True if this game is younger than the given year, or False otherwise.
	 */
	public boolean isOlderThan(int year) {
		return this.releaseYear < year;
	}
	
	/**
	 * Compares this games price against another game objects price. 
	 * @param game - a game object
	 * @return True if this game is cheaper than the given game object, false otherwise.
	 */
	public boolean cheaperThan(Game game) {
		return this.currentPrice < game.getCurrentPrice();
	}
	
	/**
	 * Checks if a given string is contained in this games developer field. 
	 * @param developer - the given game developer as a String.
	 * @return True if the given String is contained in this game object, otherwise False.
	 */
	public boolean containsDev(String developer) {
		return this.developer.contains(developer);
	}
	
	
	/**
	 * Returns a string representation of a Game object.
	 * @return a string representation of a Game object and it's fields. 
	 */
	@Override
	public String toString() {
	    String remasterString = isRemaster ? "Yes" : "No";
		return "Title: " + title + "\n" +
	    	   "Developer: " + developer + "\n" +
	    	   "Genre: " + genre + "\n" +
	           "Release Year: " + releaseYear + "\n" + 
	           "Rating: " + rating + "\n" + 
	           "Current Price: $" + currentPrice + "\n" +
	           "Remaster: " + remasterString + "\n";
	}

}
