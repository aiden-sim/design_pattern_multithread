package thread.runnable;

public class Main {
	public static void main(String[] args) {
		new Thread(new Printer("Good!")).start();
		new Thread(new Printer("Nice!")).start();
	}
}
