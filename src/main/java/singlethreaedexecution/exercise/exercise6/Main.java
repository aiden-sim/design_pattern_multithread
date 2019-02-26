package singlethreaedexecution.exercise.exercise6;

/**
 * 데드락
 * 스푼과 포크를 준비하고 Alice와 Bobby를 움직이는 클래스
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("Testing EaterThread, hit CTRL+C to exit.");
		Tool spoon = new Tool("Spoon");
		Tool fork = new Tool("Fork");
		new EnterThread("Alice", spoon, fork).start();
		new EnterThread("Bobby", spoon, fork).start();
	}
}
