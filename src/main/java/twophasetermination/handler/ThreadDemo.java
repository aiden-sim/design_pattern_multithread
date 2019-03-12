package twophasetermination.handler;

import java.lang.*;

public class ThreadDemo {

	public static void main(String[] args) {

		Thread t = new Thread(new adminThread());

		t.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(t + " throws exception: " + e);
			}
		});
		// this will call run() function
		t.start();
	}
}

class adminThread implements Runnable {

	public void run() {
		throw new RuntimeException();
	}
}