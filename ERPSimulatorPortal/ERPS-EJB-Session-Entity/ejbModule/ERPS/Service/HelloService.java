package ERPS.Service;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.ConstraintViolationException;

import ERPS.Entity.*;

import javax.ejb.Stateless;

import ERPS.Entity.HelloServiceEntity;

@Stateless
public class HelloService {
    @PersistenceContext(unitName = "ERPSimDB")
	EntityManager em;

	public String userName(String name, String password) {
		//System.out.println("8");
		HelloServiceEntity newEntity1 = new HelloServiceEntity();
		//System.out.println("9");
        String userType="Consumer";
		
		newEntity1.setUserName(name);
		newEntity1.setPassword(password);
		newEntity1.setUserType(userType);

		//System.out.println("10");
		try
		{
		//System.out.println("11");
		em.persist(newEntity1);
		//System.out.println("12");
		em.flush();
		//System.out.println("13");
		}
		catch(EntityExistsException e)
		{
			//System.out.println("14");
			System.out.println(e);
			return "Exists";
		}
		
		catch(ConstraintViolationException e)
		{
			//System.out.println("15");
			System.out.println(e);
			return "Exists";
		}
		
		catch(Exception e)
		{
			//System.out.println("16");
			System.out.println(e);
			return "Exists";
		}
		//System.out.println("17");
		
		String UserName = newEntity1.getUserName();
		//System.out.println("18"+UserName);
		return "ERP Consumer" + "Name =" + UserName;
	}
public String loginUser(String name, String password, String type) {
		
		//System.out.println("8");	
	    List<List<String>> logincred = new ArrayList<List<String>>();		//create list to hold query results
	    //System.out.println("9");
		try
		{
			List<HelloServiceEntity> loginlist;
			//System.out.println("10");
			Query query = em.createNativeQuery	//create query using this syntax
			("select * from Users where USERNAME like '" + name
			+ "'" +  " AND "+ "USERTYPE like '" + type + "'" + " and PASSWORD like '" + password + "'" 
			, HelloServiceEntity.class);
			
			loginlist = query.getResultList();;	//gets results from query and puts into a list of that object type
			//System.out.println("11");
			if(!loginlist.isEmpty())
			{
				int size = loginlist.size();
				//System.out.println("12");	
				for(int i = 0; i< size ; i++)
				{
					HelloServiceEntity hse = new HelloServiceEntity();
					hse = loginlist.get(i);
					//System.out.println("13");   				
				String uid = String.valueOf(hse.getUserid());
				String username = hse.getUserName();;
				String pwd = hse.getPassword();
				String usertype = hse.getUserType();
				//System.out.println("14"+uid+username+pwd+usertype);
				List<String> login = new ArrayList<String>();
				login.add(uid);
				login.add(username);
				login.add(pwd);
				login.add(usertype);
				//System.out.println("15");
				logincred.add(login);
				//System.out.println("16");
				}
		
			}
	
			if(!logincred.isEmpty())			//if user actually exists
			{
				//System.out.println("17");
				return "success";
			}
		}
		catch(Exception e)
		{
			//System.out.println("18");
		System.out.println(e);
			return "fail";
		}
		
		return "fail";	//return fail if user not found and handle appropriately in Backing Bean
		
	}

public List<List<String>> listcon() {

	
		List<List<String>> orders = new ArrayList<List<String>>();
		 
		List<HelloServiceEntity> orderlist;
		String a= "Consumer";
		
		Query query = em.createNativeQuery("select * from Users where usertype like '" + a + "'", HelloServiceEntity.class);
		
		orderlist = query.getResultList();
		
		if(!orderlist.isEmpty())
		{
			int size = orderlist.size();
			
			try {
				
			for(int i = 0; i< size ; i++)
			{
				HelloServiceEntity oe = new HelloServiceEntity();
				oe = orderlist.get(i);
			    				
			
			String u = oe.getUserName();
		
			
			List<String> order = new ArrayList<String>();

			order.add(u);
		//	order.add(consumername);
			//order.add(productname);
			//order.add(producername);
			//order.add(odate);
			//order.add(ostatus);
		//	order.add(quantity);
			
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


public EntityManager getEm() {
	return em;
}
public void setEm(EntityManager em) {
	this.em = em;
}
public List<List<String>> listpro() {

	
	List<List<String>> orders = new ArrayList<List<String>>();
	 
	List<HelloServiceEntity> orderlist;
	String a= "Producer";
	
	Query query = em.createNativeQuery("select * from Users where usertype like '" + a + "'", HelloServiceEntity.class);
	
	orderlist = query.getResultList();
	
	if(!orderlist.isEmpty())
	{
		int size = orderlist.size();
		
		try {
			
		for(int i = 0; i< size ; i++)
		{
			HelloServiceEntity oe = new HelloServiceEntity();
			oe = orderlist.get(i);
		    				
		
		String u = oe.getUserName();
	
		
		List<String> order = new ArrayList<String>();

		order.add(u);
	//	order.add(consumername);
		//order.add(productname);
		//order.add(producername);
		//order.add(odate);
		//order.add(ostatus);
	//	order.add(quantity);
		
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


public int delconsumer(String consumername) {		
    
	 Query query = em.createNativeQuery
			("DELETE from Users where username like " + "'"+ consumername + "'"+ " and usertype = 'Consumer'" + "", 
					HelloServiceEntity.class);
	int deleted = query.executeUpdate ();
	return deleted;
}


}
