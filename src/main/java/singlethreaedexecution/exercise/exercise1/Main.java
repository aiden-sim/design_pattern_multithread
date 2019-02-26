package singlethreaedexecution.exercise.exercise1;

/**
 * 예제1) Single Threaded Execution 패턴을 사용해야 함에도 불구하고 사용하지 않는 프로그램
 * 잘못된 예제
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
