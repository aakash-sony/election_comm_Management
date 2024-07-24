package model;

import java.io.IOException;

public class MainClass 
{

	public static void main(String[] args) throws IOException
	{
		//Insert political parties
		Factory.insertPoliticalParties();
		Factory.getPartyDetail();
		
		//Insert constituency details
		
		Factory.insertConstituencyDetails();
		Factory.getConstituencyDetails();
		
		//Insert candidate details
		Factory.insertCandidateDetail();
		Factory.getCandidateDetails();
		String str = "java is programing language";
		System.out.println(str.split(" ").length);
	}
}
