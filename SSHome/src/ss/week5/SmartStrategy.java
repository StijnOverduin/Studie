package ss.week5;

import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements Strategy {

	public SmartStrategy() {

	}

	public String getName() {
		return "Smart";
	}

	public int determineMove(Board board, Mark mark) {
		List<Integer> list = new ArrayList<Integer>();
		Board b = board.deepCopy();
		int ans = 0;
		if (b.getField(4) == Mark.EMPTY) {
			ans = 4;
		} else {
			for (int i = 0; i < b.DIM * b.DIM; i++) {
				if (b.getField(i) == Mark.EMPTY && ans == 0) {
					b.setField(i, mark);
					if (b.hasWinner()) {
						return i;
					} else {
						b.setField(i, mark.other());
						if (b.hasWinner()) {
							return i;
						} else {
							b.setField(i, Mark.EMPTY);
							list.add(i);
						}
					}

				}
			}
			int random = (int) Math.round(Math.random() * (list.size() - 1));
			ans = list.get(random);
		}
		return ans;

	}
	public String toString() {
		return getName();
	}

}
