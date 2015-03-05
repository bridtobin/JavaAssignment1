// Created by Brid Delap on 20/10/2013.  
// Assignment 1. Question 4
// This program calculates the day of the week using Zeller's congruence algorithm
// where
// • h is the day of the week  (0: Saturday, 1: Sunday, 2: Monday, 3: Tuesday, 4: Wednesday, 5: Thursday, 6: Friday).
// • q is the day of the month.
// • m is the month (3: March, 4: April, . . ., 12: December). January and February are counted as months 13 and 14 of the previous year.
// • j is the century (i.e., ).
// • k is the year of the century (i.e., year % 100).
// Note: that the division in the formula performs an integer division. Write a program that prompts the user to enter a year, month, and day of the month,
// and displays the name of the day of the week. 


// Firstly import the scanner to get input from user
import java.util.Scanner;
public class Q4 {

	public static void main(String[] args) {
		// Use the method getIntAboveZero to get the year from the user.  This method just needs the parameter
		// prompt, which prompts the user what to enter
		int k = getIntAboveZero("Enter the year e.g. (2012):  ") % 100 ;
		// use a method defined in Q2 to get a valid month ie. between 1 and 12
		int m = Q2.getIntWithinRange("Enter month 1-12:",1,12) ;
		// Use a method called getDayInMonth where the month and the year are sent as parameters
		int q = getDayInMonth("Enter the day of the month 1-31:",m,k) ;
		
		// Once we have valid input we apply the formula and calculate the day of the week.
		// Firstly change the value of m (month) and k (year) if the month is Jan or Feb as
		// instructed.  January becomes 13 and February becomes 14 and the year used is the
		// previous year.
		if (m < 3) {
			m += 12 ;
			k -= 1 ;
		} // if (m <3)
		int j = k/100 ;
		// Now apply the formula
		int h = (q + (26 * (m+1))/10 + k + (k/4) + (j/4) + (5*j))%7 ;
		System.out.println("Day of the week is " + getNameOfDay(h) + " ") ;
	} // main method
	
	//
	public static int getDayInMonth(String prompt,int month,int year) {
		int intNumber ;
		do {			
			System.out.println(prompt) ;
			Scanner getInput = new Scanner(System.in);
			intNumber = getInput.nextInt() ;
			if (intNumber <= 0 | intNumber > getValidNoOfDays(month,year)) {
				System.out.println("ERROR - You must enter a valid day for the month and year entered above") ;
			} // if intNumber <= 0
		} while (intNumber <= 0 | intNumber> getValidNoOfDays(month,year)) ;
		return intNumber ;
	} // method getDayInMonth
	
	// Method to find the highest valid day for the month and year entered.
	public static int getValidNoOfDays(int month, int year){
		int noOfDays ;
		if(month == 1 | month == 3 | month ==5 | month == 7 | month == 8
				| month == 10 | month==12) {
			noOfDays = 31 ;
		} // if month
		else {
		    if(month==4 | month==6 | month==9 | month==11) {	
		    	noOfDays = 30 ;
		    } // if month==4
		    else {
		    	// use the method ifLeapYear defined below to allocate days to February
		    	noOfDays = ifLeapYear(year) ? 29 : 28 ;
		    }  // if month==4....else
		} // if month ==1... else
		return noOfDays ;
	} // method getValidNoOfDays
	
	// method used to determine if the year passed to it is a leap year
	public static boolean ifLeapYear(int year) {
		if ((year % 4 ==0 && year % 100 != 0) || (year % 400 ==0 )) {
			return true;
		} // if year % 4
		else {
			return false;
		} // if.....else year % 4
	} // method ifLeapYear
	

	// Method which receives a prompt as a parameter. The method gets an integer value from a 
	// user and ensures that is is greater than 0.  A while loop is used to keep prompting the
	// user for this value until they enter a valid number (i.e. >0). The prompt is actually
	// the prompt that is presented to the user to get number.  
	public static int getIntAboveZero (String prompt) {
		//  use a do while loop to get an integer greater than 0  
		// Keep repeating this until they enter a correct value i.e. > 0
		int intNumber ;
		do {
			System.out.println(prompt) ;
			Scanner getInput = new Scanner(System.in);
			intNumber = getInput.nextInt() ;
			if (intNumber <= 0) {
				System.out.println("ERROR - You must enter a value greater than 0 ") ;
			} // if intNumber <= 0
		} while (intNumber <= 0) ;
		return intNumber ;
	} // getIntAboveZero method
	
	public static String getNameOfDay (int day) {
	String dayNameOfDay = " " ;
		switch (day) {
		case 0: dayNameOfDay = "Saturday"; break; 
		case 1: dayNameOfDay = "Sunday" ; break; 
		case 2: dayNameOfDay ="Monday" ; break; 
		case 3: dayNameOfDay ="Tuesday" ; break; 
		case 4: dayNameOfDay ="Wednesday" ;break; 
		case 5: dayNameOfDay ="Thursday" ;break; 
		case 6: dayNameOfDay ="Friday" ;break; 
		}
		return dayNameOfDay ;
		
	} // method getNameOfDay
		
} // class Q4




	
	
