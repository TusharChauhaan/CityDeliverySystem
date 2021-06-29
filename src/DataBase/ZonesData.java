package DataBase;

import Classes.Zone;
import Classes.Employee;

public class ZonesData {
	
	private static int size = 10;
	private static ManagerDataBase mdb = new ManagerDataBase();
	private static Employee manager[] = mdb.getManagers();
	private static DeliveryBoyDataBase dbdb = new DeliveryBoyDataBase();
	private static Employee delivery_boy[] = dbdb.getDeliveryBoys();
	private static Zone zone[] = new Zone[10];
	
	{
		zone[0] = new Zone("Zone-1","Sector 2, Gandhinagar",2600,23.201553,72.640793,manager[0],delivery_boy[0]);
		zone[1] = new Zone("Zone-2","Sector 3, Gandhinagar",2601,23.207973,72.627358,manager[1],delivery_boy[1]);
		zone[2] = new Zone("Zone-3","Sector 6, Gandhinagar",2602,23.215843,72.632045,manager[2],delivery_boy[2]);
		zone[3] = new Zone("Zone-4","Sector 7, Gandhinagar",2603,23.208969,72.644979,manager[3],delivery_boy[3]);
		zone[4] = new Zone("Zone-5","Sector 10, Gandhinagar",2604,23.218279,72.659388,manager[4],delivery_boy[4]);
		zone[5] = new Zone("Zone-6","Sector 12, Gandhinagar",2605,23.227749,72.639539,manager[5],delivery_boy[5]);
		zone[6] = new Zone("Zone-7","Sector 24, Gandhinagar",2606,23.244824,72.641600,manager[6],delivery_boy[6]);
		zone[7] = new Zone("Zone-8","Sector 22, Gandhinagar",2607,23.236829,72.654318,manager[7],delivery_boy[7]);
		zone[8] = new Zone("Zone-9","Sector 29, Gandhinagar",2608,23.239700,72.663066,manager[8],delivery_boy[8]);
		zone[9] = new Zone("Zone-10","Sector 27, Gandhinagar",2609,23.251131,72.645717,manager[9],delivery_boy[9]);
	}
	
	public static Zone [] getZones() {
		return zone;
	}
	
	public static int getSize() {
		return size;
	}
	
	public static void addNewZone(Zone newzone) {
		Zone z[] = new Zone[zone.length+1];
		System.arraycopy(zone, 0, z, 0, zone.length);
		z[zone.length] = newzone;
		zone = z;
		size++;
	}
	//return zone where provided manager is posted
	public static Zone getZoneByManager(Employee manager) {
		for(int i=0;i<zone.length;i++) {
			if(zone[i].matchZone(manager)) {
				return zone[i];
			}
		}
		return null;
	}
}
