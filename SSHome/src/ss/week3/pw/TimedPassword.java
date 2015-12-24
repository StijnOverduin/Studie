package ss.week3.pw;

public class TimedPassword extends Password {
	private long validTime;
	public long bTime;

	public TimedPassword() {
		validTime = 604800000;
	}

	public TimedPassword(long validTime) {
		this.validTime = validTime;
		bTime = System.currentTimeMillis();
	}

	public boolean isExpired() {
		return !(System.currentTimeMillis() - bTime < validTime);
	}

	public boolean setWord(String oldPass, String newPass) {
		boolean ans = false;
		if (super.setWord(oldPass, newPass)) {
			bTime = System.currentTimeMillis();
			ans = true;
		}
		return ans;
	}
}
