package thread.multi;

public class MyThread extends Thread {
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.print("Nice!");
		}
	}
}
