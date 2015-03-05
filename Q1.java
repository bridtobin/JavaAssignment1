//Created by Brid Delap on 15/10/13
//The U.S. Census Bureau projects population based on the following assumptions:
//One birth every 7 seconds; One death every 13 seconds; One new immigrant every 45 seconds;
//This program displays the population for each of the next five years.
//We assume the current population is 312,032,486 and one year has 365 days.

// I have decided to use a method called eventPerYearInSeconds with one parameter for no. of seconds.  This method will calculate 
// the number of events in a year based on the value in that parameter.  This will be called from a for loop which will carry out calculations
// for the next 5 years.
public class Q1 {

	public static void main(String[] args) {
		// declare variable to hold a runnning total of population
		int population = 312032486 ;
		// Firstly print header
		System.out.println("Year\t\tPredicted Population");
		for(int year = 2014; year <= 2018; year++) {
			// The population each year will increase by no of births (1 every 7 seconds); decrease by deaths (1 every 13 seconds)
			// and increase by the arrival of immigrants (1 every 45 seconds)
			population += eventPerYearInSeconds(7) - eventPerYearInSeconds(13) + eventPerYearInSeconds(45) ;
			// Print out the year and the predicted population total
			System.out.println(year+ "\t\t" + population) ;

		} // for int year = 2014
		
		

	} // main method
	
	public static int eventPerYearInSeconds (int seconds) {
		// return the seconds in a year divided by the parameter seconds (which holds how often in seconds this event occurs)
		return (60*60*24*365)/seconds ;
	} // eventPerYearInSeconds method

}  // class Q1
