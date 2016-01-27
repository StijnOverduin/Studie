package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class VoteTUIView implements Observer, VoteView {

	private VoteMachine votemachine;

	public VoteTUIView(VoteMachine vmachine) {
		this.votemachine = vmachine;
	}

	public void start() {
		System.out.println("Welcome to the Votemachine!");
		System.out.println("> ");
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			System.out.println("> ");
			switch (in.next()) {
				case "VOTE":
					String partij = in.next();
					if (votemachine.getParties().contains(partij)) {
						votemachine.vote(partij);
					} else {
						showError("Sorry, that party is nog recognized.\n" + "You can vote on:");
						showParties(votemachine.getParties());
					}
					break;
				case "ADD":
					switch (in.next()) {
						case "PARTY":
							votemachine.addParty(in.next());
							break;
						default:
							showError("Sorry, that command is not recognized.\n" + "Try typing \'HELP\'");
							break;
					}
					break;
				case "VOTES":
					showVotes(votemachine.getVotes());
					break;
				case "PARTIES":
					showParties(votemachine.getParties());
					break;
				case "EXIT":
					System.exit(0);
					break;
				case "HELP":
					System.out.println(
							"Commands: - VOTE [party] - ADD PARTY [party] - VOTES - PARTIES - EXIT - HELP");
					break;
				default:
					showError("Sorry, that command is not recognized." + "Try typing 'HELP'");
					break;
			}
		}
		in.close();

	}

	public void showVotes(Map<String, Integer> votes) {
		if (!votes.isEmpty()) {
			for (Map.Entry<String, Integer> e : votes.entrySet()) {
				String partij = e.getKey();
				Integer stemmen = e.getValue();
				System.out.println("Partij: " + partij + " - Stemmen: " + stemmen);
			}
			for (String partij : votemachine.getParties()) {
				if (!votes.containsKey(partij)) {
					System.out.println("Partij: " + partij + " - Stemmen: 0");
				}
			}
		} else {
			showError("There are no votes available");
		}
	}

	public void showParties(List<String> parties) {
		if (!parties.isEmpty()) {
			for (String partij : votemachine.getParties()) {
				System.out.println("partij: " + partij);
			}
		} else {
			showError("There are no parties available");
		}
	}

	public void showError(String error) {
		System.out.println(error);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		switch ((String) arg) {
			case "party":
				System.out.println("Party was added!");
				break;
			case "vote":
				System.out.println("Vote was added!");
				break;
			default:
			
				System.out.println(String.format("test %s", (String) arg));
				break;
		}
		
	}

}
