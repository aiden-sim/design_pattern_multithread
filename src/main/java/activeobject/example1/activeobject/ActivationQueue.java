package activeobject.example1.activeobject;

/**
 * ActivationQueue(활성화 큐)
 * MethodRequest 객체를 질서 정연하게 보관하는 클래스 (능동적인 객체)
 * Producer-Consumer 패턴의 Channel 역할
 */
class ActivationQueue {
	private static final int MAX_THREAD_REQUEST = 100;
	private final MethodRequest[] requestsQueue;
	private int tail; // 다음에 putRequest 할 장소
	private int head; // 다음에 takeRequest 할 장소
	private int count; // MethodRequest의 수

	public ActivationQueue() {
		this.requestsQueue = new MethodRequest[MAX_THREAD_REQUEST];
		this.head = 0;
		this.tail = 0;
		this.count = 0;
	}

	public synchronized void putRequest(MethodRequest request) {
		while (count >= requestsQueue.length) {
			try {
				wait();
			} catch (InterruptedException e) {

			}
		}
		requestsQueue[tail] = request;
		tail = (tail + 1) % requestsQueue.length;
		count++;
		notifyAll();

	}

	public synchronized MethodRequest takeRequest() {
		while (count <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		MethodRequest request = requestsQueue[head];
		head = (head + 1) % requestsQueue.length;
		count--;
		notifyAll();
		return request;
	}
}
