/*
 * James Bebarski
 * TimerController.java
 * Concept 6
 * + GUI Extension.
 */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

/**
 * TimerController handles the TimerModel and TimerView objects.
 * It handles the user input and updates the view based on changes to the model.
 * @author James Bebarski
 */
public class TimerController {
	
	/** The timer model.*/
	@SuppressWarnings("unused")
	private TimerModel model;
	
	/** The timer view.*/
	@SuppressWarnings("unused")
	private TimerView view;
	
	/** Helps update the view's timer. */
	private Timer refreshTimer;
	
	/**
	 * Constructor for the TimerController class.
	 * Initializes the TimerModel and TimerView objects, and sets up the action listeners.
	 * @param model - The TimerModel object
	 * @param view - The TimerView object
	 */
	public TimerController(TimerModel model, TimerView view) {
		this.model = model;
		this.view = view;
		
		view.addButtonListener(event-> {
			// Checks which button was clicked.
			switch (event.getActionCommand()) {
				case "START":
					// Start the timer and update the view.
					model.startTimer();
					refreshTimer.start();
					view.updateTimerDisplay(model.getTimePassed());
					break;
				case "STOP":
					// Stop the timer and update the view.
					model.stopTimer();
					refreshTimer.stop();
					view.updateTimerDisplay(model.getTimePassed());
					break;
				case "RESET":
					// Reset the timer and update the view.
					model.resetTimer();
					refreshTimer.stop();
					view.updateTimerDisplay(model.getTimePassed());
					break;
			}
		});
		
		// Sets up a timer for updating the view's timer display.
		// Basically it gets the time passed within the model for every 1/1000th of a second.
        refreshTimer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                view.updateTimerDisplay(model.getTimePassed());
            }
        });
    }
}
