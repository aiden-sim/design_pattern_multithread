package singlethreaedexecution.exercise.exercise6;

/**
 * 왼손에 식기를 집고 오른손에 식기를 잡고 식사하는 클래스
 */
public class EnterThread extends Thread {
	private String name;

	private final Tool lefthand;

	private final Tool righthand;

	public EnterThread(String name, Tool lefthand, Tool righthand) {
		this.name = name;
		this.lefthand = lefthand;
		this.righthand = righthand;
	}

	public void run() {
		while (true) {
			eat();
		}
	}

	private void eat() {
		synchronized (lefthand) {
			System.out.println(name + " takes up " + lefthand + " (left).");
			synchronized (righthand) {
				System.out.println(name + " takes up " + righthand + " (right).");
				System.out.println(name + " is eating now, yum yum!");
				System.out.println(name + " puts down " + righthand + " (right).");
			}
			System.out.println(name + " puts down " + lefthand + " (left).");
		}
	}
}
