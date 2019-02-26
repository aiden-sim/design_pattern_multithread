package singlethreaedexecution.exercise.exercise5;

public class CrackerThread extends Thread {
	private final SecurityGate gate;

	public CrackerThread(SecurityGate gate) {
		this.gate = gate;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			gate.enter();
			gate.exit();
		}
	}
}
