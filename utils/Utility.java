package utils;

public class Utility {
	public static boolean validateName(String name, String type) {

		if (name == InputType.PARTY_NAME.name())
		{
			if(!isValidAlphabeticName(name))
			{
				System.out.println("Invalid Party name.");
			}
		}

		else if (name == InputType.CANDIDATE_NAME.name()) 
		{
			if(!isValidAlphaNumericName(name))
			{
				System.out.println("Invalid Candidate name.");
			}
		} 
		else if (name == InputType.CONSTITUENCY_NAME.name())
		{
			if(!isValidAlphabeticName(name))
			{
				System.out.println("Invalid Constituency name.");
			}
		}
		else if(name == InputType.PARTY_SYMBOL_NAME.name())
		{
			if(!isValidAlphabeticName(name))
			{
				System.out.println("Invalid Party Symbol name.");
			}
		}

		return false;
	}

	public static boolean isValidAlphabeticName(String name) {

		if (name == null || name.isEmpty()) {
			return false;
		}
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);

			if (!Character.isLetter(ch)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidAlphaNumericName(String name) {
		if (name == null || name.isEmpty()) {
			return false;
		}
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);

			if (!Character.isLetterOrDigit(ch)) {
				return false;
			}
		}
		return true;
	}
}


