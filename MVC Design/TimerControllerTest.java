/*
 * James Bebarski
 * TimerControllerTest.java
 * Concept 6
 * + GUI Extension.
 */

import static org.junit.Assert.*;

import java.time.Duration;
import java.time.Instant;

import org.junit.Before;
import org.junit.Test;

/**
 * TimerControllerTest tests the TimerController class.
 * @author James Bebarski
 */
public class TimerControllerTest {
	
	/** Timer model */
	private TimerModel model;
	/** Timer view */
	private TimerView view;
	/** Timer controller */
	@SuppressWarnings("unused")
	private TimerController controller;

	/** Initializes the TimerModel, TimerView, and TimerController for testing.*/
	@Before 
	public void initialize() {
		model = new TimerModel();
		view = new TimerView();
		controller = new TimerController(model, view);
	}
	
	/** Tests that the start button functions as intended.
	 * @throws InterruptedException - if thread is interrupted.
	 */
	@Test
	public void testStartRequest() throws InterruptedException {
	    // Checks that the timer is initially null
	    Instant initialStartTime = model.getStartTime();
	    assertNull(initialStartTime);

	    // Clicks the start button and verifies the timer started
	    view.getStartButton().doClick();
	    Instant startTime = model.getStartTime();
	    assertNotNull(startTime);

	    // Checks the passed time after some delay
	    Thread.sleep(1000); // 1 second
	    Duration initialTimePassed = model.getTimePassed();
	    long initialPassedMillis = initialTimePassed.toMillis();
	    assertTrue(initialPassedMillis > 0);
	}
	
	/** Tests that the stop button works as intended.
	 * @throws InterruptedException - if thread is interrupted.
	 */
	@Test
	public void testStopRequest() throws InterruptedException {
	    // Start the timer
	    view.getStartButton().doClick();
	    Thread.sleep(1000);

	    // Stops the timer and get the passed time
	    view.getStopButton().doClick();
	    Duration timePassed = model.getTimePassed();
	    long passedMillis = timePassed.toMillis();
	    assertTrue(passedMillis > 1);

	    // Checks that the timer is stopped and the time doesn't increase
	    Thread.sleep(1000); // Waits for an additional 1 second
	    Duration timePassedAfterStop = model.getTimePassed();
	    long passedMillisAfterStop = timePassedAfterStop.toMillis();
	    assertEquals(passedMillis, passedMillisAfterStop);
	}
	
	/** Tests that the reset button works as intended.
	 * @throws InterruptedException - if thread is interrupted.
	 */
	@Test
	public void testResetRequest() throws InterruptedException {
	    // Starts the timer and waits for some time
	    view.getStartButton().doClick();
	    Thread.sleep(1000);

	    // Clicks the reset button and ensures the timer is reset
	    view.getResetButton().doClick();
	    assertEquals(null, model.getStartTime());
	    assertEquals(Duration.ZERO, model.getTimePassed());
	}
}
