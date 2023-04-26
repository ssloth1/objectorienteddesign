/**
 * James Bebarski
 * CS5004 Final
 * 1) Recursion in Practice
 * 3) Abstracted Linked Lists
 * Rating.java
 */

/**
 * A Rating Enum for the video game class.
 * @author James Bebarski
 */
public enum Rating {
	/** Early Childhood rating*/
	EC("Early Childhood"),
	
	/** Everyone rating*/
	E("Everyone"), 
	
	/** Everyone Ten and Up rating*/
	E10("Everyone 10+"), 
	
	/** Teen rating */
	T("Teen"), 
	
	/** Mature Rating */
	M("Mature");

	private final String name;
	
	/**
	 * Constructs a new rating with the given name and value.
	 * @param name - the string representation of the rating.
	 * @param value - the numeric value of the rating.
	 */
	private Rating(String name) {
	    this.name = name;
	}

	/**
	 * Returns the string representation of the rating.
	 * @return the string representation of the rating.
	 */
	public String getName() {
	    return name;
	}

	/**
	 * Returns the string representation of the rating.
	 * @return the string representation of the rating.
	 */
	@Override
	public String toString() {
	    return name;
	}
}