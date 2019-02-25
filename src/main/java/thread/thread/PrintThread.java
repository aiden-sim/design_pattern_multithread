package thread.thread;

public class PrintThread extends Thread {
	private String message;

	public PrintThread(String message) {
		this.message = message;
	}

	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.print(message);
		}
	}
}
