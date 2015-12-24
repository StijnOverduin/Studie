package ss.week5;

import java.util.ArrayList;
import java.util.List;

public class NaiveStrategy implements Strategy {
	
	public NaiveStrategy() {
		
	}
	
	public String getName() {
		return "Naive";
	}
	
	public int determineMove(Board board, Mark mark) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < board.DIM * board.DIM; i++) {
			if (board.getField(i) == Mark.EMPTY) {
				list.add(i);
			}
		}
		int random = (int) Math.round(Math.random() * list.size());
		
		return list.get(random);
		
		
	}

}
