package erps.osu;

import java.sql.*;

public class ORMManager {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
			try
			{
			System.out.println("2");
			createTables();
			System.out.println("3");
			DOMParser parse = new DOMParser();
			System.out.println("4");
			//parse.parseXML("src/InsertData.xml");
			parse.parseXML("src/Modification.xml");
	        System.out.println("THE PROGRAM ENDED");
			}
			catch (Exception e)
			{
				 System.out.println(e);
			}
	    }
		
	private static void createTables(){
		try{
			System.out.println("1");
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection(GlobalVariables.path,GlobalVariables.username,GlobalVariables.password);
			String queryAdmin = "CREATE TABLE IF NOT EXISTS ADMIN(ADMINID INT PRIMARY KEY AUTO_INCREMENT, USERNAME VARCHAR(255) UNIQUE , PASSWORD VARCHAR(255))";
			String queryConsumer = "CREATE TABLE IF NOT EXISTS CONSUMER(CONSUMERID INT PRIMARY KEY AUTO_INCREMENT,USERNAME VARCHAR(255) UNIQUE , PASSWORD VARCHAR(255) )";
			String queryProducer = "CREATE TABLE IF NOT EXISTS PRODUCER(PRODUCERID INT PRIMARY KEY AUTO_INCREMENT,USERNAME VARCHAR(255) UNIQUE , PASSWORD VARCHAR(255) )";
			String queryInventory = "CREATE TABLE IF NOT EXISTS INVENTORY(INVENTORYIDID INT PRIMARY KEY AUTO_INCREMENT, PRODUCTIDID INT,IQUANTITY INT, PRODUCERID INT)";
			String queryOrder = "CREATE TABLE IF NOT EXISTS ORDERS(ORDERID INT PRIMARY KEY AUTO_INCREMENT, QUANTITY INT, ORDERDATE VARCHAR(255), ORDERSTATUS VARCHAR(255), CONSUMERID INT)";
			
			Statement stmt = conn.createStatement();
			stmt.execute(queryAdmin);
			stmt.execute(queryConsumer);
			stmt.execute(queryProducer);
			stmt.execute(queryInventory);
			stmt.execute(queryOrder);
			
			String alterInventory2 = "ALTER TABLE INVENTORY ADD FOREIGN KEY(PRODUCERID) REFERENCES PRODUCER(PRODUCERID) ON DELETE CASCADE";
			String alterOrder = "ALTER TABLE ORDERS ADD FOREIGN KEY(CONSUMERID) REFERENCES CONSUMER(CONSUMERID) ON DELETE CASCADE";
			stmt.equals(alterInventory2);
			stmt.equals(alterOrder);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}



