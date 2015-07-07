package ERPS.Entity;
import java.io.*;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "INVENTORY")
public class InventoryEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="PRODID")
	private long prodid;
	public long getProdid() {
		return prodid;
	}
	public void setProdid(long prodid) {
		this.prodid = prodid;
	}
	
	@Column(name="PRODNAME")
	private String prodname;
		
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	@Column(name="IQUANTITY")
	private long iquantity;
	
	public long getIquantity() {
		return iquantity;
	}
	public void setIquantity(long iquantity) {
		this.iquantity = iquantity;
	}
		
	@Column(name="PRODUCERNAME")
	private String producername;
	
	public String getProducername() {
		return producername;
	}
	public void setProducername(String producername) {
		this.producername = producername;
	}
	
}
	
	
