package com.jspiders.marriage.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class RetrievePersonDetails {
	public void retrieve() throws SQLException, IOException {
		Connection CON = null;
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		String dburl = "jdbc:mysql://localhost:3306/marriage?user=root&password=root";
		
		CON = DriverManager.getConnection(dburl);
		
		String query = " select photo from person ";
		
		File file = new File("profile.jpg");
		FileOutputStream outputStream = new FileOutputStream(file);
		
		Statement stmt = CON.createStatement();
		ResultSet res = stmt.executeQuery(query);
		
		while(res.next()) {
			
			InputStream inputStream = res.getBinaryStream("photo");
			byte buffer[] = new byte[1024]; //0 1
			while(inputStream.read(buffer)>0) {
				outputStream.write(buffer);
				
			}
		
		}
		System.out.println("PHOTO retrieved");
		
	}

}
