package com.jspiders.jdbc.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class MySecondJdbcProgram {
	
	public static void main(String args[]) {
		Connection CON = null;
		PreparedStatement pstmt = null;
		
		try {
			Driver driverref=new Driver();
			DriverManager.deregisterDriver(driverref);
			
			String dburl= "jdbc:mysql://localhost:3306/bejm37"; 
			CON = DriverManager.getConnection(dburl, "root", "root");
			
			String query= " insert into studentsinfo values(?,?,?,?)";
			
					pstmt= CON.prepareStatement(query);
					
					pstmt.setInt(1, Integer.parseInt(args[0]));
					pstmt.setString(2, args[1]);
					pstmt.setString(3, args[2]);
					pstmt.setString(4, args[3]);
					
					int res = pstmt.executeUpdate();
					
					if(res!=0) {
						
						System.out.println("Record Inserted");
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				
				if(CON!=null) {
					CON.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				
			}catch(SQLException e2) {
				
				e2.printStackTrace();
			}
		}
		
	}

}
