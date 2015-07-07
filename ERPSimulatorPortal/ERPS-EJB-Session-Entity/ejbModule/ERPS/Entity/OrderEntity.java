
package ERPS.Entity;
import java.io.*;
import java.sql.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "ORDERS")
public class OrderEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name="OID")
	private long oid;
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	
	@Column(name="PRODNAME")
	private String prodname;
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	
	@Column(name="QUANTITY")
	private long quantity;
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	@Column(name="ODATE")
	private String odate;
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	
	@Column(name="OSTATUS")
	private String ostatus;
	public String getOstatus() {
		return ostatus;
	}
	public void setOstatus(String orderStatus) {
		this.ostatus = orderStatus;
	}
	
	@Column(name="PRODUCERNAME")
	private String producername;
	public String getProducername() {
		return producername;
	}
	public void setProducername(String producername) {
		this.producername = producername;
	}
	
    @Column(name="CONSUMERNAME")
	private String consumername;
	public String getConsumername() {
		return consumername;
	}
	public void setConsumername(String consumername) {
		this.consumername = consumername;
	}
}
	
	