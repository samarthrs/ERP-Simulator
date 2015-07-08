package erps.osu;

public class Inventory {
	
	private int INVENTORYID;
	private int PRODUCTID;
	private int IQUANTITY;
	private int PRODUCERID;
	
		/**
	 * 
	 * @param inventoryid
	 * @param productid
	 * @param iquantity
	 * @param producerid
	*/
	public Inventory(Integer inventoryid, Integer productid, Integer iquantity, Integer producerid){
		this.INVENTORYID = productid;
		this.PRODUCTID = productid;
		this.IQUANTITY = iquantity;
		this.PRODUCERID = producerid;
	}
	
	public Inventory(Integer productid, Integer iquantity, Integer producerid){
		this.PRODUCTID = productid;
		this.IQUANTITY = iquantity;
		this.PRODUCERID = producerid;
	}

	public int getINVENTORYID() {
		return INVENTORYID;
	}

	public void setINVENTORYID(int iNVENTORYID) {
		INVENTORYID = iNVENTORYID;
	}

	public int getPRODUCTID() {
		return PRODUCTID;
	}

	public void setPRODUCTID(int pRODUCTID) {
		PRODUCTID = pRODUCTID;
	}

	public int getIQUANTITY() {
		return IQUANTITY;
	}

	public void setIQUANTITY(int iQUANTITY) {
		IQUANTITY = iQUANTITY;
	}

	public int getPRODUCERID() {
		return PRODUCERID;
	}

	public void setPRODUCERID(int pRODUCERID) {
		PRODUCERID = pRODUCERID;
	}
	
	
	
}