package com.jspiders.database.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class CreateTable {
	public static void main(String args[])
	{
		Connection CON = null;
		Statement stmt = null;
		
		try {
			Driver driverref = new Driver();
			DriverManager.registerDriver(driverref);
			
			String dburl = "jdbc:mysql://localhost:3306/mydb?user=root&password=root";
			CON = DriverManager.getConnection(dburl);
			
			String query = " create table myinfo "
					 +" (fisrtname varchar(15), middlename varchar(15), lastname varchar(15), address varchar(40), age int(4), contact bigint(15)) ";
			
			stmt = CON.createStatement();
			int res = stmt.executeUpdate(query);
			
			if(res==0)
			{
				System.out.println("Table Created");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally 
		{
			try {
				if(CON!=null)
				{
					CON.close();
				}
				if(stmt!=null)
				{
					stmt.close();
				}
				
			}catch(Exception e2) {
				
				e2.printStackTrace();
			}
			
		}
		
	}

}
