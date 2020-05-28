package com.jspiders.job.first;

import java.io.File;
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
			
			File file = new File("resume.txt");
			FileWriter filewriter = new FileWriter(file);
			
			Statement stmt = CON.createStatement();
			
			ResultSet res = stmt.executeQuery(query);
			
			
			String writeresume= "";
			
		/*	while(res.next())
			{
				System.out.println("name = "+res.getString("name"));
				System.out.println("email = "+res.getString("email"));
				System.out.println("contact = "+res.getString("contact"));
				
				
				
			}
			
			Reader reader = res.getCharacterStream("resume");
			int read = reader.read();
			
			System.out.println(read);
			while(read!=-1)
			{
				char c=(char)read;
				writeresume= writeresume + c;
			}
			filewriter.write(writeresume);
			filewriter.flush();
			filewriter.close();
			System.out.println("resume = "+writeresume);
			 
			*/ 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
