package erps.osu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConsumerGateway {

	private Connection conn;
		
		public ConsumerGateway() throws Exception{
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(GlobalVariables.path,GlobalVariables.username,GlobalVariables.password);
		}
		
		public boolean insertConsumer(Consumer Consumer){
			try{
				String query = "INSERT INTO Consumer VALUES (DEFAULT, '"+ Consumer.getUSERNAME()+"', '"+Consumer.getPASSWORD()+"')";
				Statement stmt = conn.createStatement();
				stmt.execute(query);
				return true;
			}catch(Exception error){
				System.out.println(error);
				return false;
			}
		}
		
				
		public boolean deleteConsumer(Consumer Consumer){
			try{
				String query = "DELETE FROM Consumer WHERE CONSUMERID = '"+Consumer.getCONSUMERID()+ "'";
				Statement stmt = conn.createStatement();
				stmt.execute(query);
				return true;
			}catch(Exception error){
				System.out.println(error);
				return false;
			}
		}
		
		public boolean updateConsumer(Consumer Consumer){
			try{
				String query1 = "UPDATE Consumer SET PASSWORD='"+Consumer.getPASSWORD()+"' WHERE ConsumerID='"+Consumer.getCONSUMERID()+"'";
				String query2 = "UPDATE Consumer SET USERNAME='"+Consumer.getUSERNAME()+"' WHERE ConsumerID='"+Consumer.getCONSUMERID()+"'";
				Statement stmt = conn.createStatement();
				stmt.execute(query1);
				stmt.execute(query2);
				return true;
			}catch(Exception error){
				System.out.println(error);
				return false;
			}
		}
		
		public void selectConsumerDetails(Consumer Consumer){
			try{
				String query = "SELECT * FROM Consumer where ConsumerID = "+ Consumer.getCONSUMERID();
				Statement stmt = conn.createStatement();
				ResultSet results = stmt.executeQuery(query);
				while(results.next()){
					System.out.println("ConsumerId: "+results.getString(1)+", UserName: "+results.getString(2)+", Password: "+results.getString(3));
				}
			}catch(Exception error){
				System.out.println(error);
			}
		}
	}

