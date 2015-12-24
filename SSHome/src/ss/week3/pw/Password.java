package ss.week3.pw;

public class Password {

	public static final String INITIAL = "password";
	private String password;
	private Checker checker;
	private String factoryPassword;

	public Password(Checker newChecker) {
		checker = newChecker;
		factoryPassword = checker.generatePassword();
		password = factoryPassword;
	}
	
	public Password() {
		this(new BasicChecker());
	}

	public boolean acceptable(String suggestion) {
		return checker.acceptable(suggestion);
		
	}

	/*@pure*/ public boolean testWord(String test) {
		return test.equals(password); 
		
	}

	public boolean setWord(String oldPass, String newPass) {
		boolean ans = false;
		if (testWord(oldPass) && acceptable(newPass)) {
			password = newPass;
			ans = true;
		}
		return ans;
	}
	public String getFactoryPassword() {
		return factoryPassword;
	}
	public Checker getChecker() {
		return checker;
	}
}
