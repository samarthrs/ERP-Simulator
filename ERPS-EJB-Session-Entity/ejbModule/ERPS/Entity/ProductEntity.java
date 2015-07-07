
package ERPS.Entity;
import java.io.*;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "PRODUCT")
public class ProductEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="PRODID")
	private long prodid; 
	@Column(name="PRODNAME")
	private String prodname;
	public long getProdid() {
		return prodid;
	}
	public void setProdid(long prodid) {
		this.prodid = prodid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getProddesc() {
		return proddesc;
	}
	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}
	@Column(name="PRODDESC")
	private String proddesc;
	
}

