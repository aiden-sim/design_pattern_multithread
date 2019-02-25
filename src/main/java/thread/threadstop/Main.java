package thread.threadstop;

public class Main {
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			System.out.print("Good!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
	}
}
