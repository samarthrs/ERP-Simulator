/**
 * 
 */
package erps.osu;

/**
 * @author Samarth
 *
 */

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import ERPS.Service.HelloService;

public class AdminBean {
	
	@EJB 
	private HelloService helloService;
	
	
	
		private List<List<String>> con = new ArrayList<List<String>>();
	    private List<List<String>> pro = new ArrayList<List<String>>();
	    
		private String consumername;


		public HelloService getHelloService() {
			return helloService;
		}


		public void setHelloService(HelloService helloService) {
			this.helloService = helloService;
		}


		public List<List<String>> getCon() {
			return con;
		}


		public void setCon(List<List<String>> con) {
			this.con = con;
		}


		public List<List<String>> getPro() {
			return pro;
		}


		public void setPro(List<List<String>> pro) {
			this.pro = pro;
		}


		public String getConsumername() {
			return consumername;
		}


		public void setConsumername(String consumername) {
			this.consumername = consumername;
		}

		
		public String listpro() {
			
			pro = helloService.listpro();
			if(pro.isEmpty())
				{
				
				//System.out.println(orderdetailss.size());
				return "failp";
				}
			else
			{
				//System.out.println(orderdetailss.size());
				return "successp";}
			
		}



		public String listcon() {
			
			con = helloService.listcon();
			if(con.isEmpty())
				{
				
				//System.out.println(orderdetailss.size());
				return "failc";
				}
			else
			{
				//System.out.println(orderdetailss.size());
				return "successc";}
			
		}
		
	public String delconsumer() {
			
			int delcon = helloService.delconsumer(consumername);
			if(delcon==0)
				{
				
				//System.out.println(orderdetailss.size());
				return "faildelcon";
				}
			else
			{
				//System.out.println(orderdetailss.size());
				return "successdelcon";}
			
		}
	
	


	
}
