// Created by Brid Delap on 20/10/2013.  
// Assignment 1. Question 5.
// Program to validate credit card number using algorithm proposed by Hans Luhn.  A valid credit card must pass three criteria
// It must pass  the Hans Luhn algorithm which is described as follows:
// a) Double every second digit from right to left. If doubling of a digit results in a two-digit number, add up the two digits 
// to get a single-digit number - Then add up all those single-digit numbers. b) Add all digits in the odd places from right to
// left in the card number. Sum the results from a) and b).  If the result is divisible by 10, the card number is valid.
// As well as the above algorithm the card must have between 13 and 16 numbers and have a prefix of 4, 5 6 or 37.

	import java.util.Scanner;


	public class Q5 {
	    // The main method calls the IsValid method, passing the number input by the user, and displays whether number is valid or not
		public static void main(String[] args) {
			System.out.println("Enter a credit card number as a long integer: ") ;
			Scanner getInput = new Scanner(System.in);
			long number = getInput.nextLong() ;
			if (isValid(number)) {
				System.out.println(number + " is valid") ;
			} // if isValid
			else {
				System.out.println(number + " is invalid") ;
				
			} // if isValid(number)
		}  // main method
		
		// The isValid method calls four methods to see if the card is valid.  Firstly checks that the prefix matches by calling the method 
		// prefixMatched - it passes the number to the method and within that method calls another method getSize (to which it also passes the number)
		// getSize returns the size of the number entered by the user.  It then calls getSize to make sure number is the required length.  
		// It finally calls the two methods which determine if the number is valid using  Hans Luhn's algorithm for validating credit card -
		// those are the methods sumOfDoubleEvenPlace (which applies part of the Luhn algorithm) and sumOfOddPlace.  According to
		// Luhn's algorithm, the card is valid if the sum of those two numbers can be divided by 10.
		public static boolean isValid(long number) {
			if (prefixMatched(number,getSize(number)) && (getSize(number) >= 13 && getSize(number) <= 16)  
				&& (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0) {
				return true ;
			}
			else {
				return false ;
			} // if prefixMatched
		} // method isValid
		
		public static int sumOfOddPlace(long number) {
			// I use a while loop until the number reaches 0. Through each iteration of the loop, I divide the number by 100 
			// I get each digit by getting the number mod 100 and then from that result getting mod 10. Each digit is stored in a 
			// temporary variable called modulusResult which is added to the variable sumOddDigits on each iteration of the loop.
			// The total value of sumOddDigits is returned.
			int sumOddDigits = 0;
			long modulusResult = 0 ;
			while (number > 0) {
			    modulusResult = (number % 100) % 10 ;
				number = number/100 ;
				sumOddDigits += modulusResult ;
			} // while number > 0
			return sumOddDigits ;
		} // sumOfOddPlace method

		public static int sumOfDoubleEvenPlace(long number) {
			// I use a while loop until the number reaches 0. Through each iteration of the loop, I divide the number by 100 
			//  Before doing that I get the mod 100 of that number and I divide that mod by 10 to get the first digit. This digit is
			// then stored in a temporary variable called modulusResult. I call the method getDigit, which will carry out certain
			// modifications to the number, which varies depending on the number.  The number returned from getDigit is added to a running 
			// total held in variable called sumEvenDigits.  sumEvenDigits is finally returned.
			int sumEvenDigits = 0 ;
			long modulusResult = 0 ;
			while (number > 0) {
			    modulusResult = (number % 100) / 10 ;
				number = number/100 ;
				sumEvenDigits += getDigit((int)modulusResult) ;

			} // while number > 0 
			return sumEvenDigits ;
		} // method sumOfDoubleEvenPlace
		
		
		// This method looks at the number sent to it which will always be between 0 and 9.  If the number multiplied by 2
		// has a one digit result i.e. <= 9, we return the result of that multiplication.  Otherwise we add the resulting 
		// digits together.  As the highest number that can be received as a parameter is 9, the highest result is 18
		// We therefore take the first digit as always being 1 and add it to the number mod 10.
		public static int getDigit(int number) {
			if(number * 2 <= 9) {
				return number*2 ;
			} // if number * 2
			else {
				// highest value you can is 18 to the first digit is always going to 1.  Then add the modulus
				// to 1
				return 1 + ((number * 2) % 10) ;
			} // else... number * 2
		} // getDigit method

		//  This method gets the size of the number input by user. Used a while loop because I don't know the length of the number before starting
		//  Keep dividing number by 10 until number = 0. I keep a count of the number of loop iterations in a count variable.  This count is then returned
		 public static int getSize(long d) {
		     int count = 0;
		     while (d > 0) {
		        d = d / 10;
		        count++;
		     } // while d > 0
		        return count;
		  } // getSize method
		 
		 // This method checks that the prefix of the number is a valid prefix. It calls the method getPrefix to get the first digit
		 // of the number.  As one of the valid prefixes is 37, if getPrefix returns a 3, then it calls it again to get the first two digits. 
		 // It then checks the prefix against all valid prefixes
		 public static boolean prefixMatched(long number, int d) {
			 long prefix = getPrefix(number, d - 1) ;
			 if(prefix==3) {
				 prefix = getPrefix(number,d - 2) ;
			 } // if(prefix==3)
			 if(prefix==4 | prefix==5 | prefix==6 | prefix == 37) {
				 return true;
			 } // if(prefix==4)
			 else {
				 return false ;
			 } // else if prefix == 4
		 }  // prefixMatched method
		 
		 
		 // This method gets the prefix of the number by returning the number of digits based on the parameter k (number size - 1) which is passed to it.
		 // It is called by prefixMatched at least once but can be called twice if the first digit returned is 3.  If the number of digits is
		 // less than k, it returns the number.
		 public static long getPrefix(long number, int k) {
			 long prefix = (long)(number/Math.pow(10, k)) ;
			 if (prefix == 0)
				 return number ;
			 else
				return prefix ;
		 } // method getPrefix
	} // class Q5






		


