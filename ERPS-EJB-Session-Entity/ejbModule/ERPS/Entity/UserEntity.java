
package ERPS.Entity;
import java.io.*;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "USERS")
public class UserEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USERID")
	private long userid;
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}
	
	@Column(name="USERNAME")
	private String username;
	public String getUserName() {return username;}

	public void setUserName(String username) { this.username = username;}
	
	@Column(name="PASSWORD")
	private String password;
	public String getPassword() {return password;}

	public void setPassword(String password) { this.password = password;}
	
	@Column(name="USERTYPE")
	private String usertype;
	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	
	
}
