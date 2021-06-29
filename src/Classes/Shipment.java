package Classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import DataBase.ZonesData;

public class Shipment {
	
	private int ship_id;			//Shipment id
	private String date;			//date of Order placed
	private String time;			//time of Order placed
	private Customer sender;		//Sender details
	private Customer receiver;		//Receiver details
	private double weight;			//weight of the shipment
	private String item_type;       //Type of ordered item for example "book"
	private Zone source_zone;		//Nearest zone to sender
	private Zone destination_zone;  //Nearest zone to receiver
	private ArrayList<Integer> path;
	//Creates a object with provided data items
	
	public Shipment(int ship_id, Customer sender, Customer receiver, double weight, String item_type) {
		
		LocalTime time = LocalTime.now();
		LocalDate date = LocalDate.now();
		this.sender = sender;
		this.receiver = receiver;
		this.ship_id = ship_id;
		this.item_type = item_type;
		this.time = time.toString().substring(0, time.toString().lastIndexOf('.'));
		this.date = date.toString();
		this.weight = weight;
		preparePath();
	}
	
	//Prints some important details  
	
	public void showBasicDetails(int i) {
		System.out.println("---------------------------------------------------");
		System.out.println(i+".  Shipment Details");
		System.out.println("---------------------------------------------------");
		System.out.println("Shipment Id      : "+ship_id);
		System.out.println("Date of booking  : "+date);
		System.out.println("Item type        : "+item_type);
	}
	
	//Prints complete details of shipment
	
	public void showDetails() {
		System.out.println("---------------------------------------------------");
		System.out.println("Shipment Details");
		System.out.println("---------------------------------------------------");
		System.out.println("Shipment Id      : "+ship_id);
		System.out.println("Date of booking  : "+date);
		System.out.println("Time of booking  : "+time);
		System.out.println("Weight           : "+weight);
		System.out.println("Item type        : "+item_type);
		sender.showDetails("Sender");
		receiver.showDetails("Receiver");
		System.out.println("---------------------------------------------------");
	}
	
	//returns zone with minimum distance to coordinates x and y
	
	public Zone findNearestZone(double x ,double y, Zone zone[])
	{
		
		int min;
		int n = zone.length;
		double Distance[] = new double[n];
		
		//Calculating the distance of the coordinate from all the zones
		for(int i=0;i<n;i++)
		{
			Distance[i] = Math.sqrt(Math.pow((x-zone[i].getCoordinateX()),2) + 
					Math.pow((y-zone[i].getCoordinateY()),2));
		}
		
		//Finding the index of zone with minimum distance 
		min=0;
		
		for(int i=1; i<n; i++)
		{
			if(Distance[i]<Distance[min])
			{
				min=i;
			}
		}	
		
		return zone[min];
	}	

	public void preparePath() {
		
		source_zone = findNearestZone(sender.getCoordinateX(),sender.getCoordinateY(),ZonesData.getZones());
		destination_zone = findNearestZone(receiver.getCoordinateX(),receiver.getCoordinateY(),ZonesData.getZones());
		
		int start = 1+source_zone.getId()%100;
		int end = 1+destination_zone.getId()%100;
		
		path = PathFinder.getPath(start, end);
	}
	
	public void getPath(Zone z) {
		System.out.println(path);
		if(z == destination_zone) {
			System.out.println("\nFinal Destination \nDeliver Product...");
			return;
		}
		int index = 1 + z.getId()%100;
		for(int i=0;i<path.size();i++) {
			if(index == path.get(i)) {
				System.out.println("Send it to Zone-"+path.get(i+1));
				return;
			}
		}
		System.out.println("Moved to wrong zone");
	}
	
	public void upadtePath(Zone z) {
		int start = 1 + z.getId()%100;
		int end = 1+destination_zone.getId()%100;
		
		path = PathFinder.getPath(start, end);
		System.out.println("Path Updated Successfully...");
		getPath(z);
	}
	
	public Customer getSender() {
		return sender;
	}
	
	public Customer getReceiver() {
		return receiver;
	}
	
	public void setSender(Customer c) {
		sender = c;
	}

	public void getReceiver(Customer c) {
		receiver = c;
	}
}
