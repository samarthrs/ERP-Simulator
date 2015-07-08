package erps.osu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InventoryGateway {

	private Connection conn;
		
		public InventoryGateway() throws Exception{
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(GlobalVariables.path,GlobalVariables.username,GlobalVariables.password);
		}
		
		public boolean insertInventory(Inventory Inventory){
			try{
				String query = "INSERT INTO Inventory VALUES (DEFAULT, '"+ Inventory.getPRODUCTID()+"', '"+Inventory.getIQUANTITY()+"', '"+Inventory.getPRODUCERID()+"')";
				Statement stmt = conn.createStatement();
				stmt.execute(query);
				return true;
			}catch(Exception error){
				System.out.println(error);
				return false;
			}
		}
		
		public boolean deleteInventory(Inventory Inventory){
			try{
				String query = "DELETE FROM Inventory WHERE INVENTORYID = '"+Inventory.getINVENTORYID()+"'";
				Statement stmt = conn.createStatement();
				stmt.execute(query);
				return true;
			}catch(Exception error){
				System.out.println(error);
				return false;
			}
		}
		
		public boolean updateInventory(Inventory Inventory){
			try{
				String query1 = "UPDATE Inventory SET PRODUCTID='"+Inventory.getPRODUCTID()+"' WHERE InventoryID='"+Inventory.getINVENTORYID()+"'";
				Statement stmt = conn.createStatement();
				stmt.execute(query1);
				return true;
			}catch(Exception error){
				System.out.println(error);
				return false;
			}
		}
		
		public void selectInventoryDetails(Inventory Inventory){
			try{
				String query = "SELECT PRODUCTID, IQUANTITY, PRODUCERID FROM Inventory where InventoryID = "+ Inventory.getINVENTORYID();
				Statement stmt = conn.createStatement();
				ResultSet results = stmt.executeQuery(query);
				while(results.next()){
					System.out.println("PRODUCTID: "+results.getString(1)+", IQUANTITY: "+results.getString(2) + ", PRODUCERID: "+results.getString(3));
				}
			}catch(Exception error){
				System.out.println(error);
			}
		}
}



