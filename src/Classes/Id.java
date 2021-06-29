package Classes;

import java.util.Scanner;
import DataBase.ID_DataBase;

public class Id {
	
	private String user_id;
	private String password;
	
	public Id() {
		
	}
	
	public Id(String user_id, String password) {
		this.user_id = user_id;
		this.password = password;
	}
	
	//This method collect user id and password 
	
	public void collectId() {
		Scanner sc = new Scanner(System.in);
		boolean notFirst = false;
		do {
			if(notFirst && !ID_DataBase.isAwailable(user_id)) {
				System.out.println("\nUser name not awailable\n");
			}
			notFirst = true;
			System.out.print("Enter user Id    :");
			
			user_id = sc.nextLine();
		}while(!ID_DataBase.isAwailable(user_id));
		System.out.print("Enter password   :");
		password = sc.nextLine();
		
	}
	//returns Id object
	
	public Id getId() {
		return new Id(user_id,password);
	}
	
	//returns user id
	
	public String getUserId() {
		return user_id;
	}
	
	//check user_id and password and return true 
	//if it matches
	
	public boolean checkAccount(String user_id, String password) {
		if(user_id.equals(this.user_id)) {
			return checkPassword(password);
		}
		else {
			return false;
		}
	}
	
	//checks password and return true if matches
	
	public boolean checkPassword(String password) 
	{
		return password.equals(this.password) ;
	}
	
	//checks user id and returns true if matches
	
	public boolean checkUserID(String user_id) 
	{
		return user_id.equals(this.user_id) ;
	}
	
	//update password 
	
	public void updatePassword() 
	{
	   Scanner sc = new Scanner(System.in);
	   String newpassword;
	   System.out.println("Enter your previous password");
	   newpassword = sc.next();
	   if(checkPassword(newpassword))
	   {
		   System.out.println("Enter new password");
		   password = sc.next();
	   }
	   else
	   {
		   System.out.println("Incorrect Password");
	   }
	  
	}

}
