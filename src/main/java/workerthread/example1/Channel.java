package workerthread.example1;

/**
 * Channel(통신로) 역할
 * 업무의 리퀘스트를 받아들이고, 워커 쓰레드에게 건네는 클래스
 */
public class Channel {
	private static final int MAX_REQUEST = 10;
	private final Request[] requestQueue;
	private int tail;   // 다음에 putRequest할 장소
	private int head;   // 다음에 takeRequest할 장소
	private int count;  // Request 수

	private final WorkerThread[] threadPool;

	public Channel(int threads) {
		this.requestQueue = new Request[MAX_REQUEST];
		this.head = 0;
		this.tail = 0;
		this.count = 0;

		threadPool = new WorkerThread[threads];
		for (int i = 0; i < threadPool.length; i++) {
			threadPool[i] = new WorkerThread("Worker-" + i, this);
		}

	}

	public void startWorkers() {
		for (int i = 0; i < threadPool.length; i++) {
			threadPool[i].start();
		}
	}

	// Producer-Consumer
	public synchronized void putRequest(Request request) {
		while (count >= requestQueue.length) {
			try {
				// Guarded Suspension
				wait();
			} catch (InterruptedException e) {
			}
		}
		requestQueue[tail] = request;
		tail = (tail + 1) % requestQueue.length;
		count++;
		notifyAll();
	}

	// Producer-Consumer
	public synchronized Request takeRequest() {
		while (count <= 0) {
			try {
				// Guarded Suspension
				wait();
			} catch (InterruptedException e) {
			}
		}
		Request request = requestQueue[head];
		head = (head + 1) % requestQueue.length;
		count--;
		notifyAll();
		return request;
	}
}
