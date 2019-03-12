package twophasetermination.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	private static final int TASKS = 10; // 일의 개수

	public static void main(String[] args) {
		System.out.println("BEGIN");
		ExecutorService service = Executors.newFixedThreadPool(TASKS);
		CountDownLatch doneLatch = new CountDownLatch(TASKS);
		try {
			// 일을 시작한다.
			for (int t = 0; t < TASKS; t++) {
				service.execute(new MyTask(doneLatch, t));
			}
			System.out.println("AWAIT");
			// 일이 종료되기를 기다린다.
			doneLatch.await();
		} catch (InterruptedException e) {

		} finally {
			service.shutdown();
			System.out.println("END");
		}
	}
}
