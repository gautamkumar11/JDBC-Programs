package com.jspiders.job.first;

import java.io.File;
import java.io.IOException;

public class UserInterface {
	
	public static void main(String args[]) throws IOException
	{
		Candidate candidate = new Candidate();
		
		candidate.setName("Gautam Kumar");
		candidate.setEmail("gautam11@gmail.com");
		candidate.setContact(7028870785l);
		
		File resume = new File("C:\\J2eePrograms\\Files\\resume.txt");
		
		candidate.setResume(resume);
		
		InsertCandidateDetails candidateDetails = new InsertCandidateDetails();
		
		try {
		candidateDetails.insert(candidate);
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		RetrieveCandidateDetails retrieveDetails = new RetrieveCandidateDetails();
		retrieveDetails.retrieve();
		
	}

}
