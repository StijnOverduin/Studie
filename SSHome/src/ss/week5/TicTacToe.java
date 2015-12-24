package ss.week5;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
	public static void main(String[] args) {
		if (args.length == 2) {
			Player player1 = determinePlayer(args[0], Mark.XX);
			Player player2 = determinePlayer(args[1], Mark.OO);
			Game game = new Game(player1, player2);
			game.start();
		} else {
			System.out.println("Not enough arguments or too many arguments");
		}
	}

	public static Player determinePlayer(String arg, Mark mark) {
		if (arg.equals("-N")) {
			return new ComputerPlayer(mark, new NaiveStrategy());
		} else if (arg.equals("-S")) {
			return new ComputerPlayer(mark, new SmartStrategy());
		} else {
			return new HumanPlayer(arg, mark);
		}
	}
}