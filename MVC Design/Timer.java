/*
 * James Bebarski
 * Timer.java
 * Concept 6
 * + GUI Extension.
 */

/**
 * Driver class for the Timer Application.
 * @author James Bebarski
 */
public class Timer {
	
	/**
	 * Main/driver for the Timer Application
	 * @param args - main arguments.
	 */
	public static void main(String[] args) {
		
		/** Timer model */
		TimerModel model = new TimerModel();
		
		/** Timer view */
		TimerView view = new TimerView();
		
		/** Timer controller */
		@SuppressWarnings("unused")
		TimerController controller = new TimerController(model, view);
		
		/** Sets the visibility of the view to true. */
        view.setVisible(true);
	}
}
