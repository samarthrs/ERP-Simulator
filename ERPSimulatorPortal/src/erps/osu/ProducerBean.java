package erps.osu;



import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import erps.osu.RegisterBean;
import ERPS.Service.*;

public class ProducerBean {
	
	@EJB 
	private ProducerService producerservice;
	private OrderService orderservice;
	public OrderService getOrderservice() {
		return orderservice;
	}
	public void setOrderservice(OrderService orderservice) {
		this.orderservice = orderservice;
	}


	private RegisterBean registerBean;
	private OrderBean orderbean;
	
			
	
	private List<String> updateorderstatusdetails = new ArrayList<String>();
	private List<List<String>> viewinventorydetails = new ArrayList<List<String>>();
	
	
	public RegisterBean getRegisterBean() {
		return registerBean;
	}
	public void setRegisterBean(RegisterBean registerBean) {
		this.registerBean = registerBean;
	}
	public ProducerService getProducerservice() {
		return producerservice;
	}
	public void setProducerservice(ProducerService producerservice) {
		this.producerservice = producerservice;
	}
	
	
	private String prodname;
	private int iquantity;
	
	public int getIquantity() {
		return iquantity;
	}
	public void setIquantity(int iquantity) {
		this.iquantity = iquantity;
	}
	public String getProdname() {
		return prodname;
	}
	
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	

public String viewpinventory() {
	
	//String temp="Ferrari";
    viewinventorydetails = producerservice.viewpinventory(registerBean.getName());
    if(viewinventorydetails.isEmpty())
		{
    		System.out.println("1");
    		return "viewinventoryfail";
		}
	else
	{
		System.out.println("2");
		return "inventoryviewed";
	}
	
}

public String updateinventory() {
	//String user="Ferrari";
    String updateprodinventorydetails = producerservice.updateinventory(prodname,iquantity,registerBean.getName());
    if(updateprodinventorydetails.equalsIgnoreCase("fail"))
		return "updateinventoryfail";
	
	else
	{
		return "inventoryupdated";
	}
	
}
public OrderBean getOrderbean() {
	return orderbean;
}
public void setOrderbean(OrderBean orderbean) {
	this.orderbean = orderbean;
}
public List<String> getUpdateorderstatusdetails() {
	return updateorderstatusdetails;
}
public void setUpdateorderstatusdetails(List<String> updateorderstatusdetails) {
	this.updateorderstatusdetails = updateorderstatusdetails;
}
public List<List<String>> getViewinventorydetails() {
	return viewinventorydetails;
}
public void setViewinventorydetails(List<List<String>> viewinventorydetails) {
	this.viewinventorydetails = viewinventorydetails;
}


}


