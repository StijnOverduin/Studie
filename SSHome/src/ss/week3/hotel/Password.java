package ss.week3.hotel;

public class Password {

	public static final String INITIAL = "password";
	private String password;
	private int length;

	public int length() {
		return length;
	}

	public Password() {
		password = INITIAL;
	}

	public boolean acceptable(String suggestion) {
		if (suggestion.length() >= 6 && suggestion.indexOf(" ") == -1) {
			return true;
		} else {
			return false;
		}
	}

	/*@pure*/ public boolean testWord(String test) {
		if (test.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean setWord(String oldPass, String newPass) {
		if (testWord(oldPass) == true && acceptable(newPass) == true) {
			password = newPass;
			return true;
		} else {
			return true;
		}
	}
}
