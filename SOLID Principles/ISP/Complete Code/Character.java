


/**
 * A Character abstract class, represents an abstract player. 
 * Think of this in terms of a video game, a character could be your Player, some sort of NPC, or a character mentioned in passing or lore.
 * @author James Bebarski
 */
public abstract class Character {
	
	protected Name name;
	
	/**
	 * Constructs a character object with a given name
	 * @param fullName - the given name.
	 */
	public Character(String fullName) {
		this.name = new Name(Title.NONE, fullName);
	}
	
	/**
	 * Getter method for a character Name.
	 * @return a character Name object.
	 */
    public Name getName() {
        return name;
    }
    
    /**
     * Sets a character's Name.
     * @param name the given name object.
     */
    public void setName(Name name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
    	return name.toString();
    }
}
