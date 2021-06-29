package Main;

import DataBase.*;
import Classes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Execution {
	
	Id city_manager = new Id("Bhavin","Bhavin123");
	
	static Scanner sc = new Scanner(System.in);
    static CustomerDataBase cdb = new CustomerDataBase();
    static ManagerDataBase mdb = new ManagerDataBase();
	static ZonesData zdb = new ZonesData();
	static PathFinder p = new PathFinder();
	static ShipmentDataBase sdb = new ShipmentDataBase();
	
	public static void main(String[] args) {
		
		System.out.println("\n\t\tWellcome to our company\n");
		MainUI();
		//ArrayList<Integer> str = PathFinder.getPath(5,10);
		//System.out.println(str);
	}
	
	public static void MainUI() {
		int ch=0;
		//String user_id, password;
		System.out.println("===================================================");
		System.out.println("1. Login for Consumer");
		System.out.println("2. Login for Zone Manager");
		System.out.println("3. Login for City Consumer");
		System.out.println("4. Exit");
		System.out.print("Enter your choice : ");
		try {
			ch = sc.nextInt();
		}catch(Exception e) {
			System.out.println("Please Enter a integer no !");
			MainUI();
		}
		switch(ch) {
		case 1:
			LoginCustomerUI();
			MainUI();
			break;
		case 2:
			LoginForZoneManager();
			MainUI();
			break;
		case 3:
			LoginCityManager();
			MainUI();
			break;
		case 4:
			System.exit(0);
			break;
		default :
			System.out.println("Invalid Choice");
			MainUI();
		}
	}
	
	public static void LoginCustomerUI() {
		int ch=0;
		String user_id, password;
		System.out.println("===================================================");
		System.out.println("1. Login");
		System.out.println("2. Sign up");
		System.out.println("3. Back");
		System.out.println("4. Exit");
		System.out.print("Enter your choice : ");
		try {
			ch = sc.nextInt();
		}catch(Exception e) {
			System.out.println("Please enter a integer no !");
			LoginCustomerUI();
		}
		System.out.println("---------------------------------------------------");
		
		switch(ch) {
		case 1:
			System.out.print("\nEnter your User id   : ");
			user_id = sc.next();
			System.out.print("Enter your Password  : ");
			password = sc.next();
			Customer c = CustomerDataBase.getCustomerByUserID(user_id);
			if(c == null) {
				System.out.println("\nInvalid user id");
				hold();
				LoginCustomerUI();
			}
			if(c.checkAccount(user_id, password)) {
				CustomerUI(c);
			}else {
				System.out.println("Incorrect user id or password");
				LoginCustomerUI();
			}
			
			hold();
			
			LoginCustomerUI();
			break;
		case 2:
			try {
				Customer n = new Customer();
				CustomerDataBase.addNewCustomer(n);
			}catch(Exception e) {
				System.out.println("Incorrect Data format!");
			}
			
			hold();
			
			LoginCustomerUI();
			break;
		case 3:
			MainUI();
			break;
		case 4:
			System.exit(0);
			break;
		default :
			System.out.println("Invalid Choice");
			hold();
			LoginCustomerUI();
		}
	}
	
	public static void CustomerUI(Customer c) {
		int ch=0;
		System.out.println("===================================================");
		System.out.println("\t\tHello Mr/Mrs "+c.getName());
		System.out.println("1. Profile");
		System.out.println("2. Update Password");
		System.out.println("3. Book Shipment");
		System.out.println("4. Cancel Shipment");
		System.out.println("5. Show my orders");
		System.out.println("6. Back");
		System.out.println("7. Exit");
		System.out.print("Enter your choice : ");
		try {
			ch = sc.nextInt();
		}catch(Exception e) {
			System.out.println("Please Enter a integer no !");
			CustomerUI(c);
		}
		System.out.println("---------------------------------------------------");
		
		switch(ch) {
		case 1:
			c.showDetails("My");
			hold();
			CustomerUI(c);
			break;
		case 2:
			c.updatePassword();
			hold();
			CustomerUI(c);
			break;
		case 3:
			try {
				c.createShipment();
			} catch (Exception e) {
				System.out.println(e);
			}
			hold();
			CustomerUI(c);
			break;
		case 4:
			try {
				c.cancelOrder();
			} catch (Exception e) {
				System.out.println("No order with this no!");
			}
			hold();
			CustomerUI(c);
			break;
		case 5:
			System.out.println("\t\tYour Orders");
			c.showMyOrders();
			hold();
			CustomerUI(c);
			break;
		case 6:
			LoginCustomerUI();
			break;
		case 7:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Choice");
			hold();
			CustomerUI(c);	
		}
	}
	
	public static void LoginForZoneManager() {
		System.out.println("===================================================");
		System.out.print("User Id          : ");
		sc.nextLine();
		String user_id = sc.nextLine();
		System.out.print("Password         : ");
		String password = sc.nextLine();
		Employee manager = ManagerDataBase.search(user_id, password);
		if(manager == null) {
			System.out.println("\nInvalid user id or password\n");
			LoginForZoneManager();
		}else {
			ZoneUI(manager);
		}
	}
	
	public static void ZoneUI(Employee manager) {
		
		Zone z = ZonesData.getZoneByManager(manager);
		System.out.println("===================================================");
		System.out.println("\t\t"+z.getName());
		System.out.println("===================================================");
		System.out.println("1. Check Shipment");
		System.out.println("2. Create New Path");
		System.out.println("3. Back");
		System.out.println("4. Exit");
		System.out.print("Enter your choice  : ");
		int ch = sc.nextInt();
		int ship_id;
		Shipment s;
		switch(ch) {
		case 1:
			System.out.print("Shipment Id  : ");
			ship_id = sc.nextInt();
			s = ShipmentDataBase.getShipment(ship_id);
			if(s == null) {
				System.out.println("\nShipment not found\n");
			}else {
				s.getPath(z);
			}
			hold();
			ZoneUI(manager);
			break;
		case 2:
			System.out.print("Shipment Id  : ");
			ship_id = sc.nextInt();
			s = ShipmentDataBase.getShipment(ship_id);
			if(s == null) {
				System.out.println("\nShipment not found\n");
			}else {
				s.upadtePath(z);
			}
			hold();
			ZoneUI(manager);
			break;
		case 3:
			MainUI();
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice");
			hold();
			ZoneUI(manager);
		}
	}
	
	public static void LoginCityManager() {
		System.out.println("This part is not implemented yet");
		MainUI();
	}

	public static void hold() {
		System.out.println("\nPress Enter to continue");
		sc.nextLine();
		sc.nextLine();
	}

}
