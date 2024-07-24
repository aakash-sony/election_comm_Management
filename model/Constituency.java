package model;

public class Constituency {
	private int noOfVotes;
	private int constituencyId;
	private String constituencyName;

	public Constituency(int noOfVotes, int constituencyId, String constituencyName) {
		this.noOfVotes = noOfVotes;
		this.constituencyId = constituencyId;
		this.constituencyName = constituencyName;
	}

	public int getNoOfVotes() {
		return noOfVotes;
	}

	public void setNoOfVotes(int noOfVotes) {
		this.noOfVotes = noOfVotes;
	}

	public int getConstituencyId() {
		return constituencyId;
	}

	public void setConstituencyId(int constituencyId) {
		this.constituencyId = constituencyId;
	}
	
	public String getConstituencyName()
	{
		return constituencyName;
	}
	
	public void setConstituencyName(String constituencyName)
	{
		this.constituencyName = constituencyName;
	}

}
