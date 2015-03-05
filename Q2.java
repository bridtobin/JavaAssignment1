
//Created by Brid Delap on 15/10/13
//Assignment 1. Question 2.
// This program prompts the user to enter the exchange rate from
//currency in U.S. dollars to Chinese RMB. It prompts the user to enter 0 to
//convert from U.S. dollars to Chinese RMB and 1 to convert from Chinese
//RMB and U.S. dollars. It then prompts the user to enter the amount in U.S. dollars or
//Chinese RMB to convert it to Chinese RMB or U.S. dollars, respectively. The
//latest user will use exchange rates found on the website www.xe.com

// Firstly import the scanner to get input from user
import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		// To validate the user input I have written two methods.  The first one called getDoubleAboveZero takes a prompt as a parameter and returns a valid double number above 0
		// This method is used to get user input for exchange rate and amount (in either dollars or RMB)
		// The second one called getIntWithinRange takes a prompt, a lower range and an upper range and returns an integer within that range.
		double exchangeRate = getDoubleAboveZero("Enter the exchange rate from dollars to RMB: ") ;
		int conversionType = getIntWithinRange("Enter 0 to convert dollars to RMB and 1 vice versa:",0,1) ;
		double amount = (conversionType==0 ? getDoubleAboveZero("Enter the US dollars amount:  ") : getDoubleAboveZero("Enter the RMB amount:  ")) ;
        // print out result. If the conversion type requested is 0 i.e. dollars to RMB we multiply amount by exchangerate.  If
		// converstion type is 1, we multiply amount by (1 divided by exchange rate)
		System.out.print(conversionType==0 ? "$" + amount + " is " : amount + " yuan is $") ;
		if (conversionType == 0) {
			System.out.print (amount*exchangeRate + " yuan") ;
		}
		else {
			System.out.printf("%.4f", amount*(1/exchangeRate));
		}
		
	} // main method
	
	public static double getDoubleAboveZero (String prompt) {
		//  use a do while loop to get the correct exchange rate based on the values in firstRange and lastRange above.  
		// Keep repeating this until they enter a correct value i.e. > 0
		double doubleNumber ;
		do {
			System.out.println(prompt) ;
			Scanner getInput = new Scanner(System.in);
			doubleNumber = getInput.nextDouble() ;
			if (doubleNumber <= 0) {
				System.out.println("ERROR - You must enter a value greater than 0 ") ;
			} // if doubleNumber <= 0
		} while (doubleNumber <= 0) ;
		return doubleNumber ;
	}  // method getDoubleAboveZero
	
	
	public static int getIntWithinRange (String prompt, int lowerRange, int upperRange) {
		//  use a do while loop to get the correct exchange rate based on the values in firstRange and lastRange above.  
		// Keep repeating this until they enter a correct value i.e. > 0
		int intNumber ;
		do {
			System.out.println(prompt) ;
			Scanner getInput = new Scanner(System.in);
			intNumber = getInput.nextInt() ;
			if (intNumber < lowerRange || intNumber > upperRange ) {
				System.out.println("ERROR - You must enter a value between " + lowerRange + " and " + upperRange) ;
			} // if intNumber <= 0
		} while (intNumber < lowerRange || intNumber > upperRange) ;
		return intNumber ;
	}  // method getIntWithinRange
} // class Q2



