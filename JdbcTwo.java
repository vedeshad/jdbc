package jdbc;

import java.sql.*;

public class JdbcTwo 
{
	public static void main(String[] args) throws SQLException 
	{
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","vedesh");
		
		
		Statement st = con.createStatement();
		
		
		ResultSet rs =st.executeQuery("select * from studentdetails");
		
		while(rs.next())
		{
			System.out.println("Student ID = "+rs.getInt(1)+" Student Name = "+rs.getString(2)+" Student Contact = "+rs.getLong(3)+" Student City = "+rs.getString(4));
		}
		
		con.close();
		
		
	}

}
