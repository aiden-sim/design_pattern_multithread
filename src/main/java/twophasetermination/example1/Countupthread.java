package twophasetermination.example1;

/**
 * Terminator(종료 하는 사람) 역할
 * 숫자를 카운트 업 해 나가는 쓰레드를 나타내는 클래스
 */
public class Countupthread extends Thread {
	// 카운터의 값
	private long counter = 0;

	// 종료 요구가 제시되었으면 true
	private volatile boolean shutdownRequestd = false;

	// 종료 요구
	// Single Thread Execution을 사용하지 않았다. (Synchronized 미사용)
	public void shutdownRequest() {
		shutdownRequestd = true;
		// 스레드가 sleep 하고 있을 수 있기 때문에 interrupt 를 호출한다.
		interrupt();
	}

	// 종료 요구가 제시되었는지를 테스트
	public boolean isShutdownRequested() {
		return shutdownRequestd;
	}

	// 동작
	public final void run() {
		try {
			while (!isShutdownRequested()) {
				doWork();
			}
		} catch (InterruptedException e) {

		} finally {
			doShutdown();
		}
	}

	// 작업
	private void doWork() throws InterruptedException {
		counter++;
		System.out.println("doWork: counter = " + counter);
		Thread.sleep(500);
	}

	// 종료 처리
	private void doShutdown() {
		System.out.println("doShutdown: counter = " + counter);
	}
}
