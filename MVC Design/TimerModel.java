/*
 * James Bebarski
 * TimerModel.java
 * Concept 6
 * + GUI Extension.
 */

import java.time.Duration;
import java.time.Instant;

/**
 * TimerModel represent's the timer's data, including the start time and time passed.
 * It provides methods to start, stop, and reset the timer, and to retrieve the time passed.
 * @author James
 *
 */
public class TimerModel {
	
	/** The start time of the time. */
	private Instant startTime;
	
	/** The time passed since the timer has started. */
	private Duration timePassed;
	
	/** 
	 * Constructor for the TimerModel class.
	 * Initializes the start time and passed time to default values.
	 */
	public TimerModel() {
		startTime = null;
		timePassed = Duration.ZERO;
	}
	
	/**
	 * Returns the start time of the timer.
	 * @return the start time of the timer.
	 */
	public Instant getStartTime() {
		return startTime;
	}
	
	/**
	 * Returns the total time passed, considering whether the timer is currently running or not.
	 * @return The total time passed as a Duration object.
	 */
	public Duration getTimePassed() {
		return startTime == null ? timePassed : timePassed.plus(Duration.between(startTime, Instant.now()));
	}
	/** 
	 * Sets the start time of the timer.
	 * @param startTime - the new start time as am Instant object.
	 */
	public void setStartTime(Instant startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * Sets the passed time of the timer.
	 * @param duration - the new elapsed time as a Duration object.
	 */
	public void setTimePassed(Duration duration) {
		this.timePassed = duration;
	}
	
	/**
	 * Starts the timer by setting the start time to the current time.
	 */
	public void startTimer() {
		if (startTime == null) {
			startTime = Instant.now();
		}
	}
	
	/**
	 * Stops the timer and updates the time passed.
	 */
	public void stopTimer() {
		if (startTime != null) {
			timePassed = getTimePassed();
			startTime = null;
		}
	}
	
	/**
	 * Resets the timer by setting the start time and time passed to their default values.
	 */
	public void resetTimer() {
		startTime = null;
		timePassed = Duration.ZERO;
	}
	
	/** 
	 * Returns a string representation of the TimerModel, including the start time and passed time.
	 * @return a string representation of the TimerModel.
	 */
	@Override
	public String toString() {
		return startTime.toString() + timePassed.toString();
	}
}
