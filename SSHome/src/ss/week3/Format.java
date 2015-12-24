package ss.week3;

public class Format {
	public static String printLine(String text, double amount) {
		return String.format("%s %" + (50 - text.length()) + ".2f", text, amount);
		
	}
	public static void main(String[] args) {
		
		System.out.println(printLine("hallo", 1.00));
	}

}