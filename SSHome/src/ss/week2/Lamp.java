package ss.week2;

public class Lamp {
	private int state;
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;
	
/*@ ensures getState() == 0;
 */
	public Lamp() {
		this.state = 0;
	}

	public static void main(String[] args) {
		Lamp kamerlamp = new Lamp();

		kamerlamp.switchState();
		System.out.println(kamerlamp.getState());

	}

	/*@ ensures \old(getState()) == 0 ==> getState() == 1;
	  ensures \old(getState()) == 1 ==> getState() == 2;
	  ensures \old(getState()) == 2 ==> getState() == 3;
	  ensures \old(getState()) == 3 ==> getState() == 0;
	 */
	public void switchState() {
		state = (state + 1) % 4;
	}

	/*@ ensures \result>=0 && \result<5;
	 */
	/*@ pure */ public int getState() {
		assert state >= 0 && state < 5;
		return state;
	}

}
