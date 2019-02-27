package guardedsuspension.exercise.exercise5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * GuardedObject(보호받고 있는 객체)
 * 리퀘스트를 순서대로 비축해 두는 클래스
 * FIFO 구조 (선입선출)
 */
public class RequestQueue {
	// thread-safe 하다
	private final BlockingQueue<Request> queue = new LinkedBlockingQueue<>();

	public Request getReuqest() {
		Request req = null;
		try {
			req = queue.take();
		} catch (InterruptedException e) {

		}
		return req;
	}

	public void putRequest(Request request) {
		try {
			queue.put(request);
		} catch (InterruptedException e) {

		}
	}
}
