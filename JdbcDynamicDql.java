package jdbc;

import java.sql.*;
import java.util.Scanner;

public class JdbcDynamicDql 
{
	public static void main(String[] args) throws SQLException
	{
			Driver d = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
		
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&&password=vedesh");
			PreparedStatement pst = con.prepareStatement("select * from studentdetails Where id < ? ");         

		   Scanner sc = new Scanner(System.in);
		   System.out.println("Enter The Student ID");
		   pst.setInt(1, sc.nextInt());	
		
		   
		   ResultSet rs = pst.executeQuery();
		   
		   
		   boolean check = true;
		   while(rs.next())
		   {
		   		
			 System.out.println("Student ID = "+rs.getInt(1)+
					   "\nStudent Name = "+rs.getString(2)+
					   "\nStudent Contact = "+rs.getLong(3)+
					   "\nStudent City = "+rs.getString(4));
			System.out.println("---------------------");
			 check=false;  	
		   }
		   if(rs.next()==false&&check==true)
		   {
		   	 System.out.println("NO Student Data Found");
		   }
		   	
		   	
		   con.close();
		   pst.close();
		   sc.close();
		
	}

}
