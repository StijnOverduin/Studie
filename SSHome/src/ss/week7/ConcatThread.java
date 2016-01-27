package ss.week7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcatThread extends Thread {
	private static String text = ""; // global variable
	private String toe;
	private static final Lock lock = new ReentrantLock();

	public ConcatThread(String toeArg) {
		this.toe = toeArg;
	}

	public void run() {
		synchronized (lock) {
			while (toe.equals("two;") && text.equals("")) {
				try {
					lock.wait();

				} catch (InterruptedException e) {

				}
			}
			lock.lock();
			try {
				lock.notifyAll();
				text = text.concat(toe);
			} finally {
				lock.unlock();
			}
		}

	}

	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			ConcatThread.text = "";
			ConcatThread t1 = new ConcatThread("one;");
			ConcatThread t2 = new ConcatThread("two;");
			t1.start();
			t2.start();

			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {

			}
			if (ConcatThread.text.equals("one;two;")) {
				System.out.println("Good");
			} else {
				System.out.println(ConcatThread.text);
			}

		}

	}
}
/*
 * run, omdat deze de verschillende threads start. one; of two; of one;two; of
 * two;one;
 * 
 * 
 */
