package erps.osu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminGateway {

	private Connection conn;
		
		public AdminGateway() throws Exception{
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection(GlobalVariables.path,GlobalVariables.username,GlobalVariables.password);
		}
		
		public boolean insertAdmin(Admin admin){
			try{
				String query = "INSERT INTO ADMIN VALUES (DEFAULT, '"+ admin.getUSERNAME()+"', '"+admin.getPASSWORD()+"')";
				Statement stmt = conn.createStatement();
				stmt.execute(query);
				return true;
			}catch(Exception error){
				System.out.println(error);
				return false;
			}
		}
		
		public boolean deleteAdmin(Admin admin){
			try{
				String query = "DELETE FROM ADMIN WHERE ADMINID = '"+admin.getADMINID()+ "'";
				Statement stmt = conn.createStatement();
				stmt.execute(query);
				return true;
			}catch(Exception error){
				System.out.println(error);
				return false;
			}
		}
		
		public boolean updateAdmin(Admin admin){
			try{
				String query1 = "UPDATE ADMIN SET PASSWORD='"+admin.getPASSWORD()+"' WHERE ADMINID='"+admin.getADMINID()+"'";
				String query2 = "UPDATE ADMIN SET USERNAME='"+admin.getUSERNAME()+"' WHERE ADMINID='"+admin.getADMINID()+"'";
				Statement stmt = conn.createStatement();
				stmt.execute(query1);
				stmt.execute(query2);
				return true;
			}catch(Exception error){
				System.out.println(error);
				return false;
			}
		}
		
		public void selectAdminDetails(Admin admin){
			try{
				String query = "SELECT * FROM ADMIN where ADMINID = "+ admin.getADMINID();
				Statement stmt = conn.createStatement();
				ResultSet results = stmt.executeQuery(query);
				while(results.next()){
					System.out.println("AdminId: "+results.getString(1)+", UserName: "+results.getString(2)+", Password: "+results.getString(3));
				}
			}catch(Exception error){
				System.out.println(error);
			}
		}
	}

