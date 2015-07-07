package erps.osu;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import erps.osu.RegisterBean;
import ERPS.Service.*;

public class OrderBean {
	
	@EJB 
	private OrderService orderservice;
	private HelloService helloservice;
	
	public HelloService getHelloservice() {
		return helloservice;
	}

	public void setHelloservice(HelloService helloservice) {
		this.helloservice = helloservice;
	}

	private ProducerService producerservice;
	private RegisterBean registerBean;
	
		public OrderService getOrderService() {
		return orderservice;
	}

	public void setOrderService(OrderService orderservice) {
		this.orderservice = orderservice;
	}
	
	private String prodname,producername,consumername;
	public String getConsumername() {
		return consumername;
	}

	public void setConsumername(String consumername) {
		this.consumername = consumername;
	}

	public List<List<String>> getAdmincon() {
		return admincon;
	}

	public void setAdmincon(List<List<String>> admincon) {
		this.admincon = admincon;
	}

	public List<List<String>> getAdminpro() {
		return adminpro;
	}

	public void setAdminpro(List<List<String>> adminpro) {
		this.adminpro = adminpro;
	}

	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getProducername() {
		return producername;
	}
	public void setProducername(String producername) {
		this.producername = producername;
	}
	public OrderService getOrderservice() {
		return orderservice;
	}

	public void setOrderservice(OrderService orderservice) {
		this.orderservice = orderservice;
	}

	public ProducerService getProducerservice() {
		return producerservice;
	}

	public void setProducerservice(ProducerService producerservice) {
		this.producerservice = producerservice;
	}


	public RegisterBean getRegisterBean() {
		return registerBean;
	}

	public void setRegisterBean(RegisterBean registerBean) {
		this.registerBean = registerBean;
	}

	public List<List<String>> getOrderdetailss() {
		return orderdetailss;
	}

	public void setOrderdetailss(List<List<String>> orderdetailss) {
		this.orderdetailss = orderdetailss;
	}

	public String getOrderdetailsss() {
		return orderdetailsss;
	}

	public void setOrderdetailsss(String orderdetailsss) {
		this.orderdetailsss = orderdetailsss;
	}

	
	
	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public String getOstatus() {
		return ostatus;
	}
	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}
	
	public String getOdate() {
		return odate;
	}

	public void setOdate(String odate) {
		this.odate = odate;
	}

	private long quantity;
	private long oid;
	private String ostatus;
	private String odate;
	
   private List<List<String>> orderdetails = new ArrayList<List<String>>();
   private List<List<String>> orderdetailss = new ArrayList<List<String>>();
   private String orderdetailsss;
   
   private List<List<String>> admincon = new ArrayList<List<String>>();
   private List<List<String>> adminpro = new ArrayList<List<String>>();

   private List<List<String>> viewdorderdetails = new ArrayList<List<String>>();
   private List<List<String>> existingorderdetails = new ArrayList<List<String>>();
   
   
  	public List<List<String>> getExistingorderdetails() {
	return existingorderdetails;
}

public void setExistingorderdetails(List<List<String>> existingorderdetails) {
	this.existingorderdetails = existingorderdetails;
}

	public List<List<String>> getViewdorderdetails() {
  	return viewdorderdetails;
  }
  public void setViewdorderdetails(List<List<String>> viewdorderdetails) {
  	this.viewdorderdetails = viewdorderdetails;
  }
	
	
	public List<List<String>> getOrderdetails() {
	return orderdetails;
}

public void setOrderdetails(List<List<String>> orderdetails) {
	this.orderdetails = orderdetails;
}

	public String orderSet() {
		System.out.println(registerBean.getName());
		//System.out.println("000");
		//String temp="a";
		//System.out.println(loginbean.getUserName);
		//System.out.println("1"+loginbean.getUserName()+"2"+prodname+"3"+quantity+"4"+odate+"5"+producername);
	    orderdetails = orderservice.oset(registerBean.getName(),prodname ,quantity,odate ,producername );
	    //System.out.println("14");
	    if(orderdetails.isEmpty())
	    {
	    	System.out.println("15");
			return "fail1";
	    }
		else
		{
			System.out.println("16");
			return "success1";
			}
		
	}
public String checkstatus() {
		
	orderdetailss = orderservice.checkstatus(oid);
	if(orderdetailss.isEmpty())
		{
		
		//System.out.println(orderdetailss.size());
		return "fail2";
		}
	else
	{
		//System.out.println(orderdetailss.size());
		return "success2";}
	
}

public String oupdate() {
	
	String orderdetailsss = orderservice.oupdate(oid,prodname,producername,quantity);
	if(orderdetailsss.equalsIgnoreCase("fail"))
	return "fail4";
	else 
	return "success4";
		
}

public String cancel() {
	
	int a = orderservice.cancel(oid);
	if(a==0)
		return "fail3";
	
	else
	{return "success3";}
}

String deletedorder;


public String getDeletedorder() {
	return deletedorder;
}

public void setDeletedorder(String deletedorder) {
	this.deletedorder = deletedorder;
}

public void canceloid(){
	System.out.println("hii");
	setDeletedorder("The deleted order is "+ oid);
}

public String viewporder() {
	//String temp="Ferrari";
	   viewdorderdetails = orderservice.viewporder(registerBean.getName());
	    if(viewdorderdetails.isEmpty())
			return "vieworderfail";
		
		else
		{
			return "orderviewed";
		}
		
	}

public String ostatusupdate() {
	
	System.out.println("aaa"+oid);
	String a = orderservice.updateorderstatus(oid);
	System.out.println("bbb");
    if(a.equalsIgnoreCase("fail"))
		return "orderstatusupdatefail";
	
	else
	{
		return "orderstatusupdatedsuccess";
		
	}

}

public String existingorderschk(){
	   //String consumerName = "a";
	   existingorderdetails = orderservice.existingorderschk(registerBean.getName());
	   if(existingorderdetails.isEmpty())
			return "existingorderchkfail";
		
		else
		{
			return "existingorders";
		}
		
	}


public String conorderdisplay() {
	
	   admincon = orderservice.conorderdisplay(consumername);
	    if(admincon.isEmpty())
			return "acfail";
		
		else
		{
			return "acsuccess";
		}
		
	}

public String prodorderdisplay() {
	
	
	   adminpro = orderservice.proorderdisplay(producername);
	    if(adminpro.isEmpty())
			return "apfail";
		
		else
		{
			return "apsuccess";
		}
		
	}
	
}
