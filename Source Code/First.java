import java.sql.*;


public class First
{
	String username="system";
	String password="system";
	PreparedStatement stm;
	PreparedStatement preparedStmt;
	public First()
	{
		try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",username,password);
				String query = "CREATE TABLE  ADMIN2	 (A1 VARCHAR2(100), A2 VARCHAR2(100))";
      				preparedStmt = conn.prepareStatement(query);
      				preparedStmt.execute();
				stm =  conn.prepareStatement("insert into ADMIN2 values(?,?)");
			                stm.setString(1,"101");
				stm.setString(2,"vineet");
				stm.executeUpdate();
				String query2 = "CREATE TABLE  PRODUCT (N1 VARCHAR2(200), N2 VARCHAR2(200), N3 VARCHAR2(200), N4 VARCHAR2(200), N5 VARCHAR2(200), N6 VARCHAR2(200), N7 VARCHAR2(200))";
      				preparedStmt = conn.prepareStatement(query2);
      				preparedStmt.execute();				
				String query3 = "CREATE TABLE  ORDER1 (O1 VARCHAR2(200), O2 VARCHAR2(200), O3 VARCHAR2(200), O4 VARCHAR2(200), O5 VARCHAR2(200), O6 VARCHAR2(200), O7 VARCHAR2(200))";
      				preparedStmt = conn.prepareStatement(query3);
      				preparedStmt.execute();
				String query4 = "CREATE TABLE  CUSTOMER2 (C1 VARCHAR2(200), C2 VARCHAR2(200), C3 VARCHAR2(200), C4 VARCHAR2(200), C5 VARCHAR2(200), C6 VARCHAR2(200))";
      				preparedStmt = conn.prepareStatement(query4);
      				preparedStmt.execute();
				String query5 = "CREATE TABLE  FEEDBACK (F1 VARCHAR2(200), F2 VARCHAR2(200), F3 VARCHAR2(200))";
      				preparedStmt = conn.prepareStatement(query5);
      				preparedStmt.execute();
				
				System.out.println("Create table successful");

				
				    }
				catch(Exception v) { System.out.println("Error"+v);   }
		}
public static void main(String []args)
	{  new First();  }
}