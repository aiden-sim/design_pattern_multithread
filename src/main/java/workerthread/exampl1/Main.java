package workerthread.exampl1;

/**
 * 동작 테스트용 클래스
 */
public class Main {
	public static void main(String[] args) {
		Channel channel = new Channel(5);
		channel.startWorkers();
		new ClientThread("Alice", channel).start();
		new ClientThread("Bobby", channel).start();
		new ClientThread("Chris", channel).start();
	}
}