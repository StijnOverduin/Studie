package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;

public class PartyList {
	List<String> partyList = new ArrayList<String>();
	
	public PartyList() {

	}
	
	public void addParty(String name) {
		partyList.add(name);
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
