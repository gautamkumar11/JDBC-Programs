package com.jspiders.job.first;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class InsertCandidateDetails {

  public void insert(Candidate candidate) throws FileNotFoundException
  {
	  Connection CON = null;
	  PreparedStatement pstmt = null;
	  
	   try {
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		
		String dburl = "jdbc:mysql://localhost:3306/job?user=root&password=root";
		
		CON = DriverManager.getConnection(dburl);
		
		
		String query = " insert into candidate "
						+ " values(?,?,?,?) ";
				
		FileReader reader= new FileReader(candidate.getResume());
		
		pstmt = CON.prepareStatement(query);

		
		pstmt.setString(1, candidate.getName());
		pstmt.setString(2, candidate.getEmail());
		pstmt.setCharacterStream(3, reader);
		pstmt.setLong(4, candidate.getContact());
		
		int res = pstmt.executeUpdate();
		
		
		if(res!=0)
		{
			System.out.println("Record of the candidate inserted");
			
		}
		
		
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	   finally {
		   
		   try {
			   
			   if(CON!= null)
			   {
				   CON.close();
			   }
			   if(pstmt!= null)
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
