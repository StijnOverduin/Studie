package ss.week7.threads;

import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole extends Thread {
	private static final ReentrantLock LOCK = new ReentrantLock();
	
	public TestSyncConsole() {
		
	}
	
	public void run() {
		sum();
	}
	
	
	private void  sum() {
		//synchronized (System.in) {
		LOCK.lock();
		int one = SyncConsole.readInt(" Thread" + getName() + " Get number 1");
		int two = SyncConsole.readInt(" Thread" + getName() + " Get number 2");
		int both = one + two;
		SyncConsole.println("antwoord is " + both);
		LOCK.unlock();
		//}
	}
	
	public static void main(String[] args) {
		TestSyncConsole testconsole1 = new TestSyncConsole();
		TestSyncConsole testconsole2 = new TestSyncConsole();
		testconsole1.start();
		testconsole2.start();
	}
	/* 1. Je kan een mate van belangrijk aangeven welke thread de lock eerst moet krijgen.
	 * 2. Ja want die kan daar niet op selecteren.
	 * 3. Je kan bijvoorbeeld de lock geven aan de thread die het langst aan het wachten is.
	 * 4. De programmeerder is verantwoordelijk voor het vastellen van de lock en het releasen van de lock.
	 * 
	 */
}


