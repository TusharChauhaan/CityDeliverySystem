package Classes;

import java.util.*;

//This class maintain and handle human related data

public abstract class Man {
	
	 private String Name;
	 private char gender;
	 private String fathers_name;
	 private String mothers_name;
	 private String address;
	 private String date_of_birth;
	 private long contact_no;
	 
	 //Collect personal Data and creates a object
	 
	 public Man() {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("--------------------------------------------------");
		 System.out.println("Enter your personal details");
		 System.out.println("--------------------------------------------------");
		 System.out.print("Name            : ");
		 Name = sc.nextLine();
		 System.out.print("Father's Name   : ");
		 fathers_name = sc.nextLine();
		 System.out.print("Mother's Name   : ");
		 mothers_name = sc.nextLine();
		 System.out.print("Gender M/F/T    : ");
		 gender = sc.next().charAt(0);
		 System.out.println("Date of Birth   : ");
		 date_of_birth = Helper.getDOB(sc);
		 System.out.print("Contact No      : ");
		 contact_no = sc.nextLong();
		 System.out.println("Address         : ");
		 address = Helper.collectAddress();
	 }
	 
	 //Crates a object with provided data items
	 
	 public Man(String Name, String father_name, String mother_name, 
			 char gender, String dob, long contact_no, String address) 
	 {
		 this.Name = Name;
		 this.fathers_name = father_name;
		 this.mothers_name = mother_name;
		 this.gender = gender;
		 this.date_of_birth = dob;
		 this.contact_no = contact_no;
		 this.address = address;
	 }
	 
	 //Shows all personal Data
	 
	 public void showPersonalData() {
		 System.out.println("Personal Detail");
		 System.out.println("Name            : "+Name);
		 System.out.println("Father's Name   : "+fathers_name);
		 System.out.println("Mother's Name   : "+mothers_name);
		 System.out.println("Gender          : "+gender);
		 System.out.println("Date of Birth   : "+date_of_birth);
		 System.out.println("Contact No      : "+contact_no);
		 System.out.println("Address         : "+address);
	 }
	 
	 //Shows some basic details
	 
	 public void showBasicDetails() {
		 System.out.println("--------------------------------------------------");
		 System.out.println("Name       : "+Name);
		 System.out.println("Contact No : "+contact_no);
		 System.out.println("--------------------------------------------------");
	 }
	 
	 //returns Name
	 
	 public String getName() {
		 return Name;
	 }
	 
	 //returns Contact No
	 
	 public long getContactNo() {
		 return contact_no;
	 }
}
