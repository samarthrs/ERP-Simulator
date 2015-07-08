package erps.osu;

public class Order {
	
	private int ORDERID;
	private int QUANTITY;
	private String ORDERDATE;
	private String ORDERSTATUS;
	private int CONSUMERID;
	
		/**
	 * 
	 * @param inventoryid
	 * @param productid
	 * @param iquantity
	 * @param producerid
	*/
	public Order(Integer orderid, Integer quantity, String orderdate, String orderstatus, Integer consumerid){
		this.ORDERID = orderid;
		this.QUANTITY = quantity;
		this.ORDERDATE = orderdate;
		this.ORDERSTATUS = orderstatus;
		this.CONSUMERID = consumerid;
	}
	
	public Order(Integer quantity, String orderdate, String orderstatus, Integer consumerid){
		this.QUANTITY = quantity;
		this.ORDERDATE = orderdate;
		this.ORDERSTATUS = orderstatus;
		this.CONSUMERID = consumerid;
	}

	public int getORDERID() {
		return ORDERID;
	}

	public void setORDERID(int oRDERID) {
		ORDERID = oRDERID;
	}

	public int getQUANTITY() {
		return QUANTITY;
	}

	public void setQUANTITY(int qUANTITY) {
		QUANTITY = qUANTITY;
	}

	public String getORDERDATE() {
		return ORDERDATE;
	}

	public void setORDERDATE(String oRDERDATE) {
		ORDERDATE = oRDERDATE;
	}

	public String getORDERSTATUS() {
		return ORDERSTATUS;
	}

	public void setORDERSTATUS(String oRDERSTATUS) {
		ORDERSTATUS = oRDERSTATUS;
	}

	public int getCONSUMERID() {
		return CONSUMERID;
	}

	public void setCONSUMERID(int cONSUMERID) {
		CONSUMERID = cONSUMERID;
	}
	
	
	
	
}