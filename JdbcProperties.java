package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Properties;

public class JdbcProperties 
{
	public static void main(String[] args) 
	{
		try
		{
			Driver d = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
			
			FileInputStream fis = new FileInputStream("C:\\Users\\vedes\\j2ee\\jdbc\\src\\jdbc\\abc.properties");
			
			Properties p = new Properties();
			p.load(fis);
			String url = p.getProperty("dburl");
			
			Connection con = DriverManager.getConnection(url,p);
			         
			Statement st = con.createStatement();
			int res =st.executeUpdate("flashback table studentdetails");
					
			System.out.println(res);
			
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
