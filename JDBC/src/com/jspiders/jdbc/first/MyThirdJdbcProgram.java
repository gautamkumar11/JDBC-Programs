package com.jspiders.jdbc.first;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class MyThirdJdbcProgram {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\J2eePrograms\\EclipseProgram\\Properties\\MyProp.properties");
			FileReader reader = new FileReader(file);
			
			Properties prop = new Properties();
			prop.load(reader);
			
			Connection CON = null;
			Statement stmt = null;
			
		try {
			Driver driverref= new Driver();
			DriverManager.registerDriver(driverref);
			
			String dburl= prop.getProperty("url");
			
			CON = DriverManager.getConnection(dburl, prop);
			String query = " delete from studentsinfo where regno = 505 ";
			
			stmt = CON.createStatement();
			
			int res = stmt.executeUpdate(query);
			if(res!=0)
			{
				System.out.println("Record Updated");
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try
			{
			 if(CON!=null)
			 {
				 CON.close();
			 }
			 if(stmt!=null)
			 {
				 stmt.close();
			 }
				
			}catch(Exception e2)
			{
				e2.printStackTrace();
			}
		}

	}

}
