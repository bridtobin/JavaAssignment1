//Created by Brid Delap on 20/10/2013.  
//Assignment 1. Question 3
//Program that prompts the user to enter the number of seconds, displays
//a message at every second, and terminates when the time expires. 

// Firstly import the scanner to get input from user
import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
	// use a method already written in Q4 to get a valid integer greater than 0
		int userSeconds = Q4.getIntAboveZero("Enter the number of seconds:  ") ;
		// get the current number of milliseconds since 197.....
		long systemCurrSeconds = System.currentTimeMillis()/1000 ;
		// counter to use in the while loop. Decremented each time we print a line
		int counter=userSeconds ;
		// declare and initialse seconds as the currentTimeMillis and finish the loop when the number
		// of seconds entered by user has expired.
		
		for (long seconds = systemCurrSeconds; seconds < (systemCurrSeconds + userSeconds) ; seconds ++) {
			// start an infinite loop that breaks only when a second has passed.  Compare seconds to System.currentTimeMillis
			while (true) { 
				if (System.currentTimeMillis()/1000 == seconds) {
					// We don't want to print on the first iteration of the loop.  We only print after 1 second
					if (System.currentTimeMillis()/1000 != systemCurrSeconds) {
						System.out.println(counter + " second" + (counter != 1 ? "s " :" ") +  "remaining");
					} // if System.....!= systemCurrSeconds
					counter --;
					break ;
				} // if System.current...
			} // while 
		} // for seconds = systemCurrSeconds
		System.out.println("Stopped");

	} // main method

} // class Q3
