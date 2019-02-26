package singlethreaedexecution.exercise.exercise7;

/**
 * 개량 Mutext
 */
public final class Mutex2 {
	private long locks = 0;
	private Thread owner = null;

	public synchronized void lock() {
		Thread me = Thread.currentThread();
		while (locks > 0 && owner != me) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		assert locks == 0 || owner == me;
		owner = me;
		locks++;
	}

	public synchronized void unlock() {
		Thread me = Thread.currentThread();
		if (locks == 0 || owner != me) {
			return;
		}
		assert locks > 0 && owner == me;
		locks--;
		if (locks == 0) {
			owner = null;
			notifyAll();
		}
	}
}
