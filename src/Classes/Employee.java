package Classes;

import java.util.Scanner;

public class Employee extends Man {
	
	private int salary;
	private Id account;
	private int id;
	
	//collects employee details from user
	
	public Employee(int id) {
	    super();
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Salary          : ");
	    this.salary = sc.nextInt();
	    account.collectId();
	    this.id=id;
     }
	
	//creates object with passed data items
	
	public Employee(int id, Id account, String Name, String father_name,
			 String mother_name, char gender, String dob, long contact_no, 
			 String address, int salary) {
		
		 super(Name, father_name, mother_name, gender, dob, contact_no, address);
		 this.id = id;
		 this.account = account;
		 this.salary = salary;
	}
	 
	//Prints all employee details
	
	public void showDetails() {
		System.out.println("--------------------------------------------------");
		System.out.println("Employee Details");
		System.out.println("--------------------------------------------------");
		System.out.println("Id              : "+id);
		System.out.println("User Id         : "+account.getUserId());
		showPersonalData();
		System.out.println("Salary          : "+salary+"\n");
	}

	public Id getID() {
		return account;
	}
	
}
