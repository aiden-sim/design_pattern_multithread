package thread.thread;

public class Main {
	public static void main(String[] args) {
		new PrintThread("Good!").start();
		new PrintThread("Nice!").start();
	}
}
