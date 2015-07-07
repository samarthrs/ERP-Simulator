/**
 * 
 */
package erps.osu;


import javax.ejb.EJB;

import ERPS.Service.HelloService;

public class LoginBean {
	
	@EJB 
	private HelloService helloService;
	
	public String userName;
	private String password,userType;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String loginUser() {
		
		if((userName.isEmpty() != true) && (password.isEmpty()!= true)) {
			//System.out.println("2");
		String res = helloService.loginUser(userName, password, userType);
		//System.out.println("4");
		//helloService.password(password);
		String user=userName;
		if (res.equalsIgnoreCase("success"))
		return userType;
		else 
		return "false";
		}
		else
		return "false";
	
		}
}

