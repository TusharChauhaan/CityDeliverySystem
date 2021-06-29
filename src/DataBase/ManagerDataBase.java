package DataBase;

import java.time.LocalDate;
import Classes.Employee;
import Classes.Id;

public class ManagerDataBase {
	
	private static Employee manager[] = new Employee[10];
	private static ID_DataBase db = new ID_DataBase();
	private static Id id[] = ID_DataBase.getManagersID();
	
	{
		manager[0] = new Employee(20200000,id[0],"Shyam Mehta","Dorab Mehta",
				"Leela Mehta",'M',"date of birth",7014316242l,
				"Aadarsh Nagar SocietySector 24, Gandhinagar",10000);
		manager[1] = new Employee(20200001,id[1],"Aziz Gulzarilal Nanda","Gulzarilal Nanda","Ramlata Nanda",
				'M',"10/5/1980",6457643591l,"Parth society House no. 47-48Pethapur, Gandhinagar",10000);
		manager[2] = new Employee(20200002,id[2],"Dashrath Patel","Hetbhai Patel","Meenaben Patel",'M',
				"20/6/1980",6457622591l,"Sector 3B Sector 3, Gandhinagar",10000);
		manager[3] = new Employee(20200003,id[3],"Ajay Jadeja","Ravindra Jadeja","Heeraben Jadeja",'M',
				"8/6/1985",6498643591l,"sector 1c prime pgSector 1, Gandhinagar",10000);
		manager[4] = new Employee(20200004,id[4],"Nayan Mongia","Ramlal Mongia","Jeevlata Mongia",'M',
				"12/6/1989",4737643591l,"Sector 7CSector 7/B, Sector 7, Gandhinagar",10000);
		manager[5] = new Employee(20200005,id[5],"Hardik Pandya","Krunal Pandya","Daya Bhumik Pandya",'M',
				"19/8/1978",9087643591l,"Gujarat Knowledge Society Sector 10B, Sector 10, Gandhinagar",10000);
		manager[6] = new Employee(20200006,id[6],"Aman Parekh","Vinod Parekh","Asha Parekh",'M',
				"23/6/1980",8097643591l,"Panchshil Park Sarvodaynagar Society, Sector 21, Gandhinagar",10000);
		manager[7] = new Employee(20200007,id[7],"Axar Patel","Ravindra Patel","Ratna Patel",'M',
				"10/2/1978",9927643591l,"C Sector 12B, Gandhinagar",10000);
		manager[8] = new Employee(20200008,id[8],"Rahul Pathak","Narayan Pathak","Supriya Pathak",'M',
				"10/4/1978",8807643591l,"Sector 7/B Sector 7, Gandhinagar",10000);
		manager[9] = new Employee(20200009,id[9],"Himesh Pujara","Cheteshwar Pujara","Reema Pujara",'M',
				"19/8/1979",9217643591l,"GIDC Electronic Estate Sector 25, Gandhinagar",10000);
	}
			
	public static Employee[] getManagers() {
		return manager;
	}
	
	public static int generateID() {
		LocalDate d = LocalDate.now();
		int id = 10000*(Integer.parseInt(d.toString().substring(0,4)));
		return id + manager.length;
	}
	
	//search manager by user id
	
	public static Employee search(String user_id, String password) {
		for(int i=0;i<manager.length;i++) {
			if(manager[i].getID().checkAccount(user_id, password)) {
				return manager[i];
			}
		}
		return null;
	}
	
	public static void addNewManager(Employee n) {
		Employee z[] = new Employee[manager.length+1];
		System.arraycopy(manager, 0, z, 0, manager.length);
		z[manager.length] = n;
		manager = z;
	}
	
}
