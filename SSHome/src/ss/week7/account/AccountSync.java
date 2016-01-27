package ss.week7.account;

public class AccountSync {

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			Account account = new Account();
			MyThread thread1 = new MyThread(2, 60, account);
			MyThread thread2 = new MyThread(-2, 60, account);
			thread1.start();
			thread2.start();
			try {
				thread1.join();
				thread2.join();
			} catch (InterruptedException e) {

			}
			if (account.getBalance() != 0) {
				System.out.println(account.getBalance());
			}
		}
	}
}
