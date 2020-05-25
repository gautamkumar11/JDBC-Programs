package com.jspiders.jdbc.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class MyFourthJdbcProgram {
	
	public static void main(String[] args)
	{
		
		Connection CON = null;
		PreparedStatement pstmt = null;
	 try {
		Driver driverref = new Driver();
		
		DriverManager.registerDriver(driverref);
		String dburl= "jdbc:mysql://localhost:3306/bejm37";
		
		CON = DriverManager.getConnection(dburl, "root", "root");
		
		String query = " delete from studentsinfo "
						+ " where regno = ? ";
		pstmt = CON.prepareStatement(query);
		pstmt.setInt(1, Integer.parseInt(args[0]));
		
		int res = pstmt.executeUpdate();
		if(res!=0)
		{
			System.out.println("Record deleted");
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	 finally {
		 try {
			 
			 if(CON!=null)
			 {
				 CON.close();
			 }
			 if(pstmt!=null)
			 {
				 pstmt.close();
			 }
		 }catch(Exception e2)
		 {
			 
			 e2.printStackTrace();
		 }
		  
	 }
		
	}

}
