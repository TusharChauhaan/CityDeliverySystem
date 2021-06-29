package Classes;

import java.util.Scanner;
import DataBase.CustomerDataBase;
import DataBase.ShipmentDataBase;

public class Customer extends Id{
	
	private String Name;
	private String address;
	private long contact_no;
	private double X;
	private double Y;
	//private Id id = new Id();
	private Shipment myOrder[] = new Shipment[0];

	public Customer(String user_id, String password, String Name, String address, long contact_no, double X, double Y) 
	{
		super(user_id,password);
		this.X=X;
	    this.Y=Y;
	    this.contact_no = contact_no;
	    this.address= address;
	    this.Name = Name;
	}
	
	//collect customers data from user
	
	public Customer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------------------------------");
		System.out.println("\t\tEnter Your Details");
		System.out.println("---------------------------------------------------");
		collectId();
		System.out.print("Name             : ");
		Name = sc.nextLine();
		System.out.print("Contact No       : ");
		contact_no = sc.nextLong();
		while(contact_no/10000000000l < 6 && contact_no/10000000000l > 9) {
			System.out.println("Not a valid phone no!\nEnter a valid contact no");
			System.out.print("Contact No       : ");
			contact_no = sc.nextLong();
		}
		System.out.println("\nLocation Coordinates");
		System.out.print("X     : ");
		X = sc.nextDouble();
		System.out.print("Y     : ");
		Y = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter Address");
		address = Helper.collectAddress();
	}
	
	//this method will create or book a shipment and 
	//Adds that to list
	
	public void createShipment() throws Exception{
		Scanner sc = new Scanner(System.in);
		int ship_id = 0;
		Customer receiver = null;
		double weight;
		String item_type;
		System.out.println("---------------------------------------------------");
		System.out.println("Enter Shipment Details");
		System.out.println("---------------------------------------------------");
		System.out.print("Receiver's User Id  : ");
		String user_id = sc.next();
		System.out.print("Weight              : ");
		weight = sc.nextDouble();
		System.out.print("Item Type           : ");
		item_type = sc.next();
		receiver = CustomerDataBase.getCustomerByUserID(user_id);
		while(receiver == null) {
			System.out.println("No customer with this user id \nEnter correct user id");
			System.out.print("Receiver's User Id  : ");
			user_id = sc.next();
			receiver = CustomerDataBase.getCustomerByUserID(user_id);
		}
		ship_id = ShipmentDataBase.generateID();
		Shipment order = new Shipment(ship_id,this,receiver, weight, item_type);
		addOrder(order);
		System.out.println("\nYour Shipment Booked Successfully");
		
	}
	
	//this method adds order to list
	
	private void addOrder(Shipment order) {
		Shipment s[] = new Shipment[myOrder.length+1];
		System.arraycopy(myOrder, 0, s, 0, myOrder.length);
		s[myOrder.length] = order;
		myOrder = s;
		ShipmentDataBase.addNewShipment(order);
	}
	
	//This method will show all orders related to customer
	
	public void showMyOrders() {
		if(myOrder.length == 0) {
			System.out.println("Did't Found any Order");
			return;
		}
		for(int i =0;i<myOrder.length;i++) {
			myOrder[i].showBasicDetails(i+1);
		}
	}
	
	//This method deletes choosen order from the list
	
	public void cancelOrder() throws Exception{
		Scanner sc = new Scanner(System.in);
		showMyOrders();
		System.out.print("Enter which order you want to cancel : ");
		int ch = sc.nextInt();
		myOrder[ch-1] = myOrder[myOrder.length-1];
		Shipment s[] = new Shipment[myOrder.length-1];
		System.arraycopy(myOrder, 0, s, 0, myOrder.length-1);
		myOrder = s;
	}
	
	//checks user id and password 
	//if it is matched then return true
	
	/*public boolean checkUser(String user_id, String password) {
		return id.checkAccount(user_id, password);
	}
	
	public boolean checkUser_ID(String user_id) {
		return id.checkUserID(user_id);
	}
	
	public void updatePassword() {
		id.updatePassword();
	}*/
	
	public double getCoordinateX() 
	{
	     return X;
	}

	public double getCoordinateY() 
	{
	     return Y;
	}
	
	//prints customer data
	
	public void showDetails(String s) {
		System.out.println("\n"+s+" Details      ");
		System.out.println("\nUser Id          : "+getUserId());
		System.out.println("Name             : "+Name);
		System.out.println("Contact No       : "+contact_no);
		System.out.println("Address          : "+address);
	}
	
	//returns name
	public String getName() {
		return Name;
	}
}
