/**
 * 
 */
package erps.osu;

/**
 * @author Samarth
 *
 */

import javax.ejb.EJB;

import ERPS.Service.HelloService;

public class RegisterBean {
	
	@EJB 
	private HelloService helloService;
	
	
	private String name,password,valid,userType;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}
	


  /*  public void setName (final String name)
    {
		if(name.equalsIgnoreCase("!") || name.equalsIgnoreCase("@") || name.equalsIgnoreCase("#")
				|| name.equalsIgnoreCase("$") || name.equalsIgnoreCase("%") || name.equalsIgnoreCase("^")
				|| name.equalsIgnoreCase("&") || name.equalsIgnoreCase("*") || name.equalsIgnoreCase("(")
				|| name.equalsIgnoreCase(")") || name.equalsIgnoreCase("_") || name.equalsIgnoreCase("+")
				|| name.equalsIgnoreCase(""))
			setValid("Not a Valid User Name");
		else
			setValid("Valid User Name");


        this.name = name;
    } */
	
	
	public String userName() {
		//System.out.println("1");
		if((name.isEmpty() != true) && (password.isEmpty()!= true)) {
			//System.out.println("2");
		String ret = helloService.userName(name, password);
		//System.out.println("4");
		//helloService.password(password);
		if(!ret.equalsIgnoreCase("Exists"))
		{
			//System.out.println("5");
		return "true";
		}
		else 
		{
			//System.out.println("6");
			return "Exists";
		}	
		}
		else
		{
			//System.out.println("7");
			return "Exists";
		}	
	}
     
	public String loginUser() {
		
		if((name.isEmpty() != true) && (password.isEmpty()!= true)) {
			//System.out.println("2");
		String res = helloService.loginUser(name, password, userType);
		System.out.println(res);
		//helloService.password(password);
		if (res.equalsIgnoreCase("success"))
		{
		System.out.println(userType);
		return userType;
		}
		else 
		return "false";
		}
		else
		return "false";
	
		}
	
}
