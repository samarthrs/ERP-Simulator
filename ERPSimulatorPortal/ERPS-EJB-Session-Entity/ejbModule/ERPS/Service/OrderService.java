package ERPS.Service;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;
import javax.ejb.Stateless;

import ERPS.Entity.*;

@Stateless
public class OrderService {
    @PersistenceContext(unitName = "ERPSimDB")
	EntityManager em;

    public List<List<String>> oset(String consumername, String prodname, long quantity, String odate,String producername) {
		
    	System.out.println("2");
		OrderEntity newEntity = new OrderEntity();
		System.out.println("3");
        String orderStatus="Order Requested";
        System.out.println("4");
		newEntity.setConsumername(consumername);
		newEntity.setProdname(prodname);
		newEntity.setQuantity(quantity);
		newEntity.setOdate(odate);
		newEntity.setProducername(producername);
		newEntity.setOstatus(orderStatus);
		 System.out.println("5");
		List<List<String>> orderdetails = new ArrayList<List<String>>();
		
		try
		{
			 System.out.println("6");
		em.persist(newEntity);
		 System.out.println("7");
		em.flush();
		 System.out.println("8");
		}
		catch(EntityExistsException e)
		{
			 System.out.println("9");
			System.out.println(e);
			return orderdetails;
		}
		
		catch(ConstraintViolationException e)
		{
			 System.out.println("10");
			System.out.println(e);
			return orderdetails;
		}
		
		catch(Exception e)
		{
			System.out.println("11");
			System.out.println(e);
			return orderdetails;
		}
		System.out.println("12");
		
		List<String> orderdetail = new ArrayList<String>();

		  orderdetail.add(String.valueOf(newEntity.getOid()));
		  orderdetail.add(newEntity.getConsumername());
		  orderdetail.add(newEntity.getProdname());
		  orderdetail.add(newEntity.getProducername());
		  orderdetail.add(String.valueOf(newEntity.getOdate()));
		  orderdetail.add(newEntity.getOstatus());
		
		  System.out.println("13"+String.valueOf(newEntity.getOid())+newEntity.getConsumername()+newEntity.getProdname()+newEntity.getProducername()+String.valueOf(newEntity.getOdate())+newEntity.getOstatus());

		  orderdetails.add(orderdetail);
		  
		  return orderdetails;
	}
    	
    	
    	public List<List<String>> checkstatus(long oid) {
	    
		 List<List<String>> chkorder = new ArrayList<List<String>>();
		
		 List<OrderEntity> chkorderlist;
		 
		 Query query = em.createNativeQuery
				("select * from Orders where OID = '" + oid + "'" , 
						OrderEntity.class);
		chkorderlist = query.getResultList();
		
		if(!chkorderlist.isEmpty())
		{
			int size = chkorderlist.size();
				
			for(int i = 0; i< size ; i++)
			{
				OrderEntity oe = new OrderEntity();
				oe = chkorderlist.get(i);
				//System.out.println("13");   				
			String orderid = String.valueOf(oe.getOid());
			String prodname = oe.getProdname();;
			//System.out.println("Sam is here");
			String quant = String.valueOf(oe.getQuantity());
			//System.out.println("Sam is here too");
			String odate = oe.getOdate();
			String ostatus = oe.getOstatus();
			String producername = oe.getProducername();
			String consumername = oe.getConsumername();
			//System.out.println("14"+uid+username+pwd+usertype);
			List<String> order = new ArrayList<String>();
			order.add(orderid);
			order.add(prodname);
			order.add(quant);
			order.add(odate);
			order.add(ostatus);
			order.add(producername);
			order.add(consumername);
			//System.out.println("15");
			chkorder.add(order);
			//System.out.println("16");
			}
	
		}

		
		return chkorder;
    }
    
    	 public List<List<String>> viewporder(String producername) {

    			
     		List<List<String>> orders = new ArrayList<List<String>>();
     		 
     		List<OrderEntity> orderlist;
     		
     		
     		Query query = em.createNativeQuery("select * from Orders where producername like '" + producername + "'", OrderEntity.class);
     		
     		orderlist = query.getResultList();
     		
     		if(!orderlist.isEmpty())
     		{
     			int size = orderlist.size();
     			
     			try {
     				
     			for(int i = 0; i< size ; i++)
     			{
     				OrderEntity oe = new OrderEntity();
     				oe = orderlist.get(i);
     			    				
     			String oid = String.valueOf(oe.getOid());
     			String productname = oe.getProdname();
     			String quantity = String.valueOf(oe.getQuantity());
     			String odate = String.valueOf(oe.getOdate());
     			String ostatus = oe.getOstatus();
     			String consumername=oe.getConsumername();
     			producername = oe.getProducername();
     			
     			List<String> order = new ArrayList<String>();

     			order.add(oid);
     			order.add(consumername);
     			order.add(productname);
     			order.add(producername);
     			order.add(odate);
     			order.add(ostatus);
     			order.add(quantity);
     			
     			orders.add(order);
     			}
     			}
     			catch(Exception e)
     	    	{
     	    		System.out.println(e);
     	    		
     	    	}
     			
     			return orders;
     		
     		}
     		
     		
     		else return orders;
     	}

    
    
    
    
    
    public int cancel(long oid) {		
	    
		 Query query = em.createNativeQuery
				("DELETE from Orders where oid like '" + oid + "'" , 
						OrderEntity.class);
		int deleted = query.executeUpdate ();
		return deleted;
   }
    
