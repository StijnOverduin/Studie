package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PartyList extends Observable {
	List<String> partyList = new ArrayList<String>();
	
	public PartyList() {

	}
	
	public void addParty(String name) {
		partyList.add(name);
		setChanged();
		notifyObservers("party");
	}
	
	public List<String> getParties() {
		return partyList;
	}
	
	public boolean hasParty(String name) {
		boolean bool = false;
		if (partyList.contains(name)) {
			bool = true;
		}
		return bool;
	}

}
