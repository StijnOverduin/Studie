package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Observer;

public class VoteMachine {
	private PartyList partyList;
	private VoteList voteList;
	private Observer observer;

	public static void main(String[] args) {
		VoteMachine votemachine = new VoteMachine();
		votemachine.start();
	}

	public VoteMachine() {
		this.partyList = new PartyList();
		this.voteList = new VoteList();
	}

	public void addParty(String party) {
		partyList.addParty(party);
	}

	public void vote(String party) {
		if (partyList.hasParty(party)) {
			voteList.addVote(party);
		}
	}
	
	public Map<String, Integer> getVotes() {
		return voteList.getVotes();
	}
	
	public List<String> getParties() {
		return partyList.getParties();
	}
	
	public void start() {
		VoteView ui = new VoteGUIView(this);
		observer = ui;
		this.voteList.addObserver(observer);
		this.partyList.addObserver(observer);
		ui.start();
	}
}
