package model;

public class Candidate {
	private String candidateName;
	private int candidateAge;
	private long partyId;
	private String candidatureType;
	private int constituencyId;


	public Candidate(String candidateName, int candidateAge, long partyId, String candidatureType, int constituencyId) {
		super();
		this.candidateName = candidateName;
		this.candidateAge = candidateAge;
		this.partyId = partyId;
		this.candidatureType = candidatureType;
		this.constituencyId = constituencyId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public int getCandidateAge() {
		return candidateAge;
	}

	public void setCandidateAge(int candidateAge) {
		this.candidateAge = candidateAge;
	}

	public long getPartyId() {
		return partyId;
	}

	public void setPartyId(long partyId) {
		this.partyId = partyId;
	}

	public String getCandidatureType() {
		return candidatureType;
	}

	public void setCandidatureType(String candidatureType) {
		this.candidatureType = candidatureType;
	}

	public int getConsituencyId() {
		return constituencyId;
	}

	public void setConsituencyId(int constituencyId) {
		this.constituencyId = constituencyId;
	}
	
}

enum CandidatureType{
	PARTY_AFFLIATED, INDEPENDENT
}
