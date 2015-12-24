package ss.week2.hotel;

/**
 * 
 * Hotel guest with possibly a room.
 * 
 * @author Stijn
 * @version Version: 1.0
 *
 */

public class Guest {

	private String name;
	private Room room;

	/**
	 * Template for a new guest.
	 * 
	 * @param n
	 */

	public Guest(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	/*@ pure*/public Room getRoom() {
		return room;
	}

	public boolean checkin(Room r) {
		if (r.getGuest() == null && room == null) {
			r.setGuest(this);
			this.room = r;
			return true;
		} else {
			return false;
		}
	}

	public boolean checkout() {
		if (room != null) {
			room.setGuest(null);
			room = null;
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return "Guest " + name;
	}
}
