package workerthread.example1;

import java.util.Random;

/**
 * Client(의뢰자) 역할
 * 업무를 리퀘스트 하는 쓰레드를 나타내는 클래스
 * Request 인스턴스를 만든다
 * 만든 Request 인스턴스를 Channel 클래스의 putRequest 메소드에 전달한다.
 */
public class ClientThread extends Thread {
	private final Channel channel;
	private static final Random random = new Random();

	public ClientThread(String name, Channel channel) {
		super(name);
		this.channel = channel;
	}

	public void run() {
		try {
			for (int i = 0; true; i++) {
				Request request = new Request(getName(), i);
				channel.putRequest(request);
				Thread.sleep(random.nextInt(1000));
			}
		} catch (InterruptedException e) {

		}
	}
}
