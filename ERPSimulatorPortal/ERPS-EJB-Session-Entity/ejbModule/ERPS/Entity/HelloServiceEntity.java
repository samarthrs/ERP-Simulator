package ERPS.Entity;
import java.io.*;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "USERS")
public class HelloServiceEntity implements Serializable{
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
	private String userName;
	public String getUserName() {return userName;}

	public void setUserName(String userName) { this.userName = userName;}
	
	
	@Column(name="PASSWORD")
	private String password;
	public String getPassword() {return password;}

	public void setPassword(String password) { this.password = password;}
	
	@Column(name="USERTYPE")
	private String userType;
	public String getUserType() {return userType;}

	public void setUserType(String userType) { this.userType = userType;}
	
}
