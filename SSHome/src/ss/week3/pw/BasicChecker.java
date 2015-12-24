package ss.week3.pw;

public class BasicChecker implements Checker {
	public static final String INITPASS = "Initial";
	public boolean acceptable(String suggestion) {
		return suggestion.length() >= 6 && suggestion.indexOf(" ") == -1;
	}
	public String generatePassword() {
		return INITPASS;
	}
}
