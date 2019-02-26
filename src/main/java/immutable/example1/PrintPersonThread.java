package immutable.example1;

/**
 * Person 인스턴스를 표시하는 쓰레드를 나타내는 클래스
 */
public class PrintPersonThread extends Thread {
	private final Person person;

	public PrintPersonThread(Person person) {
		this.person = person;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "prints " + person);
		}
	}

}
