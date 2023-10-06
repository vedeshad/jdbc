package jdbc;
import java.sql.*;

public class JdbcOne 
{
	public static void main(String[] args) throws SQLException
	{
		//step 1
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		
		//step 2
		String url="jdbc:mysql://localhost:3306/student";
		String user="root";
		String pass="vedesh";
		
		Connection c = DriverManager.getConnection(url, user, pass);
		
		
		//step 3
		Statement s =c.createStatement();
		
		
		//step 4
		int res =s.executeUpdate("insert into studentdetails values(459,'vedesh',7540054857,'manglore')");
		
		System.out.println(res);
		
		//step 5
		c.close();
		
		
		
		
		
		
		
	}

}
