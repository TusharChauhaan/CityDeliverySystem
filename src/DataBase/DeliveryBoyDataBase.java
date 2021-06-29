package DataBase;

import java.time.LocalDate;
import Classes.Employee;
import Classes.Id;

public class DeliveryBoyDataBase{

  private static Employee DeliveryBoy[] = new Employee[10];
  private static ID_DataBase db = new ID_DataBase ();
  private static Id id[] = ID_DataBase.getDeliveryBoyID ();

  {

	    DeliveryBoy[0] =
	      new Employee (20200000, id[0], "Ankush Kumar", "Ram Kumar",
			    "Ramvati Sinha", 'M', "25/02/2002",9128985987l, "Gandhinagar",
			    10000);

	    DeliveryBoy[1] =
	      new Employee (20200001, id[1], "Jasabhai Barad", "Prakash Brahmbhatt",
			    "Ramya AKA Divya", 'M', "1/12/1990", 9412384672l, "Gandhinagar",
			    10000);

	    DeliveryBoy[2] =
	      new Employee (20200002, id[2], "Fatehsinghrao Gaekwad", "Jaisukh lal Hathi",
			    "Mimi Chakraborty", 'M', "1/12/1996", 93274118268l, "Gandhinagar", 10000);

	    DeliveryBoy[3] =
	      new Employee (20200003, id[3], "Ranjitsinh Pratapsinh Gaekwad", "Somjibhai Damor",
			    "Nusrat Jahan", 'M', "5/1/1996", 9781354672l, "Gandhinagar", 10000);

	    DeliveryBoy[4] =
	      new Employee (20200004, id[4], "Anna Akhmatova", "Anna Andreyenva",
			    "Shruti Choudhary", 'M', "6/12/1996", 9451673257l, "Gandhinagar", 10000);

	    DeliveryBoy[5] =
	      new Employee (20200005, id[5], "Susan Ashton", "Susan Rae Hill",
			    "Jyoti Mirdha", 'M', "6/11/1999", 9412736578l, "Gandhinagar", 10000);

	    DeliveryBoy[6] =
	      new Employee (20200006, id[6], "Khandubhai Kasanji Desai", "Kanaiyalal Maneklal Munshi",
			    "Priyanka Gandhi", 'M', "8/9/1996", 9412358464l, "Gandhinagar", 10000);

	    DeliveryBoy[7] =
	      new Employee (20200007, id[7], "Raghavji Patel", "Parsottam Ukabhai Sabariya",
			    "Nagma", 'M', "5/5/1859", 9412378421l, "Gandhinagar",
			    100);

	    DeliveryBoy[8] =
	      new Employee (20200008, id[8], "Mahendrasinh Vaghela", "Harisinh Pratapsinh Chavda",
			    "Priya Dutt", 'M', "6/11/1836",9412378465l, "Gandhinagar", 100);

	    DeliveryBoy[9] =
	      new Employee (20200009, id[9], "Vallabh Dharaviya", "Violet Alva",
			    "Chhavi Rajawat", 'M', "5/1/1896",9874125745l, "Gandhinagar",
			    10000);

	  }

     
  public static Employee[] getDeliveryBoys ()
  {
    return DeliveryBoy;
  }

  public static int generateID ()
  {
    LocalDate d = LocalDate.now ();
    int id = 10000 * (Integer.parseInt (d.toString ().substring (0, 4)));
    return id + DeliveryBoy.length + 1000;
  }

  public static void addNewDeliveryBoy (Employee n)
  {

    Employee z[] = new Employee[DeliveryBoy.length + 1];
    System.arraycopy (DeliveryBoy, 0, z, 0, DeliveryBoy.length);
    z[DeliveryBoy.length] = n;
    DeliveryBoy = z;

  }

}

