package com.jspiders.marriage.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class InsertPersonDetails {
	Connection CON = null;
	PreparedStatement pstmt = null;

	public void insert(Person person)
	{
		try {
			
		Driver driverref = new Driver();
		
		DriverManager.registerDriver(driverref);
		
		String dburl = "jdbc:mysql://localhost:3306/marriage?user=root&password=root";
		   CON = DriverManager.getConnection(dburl);
		   
		  String query = " insert into person  "
				  		+ " vlaues(?,?,?,?) ";
		  
		pstmt =   CON.prepareStatement(query);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
}
