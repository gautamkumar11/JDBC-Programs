package com.jspiders.job.first;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class RetrieveCandidateDetails {
	
	public void retrieve() throws IOException
	{
		
		try {
			Driver driverref = new Driver();
			 DriverManager.registerDriver(driverref);
			 
			 String dburl = "jdbc:mysql://localhost:3306/job";
			 
			Connection CON =  DriverManager.getConnection(dburl, "root", "root");
			
			String query = "select * from candidate";
			
			String path = "resume.txt";
			FileWriter filewriter = new FileWriter(path);
			
			Statement stmt = CON.createStatement();
			
			ResultSet res = stmt.executeQuery(query);
			
			while(res.next())
			{
				System.out.println("name = "+res.getString("name"));
				System.out.println("email = "+res.getString("email"));
				System.out.println("contact = "+res.getString("contact"));
				
				Reader reader = res.getCharacterStream("resume");
				
				int i;
				while ((i=reader.read())!=-1)
				{
		               filewriter.write(i);
		         }
				 filewriter.flush();
				 filewriter.close();
				 
				 System.out.println(res.getString("resume"));
			}
	
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
