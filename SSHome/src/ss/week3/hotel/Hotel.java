package ss.week3.hotel;

import java.io.PrintStream;

public class Hotel {
	private String name;
	private Guest guest;
	private PricedSafe safe1;
	private Safe safe2;
	private PricedRoom room1;
	private Room room2;
	private Password password;
	private Bill.Item item;
	private PricedSafe psafe;

	// @ requires hotelname != null;
	// @ ensures getHotelName().equals(hotelname);
	public Hotel(String hotelname) {
		name = hotelname;
		safe1 = new PricedSafe(30);
		safe2 = new Safe();
		room1 = new PricedRoom(102, safe1.getAmount(), 30);
		room2 = new Room(101, safe2);
		password = new Password();

	}

	// Makes a new guest with the given name and assigns him/her a room.
	// @ requires p != null && n != null;
	public Room checkIn(String p, String n) {
		assert p != null;
		assert n != null;
		if (getPassword().testWord(p) && getFreeRoom() != null) {
			guest = new Guest(n);
			guest.checkin(getFreeRoom());
			guest.getRoom().setGuest(guest);
			return guest.getRoom();
		} else {
			return null;
		}
	}

	// Makes the room assigned to a guest empty.
	// @ requires n != null;
	// @ ensures this.getRoom(n) == null;
	public void checkOut(String n) {
		assert n != null;
		if (guest != null && guest.getName() == n) {
			guest.getRoom().getSafe().close();
			guest.getRoom().getSafe().deactivate();
			guest.checkout();
		}
	}

	// Gives one of the 2 rooms if the hotel isn't full.
	// @ ensures \result == null || \result.getGuest() == null;
	/* @ pure */ public Room getFreeRoom() {
		if (room1.getGuest() == null) {
			return room1;
		} else if (room2.getGuest() == null) {
			return room2;
		} else {
			return null;
		}
	}

	// Gives the room of the guest if there is a guest with the name given.
	// @ requires n != null;
	// @ ensures \result == null || \result.getGuest().getName().equals(n);
	/* @ pure */ public Room getRoom(String n) {
		if (guest != null && guest.getName() == n) {
			return guest.getRoom();
		} else {
			return null;
		}
	}

	// Gives the password object on which the testWord method can be applied.
	/* @ pure */ public Password getPassword() {
		return password;
	}

	// @ ensures \result != null;
	/* @ pure */ public String toString() {
		return "This is guest " + guest.getName() + ", the room of this guest is " + guest.getRoom()
				+ " and The status of the safe is " + guest.getRoom().getSafe().isActive();

	}

	// Returns the name of the hotel.
	// @ ensures \result != null;
	/* @ pure */ public String getHotelName() {
		return name;
	}
	
	public Bill getBill(String n, int nights, PrintStream ps) {
		Bill bill = null;
		if (guest != null && guest.getName() == n && guest.getRoom() instanceof PricedRoom) {
			bill = new Bill(ps);
			if (guest.getRoom().getSafe().isActive() && guest.getRoom().getSafe() instanceof PricedSafe) {
				bill.newItem((PricedSafe)guest.getRoom().getSafe());	
			}
			for (int ni = 1; ni <= nights; ni++) {
				item = new PricedRoom(101, 50, 20);
				bill.newItem(item);
			}
			bill.close();
		} 
		return bill;
	}
	public static void main(String[] args) {
		Hotel h = new Hotel("t");
		h.checkIn("password", "hallo");
		h.getRoom("hallo").getSafe().activate("password");
		h.getBill("hallo", 2, System.out);
	}
}
