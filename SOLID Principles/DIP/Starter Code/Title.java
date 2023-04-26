


/**
 * An enumeration of titles that can be used to address a person.
 * @author James Bebarski
 *
 */
public enum Title {
	/** Represents the lack of a title. */
	NONE(""),
	
	/** Represents the title "Sir". */
	Sir("Sir"),
	
	/** Represents the title "Count". */
	COUNT("Count"),
	
	/** Represents the title "Duke". */
	DUKE("Duke"),
	
	/** Represents the title "King".*/
	KING("King");
	
	private final String prefix;
	
	/** 
	 * Constructs a new Title enum, with the given prefix. 
	 * @param prefix - the prefix to use for this title.
	 */
	Title(String prefix) {
		this.prefix = prefix;
	}
	
	/**
	 * Returns the prefix associated with this title.
	 * @return the prefix associated with this title.
	 */
	public String getPrefix() {
		return prefix;
	}
}
