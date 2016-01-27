package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FinegrainedIntCell implements IntCell {
	private int value = 0;
	private static final ReentrantLock LOCK = new ReentrantLock();
	private final Condition consumer = LOCK.newCondition();
	private final Condition producer = LOCK.newCondition();
	private boolean isRead = true;

	public void setValue(int valueArg) {
		LOCK.lock();
		try {
			while (!isRead) {
				try {
					producer.await();
				} catch (InterruptedException e) {

				}
			}
			this.value = valueArg;
			isRead = false;
			consumer.signal();
		} finally {
			LOCK.unlock();
		}

	}

	public int getValue() {
		LOCK.lock();
		try {
			while (isRead) {
				try {
					consumer.await();
				} catch (InterruptedException e) {

				}
			}
			isRead = true;
			producer.signal();
			return value;
		} finally {
			LOCK.unlock();
		}

	}
}
