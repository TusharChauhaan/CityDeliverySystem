package Classes;

import java.util.Scanner;

public abstract class Helper {
	
	//This method will collect all information for address from user
	//convert it to a string and then returns it
	
	public static String collectAddress() {
		
		String plot_no;
		String street;
		String city;
		String state;
		String country;
			
		Scanner scanner = new Scanner(System.in);
			
		System.out.print("Plot no    : ");
		plot_no = scanner.nextLine();
		System.out.print("Street     : ");
		street = scanner.nextLine();
		System.out.print("City       : ");
		city = scanner.nextLine();
		System.out.print("State      : ");
		state = scanner.nextLine();
		System.out.print("Country    : ");
		country = scanner.nextLine();
			
		String adrs = plot_no + ", " + street + ", " + city + ", " + state + ", " + country;
		return adrs;
	}
	
	//Collect a date and return as String
	
	 public static String getDOB(Scanner sc) {
			 
		 int day;
		 int month;
		 int year;
		 do {
			 System.out.print("Day             : ");
			 day = sc.nextInt();
			 System.out.print("Month (int)     : ");
			 month = sc.nextInt();
			 System.out.print("Year            : ");
			 year = sc.nextInt();
		 }while(!checkDate(day,month,year));
			 
		 return (day+"/"+month+"/"+year);
	 }
	 
	 //Checks weather date is correct or not
	 
	 private static boolean checkDate(int day, int month, int year) {
		
		 boolean isLeap = false;
		 boolean isCorrect = false;
		 //checking leap year
		 if(year % 400 == 0 ) {
			 isLeap = true;
		 }
		 else if(year % 100 == 0) {
			 isLeap = false;
		 }
		 else if(year % 4 == 0) {
			 isLeap = true;
		 }
		 //checking date
		 if(month > 12 || day > 31) {
			 isCorrect = false;
		 }
		 else if(month == 2) {
			 if( isLeap && (day <= 29) ) {
				 isCorrect = true;
			 }
			 else if(!isLeap && (day <= 28)) {
				 isCorrect = true;
			 }
		 }
		 else if(month < 8) {
			 if(month % 2 == 1 && day <= 31) {
				 isCorrect = true;
			 }
			 else if(day <= 30) {
				 isCorrect = true;
			 }
		 }
		 else{
			 if(month % 2 == 0 && (day <= 31)) {
				 isCorrect = true;
			 }
			 else if(day <= 30) {
				 isCorrect = true;
			 }
		 }
			 
		 if(!isCorrect) {
			 System.out.println("--------------------------------------------------");
			 System.out.println("! Invalid Date \nPlease enter correct date");
			 System.out.println("--------------------------------------------------");
		 }
		 return isCorrect;
	 }
	 
}
