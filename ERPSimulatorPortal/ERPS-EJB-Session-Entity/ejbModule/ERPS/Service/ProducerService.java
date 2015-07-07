


package ERPS.Service;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.persistence.*;
import javax.ejb.Stateless;

import ERPS.Entity.*;

@Stateless
public class ProducerService {
    @PersistenceContext(unitName = "ERPSimDB")
	EntityManager em;
   
       
    public List<List<String>> viewpinventory(String producername) {

    	System.out.println("3");
		List<List<String>> InventoryDetails = new ArrayList<List<String>>();
		 
		String queryString = "select * from Inventory where producername = '" + producername + "'" + "";
		System.out.println("4"); 
		List<InventoryEntity> inventorylist;
		System.out.println("5");
		Query query = em.createNativeQuery(queryString, InventoryEntity.class);
		System.out.println("6");
		inventorylist = query.getResultList();
		System.out.println("7");
		if(!inventorylist.isEmpty())
		{
			System.out.println("8");
			int size = inventorylist.size();
			
			try {
				System.out.println("9");
			for(int i = 0; i< size ; i++)
			{
				System.out.println("10");
				InventoryEntity ie = new InventoryEntity();
				ie = inventorylist.get(i);
				System.out.println("11");				
			String prodid = String.valueOf(ie.getProdid());
			System.out.println("12");
			String productname = ie.getProdname();
			System.out.println("13");
			String iquant = String.valueOf(ie.getIquantity());
			System.out.println("14");
			producername = ie.getProducername();
			System.out.println("15");
			
			List<String> inventory = new ArrayList<String>();
			System.out.println("16");
			inventory.add(prodid);
			System.out.println("17");
			inventory.add(productname);
			System.out.println("18");
			inventory.add(iquant);
			System.out.println("19");
			inventory.add(producername);
			System.out.println("20");
			
			InventoryDetails.add(inventory);
			System.out.println("21");
			}
			}
			catch(Exception e)
	    	{
				System.out.println("22");
	    		System.out.println(e);
	    		
	    	}
			System.out.println("23");
			return InventoryDetails;
		
		}
		
		
		else return InventoryDetails;
		
	}
	
public String updateinventory(String prodname, long iquantity,String producername)
		{
		      Query query = em.createNativeQuery
				
				("update Inventory set iquantity = " + "'" + iquantity + "'" + 
									 " where prodname = " + "'"+ prodname +"'"+ " and producername =" +"'"+ producername +"'"+ ""
						, InventoryEntity.class);
		
		try
		{
		query.executeUpdate();
		em.flush();

		}
		catch(Exception e)
		{
			return "fail";
		}
		
		return "success";

    }
}


					
	
	
