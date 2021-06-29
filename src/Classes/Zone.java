package Classes;

import java.util.*;

import DataBase.DeliveryBoyDataBase;
import DataBase.ID_DataBase;
import DataBase.ManagerDataBase;
import DataBase.ZonesData;

public class Zone {
	
	private int id;
	private String Name;
	private String address;
	private double X;
	private double Y;
	private Employee manager;
	private Employee delivery_boy;

	//Create object with passed data items
	
	public Zone(String Name, String address, int id ,double X ,double Y, 
			Employee manager, Employee delivery_boy) {
		this.address = address;
		this.manager = manager;
		this.delivery_boy = delivery_boy;
		this.id = id;
		this.X = X;
		this.Y = Y;
		this.Name = Name;
	}
	
	//Collect data from user and create a object
	
	public Zone() {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------------------------------------------------");
		System.out.println("Enter Zone Details");
		System.out.println("---------------------------------------------------");
		System.out.print("Name          : ");
		Name = sc.nextLine();
		System.out.print("Address       : ");
		address = sc.nextLine();
		System.out.print("Coordinates   : ");
		System.out.print("X   : ");
		X = sc.nextDouble();
		System.out.print("Y   : ");
		Y = sc.nextDouble();
		System.out.println("\nEnter Manager's Details\n");
		manager = new Employee(ManagerDataBase.generateID());
		System.out.println("\nEnter Delivery Boy's Details\n");
		delivery_boy = new Employee(DeliveryBoyDataBase.generateID());
		id = 2600 + ZonesData.getSize();
		ManagerDataBase.addNewManager(manager);
		ID_DataBase.addNewManagersID(manager.getID());
	}
	
	//Prints all details of the Zone
	
	public void showZone() {
		System.out.println("---------------------------------------------------");
		System.out.println("Zone Details");
		System.out.println("---------------------------------------------------");
		System.out.println("Name          : "+Name);
		System.out.println("Id            : "+id);
		System.out.println("Address       : "+address);
		System.out.println("Manager       : "+manager.getName());
		System.out.println("Delivery Boy  : "+delivery_boy.getName());
	}
	
	public double getCoordinateX() {
		return X;
	}
	
	public double getCoordinateY() {
		return Y;
	}
	
	public boolean matchZone(Employee manager) {
		return manager.equals(this.manager);
	}
	
	public String getName() {
		return Name;
	}
	
	public int getId() {
		return id;
	}
}
