package singlethreaedexecution.exercise.exercise7;

/**
 * 제약
 * 1) 재입장이 불가능하다. 같은 쓰레드에서 lock을 두번 호출하면 계속 wait 상태가 된다.
 * 2) 누구나 unlock 할 수 있다. lock 메소드를 호출하지 않는 메소드라도 unlock 메소드를 호출할 수 있다. (전체 wait)
 */
public final class Mutex {
	private boolean busy = false;

	public synchronized void lock() {
		while (busy) {
			try {
				wait();
			} catch (InterruptedException e) {

			}
		}
		busy = true;
	}

	public synchronized void unlock() {
		busy = false;
		notifyAll();
	}
}
