package erps.osu;

public class Admin {

	private int ADMINID;
	private String USERNAME;
	private String PASSWORD;
	
	
	/**
	 * 
	 * @param adminid
	 * @param username
	 * @param password
	*/
	public Admin(Integer adminid, String username, String password){
		this.ADMINID = adminid;
		this.USERNAME = username;
		this.PASSWORD = password;
	}
	
	public Admin(String username, String password){
		this.USERNAME = username;
		this.PASSWORD = password;
		
	}
	
	public Admin(Integer adminid){
		this.ADMINID = adminid;
	
	}
	

	public int getADMINID() {
		return ADMINID;
	}

	public void setADMINID(int aDMINID) {
		ADMINID = aDMINID;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
}
