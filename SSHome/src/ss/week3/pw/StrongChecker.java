package ss.week3.pw;

public class StrongChecker extends BasicChecker {
	private static final String INITPASS = "Initial1";
	public boolean acceptable(String suggestion) {
		return super.acceptable(suggestion) && Character.isDigit(suggestion.charAt(suggestion.length())) 
				&& Character.isLetter(suggestion.indexOf(0));
	}

	public String generatePassword() {
		return INITPASS;
	}

}
