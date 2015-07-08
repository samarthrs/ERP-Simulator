package erps.osu;

public class Consumer {
	
	private int CONSUMERID;
	private String USERNAME;
	private String PASSWORD;
	
	
	/**
	 * 
	 * @param consumerid
	 * @param username
	 * @param password
	*/
	public Consumer(Integer consumerid, String username, String password){
		this.CONSUMERID = consumerid;
		this.USERNAME = username;
		this.PASSWORD = password;
	}
	
	public Consumer(Integer consumerid){
		this.CONSUMERID = consumerid;
	
	}
	public Consumer(String username, String password){
		this.USERNAME = username;
		this.PASSWORD = password;
		
	}

	public int getCONSUMERID() {
		return CONSUMERID;
	}

	public void setCONSUMERID(int cONSUMERID) {
		CONSUMERID = cONSUMERID;
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
