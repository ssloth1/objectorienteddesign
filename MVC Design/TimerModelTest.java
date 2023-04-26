/*
 * James Bebarski
 * TimerModelTest.java
 * Concept 6
 * + GUI Extension.
 */

import static org.junit.Assert.*;

import java.time.Duration;
import java.time.Instant;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the Timer Model.
 * @author James Bebarski
 */
public class TimerModelTest {
	
	/** The Timer model */
	private TimerModel timer;
	
	/** Initializes the TimerModel */
	@Before
	public void initializeTimer() {
		timer = new TimerModel();
	}
	
	/** Tests getStartTime */
	@Test
	public void testGetStartTime() {
		assertNull(timer.getStartTime());
	}
	
	/** Tests gettimePassed as it is initialized */
	@Test
	public void testGetTimePassedDefault() {
		assertEquals(Duration.ZERO, timer.getTimePassed());
	}
	
	/** Tests getTimePassed 
	 * @throws InterruptedException - if thread is interrupted.
	 */
	 
	@Test
	public void testGetTimePassed() throws InterruptedException {
	    timer.startTimer();
	    Thread.sleep(1000);
	    timer.stopTimer();
	    assertTrue(timer.getTimePassed().compareTo(Duration.ofSeconds(1)) >= 0);
	}
	
	/** Tests geTimePassed doesn't increase after using stopTimer
	 * @throws InterruptedException - if thread is interrupted.
	 */
	@Test
	public void testGetTimePassedTimerStopped() throws InterruptedException {
	    timer.startTimer();
	    Thread.sleep(1000); // Wait for 1 second
	    assertTrue(timer.getTimePassed().compareTo(Duration.ofSeconds(1)) >= 0);
	    Thread.sleep(1000); // Wait for another second
	    assertTrue(timer.getTimePassed().compareTo(Duration.ofSeconds(2)) >= 0);
	    timer.stopTimer();
	    assertTrue(timer.getTimePassed().compareTo(Duration.ofSeconds(2)) >= 0);
	}
	
	/** Tests the setStartTime method. */
	@Test
	public void testSetStartTime() {
		Instant startTime = Instant.now();
		timer.setStartTime(startTime);
		assertEquals(startTime, timer.getStartTime());
	}
	
	/** Tests the setTimePassed method. */
	@Test
	public void testSetTimePassed() {
		Duration timePassed = Duration.ofMinutes(1);
		timer.setTimePassed(timePassed);
		assertEquals(timePassed, timer.getTimePassed());
	}
	
	/** Tests the setStartTime method. */
	@Test
	public void testStartTimer() {
		timer.startTimer();
		assertNotNull(timer.getStartTime());
	}
	
	/** Tests the stopTimer method.
	 * @throws InterruptedException - if thread is interrupted.
	 */
	@Test
	public void testStopTimer() throws InterruptedException {
		timer.startTimer();
		Thread.sleep(1000);
		timer.stopTimer();
		assertNotNull(timer.getTimePassed());
	}
	
	/** Tests the resetTimer method.
	 * @throws InterruptedException - if thread is interrupted.
	 */
	@Test
	public void testResetTimer() throws InterruptedException {
		timer.startTimer();
		Thread.sleep(1000);
		timer.startTimer();
		timer.resetTimer();
		assertNull(timer.getStartTime());
		assertEquals(timer.getTimePassed(), Duration.ZERO);
	}
	
	/** Tests the model toString method. */
	@Test
	public void testToString() {
		Instant startTime = Instant.now();
		Duration timePassed = Duration.ofMinutes(1);
		
		timer.setStartTime(startTime);
		timer.setTimePassed(timePassed);
		
		String expectedString = startTime.toString() + timePassed.toString();
		assertEquals(expectedString, timer.toString());
	}

}
