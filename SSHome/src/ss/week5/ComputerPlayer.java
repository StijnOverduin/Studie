package ss.week5;

public class ComputerPlayer extends Player {
	private Strategy strategy;


	public ComputerPlayer(Mark mark) {
		super("NaiveStrategy-" + mark, mark);
		this.strategy = new NaiveStrategy();
	}

	public ComputerPlayer(Mark mark, Strategy strategy) {
		super("" + strategy + "-" + mark, mark);
		this.strategy = strategy;
	}

	public int determineMove(Board board) {
		return strategy.determineMove(board, this.getMark());
	}
	
	public Strategy getStrategy() {
		return strategy;
	}
	
	public void updateStrategy(Strategy s) {
		strategy = s;
	}

}