    public String oupdate(long oid, String prodname, String producername, long quantity) {		
    	
    	Query query = em.createNativeQuery
				("update Orders set quantity = " + "'" + quantity + "'" + " ," + 
									 " producername = " + "'" + producername + "'" + " ," + 
									 " prodname = " + "'" + prodname + "'" +
									 " where oid = "  + "'" + oid + "'"
						, OrderEntity.class);
		
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
		
    public String updateorderstatus(long oid) {

    	String ost="Order Despatched";
    	System.out.println(oid);
    	Query query = em.createNativeQuery
				("update Orders set ostatus = " + "'" + ost + "'" +
									 " where oid = "  + "'" + oid + "'"+""
						, OrderEntity.class);
		
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
		
			
    public List<List<String>> existingorderschk (String consumername) {
	    
		 List<List<String>> exorderchk = new ArrayList<List<String>>();
		
		 List<OrderEntity> exorderchklist;
		 
		 Query query = em.createNativeQuery
				("select * from Orders where consumername =" +"'"+consumername+"'"+"" , 
						OrderEntity.class);
		 exorderchklist = query.getResultList();
		
		if(!exorderchklist.isEmpty())
		{
			int size = exorderchklist.size();
				
			for(int i = 0; i< size ; i++)
			{
				OrderEntity eoce = new OrderEntity();
				eoce = exorderchklist.get(i);
				//System.out.println("13");   				
			String orderid = String.valueOf(eoce.getOid());
			String prodname = eoce.getProdname();;
			//System.out.println("Sam is here");
			String quant = String.valueOf(eoce.getQuantity());
			//System.out.println("Sam is here too");
			String odate = eoce.getOdate();
			String ostatus = eoce.getOstatus();
			String producername = eoce.getProducername();
			String consumer = eoce.getConsumername();
			//System.out.println("14"+uid+username+pwd+usertype);
			List<String> exorders = new ArrayList<String>();
			exorders.add(orderid);
			exorders.add(prodname);
			exorders.add(quant);
			exorders.add(odate);
			exorders.add(ostatus);
			exorders.add(producername);
			exorders.add(consumer);
			//System.out.println("15");
			exorderchk.add(exorders);
			//System.out.println("16");
			}
	
		}
		
		return exorderchk;
   }
    
 

	 public List<List<String>> conorderdisplay(String consumername) {

		
 		List<List<String>> orders = new ArrayList<List<String>>();
 		 
 		List<OrderEntity> orderlist;
 		
 		
 		Query query = em.createNativeQuery("select * from Orders where consumername like '" + consumername + "'", OrderEntity.class);
 		
 		orderlist = query.getResultList();
 		
 		if(!orderlist.isEmpty())
 		{
 			int size = orderlist.size();
 			
 			try {
 				
 			for(int i = 0; i< size ; i++)
 			{
 				OrderEntity oe = new OrderEntity();
 				oe = orderlist.get(i);
 			    				
 			String oid = String.valueOf(oe.getOid());
 			String productname = oe.getProdname();
 			String quantity = String.valueOf(oe.getQuantity());
 			String odate = String.valueOf(oe.getOdate());
 			String ostatus = oe.getOstatus();
 			//String consumername=oe.getConsumername();
 			String producername = oe.getProducername();
 			
 			List<String> order = new ArrayList<String>();

 			order.add(oid);
 			//order.add(consumername);
 			order.add(productname);
 			order.add(producername);
 			order.add(odate);
 			order.add(ostatus);
 			order.add(quantity);
 			
 			orders.add(order);
 			}
 			}
 			catch(Exception e)
 	    	{
 	    		System.out.println(e);
 	    		
 	    	}
 			
 			return orders;
 		
 		}
 		
 		
 		else return orders;
 	}
	 
	 public List<List<String>> proorderdisplay(String producername) {

			
  		List<List<String>> orders = new ArrayList<List<String>>();
  		 
  		List<OrderEntity> orderlist;
  		
  		
  		Query query = em.createNativeQuery("select * from Orders where producername like '" + producername + "'", OrderEntity.class);
  		
  		orderlist = query.getResultList();
  		
  		if(!orderlist.isEmpty())
  		{
  			int size = orderlist.size();
  			
  			try {
  				
  			for(int i = 0; i< size ; i++)
  			{
  				OrderEntity oe = new OrderEntity();
  				oe = orderlist.get(i);
  			    				
  			String oid = String.valueOf(oe.getOid());
  			String productname = oe.getProdname();
  			String quantity = String.valueOf(oe.getQuantity());
  			String odate = String.valueOf(oe.getOdate());
  			String ostatus = oe.getOstatus();
  			String consumername=oe.getConsumername();
  			//String producername = oe.getProducername();
  			
  			List<String> order = new ArrayList<String>();

  			order.add(oid);
  			order.add(consumername);
  			order.add(productname);
  			//order.add(producername);
  			order.add(odate);
  			order.add(ostatus);
  			order.add(quantity);
  			
  			orders.add(order);
  			}
  			}
  			catch(Exception e)
  	    	{
  	    		System.out.println(e);
  	    		
  	    	}
  			
  			return orders;
  		
  		}
  		
  		
  		else return orders;
  	}




    
    
}


					
	
	
