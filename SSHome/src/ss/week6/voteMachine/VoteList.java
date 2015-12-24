package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;

public class VoteList {
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
	}
	
	public Map<String, Integer> getVotes() {
		return votelist;
	}
}
