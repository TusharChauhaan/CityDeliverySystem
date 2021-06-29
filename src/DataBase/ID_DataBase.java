package DataBase;

import Classes.Customer;
import Classes.Id;

public class ID_DataBase {
	
	private static Id managers_id[] = new Id[10];
	private static Id deliveryboy_id[] = new Id[10];
	private static Id consumer_id[] = new Id[10];
	
	{
		managers_id[0] = new Id("Shyam","Shyam123");
		managers_id[1] = new Id("Aziz","Aziz123");
		managers_id[2] = new Id("Dashrath","Dashrath123");
		managers_id[3] = new Id("Ajay","Ajay123");
		managers_id[4] = new Id("Nayan","Nayan123");
		managers_id[5] = new Id("Hardik","Hardik123");
		managers_id[6] = new Id("Aman","Aman123");
		managers_id[7] = new Id("Axar","Axar123");
		managers_id[8] = new Id("Rahul","Rahul123");
		managers_id[9] = new Id("Himesh","Himesh123");
	}
	
	{
		deliveryboy_id[0] = new Id("Ankush","Ankush123");
		deliveryboy_id[1] = new Id("Jasabhai","Jasabhai123");
		deliveryboy_id[2] = new Id("Fatehsingrao","Fatehsingrao123");
		deliveryboy_id[3] = new Id("Ranjit","Ranjit123");
		deliveryboy_id[4] = new Id("Anna","Anna123");
		deliveryboy_id[5] = new Id("Susan","Susan123");
		deliveryboy_id[6] = new Id("Khandubhai","Khandubhai123");
		deliveryboy_id[7] = new Id("Raghav","Raghav123");
		deliveryboy_id[8] = new Id("Mahendra","Mahendra123");
		deliveryboy_id[9] = new Id("Vallabh","Vallabh123");
	}
	
	{
		Customer c[] = CustomerDataBase.getCustomer();
		for(int i=0;i<consumer_id.length;i++) {
			consumer_id[i] = c[i].getId();
		}
	}
	
	public static Id[] getManagersID() {
		return managers_id;
	}
	
	public static Id[] getDeliveryBoyID() {
		return deliveryboy_id;
	}
	
	public static Id[] getConsumerID() {
		return consumer_id;
	}
	
	public static void addNewManagersID(Id manager) {
		Id id[] = new Id[managers_id.length+1];
		System.arraycopy(managers_id, 0, id, 0, managers_id.length);
		id[managers_id.length] = manager;
		managers_id = id;
	}
	
	public static void addNewDeliveryBoyID(Id delivery_boy) {
		Id id[] = new Id[deliveryboy_id.length+1];
		System.arraycopy(deliveryboy_id, 0, id, 0, deliveryboy_id.length);
		id[deliveryboy_id.length] = delivery_boy;
		deliveryboy_id = id;
	}
	
	public static void addNewConsumerID(Id consumer) {
		Id id[] = new Id[consumer_id.length+1];
		System.arraycopy(consumer_id, 0, id, 0, consumer_id.length);
		id[consumer_id.length] = consumer;
		consumer_id = id;
	}
	
	//checks availability of user id 
	//returns true if it is available
	
	public static boolean isAwailable(String user_id) {
		
		for(int i=0 ; i<consumer_id.length ; i++) {
			if(consumer_id[i].checkUserID(user_id)) {
				return false;
			}
		}
		
		for(int i=0 ; i<deliveryboy_id.length ; i++) {
			if(deliveryboy_id[i].checkUserID(user_id)) {
				return false;
			}
		}
		
		for(int i=0 ; i<managers_id.length ; i++) {
			if(managers_id[i].checkUserID(user_id)) {
				return false;
			}
		}
		
		return true;
	}
	
}
