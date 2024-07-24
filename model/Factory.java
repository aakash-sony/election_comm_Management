package model;

import java.io.*;
import utils.*;

public class Factory {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static PoliticalParties pp[] = new PoliticalParties[20];

	static Candidate cd[] = new Candidate[100];

	static Constituency cnst[] = new Constituency[100];

	static int cnstIndex = 0;
	static int cdIndex = 0;
	static int ppIndex = 0;

	public static void insertPoliticalParties() throws IOException {
		char ch;
		System.out.println("Political Parties'detail: ");
		System.out.println("**************************");
		do {
			System.out.print("Enter Party name: ");
			String name = br.readLine();
			Utility.isValidAlphabeticName(name);
			System.out.print("Enter Party symbol: ");
			String symbol = br.readLine();
			
			pp[ppIndex] = new PoliticalParties(name, symbol, System.currentTimeMillis());
			ppIndex++;

			System.out.println();
			System.out.print("Do you want to enter another political parties: ");
			ch = br.readLine().charAt(0);
		} while (ch == 'y' || ch == 'Y');
	}

	public static void getPartyDetail() {
		for (int i = 0; i < pp.length; i++) {
			if (pp[i] != null) {
				PoliticalParties obj = pp[i];
				System.out.println();
				System.out.println("Party Id: " + obj.getId());
				System.out.println("Party Name: " + obj.getName());
				System.out.println("Party Symbol: " + obj.getSymbol());

			}
		}
	}

	public static void insertCandidateDetail() throws IOException {
		char ch;
		System.out.println("\nCandidate's detail:-- ");
		System.out.println("*************************");
		do {
			System.out.print("Enter candidate name: ");
			String name = br.readLine();

			System.out.print("Enter candidate age: ");
			int age = Integer.parseInt(br.readLine());
			if (age >= 18) {
				System.out.println("\nParty Symbols list");
				System.out.println("*********************");
				showPartySymbol();

				System.out.print("\nPlease enter party symbol or others from the above list for nomination: ");
				String sym = br.readLine();

				System.out.println("\nConstituency list");
				System.out.println("*********************");
				showConstituencyList();

				System.out.println("Please Enter constituency id for the nomination: ");
				int cId = Integer.parseInt(br.readLine());
					
				Long id = getPartyId(sym);
				if (id == null) {
					System.out.println("Invalid Party symbol");
				} else {
					if (sym.equalsIgnoreCase("Others")) {
						cd[cdIndex] = new Candidate(name, age, id, CandidatureType.INDEPENDENT.name(), isValidConstituencyId(cId));
					} else {
						cd[cdIndex] = new Candidate(name, age, id, CandidatureType.PARTY_AFFLIATED.name(), isValidConstituencyId(cId));
					}

					cdIndex++;
				}
			} else {
				System.out.println("Invalid age.");
			}

			System.out.print("Do you want to enter another candidate details(y/n): ");
			ch = br.readLine().charAt(0);
		} while (ch == 'y' || ch == 'Y');
	}

	public static void getCandidateDetails() {
		for (int i = 0; i < cd.length; i++) {
			if (cd[i] != null) {
				System.out.println("-------------------------");
				System.out.println("Candidate Name: " + cd[i].getCandidateName());
				System.out.println("Candidate Age: " + cd[i].getCandidateAge());
				System.out.println("Constituency Id: " + cd[i].getConsituencyId());
				String partySymbol = getSymbolByPartyId(cd[i].getPartyId());
				if (partySymbol == null) {
					System.out.println("Party Name: NA");
				} else {
					System.out.println("Party Symbol: " + partySymbol);
				}
				System.out.println("Candidature type: " + cd[i].getCandidatureType());

			}
		}
	}

	public static void showPartySymbol() {
		int x = 0;
		for (int i = 0; i < pp.length; i++) {
			if (pp[i] != null) {
				System.out.println(i + 1 + ") " + pp[i].getSymbol());
				x++;
			}
		}
		System.out.println((x + 1) + ") Others");
	}

	public static boolean isSymbolValid(String symbol) {
		for (int i = 0; i < pp.length; i++) {
			if (pp[i] != null && (pp[i].getSymbol().equalsIgnoreCase(symbol) || symbol.equalsIgnoreCase("Others"))) {
				return true;
			}
		}
		return false;
	}

	public static Long getPartyId(String symbol) {
		for (int i = 0; i < pp.length; i++) {
			if (isSymbolValid(symbol)) {
				if (!symbol.equalsIgnoreCase("Others")) {
					return pp[i].getId();
				} else {
					return System.currentTimeMillis();
				}
			}
		}
		return null;
	}

	public static String getSymbolByPartyId(long id) {
		for (int i = 0; i < pp.length; i++) {
			if (pp[i] != null) {
				if (pp[i].getId() == id) {
					return pp[i].getSymbol();
				} else {
					return null;
				}
			}
		}
		return null;
	}

	public static void insertConstituencyDetails() throws IOException {
		char ch;
		System.out.println("-----------------------------");
		System.out.println("\nEnter Constituency Details: ");

		do {
			System.out.print("Enter Constituency Id: ");
			int id = Integer.parseInt(br.readLine());

			System.out.print("Enter no of Votes: ");
			int votes = Integer.parseInt(br.readLine());

			System.out.print("Enter constituency name: ");
			String name = br.readLine();

			cnst[cnstIndex] = new Constituency(votes, id, name);
			cnstIndex++;

			System.out.print("\nDo you want to enter another Constituency details: ");
			ch = br.readLine().charAt(0);

		} while (ch == 'Y' || ch == 'y');
	}

	public static void getConstituencyDetails() {
		for (int i = 0; i < cnst.length; i++) {
			if (cnst[i] != null) {
				System.out.println("===========================");
				System.out.println("Constituency id: " + cnst[i].getConstituencyId());
				System.out.println("Constituency name: " + cnst[i].getConstituencyName());
				System.out.println("No. of votes: " + cnst[i].getNoOfVotes());
				System.out.println("===========================");
			}
		}
	}

	public static void showConstituencyList() {
		for (int i = 0; i < cnst.length; i++) {
			if (cnst[i] != null) {
				System.out.println(
						i + 1 + ") " + cnst[i].getConstituencyName() + " (" + cnst[i].getConstituencyId() + ")");
			}
		}
	}

	public static int isValidConstituencyId(int id) {
		for (int i = 0; i < cnst.length; i++) {
			if (cnst[i] != null) {
				if (cnst[i].getConstituencyId() == id) {
					return cnst[i].getConstituencyId();
				}
			}
		}
		System.out.println("Invalid constituency details.");
		 return 0;
	}

}
