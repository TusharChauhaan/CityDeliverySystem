package DataBase;

import Classes.Customer;
import java.time.LocalDate;

public class CustomerDataBase {
	   
	private static Customer customer[] = new Customer[10];
	
	{	
		customer[0] = new Customer("Arnav","Arnav123","Arnav Singh", "Rd Number 4B, Sector 18, Gandhinagar, Gujarat 382018", 9265858678l, 23.217780, 72.667277);
		customer[1] = new Customer("Pranav","Pranav123","Pranav Singh Rajput", "Green City, Sector 26, Gandhinagar, Gujarat 382027", 9265858613l, 23.255147, 72.638517);
		customer[2] = new Customer("Suresh","Suresh123","Suresh Pal", "K Rd, Green City, Sector 26, Gandhinagar, Gujarat 382026", 9265858996l, 23.259896, 72.641488);
		customer[3] = new Customer("Hitesh","Hitesh123","Hitesh Bhai Patel", "Sector 28 GIDC, Sector 28, Gandhinagar, Gujarat 382041", 9260058686l, 23.256569, 72.658944);
		customer[4] = new Customer("Ruchi","Ruchi123","Ruchi Gada", "Krishi Bhavan, 2nd Floor, B-Wing, Sector - 10 A, CH Rd, Gandhinagar, Gujarat 382010", 9265858116l, 23.214849, 72.650591);
		customer[5] = new Customer("Jignesh","Jignesh123","Jignesh Modi", "Service Rd, Infocity, Gandhinagar, Gujarat 382421", 9265222686l, 23.194350, 72.638759);
		customer[6] = new Customer("Rajesh","Rajesh123","Rajesh Gupta", "7J3H+94 Gandhinagar, Gujarat", 9265838686l, 23.253417, 72.627792);
		customer[7] = new Customer("Suvendra","Suvendra123","Suvendra Shah", "Sector 10A, Sector 10, Gandhinagar, Gujarat 382010", 9265851236l, 23.214078, 72.653869);
		customer[8] = new Customer("Bhadresh","Bhadresh123","Bhadresh mehta", "6PGJ+CC Chiloda, Gujarat", 9265899986l, 23.226040, 72.731065);
		customer[9] = new Customer("Krishna","Krishna123","Krishna Jain", "Randheja, Gujarat 382620", 9265854446l, 23.292676, 72.638558);	
	}
	
	public static Customer[] getCustomer()
	{
		return customer;
	}
	
	public static int generateID()
	{
		LocalDate d = LocalDate.now();
		int id = 10000*(Integer.parseInt(d.toString().substring(0,4)));
		return id + customer.length + 5000;
	}
	
	public static void addNewCustomer(Customer newcustomer)
	{
		Customer c[] = new Customer[customer.length+1];
		System.arraycopy(customer, 0, c, 0, customer.length);
		c[customer.length] = newcustomer;
		customer = c;
	}
	
	public static Customer getCustomerByUserID(String user_id) {
		
		for(int i=0;i<customer.length;i++) {
			if(customer[i].checkUserID(user_id)) {
				return customer[i];
			}
		}
		
		return null;
	}
	
}
