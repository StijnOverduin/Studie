package ss.week6;

import java.util.Scanner;

public class Words {

	public static void main(String[] args) {
		new Words().senctenceToWords();
	}

	public void senctenceToWords() {
		System.out.println("Please give a sentence consisting of words separated by spaces.");
		Scanner in = new Scanner(System.in);
		boolean hasNotEnded = true;

		int i = 1;
		while ( hasNotEnded && in.hasNext()) {
			String word = in.next();
			if (word.equals("end")) {
				System.out.println("End of Programme");
				hasNotEnded = false;
			} else {
				System.out.println("Word " + i + ": " + word);
				i++;
			}
		}

	}

}
