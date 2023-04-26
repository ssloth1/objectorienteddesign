/**
 * The name class, represents a name object contains a given name as a String and a Title enum.
 * @author James Bebarski
 */
public class Name {
	
	private Title title;
	private String fullName;
	
	/**
	 * Constructor for a Name object.
	 * @param title - the title in a name object.
	 * @param fullName - the given name of a object.
	 */
	public Name(Title title, String fullName) {
		this.title = title;
		this.fullName = fullName;
	}
	
	/**
	 * Getter method for a Title.
	 * @return a title.
	 */
	public Title getTitle() {
		return title;
	}
	
	/**
	 * Setter method for a Title.
	 * @param title - the given title.
	 */
	public void setTitle(Title title) {
		this.title = title;
	}
	
	/**
	 * Getter method for fullName.
	 * @return a fullName.
	 */
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * Setter method for fullName.
	 * @param fullName - the given fullName.
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Override
	public String toString() {
		return title == Title.NONE ? fullName : title.getPrefix() + " " + fullName;
	}
}

