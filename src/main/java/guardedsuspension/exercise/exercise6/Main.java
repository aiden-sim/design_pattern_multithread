package guardedsuspension.exercise.exercise6;

/**
 * 동작 테스트용 클래스
 */
public class Main {
	public static void main(String[] args) {
		RequestQueue requestQueue = new RequestQueue();
		Thread alice = new ClientThread(requestQueue, "Alice", 3141592L);
		Thread bobby = new ServerThread(requestQueue, "Bobby", 6535897L);

		alice.start();
		bobby.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("***** calling interrup *****");
		alice.interrupt();
		bobby.interrupt();

	}
}
