package singlethreaedexecution.exercise.exercise7;

/**
 * 사람을 나타내는 클래스, 문을 통과한다.
 */
public class UserThread extends Thread {
	private final Gate gate;
	private final String myname;
	private final String myaddress;

	public UserThread(Gate gate, String myname, String myaddress) {
		this.gate = gate;
		this.myname = myname;
		this.myaddress = myaddress;
	}

	@Override public void run() {
		System.out.println(myname + " BEGIN");
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gate.pass(myname, myaddress);
		}
	}
}
