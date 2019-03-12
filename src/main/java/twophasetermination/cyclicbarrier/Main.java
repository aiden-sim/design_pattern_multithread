package twophasetermination.cyclicbarrier;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	private static final int THREADS = 3; // 쓰레드의 개수

	public static void main(String[] args) {
		System.out.println("BEGIN");

		// 일을 실행하는 쓰레드를 제공하는 ExecutorService
		ExecutorService service = Executors.newFixedThreadPool(THREADS);

		// 배리어가 해제될 때의 액션 (셧다운 후크?)
		Runnable barrierAction = new Runnable() {
			@Override public void run() {
				System.out.println("Barrier Action!");
			}
		};

		// 단계를 맞추는 CyclicBarrier
		CyclicBarrier phaseBarrier = new CyclicBarrier(THREADS, barrierAction);

		// 일의 종료를 조사하는 CountDownLatch
		CountDownLatch doneLatch = new CountDownLatch(THREADS);

		try {
			// 일을 개시한다.
			for (int i = 0; i < THREADS; i++) {
				service.execute(new MyTask(phaseBarrier, doneLatch, i));
			}
			// 일의 종료를 기다린다.
			System.out.println("AWAIT");
			doneLatch.await();
		} catch (InterruptedException e) {

		} finally {
			service.shutdown();
			System.out.println("END");
		}
	}
}
