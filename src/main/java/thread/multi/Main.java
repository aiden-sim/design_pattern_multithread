package thread.multi;

import thread.thread.PrintThread;

public class Main {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
		for (int i = 0; i < 10000; i++) {
			System.out.print("Good!");
		}

		new PrintThread("Good!").start();
		new PrintThread("Nice!").start();
	}
}
