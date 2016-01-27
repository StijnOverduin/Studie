package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VoteList extends Observable {
	Map<String, Integer> votelist = new HashMap<String, Integer>();
	
	public VoteList() {
		
	}
	
	public void addVote(String name) {
		if (!votelist.containsKey(name)) {
			votelist.put(name, 1);
		} else {
			int add = votelist.get(name);
			add++;
			votelist.put(name, add);
		}
		setChanged();
		notifyObservers("vote");
	}
	
	public Map<String, Integer> getVotes() {
		return votelist;
	}
}
