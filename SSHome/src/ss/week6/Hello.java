package ss.week6;

import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean hasNotEnded = true;
		while (hasNotEnded && in.hasNextLine()) {
			String nl = in.nextLine();
			if (nl.equals("")) {
				hasNotEnded = false;
			} else {
				System.out.println("Hello " + nl);
			}
		}

	}

}
