package ss.week2.hotel;

public class Safe {
	private Password password;
	private boolean open;
	private boolean active;
	
	public static void main(String[] args) {
		Safe safe = new Safe();
		safe.activate(null);
	}
	
	public Safe() {
		password = new Password();
		
	}

	// With the right password this method activates the safe.
	//@ requires attempt != null;
	//@ ensures (getPassword().testWord(attempt)) ? isActive(): !isActive();
	
	public void activate(String attempt) {
		assert attempt != null;
		if (getPassword().testWord(attempt)) {
			active = true;
			assert getPassword().testWord(attempt);
		} else {
			active = false;
		}

	}

	// This method deactivates the safe and deactivates it.
	//@ ensures !isActive();
	public void deactivate() {
		active = false;
		assert active == false;

	}

	// With the right password this method opens the safe.
	//@ ensures (\old(isOpen()) == true || isActive() && getPassword().testWord(attempt)) == isOpen();
	public void open(String attempt) {
		if (open == true || isActive() && getPassword().testWord(attempt)) {
			open = true;
			assert isActive() && getPassword().testWord(attempt);
		} else {
			open = false;
		}

	}

	// This method closes the safe.
	//@ ensures !isOpen();
	public void close() {
		open = false;
		assert open == false;

	}

	// Indicates whether the safe is active.
	/*@pure */ public boolean isActive() {
		return active;
	}

	// Indicates whether the safe is open.
	/*@pure */ public boolean isOpen() {
		return open;
	}

	//Returns the password object on which the method testWord can be called to check the password.
	/*@pure*/ public Password getPassword() {
		return password;
	}
}
