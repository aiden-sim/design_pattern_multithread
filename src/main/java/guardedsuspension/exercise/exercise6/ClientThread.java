package guardedsuspension.exercise.exercise6;

import java.util.Random;

/**
 * 리퀘스트를 제시하는 클래스
 */
public class ClientThread extends Thread {
	private final Random random;

	private final RequestQueue requestQueue;

	public ClientThread(RequestQueue requestQueue, String name, long seed) {
		super(name);
		this.requestQueue = requestQueue;
		this.random = new Random(seed);
	}

	public void run() {
		try {
			for (int i = 0; i < 10000; i++) {
				Request request = new Request("No." + i);
				System.out.println(Thread.currentThread().getName() + " requests " + request);
				requestQueue.putRequest(request);
				Thread.sleep(random.nextInt(1000));
			}
		} catch (InterruptedException e) {

		}
	}
}
