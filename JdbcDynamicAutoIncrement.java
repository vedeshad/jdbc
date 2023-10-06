package jdbc;

import java.sql.*;
import java.util.Scanner;

public class JdbcDynamicAutoIncrement 
{
	public static void main(String[] args) throws SQLException
	{
		Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","vedesh");
		PreparedStatement pst = con.prepareStatement("insert into persons (name,city) values(?,?) ");
		
		
		Scanner sc = new Scanner(System.in);
		
		
			System.out.println("How Many Entries U need");
			int entry = sc.nextInt();
			for (int i = 1; i <= entry; i++) 
			{
				
				System.out.println("Enter the Name Value for "+i+" Entry");
				pst.setString(1, sc.next());
				
				
				System.out.println("Enter the City Value for City"+i+" Entry");
				pst.setString(2, sc.next());
				System.out.println(pst.executeUpdate());
			}
			
		
		con.close();
		pst.close();
		sc.close();
		
	}

}
