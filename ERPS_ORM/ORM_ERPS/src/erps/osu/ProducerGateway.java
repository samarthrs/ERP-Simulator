package erps.osu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProducerGateway {

	private Connection conn;
		
		public ProducerGateway() throws Exception{
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(GlobalVariables.path,GlobalVariables.username,GlobalVariables.password);
		}
		
		public boolean insertProducer(Producer Producer){
			try{
				String query = "INSERT INTO Producer VALUES (DEFAULT, '"+ Producer.getUSERNAME()+"', '"+Producer.getPASSWORD()+"')";
				Statement stmt = conn.createStatement();
				stmt.execute(query);
				return true;
			}catch(Exception error){
				System.out.println(error);
				return false;
			}
		}
		
		public boolean deleteProducer(Producer Producer){
			try{
				String query = "DELETE FROM Producer WHERE PRODUCERID = '"+Producer.getPRODUCERID()+ "'";
				Statement stmt = conn.createStatement();
				stmt.execute(query);
				return true;
			}catch(Exception error){
				System.out.println(error);
				return false;
			}
		}
		
		public boolean updateProducer(Producer Producer){
			try{
				String query1 = "UPDATE Producer SET PASSWORD='"+Producer.getPASSWORD()+"' WHERE ProducerID='"+Producer.getPRODUCERID()+"'";
				String query2 = "UPDATE Producer SET USERNAME='"+Producer.getUSERNAME()+"' WHERE ProducerID='"+Producer.getPRODUCERID()+"'";
				Statement stmt = conn.createStatement();
				stmt.execute(query1);
				stmt.execute(query2);
				return true;
			}catch(Exception error){
				System.out.println(error);
				return false;
			}
		}
		
		public void selectProducerDetails(Producer Producer){
			try{
				String query = "SELECT * FROM Producer where ProducerID = '"+ Producer.getPRODUCERID()+"'";
				Statement stmt = conn.createStatement();
				ResultSet results = stmt.executeQuery(query);
				while(results.next()){
					System.out.println("ProducerId: "+results.getString(1)+", UserName: "+results.getString(2)+", Password: "+results.getString(3));
				}
			}catch(Exception error){
				System.out.println(error);
			}
		}
	}


