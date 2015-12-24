package ss.week2;

public class Lamp2 {
	private State state;

	public enum State {
		OFF, LOW, MED, HIGH
	};

	public Lamp2() {
		state = State.OFF;
	}

	public static void main(String[] args) {
		Lamp2 kamerlamp = new Lamp2();

		kamerlamp.switchState();
		System.out.println(kamerlamp.getState());

	}

	/*
	 * @
	 */
	public void switchState() {
		switch (state) {
		case OFF:
			state = State.LOW;
			break;
		case LOW:
			state = State.MED;
			break;
		case MED:
			state = State.HIGH;
			break;
		case HIGH:
			state = State.OFF;
			break;
		}
	}

	/*@ pure */ public State getState() {
		return state;
	}

}
