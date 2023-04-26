/*
 * James Bebarski
 * ManaImpl.java
 * Concept 2
 */

/**
 * Concrete implementation of the Mana interface. 
 * @author James Bebarski
 */
public class ManaImpl implements Mana {
	
	private int mana;
	
	/**
	 * Initializes some starting mana.  
	 * @param mana - the given amount of mana.
	 */
	public ManaImpl(int mana) {
		this.mana = mana;
	}
	
	@Override
	public int getMana() {
		return mana;
	}

	@Override
	public void setMana(int mana) {
		this.mana = mana;
	}

	@Override
	public void expendMana(int mana) {
		this.mana -= mana;
	}

	@Override
	public void regenMana(int mana) {
		this.mana += mana;
	}
	
	@Override
	public String toString() {
		return String.valueOf(mana);
	}

}
