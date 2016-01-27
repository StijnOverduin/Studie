package ss.week7.threads;

import java.util.Scanner;

public class TestConsole extends Thread {

	private String name;
	
	public TestConsole(String name) {
		this.name = name;
	}
	
	public void run() {
		sum();
	}
	
	private void sum() {
		int one = Console.readInt(" Thread" + getName() + " Get number 1");
		int two = Console.readInt(" Thread" + getName() + " Get number 2");
		int sum = one + two;
		Console.println("antwoord is " + sum);
	
	}
	
	public static void main(String[] args) {
		TestConsole testconsole1 = new TestConsole("A");
		TestConsole testconsole2 = new TestConsole("B");
		testconsole1.start();
		testconsole2.start();
	}
}
