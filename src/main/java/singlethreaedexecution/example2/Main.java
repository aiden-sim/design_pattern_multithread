package singlethreaedexecution.example2;

/**
 * 예제2) Single Threaded Execution 패턴을 사용한 예
 * 문을 만들고, 3명을 문으로 통과 시키는 클래스
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("Testing Gate, hit CTRL + C to exit.");
		Gate gate = new Gate();
		new UserThread(gate, "Alice", "Alaska").start();
		new UserThread(gate, "Bobby", "Brazil").start();
		new UserThread(gate, "Chris", "Canada").start();
	}
}
