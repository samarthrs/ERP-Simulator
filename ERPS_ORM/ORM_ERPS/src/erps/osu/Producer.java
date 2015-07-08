package erps.osu;

public class Producer {
	
	private int PRODUCERID;
	private String USERNAME;
	private String PASSWORD;
	
	
	/**
	 * 
	 * @param Producerid
	 * @param username
	 * @param password
	*/
	public Producer(Integer Producerid, String username, String password){
		this.PRODUCERID = Producerid;
		this.USERNAME = username;
		this.PASSWORD = password;
	}
	
	public Producer(Integer Producerid){
		this.PRODUCERID = Producerid;
		
	}
	
	public Producer(String username, String password){
		this.USERNAME = username;
		this.PASSWORD = password;
		
	}

	public int getPRODUCERID() {
		return PRODUCERID;
	}

	public void setPRODUCERID(int pRODUCERID) {
		PRODUCERID = pRODUCERID;
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