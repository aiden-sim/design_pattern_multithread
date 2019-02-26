package singlethreaedexecution.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

class Log {
	public static void println(String s) {
		System.out.println(Thread.currentThread().getName() + " : " + s);
	}
}

// 수 제한이 있는 리소스
class BoundedResource {
	private final Semaphore semaphore;
	private final int permits;
	private final static Random random = new Random(314159);

	// 클래스 생성자(permits는 리소스의 개수
	public BoundedResource(int permits) {
		this.semaphore = new Semaphore(permits);
		this.permits = permits;
	}

	// 리소스를 사용한다.
	public void use() throws InterruptedException {
		semaphore.acquire(); // 리소스 넘어가면 여기서 대기
		try {
			doUse();
		} finally {
			semaphore.release();
		}
	}

	private void doUse() throws InterruptedException {
		Log.println("BEGIN : used = " + (permits - semaphore.availablePermits()));
		Thread.sleep(random.nextInt(500));
		Log.println("END : used = " + (permits - semaphore.availablePermits()));
	}
}

// 리소스를 사용하는 쓰레드
class UserThread extends Thread {
	private final static Random random = new Random(26535);
	private final BoundedResource resource;

	public UserThread(BoundedResource resource) {
		this.resource = resource;
	}

	public void run() {
		try {
			resource.use();
			Thread.sleep(random.nextInt(3000));
		} catch (InterruptedException e) {

		}
	}
}

public class Main {
	public static void main(String[] args) {
		// 3개의 리소스
		BoundedResource resource = new BoundedResource(3);

		// 10개의 쓰레드가 사용한다.
		for (int i = 0; i < 10; i++) {
			new UserThread(resource).start();
		}
	}
}
