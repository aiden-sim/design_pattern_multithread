package activeobject.example1.activeobject;

/**
 * Scheduler 역할
 * MethodRequest 객체를 execute하는 클래스 (중요) (능동적인 객체)
 */
class SchedulerThread extends Thread {
	private final ActivationQueue queue;

	public SchedulerThread(ActivationQueue queue) {
		this.queue = queue;
	}

	// 기동(invocation)
	// Producer
	public void invoke(MethodRequest request) {
		queue.putRequest(request);
	}

	// Consumer
	public void run() {
		while (true) {
			MethodRequest request = queue.takeRequest();
			request.execute();
		}
	}
}
