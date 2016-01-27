package ss.week7.threads;

public class SynchronizedIntCell implements IntCell {
	private int value = 0;
	private boolean isRead = true;

	public synchronized void setValue(int val) {
		while (!isRead) {
			try {
				wait();
			} catch (InterruptedException e) {
			
			}
		}
		this.value = val;
		isRead = false;
		notifyAll();
	}

	public synchronized int getValue() {
		while (isRead) {
			try {
				wait();
			} catch (InterruptedException e) {
			
			}
		}
		isRead = true;
		notifyAll();
		return value;
		
	}

}
