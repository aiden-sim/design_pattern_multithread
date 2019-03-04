package workerthread.exampl1;

/**
 * Worker(작업자) 역할
 * 워커 쓰레드를 나타내는 클래스
 */
public class WorkerThread extends Thread {
	private final Channel channel;

	public WorkerThread(String name, Channel channel) {
		super(name);
		this.channel = channel;
	}

	public void run() {
		while (true) {
			Request request = channel.takeRequest();
			request.execute();
		}
	}
}
