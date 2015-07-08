package erps.osu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class OrderGateway {

	private Connection conn;
		
		public OrderGateway() throws Exception{
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(GlobalVariables.path,GlobalVariables.username,GlobalVariables.password);
		}
		
		public boolean insertOrder(Order Order){
			try{
				String query = "INSERT INTO Orders VALUES (DEFAULT, '"+ Order.getQUANTITY()+"', '"+Order.getORDERDATE()+"', '"+Order.getORDERSTATUS()+"', '"+Order.getCONSUMERID()+"')";
				Statement stmt = conn.createStatement();
				stmt.execute(query);
				return true;
			}catch(Exception error){
				System.out.println(error);
				return false;
			}
		}
		
		public boolean deleteOrder(Order Order){
			try{
				String query = "DELETE FROM Orders WHERE OrderID = '"+Order.getORDERID()+"'";
				Statement stmt = conn.createStatement();
				stmt.execute(query);
				return true;
			}catch(Exception error){
				System.out.println(error);
				return false;
			}
		}
		
		public boolean updateOrder(Order Order){
			try{
				String query1 = "UPDATE Orders SET QUANTITY='"+Order.getQUANTITY()+"'ORDERDATE='"+Order.getORDERDATE()+"'ORDERSTATUS='"+Order.getORDERSTATUS()+"'CONSUMERID='"+Order.getCONSUMERID()+"' WHERE OrderID='"+Order.getORDERID()+"'";
				Statement stmt = conn.createStatement();
				stmt.execute(query1);
				return true;
			}catch(Exception error){
				System.out.println(error);
				return false;
			}
		}
		
		public void selectOrderDetails(Order Order){
			try{
				String query = "SELECT QUANTITY, ORDERDATE, ORDERSTATUS, CONSUMERID FROM Orders where OrderID = "+ Order.getORDERID();
				Statement stmt = conn.createStatement();
				ResultSet results = stmt.executeQuery(query);
				while(results.next()){
					System.out.println("QUANTITY: "+results.getString(1)+", ORDERDATE: "+results.getString(2) + ", ORDERSTATUS: "+results.getString(3) + ", CONSUMERID: "+results.getString(4));
				}
			}catch(Exception error){
				System.out.println(error);
			}
		}
	}



