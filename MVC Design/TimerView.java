/*
 * James Bebarski
 * TimerView.java
 * Concept 6
 * + GUI Extension.
 */

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.ActionListener;
import java.time.Duration;


/**
 * TimerView represents the user interface for the timer Application. 
 * It extends JFrame and contains a display for the timer, and buttons for start, stop, and reset.
 * @author James Bebarski
 */
@SuppressWarnings({ "serial", "unused" })
public class TimerView extends JFrame{
	
	/** The display for the timer. */
	private JLabel timerDisplay;
	
	/** The start button. */
	private JButton startButton;

	/** The stop button. */
	private JButton stopButton;
	
	/** The reset button. */
	private JButton resetButton;
	
	/**
	 * Constructor for the TimerView class.
	 * Initializes and configures the timer display, start, stop, and reset buttons.
	 */
	public TimerView() {
		setTitle("Timer");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		
		// Initializes the timer display.
		timerDisplay = new JLabel("00:00:00:000", SwingConstants.CENTER);
		timerDisplay.setFont(new Font("Verdana", Font.BOLD, 30));
		
		// Initializes the buttons.
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		resetButton = new JButton("Reset");
		
		// Adds the buttons to the panel.
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(startButton);
		buttonsPanel.add(stopButton);
		buttonsPanel.add(resetButton);
		
		// Adds the timer display and button panel to the frame.
		add(timerDisplay, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Adds a single ActionListener to the start, stop, and reset buttons.
	 * @param listener - the action listener.
	 */
	public void addButtonListener(ActionListener listener) {
		
		// Adds an actions listener and set action command for the start button.
		startButton.addActionListener(listener);
		startButton.setActionCommand("START");
		
		// Adds an action listener and set action command for the stop button.
		stopButton.addActionListener(listener);
		stopButton.setActionCommand("STOP");
		
		// Adds an action listener and set action command for the reset button.
		resetButton.addActionListener(listener);
		resetButton.setActionCommand("RESET");
	}
    
    /**
     * Updates the timer display with the provided duration.
     * @param duration - the Duration object representing the current elapsed.
     */
    public void updateTimerDisplay(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutes();
        long seconds = duration.toSeconds();
        long milliseconds = duration.toMillisPart();
        timerDisplay.setText(String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, milliseconds));
    }
    
    // The below getters were only used to help with testing.
    
    /**
     * Basic getter for the start button. 
     * @return the start button.
     */
	public JButton getStartButton() {
		return startButton;
	}
	
	/** 
	 * Basic getter for the stop button.
	 * @return the stop button.
	 */
	public JButton getStopButton() {
		return stopButton;
	}
	
	/** 
	 * Basic getter for the reset button.
	 * @return the reset button.
	 */
	public JButton getResetButton() {
		return resetButton;
	}
}
