package thread.sync;

public class Bank {
	private String name;
	private int money;

	public Bank(String name, int money) {
		this.name = name;
		this.money = money;
	}

	// 예금
	public synchronized void deposit(int m) {
		money += m;
	}

	// 인출
	public synchronized boolean withdraw(int m) {
		if (money >= m) {
			money -= m;
			return true; // 인출 가능
		} else {
			return false; // 잔고부족
		}
	}

	public String getName() {
		return name;
	}
}
