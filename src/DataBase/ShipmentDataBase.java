package DataBase;

import java.time.LocalDate;

import Classes.Customer;
import Classes.Shipment;

public class ShipmentDataBase {
	
	private static CustomerDataBase c = new CustomerDataBase();
	private static Customer customer[] = CustomerDataBase.getCustomer();
	
	private static Shipment shipment[] = new Shipment[10];
	
	{
		shipment[0] = new Shipment(20203001,customer[0],customer[2], 22, "books");
		shipment[1] = new Shipment(20203002,customer[1],customer[2], 32, "books");
		shipment[2] = new Shipment(20203003,customer[0],customer[4], 29, "other");
		shipment[3] = new Shipment(20203004,customer[4],customer[8], 12, "kitchen items");
		shipment[4] = new Shipment(20203005,customer[6],customer[2], 10, "food items");
		shipment[5] = new Shipment(20203006,customer[7],customer[5], 17, "stationary items");
		shipment[6] = new Shipment(20203007,customer[3],customer[6],  8, "books");
		shipment[7] = new Shipment(20203008,customer[0],customer[9], 27, "electronics");
		shipment[8] = new Shipment(20203009,customer[7],customer[2], 25, "books");
		shipment[9] = new Shipment(20203010,customer[3],customer[9], 35, "medicines");
		
		//shipment[0].setSender(c.getCustomerByUserID(shipment[0].getSender().getUserId()));
	}
	
	public static Shipment[] getShipment()
	{
		return shipment;
	}
	
	public static Shipment getShipment(int id) {
		if((id/1000)%10 == 3) {
			if(id%1000 < shipment.length) {
				return shipment[(id%1000) - 1];
			}
		}
		return null;
	}
	
	public static int generateID()
	{
		LocalDate d = LocalDate.now();
		int id = 10000*(Integer.parseInt(d.toString().substring(0,4)));
		return id + shipment.length + 3000;
	}
	
	public static void addNewShipment(Shipment newshipment)
	{
		Shipment s[] = new Shipment[shipment.length+1];
		System.arraycopy(shipment, 0, s, 0, shipment.length);
		s[shipment.length] = newshipment;
		shipment = s;
	}

}
