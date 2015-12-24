package ss.week4.tictactoe;

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
			HumanPlayer player1 = new HumanPlayer(args[0], Mark.XX);
			HumanPlayer player2 = new HumanPlayer(args[1], Mark.OO);
			Game game = new Game(player1, player2);
			game.start();
		} else {
			System.out.println("Not enough arguments");
		}
	}
}